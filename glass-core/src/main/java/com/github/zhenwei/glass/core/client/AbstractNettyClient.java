package com.github.zhenwei.glass.core.client;


import com.github.zhenwei.glass.common.enums.GlassNettyErrorEnum;
import com.github.zhenwei.glass.common.exceptions.GlassNettyException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.val;

public abstract class AbstractNettyClient extends AbstractNioClient {

    private ChannelFuture future;

    protected AbstractNettyClient(String host, int port, ChannelInitializer<SocketChannel> initializer,
                                  GenericFutureListener<ChannelPromise> listener, LogLevel level) throws GlassNettyException {
        try {
            val worker = new NioEventLoopGroup(1);
            val bootstrap = new Bootstrap();
            operate(bootstrap);
            future = bootstrap.group(worker).channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(level))
                    .handler(initializer).connect(host, port).sync();
            if (listener != null) {
                future.addListener(listener);
            }
        } catch (Exception e) {
            throw new GlassNettyException(GlassNettyErrorEnum.BUILD_CLIENT_ERR, e);
        }
    }


    abstract void operate(Bootstrap bootstrap);


    @Override
    public void send(Object t) {
        future.channel().writeAndFlush(t);
    }

    @Override
    public void close() {
        future.channel().close();
    }


}

package com.github.zhenwei.glass.core.server;

import com.github.zhenwei.glass.common.enums.GlassNettyErrorEnum;
import com.github.zhenwei.glass.common.exceptions.GlassNettyException;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.GenericFutureListener;

public abstract class AbstractNettyServer extends AbstractNioServer{

    public AbstractNettyServer(int port, ChannelInitializer<SocketChannel> initializer,
                             GenericFutureListener<ChannelPromise> listener, LogLevel level) throws GlassNettyException {
        ChannelFuture channelFuture;
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            channelFuture = serverBootstrap.group(boss, work).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(level)).childHandler(initializer).bind(port).sync();
            if (listener != null) {
                channelFuture.addListener(listener);
            }
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            throw new GlassNettyException(GlassNettyErrorEnum.BUILD_SERVER_ERR, e);
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }
}

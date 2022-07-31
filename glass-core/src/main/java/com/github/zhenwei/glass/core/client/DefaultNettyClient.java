package com.github.zhenwei.glass.core.client;

import com.github.zhenwei.glass.common.exceptions.GlassNettyException;
import com.github.zhenwei.glass.core.channel.AbstractNettyChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.util.concurrent.GenericFutureListener;

public class DefaultNettyClient extends AbstractNettyClient {

    public DefaultNettyClient(String host, int port) throws GlassNettyException {
        this(host, port, new DefaultProviderChannelInitializer());
    }

    public DefaultNettyClient(String host, int port, AbstractNettyChannelInitializer initializer) throws GlassNettyException {
        this(host, port, initializer, null, LogLevel.INFO);
    }

    public DefaultNettyClient(String host, int port, ChannelInitializer<SocketChannel> initializer,
                              GenericFutureListener<ChannelPromise> listener, LogLevel level) throws GlassNettyException {
        build(host, port, initializer, listener, level);
    }


    @Override
    void operate(Bootstrap bootstrap) {
        bootstrap
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.SO_TIMEOUT, 3000)
                .option(ChannelOption.AUTO_CLOSE, true)
                //发送缓冲区大小, 内核参数: net.core.wmem_max
                .option(ChannelOption.SO_SNDBUF, 1024)
                //禁用 Nagle算法
                .option(ChannelOption.TCP_NODELAY, false)
                //从缓冲区读取数据大小,自适应调整
                .option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator())

        ;
    }


    @Override
    public byte[] read() {
        return new byte[0];
    }
}

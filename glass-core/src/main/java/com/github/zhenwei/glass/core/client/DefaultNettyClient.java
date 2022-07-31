package com.github.zhenwei.glass.core.client;

import com.github.zhenwei.glass.common.exceptions.GlassNettyException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;

public class DefaultNettyClient extends AbstractNettyClient {

    public DefaultNettyClient(String host, int port) throws GlassNettyException {
        DefaultProviderChannelInitializer initializer = new DefaultProviderChannelInitializer();
        ChannelFuture future = build(host, port, initializer, null, LogLevel.INFO);


    }

    @Override
    void operate(Bootstrap bootstrap) {
        bootstrap
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.SO_TIMEOUT, 2000)
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

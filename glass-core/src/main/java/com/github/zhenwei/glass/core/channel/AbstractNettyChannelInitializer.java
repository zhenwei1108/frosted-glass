package com.github.zhenwei.glass.core.channel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public abstract class AbstractNettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    public abstract void bindHandler(ChannelPipeline pipeline);


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        bindHandler(socketChannel.pipeline());
    }

}

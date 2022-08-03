package com.github.zhenwei.glass.core.server;

import com.github.zhenwei.glass.core.channel.AbstractNettyChannelInitializer;
import io.netty.channel.ChannelPipeline;

public class DefaultServerChannelInitializer extends AbstractNettyChannelInitializer {

    @Override
    public void bindHandler(ChannelPipeline pipeline) {
        //todo add decoder
    }

}

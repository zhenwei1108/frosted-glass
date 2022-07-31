package com.github.zhenwei.glass.core.client;

import com.github.zhenwei.glass.core.channel.AbstractNettyChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * @description: default impl for ChannelInitializer
 * @see  io.netty.channel.ChannelInitializer
 * @author: zhangzhenwei
 * @date: 2021/12/26 21:42
 */
public class DefaultProviderChannelInitializer extends AbstractNettyChannelInitializer {

    @Override
    public void bindOutboundHandler(ChannelPipeline pipeline) {
        //add list of OutboundHandler
    }
}
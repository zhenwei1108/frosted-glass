package com.github.zhenwei.glass.core.server;

import com.github.zhenwei.glass.common.exceptions.GlassNettyException;
import com.github.zhenwei.glass.core.channel.AbstractNettyChannelInitializer;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.util.concurrent.GenericFutureListener;

public class DefaultNettyServer extends AbstractNettyServer {

    public DefaultNettyServer(int port) throws GlassNettyException {
        this(port, new DefaultServerChannelInitializer());
    }

    public DefaultNettyServer(int port, AbstractNettyChannelInitializer initializer) throws GlassNettyException {
        this(port, initializer, null, LogLevel.INFO);
    }

    public DefaultNettyServer(int port, ChannelInitializer<SocketChannel> initializer, GenericFutureListener<ChannelPromise> listener, LogLevel level) throws GlassNettyException {
        super(port, initializer, listener, level);
    }

    @Override
    public void send(Object t) {

    }

    @Override
    public void close() {

    }

    @Override
    public byte[] read() {
        return new byte[0];
    }
}

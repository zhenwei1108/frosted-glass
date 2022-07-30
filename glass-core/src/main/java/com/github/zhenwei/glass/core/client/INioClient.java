package com.github.zhenwei.glass.core.client;

/**
 * @description: INettyClient
 *  Netty客户端抽象
 * @author: zhangzhenwei
 * @since: 1.0
 * @date: 2022/7/30  22:32
 */
public interface INioClient {

    void send(Object t);

    void close();

    byte[] read();


}

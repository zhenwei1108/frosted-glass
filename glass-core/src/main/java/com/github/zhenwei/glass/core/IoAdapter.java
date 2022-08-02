package com.github.zhenwei.glass.core;

public interface IoAdapter {

    void send(Object t);

    void close();

    byte[] read();

}

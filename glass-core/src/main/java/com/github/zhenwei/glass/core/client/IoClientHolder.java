package com.github.zhenwei.glass.core.client;

import java.util.concurrent.ConcurrentHashMap;

public class IoClientHolder {

    private static final ConcurrentHashMap<String, INioClient> clients = new ConcurrentHashMap<>(1);
}

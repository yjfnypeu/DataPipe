package com.lzh.nonview.datapipe.executor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public final class PipeExecutors {
    private static PipeExecutors executors = new PipeExecutors();
    private PipeExecutors () {
        register(UIExecutor.class, new UIExecutor());
        register(SubThreadExecutor.class, new SubThreadExecutor());
    }
    public static PipeExecutors get () {
        return executors;
    }
    private Map<Class<? extends Executor>, Executor> container = new ConcurrentHashMap<>();

    public <T extends Executor> void register(Class<T> clz, Executor t) {
        if (clz != null && t != null) {
            container.remove(clz);
            container.put(clz, t);
        }
    }

    public Executor find(Class<? extends Executor> clz) {
        try {
            Executor executor = container.get(clz);
            if (executor == null) {
                executor = clz.newInstance();
                register(clz, executor);
            }
            return executor;
        } catch (Throwable t) {
            return container.get(UIExecutor.class);
        }
    }
}

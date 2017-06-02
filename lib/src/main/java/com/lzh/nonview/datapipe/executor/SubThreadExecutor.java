package com.lzh.nonview.datapipe.executor;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SubThreadExecutor implements Executor {

    ExecutorService executor;

    public SubThreadExecutor() {
        executor = Executors.newSingleThreadExecutor(new Factory());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        executor.execute(command);
    }

    private static class Factory implements ThreadFactory {

        @Override
        public Thread newThread(@NonNull Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("PipeExecutor");
            thread.setUncaughtExceptionHandler(new ExceptionHandler());
            return thread;
        }
    }

    private static class ExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            // ignore. avoid crash
        }
    }
}

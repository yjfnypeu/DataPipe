package com.lzh.nonview.datapipe.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class UIExecutor implements Executor{

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }
}

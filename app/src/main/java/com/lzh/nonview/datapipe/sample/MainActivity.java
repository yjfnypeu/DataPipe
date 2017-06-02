package com.lzh.nonview.datapipe.sample;

import android.app.Activity;
import android.os.Bundle;

import com.lzh.nonview.datapipe.PipeCallback;
import com.lzh.nonview.datapipe.PipeManager;
import com.lzh.nonview.datapipe.sample.impl.CallbackPipeImpl;
import com.lzh.nonview.datapipe.sample.pipe.CallbackPipe;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registerAll)
    void registerAll() {
        PipeManager.register(CallbackPipe.class, new CallbackPipeImpl());
    }

    @OnClick(R.id.trigCallbackPipe)
    void trigCallbackPipe() {
        PipeManager.get(CallbackPipe.class).callback(new PipeCallback<Object>() {
            @Override
            public void onResponse(Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(Thread.currentThread());
                System.out.println(t.getMessage());
            }
        });
    }

}

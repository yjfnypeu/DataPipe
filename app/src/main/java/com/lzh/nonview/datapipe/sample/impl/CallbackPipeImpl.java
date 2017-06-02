package com.lzh.nonview.datapipe.sample.impl;

import com.lzh.nonview.datapipe.PipeCallback;
import com.lzh.nonview.datapipe.sample.pipe.CallbackPipe;

/**
 * Created by haoge on 2017/6/2.
 */

public class CallbackPipeImpl implements CallbackPipe{
    @Override
    public void callback(PipeCallback<Object> callback) {
        callback.onResponse("Say it works");
    }
}

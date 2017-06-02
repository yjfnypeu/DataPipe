package com.lzh.nonview.datapipe.sample.pipe;

import com.lzh.nonview.datapipe.Pipe;
import com.lzh.nonview.datapipe.PipeCallback;
import com.lzh.nonview.datapipe.annotations.Executors;
import com.lzh.nonview.datapipe.executor.SubThreadExecutor;

/**
 * Created by haoge on 2017/6/2.
 */

public interface CallbackPipe extends Pipe{

    @Executors(SubThreadExecutor.class)
    void callback(PipeCallback<Object> callback);
}

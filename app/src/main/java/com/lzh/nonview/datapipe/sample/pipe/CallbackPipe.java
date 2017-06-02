package com.lzh.nonview.datapipe.sample.pipe;

import com.lzh.nonview.datapipe.Pipe;
import com.lzh.nonview.datapipe.PipeCallback;

/**
 * Created by haoge on 2017/6/2.
 */

public interface CallbackPipe extends Pipe{

    void callback(PipeCallback<Object> callback);
}

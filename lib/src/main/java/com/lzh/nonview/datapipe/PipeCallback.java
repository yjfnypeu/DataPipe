package com.lzh.nonview.datapipe;

public interface PipeCallback<T> {

    void onResponse(T t);

    void onError(Throwable t);
}

package com.lzh.nonview.datapipe;

/**
 * This is a common callback to provided async task with {@link PipeManager}
 *
 * <p>For example, when you create new protocol pipe interface like below:
 *
 * <pre>
 * public interface CallbackPipe implements Pipe {
 *      void callbackMethod(Object arg, PipeCallback callback);
 * }
 * </pre>
 *
 * <p>Then, when you start task with <b>PipeManager.get(CallbackPipe.class).callbackMethod(arg, callback)</b> there's two ways for feed you back.
 *
 * <ol>
 *     <li>As it was unregistered. the framework should create an new {@link PipeException} for you with method {@link PipeCallback#onError(Throwable)}</li>
 *     <li>As it was registered. it depends on the concrete logic of impl class</li>
 * </ol>
 *
 * @param <T> The instance type that you need.
 */
public interface PipeCallback<T> {

    void onResponse(T t);

    void onError(Throwable t);
}

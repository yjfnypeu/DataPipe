package com.lzh.nonview.datapipe.annotations;


import com.lzh.nonview.datapipe.executor.UIExecutor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Executor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Executors {

    Class<? extends Executor> value() default UIExecutor.class;
}

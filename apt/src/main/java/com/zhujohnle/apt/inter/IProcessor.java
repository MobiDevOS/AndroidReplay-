package com.zhujohnle.apt.inter;


import com.zhujohnle.apt.AnnotationProcessor;

import javax.annotation.processing.RoundEnvironment;

/**
 * Created by baixiaokang on 16/10/8.
 * 注解处理器接口
 */

public interface IProcessor {
    void process(RoundEnvironment roundEnv, AnnotationProcessor mAbstractProcessor);
}

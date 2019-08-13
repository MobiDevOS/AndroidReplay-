package com.zhujohnle.apt;

import com.google.auto.service.AutoService;
import com.zhujohnle.annotation.InstanceFactory;
import com.zhujohnle.annotation.bindview.$;
import com.zhujohnle.apt.processor.InstanceProcessor;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

@AutoService(Processor.class)//自动生成 javax.annotation.processing.IProcessor 文件
@SupportedSourceVersion(SourceVersion.RELEASE_8)//java版本支持
public class AnnotationProcessor extends AbstractProcessor {
    public Filer mFiler; //文件相关的辅助类
    public Elements mElements; //元素相关的辅助类
    public Messager mMessager; //日志相关的辅助类

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        System.err.println("********开始解析注解INIT*******");
        super.init(processingEnvironment);

    }
    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> annotations = new HashSet<>();
        annotations.add(InstanceFactory.class.getCanonicalName());
        annotations.add($.class.getCanonicalName());
        return annotations;
    }



    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.err.println("********开始解析注解*******");
        mFiler = processingEnv.getFiler();
        mElements = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
        new InstanceProcessor().process(roundEnv, this);
        //new ApiFactoryProcessor().process(roundEnv, this);
       // new RouterProcessor().process(roundEnv, this);
        //new BindViewProcessor().process(roundEnv,this);
        return true;
    }
}

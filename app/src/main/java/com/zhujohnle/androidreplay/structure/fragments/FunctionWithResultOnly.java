package com.zhujohnle.androidreplay.structure.fragments;

public abstract class FunctionWithResultOnly<Result> extends Function {

    public FunctionWithResultOnly(String funName) {
        super(funName);
    }

    public abstract Result function();

}

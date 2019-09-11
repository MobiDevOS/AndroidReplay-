package com.zhujohnle.androidreplay.structure.fragments;

public abstract class FunctionWithParamWithResult<Result,Param> extends Function {

    public FunctionWithParamWithResult(String funName) {
        super(funName);
    }

    public abstract Result function(Param param);

}

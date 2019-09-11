package com.zhujohnle.androidreplay.structure.fragments;


public abstract class FunctionWithParamOnly<Param> extends Function {

    public FunctionWithParamOnly(String funName) {
        super(funName);
    }

    public abstract void function(Param param);


}

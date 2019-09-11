package com.zhujohnle.androidreplay.structure.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhujohnle.androidreplay.MainActivity;
import com.zhujohnle.androidreplay.R;

public class NoParamNoResultFragment extends BaseFragment {

    private Handler  mHandler;

    public NoParamNoResultFragment(Handler  handler) {
        // Required empty public constructor
        this.mHandler  = handler;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view  = inflater.inflate(R.layout.fragment_no_param_no_result, container, false);

        view.findViewById(R.id.txt_handle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message  message = mHandler.obtainMessage();
                message.what = 0x123;
                message.obj = "handle 通信";
                mHandler.sendMessage(message);
            }
        });


        view.findViewById(R.id.txt_noALl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFunctionManager.invokeNoAll(MainActivity.FunctionNoParamNoResult);

            }
        });
        view.findViewById(R.id.txt_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mFunctionManager.invokeNoAll(MainActivity.FunctionNoParamNoResult);
                String result =  mFunctionManager.invokeWithResultOnly(MainActivity.FunctionWithResultOnly,String.class);
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.txt_param).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFunctionManager.invokeWithParamOnly(MainActivity.FunctionWithParamOnly,"有参无返回值");
            }
        });
        view.findViewById(R.id.txt_withAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result =  mFunctionManager.invokeWithAll(MainActivity.FunctionWithParamWithResult,String.class,"有参有返回值");
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof MainActivity) {
//
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }



}

package com.zhujohnle.androidreplay.structure.fragments;

import android.content.Context;

import com.zhujohnle.androidreplay.MainActivity;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public FunctionManager mFunctionManager;
    private MainActivity mainActivity;

    public void setFunctionManager(FunctionManager mFunctionManager) {
        this.mFunctionManager = mFunctionManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity  = (MainActivity) context;
            mainActivity.setFunctionForFragment(getTag());
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

}

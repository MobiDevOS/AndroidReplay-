package com.zhujohnle.androidreplay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zhujohnle.androidreplay.ipc.aidl.client.ClientActivity;
import com.zhujohnle.androidreplay.structure.fragments.BaseFragment;
import com.zhujohnle.androidreplay.structure.fragments.FunctionManager;
import com.zhujohnle.androidreplay.structure.fragments.FunctionNoParamNoResult;
import com.zhujohnle.androidreplay.structure.fragments.FunctionWithParamOnly;
import com.zhujohnle.androidreplay.structure.fragments.FunctionWithParamWithResult;
import com.zhujohnle.androidreplay.structure.fragments.FunctionWithResultOnly;
import com.zhujohnle.androidreplay.structure.fragments.NoParamNoResultFragment;
import com.zhujohnle.androidreplay.utils.InjectView;
import com.zhujohnle.androidreplay.utils.InstanceUtil;
import com.zhujohnle.annotation.bindview.$;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
   @$(R.id.tv_binder_ipc)
   public View mView;

   MainPresenter mPresenter;

   public static final String FunctionNoParamNoResult = "FunctionNoParamNoResult";
   public static final String FunctionWithResultOnly = "FunctionWithResultOnly";
   public static final String FunctionWithParamOnly = "FunctionWithParamOnly";
   public static final String FunctionWithParamWithResult = "FunctionWithParamWithResult";

   private FragmentManager fm;


   private Handler  handler =  new Handler(){
      @Override
      public void handleMessage(Message msg) {
         super.handleMessage(msg);
         switch (msg.what){
            case 0x123:
               String message = (String) msg.obj;
               Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
               break;
         }
      }
   };
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      InjectView.bind(this);
      mView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            mPresenter = InstanceUtil.getInstance(MainPresenter.class);
            mPresenter.showToast(MainActivity.this);
            startActivity(new Intent(MainActivity.this, ClientActivity.class));
         }
      });
      fm = getSupportFragmentManager();
      FragmentTransaction ft = fm.beginTransaction();
      NoParamNoResultFragment noParamNoResultFragment = new NoParamNoResultFragment(handler);
      ft.add(R.id.fragment,noParamNoResultFragment,NoParamNoResultFragment.class.getName());
      ft.commit();
   }


   public void setFunctionForFragment(String tag){
      if (TextUtils.isEmpty(tag)){
         Log.e(MainActivity.class.getSimpleName(),"tag is null !");
         return;
      }
      BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
      FunctionManager functionManager = FunctionManager.getInstance();

      functionManager.addFunction(new FunctionNoParamNoResult(FunctionNoParamNoResult) {
         @Override
         public void function() {
            Toast.makeText(MainActivity.this, "无参无返回值", Toast.LENGTH_SHORT).show();
         }
      });

      functionManager.addFunction(new FunctionWithResultOnly(FunctionWithResultOnly) {
         @Override
         public String function() {
            return "无参有返回值";
         }
      });

      functionManager.addFunction(new FunctionWithParamOnly(FunctionWithParamOnly) {
         @Override
         public void function(Object o) {
            Toast.makeText(MainActivity.this, o.toString(), Toast.LENGTH_SHORT).show();
         }
      });

      functionManager.addFunction(new FunctionWithParamWithResult(FunctionWithParamWithResult) {
         @Override
         public Object function(Object o) {
            return o;
         }
      });

      fragment.setFunctionManager(functionManager);
   }




}

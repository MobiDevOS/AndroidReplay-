package com.zhujohnle.androidreplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhujohnle.androidreplay.ipc.aidl.client.ClientActivity;
import com.zhujohnle.annotation.bindview.$;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   @$(R.id.tv_binder_ipc)
   private View mView;

   MainPresenter mPresenter;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      //InjectView.bind(this);
      setContentView(R.layout.activity_main);
      mView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, ClientActivity.class));
         }
      });
   }


}

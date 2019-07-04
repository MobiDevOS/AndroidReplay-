package com.zhujohnle.androidreplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhujohnle.androidreplay.ipc.aidl.client.ClientActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      findViewById(R.id.tv_binder_ipc).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, ClientActivity.class));
         }
      });
   }


}

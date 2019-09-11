package com.zhujohnle.androidreplay;


import android.content.Context;
import android.widget.Toast;

import com.zhujohnle.annotation.InstanceFactory;

/**
 * @auth &{zhujiule}
 * @date 2019-08-11
 * @copyright 杭州物恋网科技有限公司
 **/
@InstanceFactory
public class MainPresenter  {

   public void showToast(Context mContext){
      Toast.makeText(mContext,"test",Toast.LENGTH_SHORT).show();
   }
}

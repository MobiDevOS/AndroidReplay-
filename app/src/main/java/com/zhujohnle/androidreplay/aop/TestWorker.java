package com.zhujohnle.androidreplay.aop;

/**
 * @auth &{zhujiule}
 * @date 2019-07-03
 * @copyright 杭州物恋网科技有限公司
 **/
public class TestWorker {
   Person iPerson ;

   public TestWorker(){
      iPerson = new Worker();
   }
   public void doWhat(){
      iPerson.say("我是工人");
   }
}

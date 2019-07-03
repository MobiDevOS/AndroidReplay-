package com.zhujohnle.androidreplay.aop;

/**
 * @auth &{zhujiule}
 * @date 2019-07-03
 * @copyright 杭州物恋网科技有限公司
 **/
public class Leader implements Person {

   public Leader(){
   }
   @Override
   public void printCategory() {
      System.out.println("Im a leader");
   }

   @Override
   public void say(String what) {
      System.out.println("Im a leader");

   }

   @Override
   public void walk(String where) {
      System.out.println("lead work");
   }
}

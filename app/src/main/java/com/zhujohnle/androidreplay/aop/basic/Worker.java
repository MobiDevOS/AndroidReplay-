package com.zhujohnle.androidreplay.aop.basic;

/**
 * @auth &{zhujiule}
 * @date 2019-07-03
 * @copyright 杭州物恋网科技有限公司
 **/
public class Worker implements Person {
   @Override
   public void say(String what) {
      System.out.println(what);
      System.out.println("Im a work");
   }

   @Override
   public void walk(String where) {
      System.out.println(where);
   }

   @Override
   public void printCategory() {
      System.out.println("Im a worker");
   }
}

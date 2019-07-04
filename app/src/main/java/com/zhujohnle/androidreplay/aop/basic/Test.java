package com.zhujohnle.androidreplay.aop.basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auth &{zhujiule}
 * @date 2019-07-03
 * @copyright 杭州物恋网科技有限公司
 *
 * aop 实现的原则是 要有一个想听的父类 这里是persion
 **/
public class Test {

   public static final void main(String args[]){
      final Leader leader = new Leader();

      Person IpensonImp = (Person) Proxy.newProxyInstance(Leader.class.getClassLoader(),new Class[]{Person.class}, new InvocationHandler() {
         @Override
         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method.invoke(leader,args);
            return proxy;
         }
      });



      //原本testworker 是 包含了一个work 这里偷偷给他放了个leader进去
      TestWorker mTestWork = new TestWorker();

      Field[] fields = mTestWork.getClass().getDeclaredFields();
      for (Field field : fields){
         field.setAccessible(true);
         if (field.getName().equals("iPerson")){
            try {
               field.set(mTestWork,IpensonImp);
            } catch (IllegalAccessException e) {
               e.printStackTrace();
            }
            break;
         }
      }

      mTestWork.doWhat();
   }




}

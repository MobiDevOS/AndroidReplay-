package com.zhujohnle.androidreplay.ipc.aidl.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import com.zhujohnle.androidreplay.IBookManager;
import com.zhujohnle.androidreplay.ipc.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth &{zhujiule}
 * @date 2019-07-04
 * @copyright 杭州物恋网科技有限公司
 **/
public class BookManagerService extends Service {

   private static final String TAG = "DEBUG-WCL: " + BookManagerService.class.getSimpleName();
   /*数据集合*/
   List<Book> mListBook = new ArrayList<>();

   Binder binder = new IBookManager.Stub(){

      @Override
      public List<Book> getBookList() throws RemoteException {
         return mListBook;
      }

      @Override
      public void addBook(Book book) throws RemoteException {
         mListBook.add(book);
      }
   };

   @Override
   public void onCreate() {
      super.onCreate();
      mListBook.add(new Book(1, "Android"));
      mListBook.add(new Book(2, "iOS"));
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
   }

   @Override
   public IBinder onBind(Intent intent) {
      return binder;
   }



}

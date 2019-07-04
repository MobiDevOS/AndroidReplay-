package com.zhujohnle.androidreplay.ipc.binder.service;

import android.os.IInterface;
import android.os.RemoteException;

import com.zhujohnle.androidreplay.ipc.Book;

import java.util.List;

public interface BookManager extends IInterface {

    List<Book> getBooks() throws RemoteException;

    void addBook(Book book) throws RemoteException;
}

package com.zhujohnle.androidreplay.ipc.binder.proxy;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import com.zhujohnle.androidreplay.ipc.Book;
import com.zhujohnle.androidreplay.ipc.binder.service.BookManager;
import com.zhujohnle.androidreplay.ipc.binder.service.Stub;

import java.util.List;

public class Proxy implements BookManager {

    private static final String DESCRIPTOR = "com.zhujohnle.androidreplay.ipc.binder.service.BookManager";

    private IBinder remote;

    public Proxy(IBinder remote) {

        this.remote = remote;
    }

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public List<Book> getBooks() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel replay = Parcel.obtain();
        List<Book> result;

        try {
            data.writeInterfaceToken(DESCRIPTOR);
            remote.transact(Stub.TRANSAVTION_getBooks, data, replay, 0);
            replay.readException();
            result = replay.createTypedArrayList(Book.CREATOR);
        } finally {
            replay.recycle();
            data.recycle();
        }
        return result;
    }

    @Override
    public void addBook(Book book) throws RemoteException {

        Parcel data = Parcel.obtain();
        Parcel replay = Parcel.obtain();

        try {
            data.writeInterfaceToken(DESCRIPTOR);
            if (book != null) {
                data.writeInt(1);
                book.writeToParcel(data, 0);
            } else {
                data.writeInt(0);
            }
            remote.transact(Stub.TRANSAVTION_addBook, data, replay, 0);
            replay.readException();
        } finally {
            replay.recycle();
            data.recycle();
        }
    }

    @Override
    public IBinder asBinder() {
        return remote;
    }
}

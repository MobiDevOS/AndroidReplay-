package com.zhujohnle.androidreplay.ipc.binder.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.zhujohnle.androidreplay.ipc.Book;
import com.zhujohnle.androidreplay.ipc.binder.proxy.Proxy;

import java.util.List;


public abstract class Stub extends Binder implements BookManager {

    private static final String DESCRIPTOR = "com.zhujohnle.androidreplay.ipc.binder.service.BookManager";

    public Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static BookManager asInterface(IBinder binder) {

        if (binder == null)
            return null;
        IInterface iin = binder.queryLocalInterface(DESCRIPTOR);
        if (iin != null && iin instanceof BookManager)
            return (BookManager) iin;
        return new Proxy(binder);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {

            case INTERFACE_TRANSACTION:
                reply.writeString(DESCRIPTOR);
                return true;

            case TRANSAVTION_getBooks:
                data.enforceInterface(DESCRIPTOR);
                List<Book> result = this.getBooks();
                reply.writeNoException();
                reply.writeTypedList(result);
                return true;

            case TRANSAVTION_addBook:
                data.enforceInterface(DESCRIPTOR);
                Book arg0 = null;
                if (data.readInt() != 0) {
                    arg0 = Book.CREATOR.createFromParcel(data);
                }
                this.addBook(arg0);
                reply.writeNoException();
                return true;

        }
        return super.onTransact(code, data, reply, flags);
    }

    public static final int TRANSAVTION_getBooks = IBinder.FIRST_CALL_TRANSACTION;
    public static final int TRANSAVTION_addBook = IBinder.FIRST_CALL_TRANSACTION + 1;
}

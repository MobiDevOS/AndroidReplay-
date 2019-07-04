package com.zhujohnle.androidreplay.ipc.aidl.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import com.zhujohnle.androidreplay.IBookManager;
import com.zhujohnle.androidreplay.R;
import com.zhujohnle.androidreplay.ipc.Book;
import com.zhujohnle.androidreplay.ipc.aidl.server.BookManagerService;

import java.util.List;
import java.util.logging.Logger;

import androidx.appcompat.app.AppCompatActivity;


public class ClientActivity extends AppCompatActivity {

    IBookManager mRemoteBookManager;
    private boolean isConnection = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Button btn = findViewById(R.id.addbook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isConnection){
                    return;
                }

                attemptToBindService();
            }
        });


        Button btnGetBooks = findViewById(R.id.getbooks);
        btnGetBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mRemoteBookManager!=null){
                    try {
                     List<Book> mListBooks =  mRemoteBookManager.getBookList();
                     if(mListBooks!=null){
                         Logger.getLogger(ClientActivity.class.getName()).info(mListBooks.toString());
                     }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void attemptToBindService() {
        Intent intent = new Intent(this, BookManagerService.class);
        intent.setAction("com.zhujohnle.androidreplay.ipc.aidl");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isConnection = true;
            IBookManager bookManager = IBookManager.Stub.asInterface(service);
            try {
                mRemoteBookManager = bookManager;
                Book newBook = new Book(3, "学姐的故事");
                bookManager.addBook(newBook);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnection = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if (!isConnection) {
            attemptToBindService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isConnection) {
            unbindService(serviceConnection);
        }
    }
}

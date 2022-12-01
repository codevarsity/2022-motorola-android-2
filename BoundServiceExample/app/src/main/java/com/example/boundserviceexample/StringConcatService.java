package com.example.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;

public class StringConcatService extends Service {

    public class StringConcatImpl extends IStringConcat.Stub {

        @Override
        public String concat(List<String> items) throws RemoteException {
            StringBuffer buffer = new StringBuffer();
            for (String item : items) {
                buffer.append(item);
            }

            return buffer.toString();
        }
    }
    public StringConcatService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new StringConcatImpl();
    }
}
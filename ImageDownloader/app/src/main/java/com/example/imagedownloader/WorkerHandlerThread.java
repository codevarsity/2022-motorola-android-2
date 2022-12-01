package com.example.imagedownloader;

import android.os.HandlerThread;

public class WorkerHandlerThread extends HandlerThread {

    public WorkerHandlerThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
    }
}

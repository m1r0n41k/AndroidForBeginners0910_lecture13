package com.drondon.androidforbeginners0910_lecture13;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends IntentService {

    public static final String EXTRA_KEY_COUNT = "extra.key.count";

    public static final String ACTION_COUNTER = "action.counter";

    public static int myCounter = 0;

    public MyService() {
        super("MyServiceThread");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        if (ACTION_COUNTER.equals(action)) {
            int counter = intent.getIntExtra(EXTRA_KEY_COUNT, 0);
            for (int i = 0; i < counter; i++) {
                myCounter = i;
                try {
                    Thread.sleep(500); // Очень сложная задача
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

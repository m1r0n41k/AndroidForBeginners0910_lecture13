package com.drondon.androidforbeginners0910_lecture13;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_LEVEL = "key.level";
    private int currentLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Сохранненные данные можно восстановить сдесь
        if (savedInstanceState != null) {
            currentLevel = savedInstanceState.getInt(STATE_LEVEL);
        }
        currentLevel++;
        Log.d(TAG, "onCreate: " + currentLevel);
    }

    private static final String TAG = "MainActivity_";

    // Сохраняем данные
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_LEVEL, currentLevel);// ++ для примера
        super.onSaveInstanceState(savedInstanceState);
    }

    // Восстанавливаем сохраненные  данные
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //currentLevel = savedInstanceState.getInt(STATE_LEVEL);
    }

}

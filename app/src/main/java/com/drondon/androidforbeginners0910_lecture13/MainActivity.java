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

    TextView counterTextView;
    Button buttonStart;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTextView = findViewById(R.id.counter);
        buttonStart = findViewById(R.id.start);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDownloadTask task = new MyDownloadTask();
                task.execute("http://mysite.com/logo.png");
            }
        });
    }

    class MyDownloadTask extends AsyncTask<String, Integer, File> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
            counterTextView.setText("Подготовка...");
        }

        @Override
        protected File doInBackground(String... strings) {
            Log.d(TAG, "doInBackground: " + Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return new File("/my_file.png");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d(TAG, "onProgressUpdate: " + Thread.currentThread().getName());
            counterTextView.setText("Загружено " + (values[0] + 1) + " %");
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            Log.d(TAG, "onPostExecute: " + Thread.currentThread().getName());
            counterTextView.setText("Готово!");
        }
    }

}

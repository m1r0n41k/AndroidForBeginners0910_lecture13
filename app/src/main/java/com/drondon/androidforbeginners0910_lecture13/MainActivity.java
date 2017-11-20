package com.drondon.androidforbeginners0910_lecture13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.setAction(MyService.ACTION_COUNTER);
                intent.putExtra(MyService.EXTRA_KEY_COUNT, 250);
                /*Context*/
                Log.d(TAG, "before: ");
                startService(intent);
                Log.d(TAG, "after: ");
                v.setEnabled(false);
                updateUI();
            }
        });
    }

    private void updateUI() {
        counterTextView.postDelayed(new Runnable() {
            @Override
            public void run() {
                counterTextView.setText("" + MyService.myCounter);
                updateUI();
            }
        }, 500);
    }


}

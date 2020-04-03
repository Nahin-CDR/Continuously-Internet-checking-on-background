package com.nahin.continuouslynetchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Observable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    Handler handler;
    Runnable runnable;
    int delay = 15*1000;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txtID);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 20 seconds

                if (isNetworkConnected()==true)
                {
                    textView.setText("Successfully connected !");
                }
                else
                {
                    textView.setText("No internet..!");
                }


                handler.postDelayed(this, 2000);
            }
        }, 5000);



    }




    private boolean isNetworkConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }



}

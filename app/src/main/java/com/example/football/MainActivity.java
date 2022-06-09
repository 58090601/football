package com.example.football;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer elephants = 0;
    private Integer ducks = 0;
    private TextView elephantsTextView;
    private TextView ducksTextView;

    private static final String TAG = "MainActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elephantsTextView = findViewById(R.id.elephants_score);
        ducksTextView = findViewById(R.id.ducks_score);
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddElephants(View view) {
        elephants++;
        elephantsTextView.setText(elephants.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddDucks(View view) {
        ducks++;
        ducksTextView.setText(ducks.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonClear(View view) {
        elephants = 0;
        ducks = 0;

        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Черные", elephants);
        outState.putInt("Белые", ducks);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("Черные")) {
            elephants = savedInstanceState.getInt("Чёрные");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("Белые"))) {
            ducks= savedInstanceState.getInt("Белые");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @SuppressLint("SetTextI18n")
    private void resetUI() {
        elephantsTextView.setText(elephants.toString());
        ducksTextView.setText(ducks.toString());
        Log.d(TAG, "resetUI");
    }
}
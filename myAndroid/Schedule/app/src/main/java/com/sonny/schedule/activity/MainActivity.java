package com.sonny.schedule.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sonny.schedule.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);


    }
}

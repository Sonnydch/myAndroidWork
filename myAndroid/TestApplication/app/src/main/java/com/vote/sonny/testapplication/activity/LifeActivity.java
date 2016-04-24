package com.vote.sonny.testapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.vote.sonny.testapplication.R;

public class LifeActivity extends AppCompatActivity {
    String message=LifeActivity.class.getSimpleName()+"Activity生命周期";
    int count=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count++;
        message+="->"+count+"onCreate";
        setContentView(R.layout.activity_life);
        showToast(message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        count++;
        message+="->"+count+"onStart";
        showToast(message);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        count++;
        message+="->"+count+"onRestart";
        showToast(message);
    }
    @Override
    protected void onResume() {
        super.onResume();
        count++;
        message+="->"+count+"onResume";
        showToast(message);

    }
/*
    @Override
    protected void onPostResume() {
        super.onPostResume();
        count++;
        message+="->"+count+"onPostResume";
        showToast(message);
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        count++;
        message+="->"+count+"onPause";
        showToast(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        count++;
        message+="->"+count+"onDestroy";
        showToast(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        count++;
        message+="->"+count+"onStop";
        showToast(message);
    }

 /*   @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        count++;
        message+="->"+count+"onSaveInstanceState";
        showToast(message);
    }
*/
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}

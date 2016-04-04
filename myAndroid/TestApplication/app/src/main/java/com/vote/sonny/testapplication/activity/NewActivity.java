package com.vote.sonny.testapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.vote.sonny.testapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NewActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.txtView)
    AwesomeTextView txtView;
    @InjectView(R.id.btn_finish)
    BootstrapButton btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ButterKnife.inject(this);

        initView();

    }

    private void initView(){

        getSupportActionBar().setTitle("新Activity");

        txtView.setText("这是新的activity");
        btnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_finish:
                finish();
                break;
        }

    }
}

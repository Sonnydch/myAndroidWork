package com.example.sonny.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {


    private TextView stuIdView;
    private  TextView stuNameView;

    private Button btn_return;

    private String stuId;
    private String stuName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        stuIdView = (TextView)findViewById(R.id.stuId_view_info);
        stuNameView = (TextView)findViewById(R.id.name_view_info);

        btn_return = (Button)findViewById(R.id.btn_finish);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        stuId = (String)bundle.get("stuId");
        stuName= (String)bundle.get("stuName");


        stuIdView.setText(stuId);
        stuNameView.setText(stuName);



    }

}

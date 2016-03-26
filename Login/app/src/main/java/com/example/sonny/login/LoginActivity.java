package com.example.sonny.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText studentId;
    private EditText studentName;
    private EditText password;
    private EditText confirm;
    private Button loginBtn;

    private String stuId;
    private String stuName;
    private String pass;
    private String conf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        studentId = (EditText)findViewById(R.id.stuId);
        studentName = (EditText)findViewById(R.id.nameText);
        password = (EditText)findViewById(R.id.passwordText);
        confirm = (EditText)findViewById(R.id.confirmText);
        loginBtn = (Button)findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                stuId = studentId.getText().toString();
                stuName = studentName.getText().toString();
                pass = password.getText().toString();
                conf = confirm.getText().toString();

                if(pass.equalsIgnoreCase("")||!conf.equalsIgnoreCase(pass)){
                    Toast.makeText(LoginActivity.this,"密码确认有误！",Toast.LENGTH_LONG).show();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("stuId",stuId);
                bundle.putString("stuName",stuName);
                bundle.putString("pass",pass);
                bundle.putString("conf",conf);

                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,InfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

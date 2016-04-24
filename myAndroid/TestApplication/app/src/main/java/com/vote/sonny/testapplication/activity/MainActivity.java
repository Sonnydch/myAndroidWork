package com.vote.sonny.testapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.marshalchen.common.ui.ToastUtil;
import com.vote.sonny.testapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.myText)
    TextView myText;
    @InjectView(R.id.btnText)
    BootstrapButton btnTest;
    @InjectView(R.id.btn_001)
    BootstrapButton btnStartActvt;
    @InjectView(R.id.btn_002)
    BootstrapButton btn002;
    @InjectView(R.id.btn_003)
    BootstrapButton btn003;
    @InjectView(R.id.btn_004)
    BootstrapButton btn004;
    @InjectView(R.id.btn_005)
    BootstrapButton btn005;
    @InjectView(R.id.btn_006)
    BootstrapButton btn006;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();
    }

    private void initView(){

        getSupportActionBar().setTitle("主页");
        //给页面上的视图赋值
        myText.setText("啦啦啦真牛逼");
        btnTest.setText("释放一个toast");
        btnStartActvt.setText("新建一个activity");
        btn002.setText("新建一个可展开item的Activity");
        btn003.setText("Activity生命周期演示");
        btn004.setText("tryFlex");
        btnTest.setOnClickListener(this);
        btnStartActvt.setOnClickListener(this);
        btn002.setOnClickListener(this);
        btn003.setOnClickListener(this);
        btn004.setOnClickListener(this);
        btn005.setOnClickListener(this);
        btn006.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnText:
                ToastUtil.showLong(this,"杜曹辉大天才");
                break;
            case R.id.btn_001:
                gotoActivityNew();
                break;
            case R.id.btn_002:
                Intent intent  = new Intent(MainActivity.this,ListTestActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_003:
                intent  = new Intent(MainActivity.this,LifeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_004:
                intent = new Intent(MainActivity.this,TryFlexActivity.class);
                startActivity(intent);
                break;
            default:
                ToastUtil.showLong(this, "模块仍在开发" + v.getId());

        }
    }

    private void gotoActivityNew(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, NewActivity.class);
        startActivity(intent);
    }
}

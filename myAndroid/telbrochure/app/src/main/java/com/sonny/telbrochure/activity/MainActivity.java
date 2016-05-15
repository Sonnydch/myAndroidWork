package com.sonny.telbrochure.activity;

import android.os.Bundle;

import com.sonny.telbrochure.R;
import com.sonny.telbrochure.fragment.MainFragment;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            start(MainFragment.newInstance());
        }
    }

    @Override
    protected int setContainerId() {
        return R.id.fl_container;
    }
}

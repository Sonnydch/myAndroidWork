package com.sonny.myzjutschedule;

import android.os.Bundle;
import com.sonny.myzjutschedule.fragment.MainFragment;
import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {

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
        return R.id.my_frame;
    }



}

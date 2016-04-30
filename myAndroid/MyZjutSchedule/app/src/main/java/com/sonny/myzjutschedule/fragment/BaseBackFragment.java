package com.sonny.myzjutschedule.fragment;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sonny.myzjutschedule.R;


/**
 * Created by YoKeyword on 16/2/7.
 */
public class BaseBackFragment extends BaseFragment {

    protected void initToolbarNav(Toolbar toolbar) {

        toolbar.setNavigationIcon(R.drawable.back002);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithFinish(MainFragment.newInstance());
            }
        });

        initToolbarMenu(toolbar);
    }
}

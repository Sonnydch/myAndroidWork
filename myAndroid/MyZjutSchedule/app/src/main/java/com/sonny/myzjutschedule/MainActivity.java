package com.sonny.myzjutschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.sonny.myzjutschedule.model.TimeTableModel;
import com.sonny.myzjutschedule.view.TimeTableView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.myToolbar)
    Toolbar myToolBar;
    private TimeTableView mTimaTableView;
    private List<TimeTableModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mList = new ArrayList<TimeTableModel>();
        mTimaTableView = (TimeTableView) findViewById(R.id.main_timetable_ly);
        addList();
        mTimaTableView.setTimeTable(mList);

        initView();
    }

    private void addList() {
        mList.add(new TimeTableModel(0, 1, 2, 1, "8:20", "10:10", "软件工程",
                "杜老师", "郁文楼", "2-13"));
        mList.add(new TimeTableModel(1, 3, 4, 1, "8:20", "10:10", "操作系统",
                "李老师", "博弈楼", "2-13"));
        mList.add(new TimeTableModel(2, 6, 7, 1, "8:20", "10:10", "linux",
                "王", "机房", "2-13"));
        mList.add(new TimeTableModel(3, 6, 7, 2, "8:20", "10:10", "体育课",
                "老师1", "田径场", "2-13"));

        mList.add(new TimeTableModel(4, 3, 4, 2, "8:20", "10:10", "多媒体",
                "老师1", "机房", "2-13"));

        mList.add(new TimeTableModel(5, 8, 9, 4, "8:20", "10:10", "数据库技术",
                "老师1", "法学楼", "2-13"));

        mList.add(new TimeTableModel(6, 3, 4, 5, "8:20", "10:10", "Java程序设计",
                "老师1", "广知楼", "2-13"));
    }

    private void initView(){
        myToolBar.setTitle("小表仔");
        myToolBar.inflateMenu(R.menu.main_menu);
        myToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.add_course){
                    Toast.makeText(getApplicationContext(),"添加课程",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }
}

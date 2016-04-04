package com.vote.sonny.testapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.marshalchen.common.ui.ToastUtil;
import com.pacific.adapter.ExpandableAdapter;
import com.pacific.adapter.ExpandableAdapterHelper;
import com.vote.sonny.testapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ListTestActivity extends AppCompatActivity {

    @InjectView(R.id.myExpdList)
    ExpandableListView myExpdList;

    //adapter
    ExpandableAdapter<HeaderName, Child> listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);
        ButterKnife.inject(this);

        initView();

        initData();



    }

    private void initView(){
        getSupportActionBar().setTitle("可展开ListView");
        listAdapter = new ExpandableAdapter<HeaderName,Child>(getApplicationContext(),R.layout.header_item,R.layout.child_item) {
            @Override
            protected List<Child> getChildren(int groupPosition) {
                return get(groupPosition).getChildList();
            }

            @Override
            protected void convertGroupView(final boolean isExpanded, final ExpandableAdapterHelper helper, HeaderName item) {
                helper.setText(R.id.tv_header_name,item.getName())
                        .getItemView()
                        .setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                if (isExpanded) {
                                    myExpdList.collapseGroup(helper.getGroupPosition());
                                } else {
                                    myExpdList.expandGroup(helper.getGroupPosition());
                                }
                        }});
            }

            @Override
            protected void convertChildView(boolean isLastChild, final ExpandableAdapterHelper helper, Child item) {
                helper.setText(R.id.tv_child_name,item.getName())
                        .getItemView()
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtil.showLong(getApplicationContext(),helper.getGroupPosition()+"的"+helper.getChildPosition());
                            }
                        });

            }

            @Override
            protected ExpandableAdapterHelper getAdapterHelper(int groupPosition, int childPosition, View convertView, ViewGroup parent) {
                return super.getAdapterHelper(groupPosition, childPosition, convertView, parent);
            }
        };


        myExpdList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        myExpdList.setAdapter(listAdapter);

    }
    private void initData(){

        List<HeaderName> headerList = new ArrayList<HeaderName>();
        HeaderName header;
        for(int i=0;i<5;i++){
            header = new HeaderName();
            header.setName("dchTestHeader"+i);
            headerList.add(header);
        }

        List<Child> childList ;
        for(HeaderName headerT : headerList){
            childList = new ArrayList<Child>();
            childList.add(new Child(R.drawable.buildings,"child001"));
            childList.add(new Child(R.drawable.buildings,"child002"));
            childList.add(new Child(R.drawable.buildings,"child003"));
            childList.add(new Child(R.drawable.buildings,"child004"));
            childList.add(new Child(R.drawable.buildings,"child005"));
            headerT.setChildList(childList);
        }

        listAdapter.addAll(headerList);

    }

    class HeaderName{
        String name;
        List<Child> childList;

        public List<Child> getChildList() {
            return childList;
        }

        public void setChildList(List<Child> childList) {
            this.childList = childList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    class Child{
        int imgRsId;
        String name;
        public Child(int img,String name){
            this.imgRsId = img;
            this.name = name;
        }

        public int getImgRsId() {
            return imgRsId;
        }

        public void setImgRsId(int imgRsId) {
            this.imgRsId = imgRsId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

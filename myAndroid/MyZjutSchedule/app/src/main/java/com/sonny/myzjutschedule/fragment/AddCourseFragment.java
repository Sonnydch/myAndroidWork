package com.sonny.myzjutschedule.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.marshalchen.common.ui.ToastUtil;
import com.sonny.myzjutschedule.Global;
import com.sonny.myzjutschedule.R;
import com.vi.swipenumberpicker.OnValueChangeListener;
import com.vi.swipenumberpicker.SwipeNumberPicker;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hotchemi.stringpicker.StringPicker;

/**
 * Created by sonny on 16-4-25.
 */
public class AddCourseFragment extends BaseBackFragment
        implements Toolbar.OnMenuItemClickListener{

    private OnFragmentInteractionListener mListener;

    private Toolbar mToolbar;
    private SwipeNumberPicker startnum;
    private SwipeNumberPicker endnum;
    private  StringPicker stringPicker;
    @InjectView(R.id.editText)
    EditText coursenameEt;
    @InjectView(R.id.editText2)
    EditText classroomEt;
    @InjectView(R.id.editText3)
    EditText teacherEt;
    String coursename;
    String classroom;
    String teacher;
    int id;
    int startn;
    int endn;
    int week;

    public AddCourseFragment(){

    }
    public static AddCourseFragment newInstance(){
        AddCourseFragment fragment = new AddCourseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        initDb();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_course, container, false);
        initView(view);
        ButterKnife.inject(this, view);
        return view;
    }

    private void initView(View view){
            mToolbar = (Toolbar) view.findViewById(R.id.ACtoolbar);
            stringPicker = (StringPicker) view.findViewById(R.id.string_picker);
            startnum = (SwipeNumberPicker) view.findViewById(R.id.number_picker);
            endnum = (SwipeNumberPicker) view.findViewById(R.id.number_picker_two);
            startnum.setOnValueChangeListener(new OnValueChangeListener() {
            @Override
            public boolean onValueChange(SwipeNumberPicker view, int oldValue, int newValue) {
                boolean isValueOk = (newValue & 1) == 0;
                startnum.setValue(newValue,false);
                return isValueOk;
            }
             });
            endnum.setOnValueChangeListener(new OnValueChangeListener() {
                @Override
                public boolean onValueChange(SwipeNumberPicker view, int oldValue, int newValue) {
                    boolean isValueOk = (newValue & 1) == 0;
                    endnum.setValue(newValue,false);
                    return isValueOk;
                }
            });

            String[] values = new String[] {"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
            stringPicker.setValues(values);
            stringPicker.getCurrentValue();
             initToolbarNav(mToolbar);
            mToolbar.setTitle("添加课程");
            mToolbar.inflateMenu(R.menu.course);
            mToolbar.setOnMenuItemClickListener(this);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId() == R.id.add_ok){
           if (getValue()){
                startWithFinish(MainFragment.newInstance());
           }
        }
        return true;
    }

    private boolean getValue(){
        teacher = teacherEt.getText().toString();
        coursename = coursenameEt.getText().toString();
        classroom = classroomEt.getText().toString();
        startn = startnum.getValue();
        endn = endnum.getValue();
        week = stringPicker.getCurrent()+1;
        if(check()){
            insertCourse(++Global.all,startn,endn,week,"","",coursename,teacher,classroom,"");
            return true;
        }else {
            return false;
        }
    }
    private boolean check(){
        if("".equalsIgnoreCase(teacher)){
            ToastUtil.showShort(_mActivity,"教师名不能为空");
            return false;
        }
        if("".equalsIgnoreCase(coursename)){
            ToastUtil.showShort(_mActivity,"课程名不能为空");
            return false;
        }
        if("".equalsIgnoreCase(classroom)){
            ToastUtil.showShort(_mActivity,"教室名不能为空");
            return false;
        }
        if(endn<=startn){
            ToastUtil.showShort(_mActivity,"课程节数错误");
            return false;
        }
        return true;
    }

}

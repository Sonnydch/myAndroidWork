package com.sonny.myzjutschedule.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.common.commonUtils.dbUtils.DataBaseUtils;
import com.sonny.myzjutschedule.Global;
import com.sonny.myzjutschedule.R;
import com.sonny.myzjutschedule.model.TimeTableModel;
import com.sonny.myzjutschedule.view.TimeTableView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainFragment extends BaseFragment {


    private OnFragmentInteractionListener mListener;

    @InjectView(R.id.myToolbar)
    Toolbar myToolBar;
    @InjectView(R.id.main_timetable_ly)
    TimeTableView mTimeTableView;
    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        mList = new ArrayList<TimeTableModel>();
        // addList();
        initData();
        detectChange();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);

        initView();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    private void initView(){
        myToolBar.setTitle("小表仔");
        myToolBar.inflateMenu(R.menu.main_menu);
        myToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.add_course){
                    //Toast.makeText(getApplicationContext(),"添加课程",Toast.LENGTH_SHORT).show();
                    startWithFinish(AddCourseFragment.newInstance());

                }
                return true;
            }
        });
        mTimeTableView.setTimeTable(mList);
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

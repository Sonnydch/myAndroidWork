package com.sonny.telbrochure.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sonny.telbrochure.R;
import com.sonny.telbrochure.adapter.ContactorAdapter;
import com.sonny.telbrochure.bean.Contactor;
import com.yokeyword.indexablelistview.IndexEntity;
import com.yokeyword.indexablelistview.IndexableStickyListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;


public class MainFragment extends BaseFragment {

    private OnListFragmentInteractionListener mListener;
    IndexableStickyListView mIndexableStickyListView;
    SearchView mSearchView;

    View headerView;
    TextView add;

    private List<Contactor> mContacts = new ArrayList<>();

    public MainFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
       // headerView= getLayoutInflater(savedInstanceState).inflate(R.layout.header_view, null);
        initView(view);
        return view;
    }

    private void initView(View view){

        _mActivity.getSupportActionBar().setTitle("联系人");

        mIndexableStickyListView = (IndexableStickyListView)view.findViewById(R.id.listView);
        add = (TextView)view.findViewById(R.id.my_head);
       // mSearchView =(SearchView)view.findViewById(R.id.searchview);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(NewContactFragment.newInstance());
            }
        });

       // mIndexableStickyListView.addHeaderView(headerView);

        ContactorAdapter adapter = new ContactorAdapter(_mActivity);
        mIndexableStickyListView.setAdapter(adapter);

        // 初始化数据
        List<String> contactStrings = Arrays.asList(getResources().getStringArray(R.array.contact_array));
        List<String> mobileStrings = Arrays.asList(getResources().getStringArray(R.array.mobile_array));
        for (int i = 0; i < contactStrings.size(); i++) {
            Contactor contact = new Contactor(contactStrings.get(i), mobileStrings.get(i));
            mContacts.add(contact);
        }

        mIndexableStickyListView.bindDatas(mContacts);

        mIndexableStickyListView.setOnItemContentClickListener(new IndexableStickyListView.OnItemContentClickListener() {
            @Override
            public void onItemClick(View v, IndexEntity indexEntity) {
                Contactor contactEntity = (Contactor) indexEntity;
                Bundle bundle = new Bundle();
                bundle.putSerializable("contactor", contactEntity);

                Toast.makeText(_mActivity,contactEntity.getName(),Toast.LENGTH_LONG).show();
                SupportFragment fragment = NewContactFragment.newInstance();
                fragment.setArguments(bundle);
                start(fragment);

            }

        });


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);/*
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction();
    }
}

package com.sonny.telbrochure.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonny.telbrochure.R;
import com.sonny.telbrochure.bean.Contactor;

public class NewContactFragment extends BaseFragment {
    private OnFragmentInteractionListener mListener;

    private EditText nameEt;
    private EditText phontEt;
    private Button saveBtn;
    private Button deleteBtn;

    String name;
    String phone;
    public NewContactFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NewContactFragment newInstance() {
        NewContactFragment fragment = new NewContactFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args  = getArguments();
            Contactor con = (Contactor)args.getSerializable("contactor");
            //Toast.makeText(_mActivity,"args",Toast.LENGTH_LONG).show();
            if(con !=null){
                name = con.getName();
                phone = con.getMobile();
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_contact, container, false);

        initView(view);
        return view;
    }

    private void initView(View view){

        nameEt = (EditText)view.findViewById(R.id.editText);
        phontEt = (EditText)view.findViewById(R.id.editText2);
        saveBtn =(Button)view.findViewById(R.id.button);
        deleteBtn=(Button)view.findViewById(R.id.delete);

        nameEt.setText(name);
        phontEt.setText(phone);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(_mActivity,"完成",Toast.LENGTH_SHORT).show();
                pop();
            }
        });


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

package com.example.daniel.koerelogbogapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link createEntryWithManualInput.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link createEntryWithManualInput#newInstance} factory method to
 * create an instance of this fragment.
 */
public class createEntryWithManualInput extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText companyName;
    private EditText companyAddress;

    // TODO: Rename and change types and number of parameters
    public static createEntryWithManualInput newInstance(String param1, String param2) {
        createEntryWithManualInput fragment = new createEntryWithManualInput();
        Bundle args = new Bundle();
        return fragment;
    }

    public createEntryWithManualInput() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_entry_with_manual_input, container, false);
        companyName = (EditText) rootView.findViewById(R.id.inputCompanyName);
        companyAddress = (EditText) rootView.findViewById(R.id.inputCompanyAddress);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public String getCompanyName(){
        return (companyName != null) ? companyName.getText().toString() : "";
    }

    public String getCompanyAddress(){
        return (companyAddress != null) ? companyAddress.getText().toString() : "";
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
        public void onFragmentInteraction(Uri uri);
    }

}

package com.example.hp_2000.engineer_way_02;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_bank_faq extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Banking FAQs");
        return inflater.inflate(R.layout.fragment_frag_bank_faq, container, false);
    }

}

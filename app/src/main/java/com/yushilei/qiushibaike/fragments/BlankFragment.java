package com.yushilei.qiushibaike.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yushilei.qiushibaike.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private static final String TEXT = "text";

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString(TEXT, text);
        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle.containsKey(TEXT)) {
            String s = bundle.getString(TEXT);
            TextView text = (TextView) view.findViewById(R.id.blank_fragment_text);
            text.setText(s);

        }

    }
}

package com.akatowolf.sarku_japan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akatowolf.sarku_japan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class mandariyakiFragment extends Fragment {


    public mandariyakiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mandariyaki, container, false);
    }

}

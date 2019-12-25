
package com.zt.details.PackageHome;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.zt.details.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private TextView txtTitle;
    private View view;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileFragment(TextView txt) {
        // Required empty public constructor
        this.txtTitle=txt;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        txtTitle.setText(getResources().getString(R.string.profile));
        HomeActivity.changeBar(R.id.profile,getResources().getString(R.string.profile));
    }
}
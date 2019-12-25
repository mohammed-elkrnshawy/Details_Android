package com.zt.details.PackageHome;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.zt.details.PackageStores.StoresActivity;
import com.zt.details.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    @BindView(R.id.line)
    LinearLayout linear;

    private TextView txtTitle;

    View view;

    public MoreFragment() {
        // Required empty public constructor
    }

    public MoreFragment(TextView txtTitle) {
        this.txtTitle=txtTitle;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this,view);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), StoresActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        txtTitle.setText(getResources().getString(R.string.more));
        HomeActivity.changeBar(R.id.more,getResources().getString(R.string.more));
    }

}
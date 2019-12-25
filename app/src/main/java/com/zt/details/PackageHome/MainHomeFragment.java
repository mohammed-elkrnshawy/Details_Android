package com.zt.details.PackageHome;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zt.details.PackageTry.AdapterTry;
import com.zt.details.PackageTry.ClassTry;
import com.zt.details.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainHomeFragment extends Fragment {

    private View view;

    @BindView(R.id.recycle_discount)
    RecyclerView recycle_discount;
    @BindView(R.id.recycle_product)
    RecyclerView recycle_product;
    @BindView(R.id.recycle_rate)
    RecyclerView recycle_rate;

    private RelativeLayout rlv_search;
    private TextView txtTitle;

    private ClassTry classTry;
    private List<ClassTry> tryList=new ArrayList<>();
    private LinearLayoutManager layoutManager ;
    private AdapterTry adapterTry;

    public MainHomeFragment() {
        // Required empty public constructor
    }

    public MainHomeFragment(RelativeLayout rlv_search,TextView txt) {
        // Required empty public constructor
        this.rlv_search=rlv_search;
        this.txtTitle=txt;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_main_home, container, false);
        ButterKnife.bind(this,view);

        classTry=new ClassTry();
        classTry.setName("تيشرت هالك");
        classTry.setPrice(103.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        layoutManager = new GridLayoutManager(getContext(),2) ;
        recycle_product.setLayoutManager(layoutManager);
        //recycle.setHasFixedSize(true);
        adapterTry = new AdapterTry(getContext() , tryList);
        recycle_product.setAdapter(adapterTry);


        layoutManager = new GridLayoutManager(getContext(),2) ;
        recycle_discount.setLayoutManager(layoutManager);
        recycle_discount.setAdapter(adapterTry);


        layoutManager = new GridLayoutManager(getContext(),2) ;
        recycle_rate.setLayoutManager(layoutManager);
        recycle_rate.setAdapter(adapterTry);




        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        rlv_search.setVisibility(View.VISIBLE);
        txtTitle.setText(getResources().getString(R.string.home));
        HomeActivity.changeBar(R.id.home,getResources().getString(R.string.home));
    }

    @Override
    public void onPause() {
        super.onPause();
        rlv_search.setVisibility(View.GONE);
    }
}

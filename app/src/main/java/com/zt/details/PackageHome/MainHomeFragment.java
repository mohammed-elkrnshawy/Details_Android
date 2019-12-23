package com.zt.details.PackageHome;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


    private ClassTry classTry;
    private List<ClassTry> tryList=new ArrayList<>();
    private LinearLayoutManager layoutManager ;
    private AdapterTry adapterTry;

    public MainHomeFragment() {
        // Required empty public constructor
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

}

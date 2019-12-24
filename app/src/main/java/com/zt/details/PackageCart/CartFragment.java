package com.zt.details.PackageCart;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zt.details.PackageTry.AdapterTry;
import com.zt.details.PackageTry.AdapterTryCart;
import com.zt.details.PackageTry.ClassTry;
import com.zt.details.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private View view;
    private ClassTry classTry;
    private List<ClassTry> tryList=new ArrayList<>();
    private LinearLayoutManager layoutManager ;
    private AdapterTryCart adapterTry;

    @BindView(R.id.recycle_cart)
    RecyclerView recycle_cart;
    @BindView(R.id.btn_continue)
    Button btn_continue;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        ButterKnife.bind(this,view);


        classTry=new ClassTry();
        classTry.setName("تيشرت هالك");
        classTry.setPrice(103.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        layoutManager = new LinearLayoutManager(getContext()) ;
        recycle_cart.setLayoutManager(layoutManager);
        //recycle.setHasFixedSize(true);
        adapterTry = new AdapterTryCart(getContext() , tryList);
        recycle_cart.setAdapter(adapterTry);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),DeliveryActivity.class));
            }
        });

        return view;
    }

}

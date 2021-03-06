package com.zt.details.PackageHome;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
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
    @BindView(R.id.image_slider)
    ImageSlider image_slider;

    private RelativeLayout rlv_search;
    private TextView txtTitle;

    private ClassTry classTry;
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

        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.offers));
        imageList.add(new SlideModel(R.drawable.offer2));
        imageList.add(new SlideModel(R.drawable.offer3));

        List<ClassTry> tryList=new ArrayList<>();

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
        recycle_product.setHasFixedSize(true);
        adapterTry = new AdapterTry(getContext() , tryList);
        recycle_product.setAdapter(adapterTry);


        layoutManager = new GridLayoutManager(getContext(),2) ;
        recycle_discount.setLayoutManager(layoutManager);
        recycle_discount.setAdapter(adapterTry);
        recycle_discount.setHasFixedSize(true);



        layoutManager = new GridLayoutManager(getContext(),2) ;
        recycle_rate.setLayoutManager(layoutManager);
        recycle_rate.setAdapter(adapterTry);
        recycle_rate.setHasFixedSize(true);


        image_slider.setImageList(imageList, true); // centerCrop for all images
        image_slider.startSliding(2500);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        rlv_search.setVisibility(View.VISIBLE);
        txtTitle.setText(getResources().getString(R.string.home));
        HomeActivity.changeBar(R.id.home,getResources().getString(R.string.home));
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    ((Activity)getContext()).finishAffinity();
                    return true ;
                }
                return false;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        rlv_search.setVisibility(View.GONE);
    }
}

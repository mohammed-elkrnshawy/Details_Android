package com.zt.details.PackageStores;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.recycle_product)
    RecyclerView recycle_product;

    private ClassTry classTry;
    private List<ClassTry> tryList=new ArrayList<>();
    private LinearLayoutManager layoutManager ;
    private AdapterTry adapterTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        classTry=new ClassTry();
        classTry.setName("تيشرت هالك");
        classTry.setPrice(103.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        layoutManager = new GridLayoutManager(this,2) ;
        recycle_product.setLayoutManager(layoutManager);
        //recycle.setHasFixedSize(true);
        adapterTry = new AdapterTry(this , tryList);
        recycle_product.setAdapter(adapterTry);


    }
}

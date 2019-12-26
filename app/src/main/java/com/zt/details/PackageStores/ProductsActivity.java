package com.zt.details.PackageStores;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zt.details.PackageTry.AdapterTry;
import com.zt.details.PackageTry.AdapterTryProduct;
import com.zt.details.PackageTry.ClassTry;
import com.zt.details.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.recycle_product)
    RecyclerView recycle_product;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ClassTry classTry;
    private List<ClassTry> tryList=new ArrayList<>();
    private LinearLayoutManager layoutManager ;
    private AdapterTryProduct adapterTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);
        setToolBar();

        classTry=new ClassTry();
        classTry.setName("عربة شيكولاتة للخفلات");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("شيكولاتة جلاكسي");
        classTry.setPrice(103.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("شيكولاتة مورو");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("شيكولانة شنيكرز");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("شيكولاتة كات");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("شيكولاتة توينكس");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("شيكولاتة مارس");
        classTry.setPrice(840.50);
        tryList.add(classTry);



        layoutManager = new GridLayoutManager(this,2) ;
        recycle_product.setLayoutManager(layoutManager);
        //recycle.setHasFixedSize(true);
        adapterTry = new AdapterTryProduct(this , tryList);
        recycle_product.setAdapter(adapterTry);

    }

    private void setToolBar(){
        setSupportActionBar(toolbar);
        final LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (inflator != null) {
            view = inflator.inflate(R.layout.bar_home, null);
        }
        TextView txtTitle = view.findViewById(R.id.txtTitle) ;
        txtTitle.setText("محلات الشوكولاه");
        toolbar.addView(view);
    }
}

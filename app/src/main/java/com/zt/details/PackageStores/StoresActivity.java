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

import com.zt.details.PackageTry.AdapterTryStore;
import com.zt.details.PackageTry.ClassTry;
import com.zt.details.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresActivity extends AppCompatActivity {

    @BindView(R.id.recycle_store)
    RecyclerView recycle_store;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private TextView txtTitle;
    private ClassTry classTry;
    private List<ClassTry> tryList=new ArrayList<>();
    private LinearLayoutManager layoutManager ;
    private AdapterTryStore adapterTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        ButterKnife.bind(this);
        setToolBar();
        classTry=new ClassTry();
        classTry.setName("محلات شيكولاتة الجبل");
        classTry.setPrice(103.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("محلات شيكولاتة العيد");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("محلات شيكولاتة العبد");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("محلات شيكولاتة الكبير");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("محلات شيكولاتة زمان");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("محلات شيكولاتة الاطفال");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        layoutManager = new GridLayoutManager(this,2) ;
        recycle_store.setLayoutManager(layoutManager);
        //recycle.setHasFixedSize(true);
        adapterTry = new AdapterTryStore(this , tryList);
        recycle_store.setAdapter(adapterTry);

    }

    private void setToolBar(){
        setSupportActionBar(toolbar);
        final LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (inflator != null) {
            view = inflator.inflate(R.layout.bar_home, null);
        }
        txtTitle = view.findViewById(R.id.txtTitle) ;
        txtTitle.setText("محلات الشوكولاه");
        toolbar.addView(view);
    }
}

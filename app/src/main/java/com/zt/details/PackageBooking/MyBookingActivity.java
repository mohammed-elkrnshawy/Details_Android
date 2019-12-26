package com.zt.details.PackageBooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zt.details.PackageTry.AdapterTry;
import com.zt.details.PackageTry.AdapterTryBooking;
import com.zt.details.PackageTry.ClassTry;
import com.zt.details.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBookingActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_booking)
    RecyclerView recycle_booking;

    private ClassTry classTry;
    private LinearLayoutManager layoutManager ;
    private AdapterTryBooking adapterTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);
        ButterKnife.bind(this);
        setToolBar();

        List<ClassTry> tryList=new ArrayList<>();

        classTry=new ClassTry();
        classTry.setName("تيشرت هالك");
        classTry.setPrice(103.50);
        tryList.add(classTry);


        classTry=new ClassTry();
        classTry.setName("جاكت هالك");
        classTry.setPrice(840.50);
        tryList.add(classTry);


        layoutManager = new LinearLayoutManager(this) ;
        recycle_booking.setLayoutManager(layoutManager);
        recycle_booking.setHasFixedSize(true);
        adapterTry = new AdapterTryBooking(this, tryList);
        recycle_booking.setAdapter(adapterTry);

    }

    private void setToolBar(){
        setSupportActionBar(toolbar);
        final LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (inflator != null) {
            view = inflator.inflate(R.layout.bar_home, null);
        }
        TextView textView=view.findViewById(R.id.txtTitle);
        textView.setText(getResources().getString(R.string.booking));
        toolbar.addView(view);
    }


}

package com.zt.details.PackageProductDetails;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.zt.details.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailsActivity extends AppCompatActivity {

    @BindView(R.id.txt_product)
    TextView txt_product;
    @BindView(R.id.txt_details)
    TextView txt_details;
    @BindView(R.id.txt_rate)
    TextView txt_rate;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String preTitle = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        setToolBar();
        setFragment(new ProductFragment(),getResources().getString(R.string.product));
        txt_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_rate.setBackground(getResources().getDrawable(R.drawable.shape_btn));
                txt_rate.setTextColor(getResources().getColor(R.color.ColorWhite));
                setFragment(new RateFragment(),getResources().getString(R.string.rate));

                txt_details.setTextColor(getResources().getColor(R.color.colorBlack));
                txt_product.setTextColor(getResources().getColor(R.color.colorBlack));
                txt_details.setBackground(null);
                txt_product.setBackground(null);
            }
        });

        txt_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_details.setBackground(getResources().getDrawable(R.drawable.shape_btn));
                txt_details.setTextColor(getResources().getColor(R.color.ColorWhite));
                setFragment(new DetailsFragment(),getResources().getString(R.string.details));

                txt_product.setTextColor(getResources().getColor(R.color.colorBlack));
                txt_rate.setTextColor(getResources().getColor(R.color.colorBlack));
                txt_rate.setBackground(null);
                txt_product.setBackground(null);
            }
        });

        txt_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_product.setBackground(getResources().getDrawable(R.drawable.shape_btn));
                txt_product.setTextColor(getResources().getColor(R.color.ColorWhite));
                setFragment(new ProductFragment(),getResources().getString(R.string.product));

                txt_details.setTextColor(getResources().getColor(R.color.colorBlack));
                txt_rate.setTextColor(getResources().getColor(R.color.colorBlack));
                txt_details.setBackground(null);
                txt_rate.setBackground(null);
            }
        });

    }

    private void setFragment(Fragment fragment, String Title) {
        if (!preTitle.equals(Title)){
           /* fragmentBundle.putSerializable(Constant.userFlag,userObject);
            fragmentBundle.putString(Constant.TypeTag,stringType);
            fragment.setArguments(fragmentBundle);*/
            getSupportFragmentManager().beginTransaction().replace(R.id.conainerDetails,fragment)
                    .commitAllowingStateLoss();
            preTitle = Title ;
        }

    }

    private void setToolBar(){
        setSupportActionBar(toolbar);
        final LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (inflator != null) {
            view = inflator.inflate(R.layout.bar_product_details, null);
        }

        toolbar.addView(view);
    }
}

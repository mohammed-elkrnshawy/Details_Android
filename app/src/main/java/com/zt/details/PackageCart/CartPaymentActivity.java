package com.zt.details.PackageCart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zt.details.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartPaymentActivity extends AppCompatActivity {

    @BindView(R.id.btn_continue)
    Button btn_continue;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment);
        ButterKnife.bind(this);
        setToolBar();
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartPaymentActivity.this, CartBriefActivity.class));
            }
        });
    }

    private void setToolBar(){
        setSupportActionBar(toolbar);
        final LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (inflator != null) {
            view = inflator.inflate(R.layout.bar_cart_payment, null);
        }

        toolbar.addView(view);
    }
}

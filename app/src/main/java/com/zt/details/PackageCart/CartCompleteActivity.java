package com.zt.details.PackageCart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zt.details.PackageHome.HomeActivity;
import com.zt.details.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartCompleteActivity extends AppCompatActivity {

    @BindView(R.id.btn_confirm)
    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_complete);
        ButterKnife.bind(this);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                startActivity(new Intent(CartCompleteActivity.this, HomeActivity.class));
            }
        });
    }
}

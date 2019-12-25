package com.zt.details.PackageCart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zt.details.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartPaymentActivity extends AppCompatActivity {

    @BindView(R.id.btn_continue)
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment);
        ButterKnife.bind(this);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartPaymentActivity.this, CartCompleteActivity.class));
            }
        });
    }
}

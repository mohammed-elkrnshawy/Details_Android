package com.zt.details.PackageHome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zt.details.PackageCart.CartFragment;
import com.zt.details.R;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView navigation;

   /* private static userData userObject;
    private String stringType;
    private RelativeLayout relativeFlight,relativeHotel,relativeCar;
    private ImageView imgFlight,imgHotel,imgCar;
    private TextView txtFlight,txtHotel,txtCar;
    private Bundle fragmentBundle=new Bundle();*/
    private String preTitle = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
        onBottomItemClicked();
    }

    private void initComponents() {
        navigation = findViewById(R.id.navigation) ;
        navigation.setSelectedItemId(R.id.home);
    }

    private void setFragment(Fragment fragment, String Title) {
        if (!preTitle.equals(Title)){
           /* fragmentBundle.putSerializable(Constant.userFlag,userObject);
            fragmentBundle.putString(Constant.TypeTag,stringType);
            fragment.setArguments(fragmentBundle);*/
            getSupportFragmentManager().beginTransaction().replace(R.id.conainerHome,fragment).addToBackStack(Title)
                    .commitAllowingStateLoss();
            preTitle = Title ;
        }

    }

    private void onBottomItemClicked(){
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        setFragment(new MainHomeFragment(),getResources().getString(R.string.home));
                        return true;
                    case R.id.cart:
                        setFragment(new CartFragment(),getResources().getString(R.string.cart));
                        return true;
                    case R.id.profile:
                        setFragment(new ProfileFragment(),getResources().getString(R.string.profile));
                        return true;
                    case R.id.more:
                        setFragment(new MoreFragment(),getResources().getString(R.string.more));
                        return true;
                }
                return false ;
            }
        });
    }
}

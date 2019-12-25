package com.zt.details.PackageHome;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zt.details.PackageCart.CartFragment;
import com.zt.details.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private RelativeLayout rlv_Search;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


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
        ButterKnife.bind(this);
        initComponents();
        setToolBar();
        onBottomItemClicked();
        navigation.setSelectedItemId(R.id.home);
    }

    private void initComponents() {
        navigation = findViewById(R.id.navigation) ;
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
                        setFragment(new MainHomeFragment(rlv_Search),getResources().getString(R.string.home));
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
                    case R.id.service:
                        setFragment(new ServiceFragment(),getResources().getString(R.string.service));
                        return true;
                }
                return false ;
            }
        });
    }

    private void setToolBar(){
        setSupportActionBar(toolbar);
        final LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (inflator != null) {
            view = inflator.inflate(R.layout.bar_home, null);
        }

        rlv_Search = view.findViewById(R.id.rlv_Search) ;

        toolbar.addView(view);


        /*menu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        });

        cart.setOnClickListener(v -> {
            if (SharedClass.isLogin) {
                Intent intent = new Intent(HomeActivity.this, CartsActivity.class);
                intent.putExtra("data", userdata);
                startActivity(intent);
            } else {
                Toast.makeText(HomeActivity.this, getString(R.string.mustLogin), Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SearchBranchActivity.class);
            intent.putExtra("userObject", userdata);
            startActivity(intent);
        });*/

    }


}

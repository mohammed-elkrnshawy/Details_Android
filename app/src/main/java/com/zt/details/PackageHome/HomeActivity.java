package com.zt.details.PackageHome;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    private static BottomNavigationView navigation;
    private RelativeLayout rlv_Search;
    private TextView txtTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private static String preTitle = "" ;

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
                        setFragment(new MainHomeFragment(rlv_Search,txtTitle),getResources().getString(R.string.home));
                        return true;
                    case R.id.cart:
                        setFragment(new CartFragment(txtTitle),getResources().getString(R.string.cart));
                        return true;
                    case R.id.profile:
                        setFragment(new ProfileFragment(txtTitle),getResources().getString(R.string.profile));
                        return true;
                    case R.id.more:
                        setFragment(new MoreFragment(txtTitle),getResources().getString(R.string.more));
                        return true;
                    /*case R.id.service:
                        setFragment(new ServiceFragment(),getResources().getString(R.string.service));
                        return true;*/
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
        txtTitle = view.findViewById(R.id.txtTitle) ;

        toolbar.addView(view);
    }

    public static void changeBar(int id,String Title){
        preTitle=Title;
       navigation.setSelectedItemId(id);
    }

    @Override
    protected void onPause() {
        super.onPause();
        preTitle="";
    }
}

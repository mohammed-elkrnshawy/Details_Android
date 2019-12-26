package com.zt.details.PackageTry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zt.details.PackageProductDetails.ProductDetailsActivity;
import com.zt.details.PackageProductDetails.ServiceDetailsActivity;
import com.zt.details.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTryBooking extends RecyclerView.Adapter<AdapterTryBooking.ViewHolder> {

    private Context context ;
    private List<ClassTry> offerList ;

    public AdapterTryBooking(Context context, List<ClassTry> offerList) {
        this.context = context;
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_my_booking , viewGroup , false) ;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {



    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View view) {
            super(view);
        }
    }
}
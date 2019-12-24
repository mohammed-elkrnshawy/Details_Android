package com.zt.details.PackageTry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zt.details.PackageProductDetails.ProductDetailsActivity;
import com.zt.details.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTry extends RecyclerView.Adapter<AdapterTry.ViewHolder> {

    private Context context ;
    private List<ClassTry> offerList ;

    public AdapterTry(Context context, List<ClassTry> offerList) {
        this.context = context;
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_product_item , viewGroup , false) ;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {


        holder.txt_name.setText(offerList.get(i).getName());
        holder.txt_price.setText(offerList.get(i).getPrice()+" "+"$");
            //holder.layout.setVisibility(View.VISIBLE);
            /*holder.layoutTrip.setVisibility(View.GONE);
            holder.txtPassenger.setText(offerList.get(i).getPassengers());
            holder.txtDoor.setText(offerList.get(i).getDoors());
            holder.txtGear.setText(offerList.get(i).getGears());
            holder.txtCrystal.setText(offerList.get(i).getAc());
            holder.txtNameCar.setText(offerList.get(i).getName());
            holder.txtLocation.setText(offerList.get(i).getAddress());
            holder.txtPrice.setText(String.format("%s %s", offerList.get(i).getPrice(), offerList.get(i).getCurrency()));
            holder.txtPrice.setPaintFlags(holder.txtPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.txtOffer.setText(String.format("%s %s", offerList.get(i).getOffer(), offerList.get(i).getCurrency()));
        */

        holder.card_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.txt_name)
        TextView txt_name;
        @BindView(R.id.txt_price)
        TextView txt_price;
        @BindView(R.id.card_parent)
        LinearLayout card_parent;


        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
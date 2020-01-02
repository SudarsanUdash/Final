package com.sudarsanudash.ilamteagarden.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sudarsanudash.ilamteagarden.ModelClasses.ShopNowProducts;
import com.sudarsanudash.ilamteagarden.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShopNowProductsAdapter extends RecyclerView.Adapter<ShopNowProductsAdapter.ShopNowProductsViewHolder>{

Context mContext;
    List<ShopNowProducts>shopNowProductsList;

    public ShopNowProductsAdapter( List<ShopNowProducts> shopNowProductsList) {

        this.shopNowProductsList = shopNowProductsList;
    }

    @NonNull
    @Override
    public ShopNowProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopnow_layout,parent,false);

        return new ShopNowProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopNowProductsViewHolder shopNowProductsViewHolder, int position) {
      final ShopNowProducts shopNowProducts = shopNowProductsList.get(position);
        shopNowProductsViewHolder.ivImage.setImageResource(shopNowProducts.getIvImage());
        shopNowProductsViewHolder.tvName.setText(shopNowProducts.getTvName());
        shopNowProductsViewHolder.tvPrice.setText(shopNowProducts.getTvPrice());




    }






    @Override
    public int getItemCount() {
        return shopNowProductsList.size();
    }

    public class ShopNowProductsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView ivImage;
        TextView tvName,tvPrice;
        public ShopNowProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}

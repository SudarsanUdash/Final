package com.sudarsanudash.ilamteagarden.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sudarsanudash.ilamteagarden.Adapter.ShopNowProductsAdapter;
import com.sudarsanudash.ilamteagarden.ModelClasses.ShopNowProducts;
import com.sudarsanudash.ilamteagarden.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment  {
private RecyclerView recyclerView;



    public ShopFragment() {
        // Required empty public constructor

    }

    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_shop, container, false);

recyclerView  = view.findViewById(R.id.recyclerView);

        List<ShopNowProducts> shopNowProductsList = new ArrayList<>();
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));
        shopNowProductsList.add(new ShopNowProducts("Tea","9817017356",R.drawable.aaaaa));

        ShopNowProductsAdapter shopNowProductsAdapter = new ShopNowProductsAdapter(shopNowProductsList);
        recyclerView.setAdapter(shopNowProductsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        return view;
    }


}

package com.example.aksha.sell.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aksha.sell.Adapter.Categoryadapter;
import com.example.aksha.sell.ApiClient;
import com.example.aksha.sell.ApiInterface;
import com.example.aksha.sell.POJO.Categorymodel;
import com.example.aksha.sell.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recycler_category;
    List<Categorymodel> categorymodels;



    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        categorymodels = new ArrayList<>();

        recycler_category = view.findViewById(R.id.recycler_category);
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler_category.setLayoutManager(linearLayoutManager);
        return view;
    }

    private void getData() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        retrofit2.Call<List<Categorymodel>> call = apiInterface.categoryview();
        call.enqueue(new Callback<List<Categorymodel>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Categorymodel>> call, Response<List<Categorymodel>> response) {

                Categoryadapter categoryadapter = new Categoryadapter(getActivity(),categorymodels);
                recycler_category.setAdapter(categoryadapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<Categorymodel>> call, Throwable t) {
                Toast.makeText(getActivity(),"Error To Load Data",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

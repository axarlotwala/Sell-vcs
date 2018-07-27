package com.example.aksha.sell.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aksha.sell.POJO.Categorymodel;
import com.example.aksha.sell.R;

import java.util.List;

public class Categoryadapter extends RecyclerView.Adapter<Categoryadapter.Viewholder> {

    private Context context;
    private List<Categorymodel> categorymodels;

    public Categoryadapter(Context context, List<Categorymodel> categorymodels) {
        this.context = context;
        this.categorymodels = categorymodels;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorytext,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.tv_cat.setText(categorymodels.get(position).getCategory_name());
    }

    @Override
    public int getItemCount() {
        return categorymodels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tv_cat;

        public Viewholder(View itemView) {
            super(itemView);

            tv_cat = itemView.findViewById(R.id.tv_cat);
        }
    }
}

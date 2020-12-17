package com.arti.retrofitrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<CarsModel>carsModelArrayList;
    private Context context;

    public ImageAdapter(ArrayList<CarsModel> carsModelArrayList, Context context) {
        this.carsModelArrayList = carsModelArrayList;
        this.context = context;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_layout,parent,false);
        return new ImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        holder.car_name.setText(carsModelArrayList.get(position).getName());
        holder.car_desc.setText(carsModelArrayList.get(position).getDesc());
        Picasso.get().load(carsModelArrayList.get(position).getImage()).into(holder.car_image);





    }

    @Override
    public int getItemCount() {
        return carsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView car_image;
        private TextView car_name,car_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            car_image=itemView.findViewById(R.id.car_image);
            car_name=itemView.findViewById(R.id.car_name);
            car_desc=itemView.findViewById(R.id.car_desc);
        }
    }
}
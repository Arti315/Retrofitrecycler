package com.arti.retrofitrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ImageAdapter imageAdapter;
private ArrayList<CarsModel>carsModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setLayoutManager(new GridLayoutManager(this,3));
       // LinearLayoutManager  layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
       // recyclerView.setLayoutManager(layoutManager);
        photo();

    }


    private void photo(){
        Call<List<CarsModel>> call = RetroitClient.getInstance().getApi().getPhoto();
        call.enqueue(new Callback<List<CarsModel>>() {
            @Override
            public void onResponse(Call<List<CarsModel>> call, Response<List<CarsModel>> response) {
                carsModelArrayList =new ArrayList<CarsModel>(response.body());
                imageAdapter=new ImageAdapter(carsModelArrayList,MainActivity.this);
                recyclerView.setAdapter(imageAdapter);
            }

            @Override
            public void onFailure(Call<List<CarsModel>> call, Throwable t) {

            }
        });
    }
}
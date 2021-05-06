package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  //  ArrayList<serviceModel> serviceModels = new ArrayList<>();
  //  private serviceAdapter serviceAdapter;
  //  private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(getApplicationContext(),login.class);
        startActivity(i);


        //recyclerView = findViewById(R.id.Recyclerview_service);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // serviceAdapter = new serviceAdapter(serviceModels,MainActivity.this);
      //  recyclerView.setAdapter(serviceAdapter);
      //  serviceModels = new ArrayList<>();



       // work();
    }

   // private void work() {
    //    Retrofit retrofit = new Retrofit.Builder()
      //          .baseUrl("http://afihqsa.com/Home/Newsline/")
        //        .addConverterFactory(GsonConverterFactory.create())
        //        .build();
      //  RequestInterface requestInterface = retrofit.create(RequestInterface.class);
     //   Call<List<serviceModel>> call = requestInterface.getServices();

      //  call.enqueue(new Callback<List<serviceModel>>() {
       //     @Override
       //     public void onResponse(Call<List<serviceModel>> call, Response<List<serviceModel>> response) {
         //       assert response.body() != null;
           //     serviceModels = new ArrayList<>(response.body());
         //       serviceAdapter = new serviceAdapter(serviceModels,MainActivity.this);
           //     recyclerView.setAdapter(serviceAdapter);


           //     Toast.makeText(MainActivity.this,"success", Toast.LENGTH_SHORT).show();

         //   }

         //   @Override
         //   public void onFailure(Call<List<serviceModel>> call, Throwable t) {
         //       Toast.makeText(MainActivity.this,"fail", Toast.LENGTH_SHORT).show();
         //       Log.e("failure",t.getLocalizedMessage());


        //    }
     //   });

   // }
}
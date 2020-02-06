package com.example.BitStat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class distribution extends AppCompatActivity {
    BarChart barChart;

    Price p ;
    private LineChart mchart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribution);


         final ListView listView = (ListView) findViewById(R.id.listView);
        fetchData f = new fetchData();
        System.out.println("*******************");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Price>> call = api.getPrices();

        call.enqueue(new Callback<List<Price>>() {
            @Override
            public void onResponse(Call<List<Price>> call, Response<List<Price>> response) {
                List<Price> Prices = response.body();

                String[] pricess = new String[Prices.size()];
                for(int i = 0; i< Prices.size();i++)
                {
                    pricess[i] = Prices.get(i).getPrice();
                }
listView.setAdapter(
        new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                pricess
        )
);






            }

            @Override
            public void onFailure(Call<List<Price>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });









    }
}
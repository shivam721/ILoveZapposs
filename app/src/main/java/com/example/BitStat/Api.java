package com.example.BitStat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String baseurl = "https://www.bitstamp.net/api/v2/";

    @GET("transactions/btcusd/")
        Call<List<Price>> getPrices() ;

}

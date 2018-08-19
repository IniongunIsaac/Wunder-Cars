package com.wunder.wundercarsapp.api_interface;

import com.wunder.wundercarsapp.model.WunderCars;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WunderCarsApiService {

    @GET("locations.json")
    Call<WunderCars> getWunderCars();

}

package com.wunder.wundercarsapp.modules.main_activity;

import android.util.Log;

import com.wunder.wundercarsapp.api_interface.WunderCarsApiService;
import com.wunder.wundercarsapp.model.WunderCars;
import com.wunder.wundercarsapp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bpn on 12/7/17.
 */

public class GetWunderCarsInteractorImpl implements MainContract.GetWunderCarsInteractor {

    @Override
    public void getWunderCarsList(final MainContract.GetWunderCarsInteractor.OnFinishedListener onFinishedListener) {


        /** Create handle for the RetrofitInstance interface*/
        WunderCarsApiService service = RetrofitInstance.getRetrofitInstance().create(WunderCarsApiService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<WunderCars> call = service.getWunderCars();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<WunderCars>() {
            @Override
            public void onResponse(Call<WunderCars> call, Response<WunderCars> response) {
                onFinishedListener.onFinished(response.body().getPlacemarks());

            }

            @Override
            public void onFailure(Call<WunderCars> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}

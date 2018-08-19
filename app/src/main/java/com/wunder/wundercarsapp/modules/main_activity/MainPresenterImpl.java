package com.wunder.wundercarsapp.modules.main_activity;

import android.content.Context;

import com.wunder.wundercarsapp.model.Placemark;
import com.wunder.wundercarsapp.utilities.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpn on 12/7/17.
 */

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetWunderCarsInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetWunderCarsInteractor getWunderCarsInteractor;
    private Utils utils;

    public MainPresenterImpl(Context context, MainContract.MainView mainView, MainContract.GetWunderCarsInteractor getWunderCarsInteractor) {
        this.mainView = mainView;
        this.getWunderCarsInteractor = getWunderCarsInteractor;
        this.utils = new Utils(context);
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getWunderCarsInteractor.getWunderCarsList(this);

    }

    @Override
    public void requestDataFromServer() {
        getWunderCarsInteractor.getWunderCarsList(this);
    }


    @Override
    public void onFinished(List<Placemark> carsList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(carsList);

            //save Wunder Cars List to shared preferences for later use in maps
            utils.saveCarsList(carsList);

            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}

package com.wunder.wundercarsapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wunder.wundercarsapp.model.Placemark;

import java.lang.reflect.Type;
import java.util.List;

public class Utils {

    private Context mContext;
    private SharedPreferences mSharedPreferences;
    private final String CARS_LIST_KEY = "Wunder_Cars_List";

    public Utils(Context context) {
        this.mContext = context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void saveCarsList(List<Placemark> list){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(CARS_LIST_KEY, json);
        editor.apply();
    }

    public List<Placemark> getCarsList(){
        Gson gson = new Gson();
        String json = mSharedPreferences.getString(CARS_LIST_KEY, null);
        Type type = new TypeToken<List<Placemark>>() {}.getType();
        return gson.fromJson(json, type);
    }
}


package com.wunder.wundercarsapp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WunderCars {

    @SerializedName("placemarks")
    private List<Placemark> mPlacemarks;

    public List<Placemark> getPlacemarks() {
        return mPlacemarks;
    }

    public void setPlacemarks(List<Placemark> placemarks) {
        mPlacemarks = placemarks;
    }

}

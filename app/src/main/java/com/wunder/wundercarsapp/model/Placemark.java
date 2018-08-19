
package com.wunder.wundercarsapp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Placemark {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("coordinates")
    private List<Double> mCoordinates;
    @SerializedName("engineType")
    private String mEngineType;
    @SerializedName("exterior")
    private String mExterior;
    @SerializedName("fuel")
    private Long mFuel;
    @SerializedName("interior")
    private String mInterior;
    @SerializedName("name")
    private String mName;
    @SerializedName("vin")
    private String mVin;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public List<Double> getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        mCoordinates = coordinates;
    }

    public String getEngineType() {
        return mEngineType;
    }

    public void setEngineType(String engineType) {
        mEngineType = engineType;
    }

    public String getExterior() {
        return mExterior;
    }

    public void setExterior(String exterior) {
        mExterior = exterior;
    }

    public Long getFuel() {
        return mFuel;
    }

    public void setFuel(Long fuel) {
        mFuel = fuel;
    }

    public String getInterior() {
        return mInterior;
    }

    public void setInterior(String interior) {
        mInterior = interior;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getVin() {
        return mVin;
    }

    public void setVin(String vin) {
        mVin = vin;
    }

}

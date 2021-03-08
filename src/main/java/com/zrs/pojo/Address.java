package com.zrs.pojo;

import java.io.Serializable;


public class Address implements Serializable {
    private static final long serialVersionUID = -1381619276962105303L;

    private String provinceName;
    private String cityName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}

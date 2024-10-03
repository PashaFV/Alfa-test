package com.alfabank.qapp.android.models;

public class Device {

    private String deviceName;
    private String udid;

    public Device(String deviceName, String udid) {
        this.deviceName = deviceName;
        this.udid = udid;

    }

    public Device() {
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

}
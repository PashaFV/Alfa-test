package com.alfabank.qapp.android.models;

public class DeviceFactory {

    public static Device setEmulator() {
        Device device = new Device();
        device.setDeviceName("Emulator");
        device.setUdid("emulator-5554");
        return device;
    }

}

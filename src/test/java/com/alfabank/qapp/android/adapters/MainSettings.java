package com.alfabank.qapp.android.adapters;

import com.alfabank.qapp.android.models.Device;
import com.alfabank.qapp.android.models.DeviceFactory;

public class MainSettings {

    public Device setDevice() {

        Device device = DeviceFactory.setEmulator(); //Выбор тестируемого устройства
        return device;

    }


}

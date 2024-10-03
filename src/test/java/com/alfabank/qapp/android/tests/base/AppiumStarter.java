package com.alfabank.qapp.android.tests.base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.RELAXED_SECURITY;
import static java.time.Duration.ofMinutes;

public class AppiumStarter {

    private static AppiumDriverLocalService service;

    void startAppium() {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .withArgument(RELAXED_SECURITY)
                .withIPAddress("127.0.0.1")
                .withTimeout(ofMinutes(3));
        service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        service.start();
    }

    void stopAppium() {

        service.stop();
    }
}

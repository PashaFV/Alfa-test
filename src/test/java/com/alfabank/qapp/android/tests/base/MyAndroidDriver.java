package com.alfabank.qapp.android.tests.base;

import com.alfabank.qapp.android.adapters.MainSettings;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAndroidDriver implements WebDriverProvider {

    public static MainSettings mainSettings;

    @CheckReturnValue
    @Nonnull
    @BeforeClass
    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        File app = new File("C:/Users/Pasha/Desktop/AlfaTest/app-debug.apk");

        mainSettings = new MainSettings();
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(mainSettings.setDevice().getUdid())
                .setDeviceName(mainSettings.setDevice().getDeviceName())
                .setApp(app.getAbsolutePath())
                .autoGrantPermissions()
                .setAppPackage("com.alfabank.qapp")
                .setAppActivity("com.alfabank.qapp.presentation.MainActivity");

        try {
            return new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}


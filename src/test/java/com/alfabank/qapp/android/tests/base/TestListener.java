package com.alfabank.qapp.android.tests.base;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {

        System.out.printf("Test started:  %s \n", result.getName());
    }

    public void onTestSuccess(ITestResult result) {

        System.out.printf("Test success:  %s \n", result.getName());
    }

    @Attachment
    public void onTestFailure(ITestResult result) {

        System.out.printf("Test failed:  %s \n", result.getName());

    }


}

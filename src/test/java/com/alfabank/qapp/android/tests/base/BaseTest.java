package com.alfabank.qapp.android.tests.base;

import com.alfabank.qapp.android.pages.AuthorizationPage;
import com.alfabank.qapp.android.pages.SuccessAuthorizationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({TestListener.class})
public class BaseTest {


    public static AndroidDriver mobiledriver;
    public static MyAndroidDriver myAndroidDriver;
    public static AppiumStarter appiumStarter;
    public static AuthorizationPage authorizationPage;
    public static SuccessAuthorizationPage successAuthorizationPage;


    @BeforeClass(alwaysRun = true)

    public void initializationBeforeTest() {

        myAndroidDriver = new MyAndroidDriver();
        appiumStarter = new AppiumStarter();
        authorizationPage = new AuthorizationPage();
        successAuthorizationPage = new SuccessAuthorizationPage();

    }


    @BeforeClass
    public void setUp() {

        appiumStarter.startAppium();
        Configuration.browser = MyAndroidDriver.class.getName();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 7000;
        Configuration.browserSize = null;
        WebDriverRunner.getAndCheckWebDriver();
        mobiledriver = (AndroidDriver) getWebDriver();
        mobiledriver.resetInputState();
        mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeMethod
    public void open() {

        String state = String.valueOf(mobiledriver.queryAppState("com.alfabank.qapp"));
        if (state.equals("NOT_RUNNING") || state.equals("RUNNING_IN_BACKGROUND")) {
            mobiledriver.activateApp("com.alfabank.qapp");
        }

    }

    @AfterMethod
    public void closeApp() {

        mobiledriver.terminateApp("com.alfabank.qapp");

    }

    @AfterSuite
    public void tearDown() {

        WebDriverRunner.closeWebDriver();
        appiumStarter.stopAppium();
    }

}


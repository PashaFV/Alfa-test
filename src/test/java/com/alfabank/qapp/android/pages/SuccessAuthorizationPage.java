package com.alfabank.qapp.android.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SuccessAuthorizationPage extends BasePage {

    public static final By SUCCESS_AUTHORIZATION_TITLE = By.xpath("//android.widget.TextView[@text=\"Вход в Alfa-Test выполнен\"]");

    @Step("Проверка отображения текста 'Вход в Alfa-test выполнен'")
    public boolean getVisibilityTitle() {
        $(SUCCESS_AUTHORIZATION_TITLE).shouldBe(Condition.visible);
        $(SUCCESS_AUTHORIZATION_TITLE).shouldHave(Condition.text("Вход в Alfa-Test выполнен"));
        return $(SUCCESS_AUTHORIZATION_TITLE).isDisplayed();

    }


}

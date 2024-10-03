package com.alfabank.qapp.android.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AuthorizationPage extends BasePage {

    public static final By TITLE = By.xpath("//android.widget.TextView[@resource-id=\"com.alfabank.qapp:id/tvTitle\"]");
    public static final By LOGIN_FIELD = By.xpath("//android.widget.EditText[@resource-id=\"com.alfabank.qapp:id/etUsername\"]");
    public static final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[@resource-id=\"com.alfabank.qapp:id/etPassword\"]");
    public static final By SHOW_PASSWORD_BUTTON = By.xpath("//android.widget.ImageButton[@content-desc=\"Show password\"]");
    public static final By ENTER_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm");
    public static final By INVALID_VALUE_NOTIFICATION = By.xpath("//android.widget.TextView[@resource-id=\"com.alfabank.qapp:id/tvError\"]");

    @Step("Проверка отображения заголовка")
    public boolean getVisibilityTitle() {
        $(TITLE).shouldBe(Condition.visible);
        $(TITLE).shouldHave(Condition.text("Вход в Alfa-test"));
        return $(TITLE).isDisplayed();

    }

    @Step("Проверка отображения поля 'Логин'")
    public boolean getVisibilityLoginField() {
        $(LOGIN_FIELD).shouldBe(Condition.visible);
        $(LOGIN_FIELD).shouldHave(Condition.text("Логин"));
        return $(LOGIN_FIELD).isDisplayed();

    }

    @Step("Проверка отображения поля 'Пароль'")
    public boolean getVisibilityPasswordField() {
        $(PASSWORD_FIELD).shouldBe(Condition.visible);
        $(PASSWORD_FIELD).shouldHave(Condition.text("Пароль"));
        return $(PASSWORD_FIELD).isDisplayed();

    }

    @Step("Проверка отображения кнопки 'Показать пароль'")
    public boolean getVisibilityShowPasswordButton() {
        $(SHOW_PASSWORD_BUTTON).shouldBe(Condition.visible);
        return $(SHOW_PASSWORD_BUTTON).isDisplayed();

    }

    @Step("Проверка отображения кнопки 'Вход'")
    public boolean getVisibilityEnterButton() {
        $(ENTER_BUTTON).shouldBe(Condition.visible);
        $(ENTER_BUTTON).shouldHave(Condition.text("Вход"));
        return $(TITLE).isDisplayed();

    }

    @Step("Ввод {values} в поле 'Логин'")
    public void inputValuesInLoginField(String values) {
        $(LOGIN_FIELD).type(values);

    }

    @Step("Ввод {values} в поле 'Пароль'")
    public void inputValuesInPasswordField(String values) {
        $(PASSWORD_FIELD).type(values);

    }

    @Step("Получение значений в поле 'Пароль'")
    public String getValuesInPasswordField() {
        return $(PASSWORD_FIELD).getText();

    }

    @Step("Получение значений в поле 'Логин'")
    public String getValuesInLoginField() {
        return $(LOGIN_FIELD).getText();

    }

    @Step("Получение значения флага password в поле 'Пароль'")
    public String getPasswordFlagValueInPasswordField() {
        return $(PASSWORD_FIELD).getAttribute("password");

    }


    @Step("Нажатие на кнопку 'Вход'")
    public void clickEnterButton() {
        $(ENTER_BUTTON).click();

    }

    @Step("Проверка отображения ошибки 'Введены неверные данные'")
    public boolean getVisibilityInvalidValueNotification() {
        $(INVALID_VALUE_NOTIFICATION).shouldBe(Condition.visible);
        $(INVALID_VALUE_NOTIFICATION).shouldHave(Condition.text("Введены неверные данные"));
        return $(INVALID_VALUE_NOTIFICATION).isDisplayed();

    }

    @Step("Нажатие на кнопку 'Показать пароль'")
    public void clickShowPasswordButton() {
        $(SHOW_PASSWORD_BUTTON).click();

    }

}

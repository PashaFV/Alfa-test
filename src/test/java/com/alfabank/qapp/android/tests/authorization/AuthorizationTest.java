package com.alfabank.qapp.android.tests.authorization;

import com.alfabank.qapp.android.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {


    @Test(priority = 1, description = "Проверка отображения элементов на экране авторизации")
    private void checkVisibilityElementsTest() {

        Assert.assertEquals(authorizationPage.getVisibilityTitle(), true, "Заголовок не отображается");
        Assert.assertEquals(authorizationPage.getVisibilityLoginField(), true, "Поле не отображается");
        Assert.assertEquals(authorizationPage.getVisibilityPasswordField(), true, "Поле не отображается");
        Assert.assertEquals(authorizationPage.getVisibilityShowPasswordButton(), true, "Кнопка не отображается");
        Assert.assertEquals(authorizationPage.getVisibilityEnterButton(), true, "Кнопка не отображается");

    }

    @Test(priority = 2,dependsOnMethods = { "checkVisibilityElementsTest" }, description = "Проверка успешной авторизации с валидными значениями")
    private void successAuthorizationTest() {

        authorizationPage.inputValuesInLoginField("Login");
        authorizationPage.inputValuesInPasswordField("Password");
        authorizationPage.clickEnterButton();
        Assert.assertEquals(successAuthorizationPage.getVisibilityTitle(), true, "Текст на экране успешной авторизации не отображается");

    }

    @Test(priority = 3,dependsOnMethods = { "checkVisibilityElementsTest" }, description = "Проверка ввода недопустимых символов в поле 'Логин'")
    private void inputInvalidSymbolsInLoginTest() {

        authorizationPage.inputValuesInLoginField("Login@#@");
        authorizationPage.clickEnterButton();
        Assert.assertEquals(authorizationPage.getVisibilityInvalidValueNotification(), true, "Ошибка не отображается");

    }

    @Test(priority = 4,dependsOnMethods = { "checkVisibilityElementsTest" }, description = "Проверка маскировки символов в поле 'Пароль'")
    private void checkHideSymbolsInPasswordTest() {

        authorizationPage.inputValuesInPasswordField("Password123");
        Assert.assertEquals(authorizationPage.getPasswordFlagValueInPasswordField(), "true", "Пароль не скрыт");
        authorizationPage.clickShowPasswordButton();
        Assert.assertEquals(authorizationPage.getPasswordFlagValueInPasswordField(), "false", "Пароль скрыт");
        Assert.assertEquals(authorizationPage.getValuesInPasswordField(), "Password123", "Текст не отображается");
        authorizationPage.clickShowPasswordButton();
        Assert.assertEquals(authorizationPage.getPasswordFlagValueInPasswordField(), "true", "Пароль не скрыт");

    }

    @Test(priority = 5,dependsOnMethods = { "checkVisibilityElementsTest" }, description = "Проверка ограничения на длину ввода в поле 'Пароль'")
    private void checkLengthInLoginTest() {

        String password = "Password1Password1Password1Password1Password1Password1";
        //String expectedPassword = password.substring(0, password.length() - 4);
        authorizationPage.inputValuesInPasswordField(password);
        authorizationPage.clickShowPasswordButton();
        Assert.assertTrue(authorizationPage.getValuesInPasswordField().matches("^[\\s\\S]{1,50}$"), "Некорректное значение пароля");

    }

    @Test(priority = 6,dependsOnMethods = { "checkVisibilityElementsTest" }, description = "Проверка авторизации с пустыми полями 'Логин' и 'Пароль'")
    private void authorizationWithoutCredentialsTest() {

        authorizationPage.clickEnterButton();
        Assert.assertEquals(authorizationPage.getVisibilityInvalidValueNotification(), true, "Ошибка не отображается");

    }


}

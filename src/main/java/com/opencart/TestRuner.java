package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRuner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver Object that will be used for the future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();

        // deschidem fereastra - https://andreisecuqa.host/
        driver.get("https://andreisecuqa.host/");


        // apasam butoanele Myaccount, Register
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterFromHeaderMenu();

         // introducem datele
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPassword(10, 20);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnPrivacyToggle (driver);
        registerPage.clickOnContinueButton();

        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.logOutFromTheAccount();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        driver.quit();
        System.out.println("Execution was Finished !");

    }

}

package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRuner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver Object that will be used for the future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();

        // deschidem fereastra - https://andreisecuqa.host/
        driver.get("https://andreisecuqa.host/");

        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");
        // apasam butoanele Myaccount, Register
        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();
        WebElement registerBtn = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerBtn.click();

        // introducem datele
        String firstName = DataFakerManager.getRandomName();
        System.out.println("First Name is: " + firstName);

        String lastName = DataFakerManager.getRandomName();
        System.out.println("Last Name is: " + lastName);

        String email = DataFakerManager.getRandomEmail();
        System.out.println("EMAIL is: " + email);

        String password = DataFakerManager.getRandomPassword(10, 20);
        System.out.println("password is: " + password);

        WebElement lastNameInput = driver.findElement(By.id("input-firstname"));
        lastNameInput.sendKeys(lastName);

        WebElement firstNameInput = driver.findElement(By.id("input-lastname"));
        firstNameInput.sendKeys(firstName);

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(password);

        // Butonul Toggle , scroll to element
        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement(driver, privacyToggle);


        privacyToggle.click();

        WebElement continueBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueBtn.click();

        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());


        driver.close();
    driver.switchTo().window(currentWindowName);
    driver.get("https://www.drive2.ru/");
        driver.quit();

        System.out.println("Execution was Finished !");

    }

}

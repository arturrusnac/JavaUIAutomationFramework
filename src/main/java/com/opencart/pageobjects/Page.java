package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver){
        PageFactory.initElements(driver, this); // daca nu introducem paramtri, atunci asta e o met. statica


    }
    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    WebElement accountIcon;
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
    private WebElement registerBtn;



    public void navigateToRegisterFromHeaderMenu() {
        accountIcon.click();
        System.out.println("the account icon was clicked");
        registerBtn.click();
        System.out.println("register button was clicked");

    }
}

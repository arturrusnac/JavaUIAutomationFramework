package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRuner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver Object that will be used for the future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://maven.apache.org/");
        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://chromedriver.chromium.org/");
        Thread.sleep(5000);

        driver.close();
    driver.switchTo().window(currentWindowName);
    driver.get("https://www.drive2.ru/");
        driver.quit();

        System.out.println("Execution was Finished !");

    }

}

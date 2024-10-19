package org.automation.com.ex_selenium.ex_19102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VWOLogin_Test
{
    @Description("Verify if user has entered Valid Username,Password.And then name on dashboard")
    @Test
    public void loginAndVerifyName() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximaized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        WebElement username = driver.findElement(By.id("login-username"));
        WebElement password = driver.findElement(By.id("login-password"));
        WebElement login = driver.findElement(By.xpath("//button[@id='js-login-btn']"));

        username.sendKeys("qa123@gmail.com");
        password.sendKeys("QAtester@1234");
        login.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dashboard = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        WebElement name = driver.findElement(By.xpath("//span[contains(text(),'qa test')]"));

        if (dashboard.getText().equals("Dashboard")) {
            Assert.assertEquals(name.getText(), "qa test");
        }
        driver.quit();
    }

}

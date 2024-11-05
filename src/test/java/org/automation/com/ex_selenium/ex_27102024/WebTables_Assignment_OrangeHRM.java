package org.automation.com.ex_selenium.ex_27102024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class WebTables_Assignment_OrangeHRM {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Description("Click on terminated button")
    @Test
    public void deleteTerminatedEmployee() {
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/hr/web/index.php/auth/login";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(URL);

        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("admin");
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");
        WebElement login= driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement webTable = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webTable);
        WebElement terminatedEmp= driver.findElement(By.xpath("//div[@class='orangehrm-container']//div[@class='oxd-table-body']//div//div[@role='cell']//div[contains(text(),'Terminated')]//following::button[@type='button']//i[@class='oxd-icon bi-trash']"));
        terminatedEmp.click();
        WebElement popup= driver.findElement(By.xpath("//div[@role=\"document\"]"));
        WebElement cancel= driver.findElement(By.xpath("//div[@role=\"document\"]//following::button[2]"));
        if(popup.isDisplayed())
        {
            cancel.click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

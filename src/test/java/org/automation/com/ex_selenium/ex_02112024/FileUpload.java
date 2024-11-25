package org.automation.com.ex_selenium.ex_02112024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FileUpload
{
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }
    @Description("file Upload Test")
    @Test
    public void fileUploadTest()
    {
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();
        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
       //C:\Users\deepa\IdeaProjects\SeleniumLearningATB7x\src\test\java\org\automation\com\ex_selenium\ex_02112024\TestDemo.txt
        uploadFileInput.sendKeys(dir+"\\src\\test\\java\\org\\automation\\com\\ex_selenium\\ex_02112024\\TestDemo.txt");
        driver.findElement(By.name("submit")).click();
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


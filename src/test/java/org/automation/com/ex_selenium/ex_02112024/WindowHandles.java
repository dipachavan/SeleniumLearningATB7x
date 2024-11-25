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
import java.util.Set;

public class WindowHandles
{
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }
    @Description("Window Handle")
    @Test
    public void windowHandle_Test()
    {
        driver.manage().window().maximize();
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();
        String parentWindowHandle= driver.getWindowHandle();
        System.out.println("Parent window handle is:"+parentWindowHandle);
        WebElement link= driver.findElement(By.linkText("Click Here"));
        link.click();
        //driver.findElement(By.linkText("Click Here")).click();
        Set<String> WindowHandles= driver.getWindowHandles();
        System.out.println("Window handles:"+WindowHandles);
        for (String handle: WindowHandles)
        {
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window"))
            {
                System.out.println("switched to new window");
                driver.switchTo().window(parentWindowHandle);
                if(driver.getPageSource().contains("The Internet"))
                {
                    System.out.println("switched to parent window");
                    break;
                }
            }
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

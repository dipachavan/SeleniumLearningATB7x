package org.automation.com.ex_selenium.ex_02112024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowHandles_WithIFrame
{
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }
    @Description("Window Handle with IFrame")
    @Test
    public void windowHandleWithIFrame_Test() throws InterruptedException {
        driver.manage().window().maximize();
        String URL = "https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String parentWindowHandle= driver.getWindowHandle();
        System.out.println("Parent window handle is:"+parentWindowHandle);

        List<WebElement> heatMapTabs= driver.findElements(By.xpath("//div[@data-qa=\"yedexafobi\"]"));
        //heatMapTabs.click();              --->this will not work
        Actions actions = new Actions(driver);
        actions.moveToElement(heatMapTabs.get(1)).click().build().perform();
        Thread.sleep(13000);
        Set<String> WindowHandles= driver.getWindowHandles();
        System.out.println("Window handles:"+WindowHandles);
        for (String handle : WindowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Child Window Title: " + driver.getTitle());
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickmap = driver.findElement(By.cssSelector("[data-qa='liqokuxuba']"));
                clickmap.click();

            }
        }


        driver.switchTo().window(parentWindowHandle);
        // driver.switchTo().defaultContent();
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

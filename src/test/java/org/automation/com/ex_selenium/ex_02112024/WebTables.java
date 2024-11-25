package org.automation.com.ex_selenium.ex_02112024;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables
{
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }
    @Test
    public void webTable_Test()
    {
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement table= driver.findElement(By.xpath("//table[@summary='Sample Table']//tbody"));
        List<WebElement> rows= table.findElements(By.tagName("tr"));
        for(int i=0; i<rows.size(); i++)
        {
            List<WebElement> columns= rows.get(i).findElements(By.tagName("td"));
            for(WebElement cell:columns){
                System.out.println(cell.getText());
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


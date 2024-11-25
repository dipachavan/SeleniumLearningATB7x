package org.automation.com.ex_selenium.ex_02112024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionsTest
{
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Actions Class")
    @Test
    public void actions_Test_Awesomeqa()
    {
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement firstName= driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstName,"deepa").keyUp(Keys.SHIFT).build().perform();


    }
    @Description("Spice Jet")
    @Test
    public void actions_Test_SpiceJet()
    {
        driver.manage().window().maximize();
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement from= driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        Actions actions=new Actions(driver);
        actions.moveToElement(from).click().sendKeys("Mumbai").build().perform();



    }
    @Description("Make My Trip")
    @Test
    public void actions_Test_MakeMyTrip()
    {
        driver.manage().window().maximize();
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement cross= driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(cross));
        cross.click();
        WebElement from= driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(from).click().sendKeys("Mumbai").build().perform();
        //actions.moveToElement(from).contextClick();
        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

//        for(WebElement e : list_auto_complete){
//            if(e.getText().contains("Mumbai")){
//                e.click();
//                break;
//            }
//        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //will automatically select
        actions.moveToElement(from).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();


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


package org.automation.com.ex_selenium.ex_19102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AwesomeQA_Test
{
    @Description("Verify AwesomeQA Account is created")
    @Test
    public void createAccountAndVerify()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--start-maximaized");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");

        //web elements
        WebElement firstName= driver.findElement(By.id("input-firstname"));
        WebElement lastName= driver.findElement(By.id("input-lastname"));
        WebElement email= driver.findElement(By.id("input-email"));
        WebElement telephone= driver.findElement(By.id("input-telephone"));
        WebElement password= driver.findElement(By.id("input-password"));
        WebElement confirm= driver.findElement(By.id("input-confirm"));
        WebElement subscribe= driver.findElement(By.xpath("//input[@name='newsletter' and @value='0'] "));
        WebElement checkBox= driver.findElement(By.name("agree"));
        WebElement submit= driver.findElement(By.xpath("//input[@value=\"Continue\"]"));

        //setting values
        firstName.sendKeys("ffname");
        lastName.sendKeys("lname");
        email.sendKeys("dipa43221@gmail.com");
        telephone.sendKeys("5895785369");
        password.sendKeys("qa4321");
        confirm.sendKeys("qa4321");
        subscribe.click();
        checkBox.click();
        submit.click();
        WebElement response= driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        System.out.println(response);
        if(response.isDisplayed())
        {
            System.out.println("You have successfully created an account");
        }
        WebElement continueButton=driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        continueButton.click();
        WebElement myAccount=driver.findElement(By.xpath("//h2[contains(text(),'My Account')]"));
        System.out.println(myAccount.getText());
        Assert.assertEquals(myAccount.getText(),"My Account");
        driver.quit();


    }
}

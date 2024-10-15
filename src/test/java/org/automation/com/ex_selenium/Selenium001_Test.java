package org.automation.com.ex_selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

@Test
public class Selenium001_Test
{

        public void firstTest()
        {
                EdgeDriver driver=new EdgeDriver();
                driver.get("https://app.vwo.com");
        }

}

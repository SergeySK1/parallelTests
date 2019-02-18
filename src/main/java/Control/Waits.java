package Control;

import Driver.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Waits extends SetupDriver{

    protected WebDriver driver;



    public Waits(){
      this.driver = SetupDriver.getDriver();
    }

      WebElement waitElementToClick(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 100);
        return  wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

     void type(By locator, String text){

           if (isElementEnabled(locator)) {
               driver.findElement(locator).clear();
               driver.findElement(locator).sendKeys(text);
           }
    }

    public String getAttribute(By locator, String value){

        return driver.findElement(locator).getAttribute(value);
    }

    public boolean isElementEnabled(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 100);
        try {
            if (wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isEnabled()) {
                return true;
            }
        }catch (ElementNotVisibleException e) {
            System.out.println(e);
        }
        return false;
    }

}

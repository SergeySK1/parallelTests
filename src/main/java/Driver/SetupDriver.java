package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SetupDriver {

    private static final ThreadLocal<WebDriver> initDriver = new ThreadLocal<>();
    private WebDriver driver;
    protected static String selectBrowser="";


    public synchronized WebDriver getDriver(){
        return getInstance(selectBrowser);
    }

    public void removeDriver(){
        initDriver.get().quit();
    }

    private WebDriver getInstance(String selectBrowser){
        if(initDriver.get() != null){
          return initDriver.get();
        }
        initDriver.set(browserSetup(selectBrowser));
        return initDriver.get();
    }


    private  WebDriver browserSetup(String selectBrowser){
        if (driver==null) {
            try {
                switch (selectBrowser) {
                    case "chrome":
                        driver = initChromeDriver();
                        break;
                    case "firefox":
                        driver = initMozilaDriver();
                        break;
                }
            } catch (Exception e) {
                System.out.println("browserSetup - Error" + e);
            }
        }
        return driver;
    }

    private  WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

    private   WebDriver initMozilaDriver(){
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        return new FirefoxDriver();
    }

}

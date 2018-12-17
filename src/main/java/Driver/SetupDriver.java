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
    private static Map<String, WebDriver> boxDriver;
    protected static String selectBrowser="";


    public synchronized WebDriver getDriver(){
        getInstance(selectBrowser);
        return initDriver.get();
    }

    public void removeDriver(){
        initDriver.get().quit();
    }

    private void getInstance(String selectBrowser){
        initBoxDriver();
        if(boxDriver != null && boxDriver.containsKey(selectBrowser)){
          return;
        }
        boxDriver.put(selectBrowser, browserSetup(selectBrowser));
        initDriver.set(boxDriver.get(selectBrowser));
    }

    private static void initBoxDriver(){
        if(boxDriver!=null){
            return;
        }
        boxDriver = new HashMap<>();
    }

    private   WebDriver browserSetup(String selectBrowser){
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

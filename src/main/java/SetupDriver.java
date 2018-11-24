import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class SetupDriver {

    private static final ThreadLocal<WebDriver> initDriver = new ThreadLocal<>();
    private static WebDriver driver;
    private static Map<String, WebDriver> boxDriver = new HashMap<>();


    protected static WebDriver getDriver(String selectBrowser){
        return getInstance(selectBrowser);

    }

    protected void removeDriver(){
        initDriver.get().quit();
    }

    private  static WebDriver getInstance(String selectBrowser){
        if(boxDriver != null && boxDriver.containsKey(selectBrowser)){

          return initDriver.get();
        }
        else{
            boxDriver.put(selectBrowser, browserSetup(selectBrowser));
            initDriver.set(boxDriver.get(selectBrowser));
        }
        return initDriver.get();
    }

    private static WebDriver browserSetup(String selectBrowser){
        switch (selectBrowser){
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initMozilaDriver();
                break;
        }
        return driver;
    }

    private static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

    private  static WebDriver initMozilaDriver(){
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        return new FirefoxDriver();
    }

}

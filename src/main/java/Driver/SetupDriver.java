package Driver;

import Control.EventPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SetupDriver {

    private static final ThreadLocal<WebDriver> initDriver = new ThreadLocal<>();
    private static WebDriver driver;

    protected static String browserName = "";


    static{
        try {
            InputStream file = new FileInputStream("browserinfo.properties");
            Properties properpty = new Properties();
            properpty.load(file);
            browserName = properpty.getProperty("ch");
        }catch (IOException e ){
            System.out.println(e);
        }
    }

    public static WebDriver getDriver(){
        if(initDriver.get() != null){
            return initDriver.get();
        }

        initDriver.set(browserSetup(browserName));
        return initDriver.get();
    }

    public static void removeDriver(){
        initDriver.get().quit();
    }


    private static synchronized WebDriver browserSetup(String browserName){
                switch (browserName) {
                    case "chrome":
                        driver = initChromeDriver();
                        break;
                    case "firefox":
                        driver = initMozilaDriver();
                        break;
                }

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        EventPage eventPage = new EventPage();
        driver = eventFiringWebDriver.register(eventPage);

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

package Control;

import Driver.SetupDriver;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WaitReady extends Waits {



    private static int  sleepTimeout;
    volatile static int  countThread = 1;

    static {
        try {
            InputStream file = new FileInputStream("waitinfo.properties");
            Properties properpty = new Properties();
            properpty.load(file);
            sleepTimeout = Integer.parseInt(properpty.getProperty("JS_WAIT_TIMEOUT"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void waitReadyPage(){

        if(SetupDriver.getDriver() != null) {

            try{

                WebDriverWait wait = new WebDriverWait(driver, sleepTimeout);

                wait.until(w-> {
                    boolean result =
                            ((JavascriptExecutor) w).executeScript("return " +
                                   "document.querySelector([\".serp.serp__spin.i-bem.serp_js_inited.serp_loading_yes.serp__spin_progress_yes\"])==null || " +
                                    "document.readyState").equals("complete");
                    if (!result) {
                        if(countThread == 1) {
                           new MyThread().start();
                            countThread--;
                        }
                    }

                    return result;
                });

            }catch (RuntimeException e){
                System.out.println("Page Error " + e);
            }
        }
    }
}

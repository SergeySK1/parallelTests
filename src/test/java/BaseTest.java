import Driver.SetupDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(InitTestParameter.class)
public class BaseTest {

    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void initSuite(){
        driver = SetupDriver.getDriver();
    }

    @BeforeTest(alwaysRun = true)
    public void initTest(){
        driver = SetupDriver.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void removeTest(){
        SetupDriver.removeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void removeSuite(){
        SetupDriver.removeDriver();
    }


}

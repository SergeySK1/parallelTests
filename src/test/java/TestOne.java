import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestOne extends SetupDriver {

    private WebDriver driver;

    @BeforeTest()
    @Parameters({"browserName"})
    public void initBeforeTest(String browserName){
        driver = getDriver(browserName);
    }

    @BeforeClass()
    public void setup(){
        driver.get("https://www.yandex.ru/");
    }


    @Test(priority = 1)
    public void oneTest(){
        driver.findElement(By.id("text")).sendKeys("Погода");
        driver.findElement(By.cssSelector(".search2__button")).click();
        driver.findElement(By.cssSelector(".logo_type_link")).click();
    }

    @Test(priority = 2)
    public void twoTest(){
        driver.findElement(By.id("text")).sendKeys("Автомобили");
        driver.findElement(By.cssSelector(".search2__button")).click();
        driver.findElement(By.cssSelector(".logo_type_link")).click();
    }

    @AfterClass()
    public void removeDriver(){
        super.removeDriver();
    }

}

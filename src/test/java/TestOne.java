
import Driver.SetupDriver;
import org.testng.annotations.*;
import page.MarketForm;
import page.SearchBlock;
import page.SearchForm;

public class TestOne extends SetupDriver {

    private SearchForm searchForm;
    private MarketForm marketForm;

    @BeforeTest()
    @Parameters({"browserName", "url"})
    public void initBeforeTest(String browserName, String url){
        System.out.println(browserName);
        selectBrowser = browserName;
        getDriver().get(url);
    }

    @BeforeClass()
    public void setup(){
        searchForm = new SearchForm();
        marketForm = new MarketForm();
    }

    @Test(priority = 1)
    @Parameters({"weather"})
    public void oneTest(String weather){
        searchForm.searchAndGo(weather);
        searchForm.checkFirstResultLink("yandex.ru");
        searchForm.goToStartPage();
    }

    @Test(priority = 2)
    @Parameters({"weatherInUSA"})
    public void twoTest(String weatherInUSA){
        searchForm.searchAndGo(weatherInUSA);
        searchForm.checkFirstResultLink("yandex.ru");
        searchForm.goToStartPage();
    }

    @Test(priority = 3)
    @Parameters({"tabs"})
    public void thirdTest(String tabsSearch){
        marketForm.goToTabs();
        marketForm.searchMarketPlace(tabsSearch);
    }

    @AfterClass()
    public void removeDriverThis(){
        removeDriver();
    }

}



import org.testng.annotations.*;
import page.MarketForm;
import page.SearchForm;

public class TestOne  extends BaseTest{

    private SearchForm searchForm;
    private MarketForm marketForm;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        searchForm = new SearchForm();
        marketForm = new MarketForm();

    }

    @Test(priority = 1)
    @Parameters({"weather"})
    public void oneTest(@Optional("Автомобили") String weather){
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

}

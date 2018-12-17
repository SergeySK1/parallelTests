package page;

import Control.ControlWebElement;
import org.openqa.selenium.By;

public class MarketForm {
    private ControlWebElement controlWebElement = new ControlWebElement();
    private SearchBlock searchBlock = new SearchBlock();

    private By electronics = By.xpath("//span[@class='n-w-tab__control-caption' and text()='�����������']");
    private By tabs = By.xpath("//*[text()='��������']");
    private By searchField = By.id("header-search");

    public void goToTabs(){
        searchBlock.goToMarket();
        controlWebElement.clickWebElement(electronics);
        controlWebElement.clickWebElement(tabs);
    }

    public void searchMarketPlace(String searchText){
        controlWebElement.typeText(searchField, searchText);
        controlWebElement.clickWebElement(SearchBlock.searchBtn);
    }
}

package page;

import Control.ControlWebElement;
import org.openqa.selenium.By;
import org.testng.*;

public class SearchForm {

    private ControlWebElement controlWebElement = new ControlWebElement();
    private SearchBlock searchBlock = new SearchBlock();
    private By textField = By.id("text");

    private By firstLinkResultSearch = By.cssSelector(".serp-list.serp-list_left_yes li:nth-of-type(1) b");
    private By logo = By.className("serp-header__logo");


    public void searchAndGo(String text){
        controlWebElement.typeText(textField, text);
        controlWebElement.clickWebElement(searchBlock.searchBtn);
    }

    public void checkFirstResultLink(String expectedResult){

         Assert.assertTrue(controlWebElement.getAttribute(firstLinkResultSearch, "innerText").equals(expectedResult));
    }

    public void goToStartPage(){
        controlWebElement.clickWebElement(logo);
    }
}

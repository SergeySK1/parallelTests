package page;

import Control.ControlWebElement;
import org.openqa.selenium.By;

public class SearchBlock {

    private By videoTab = By.linkText("Видео");
    private By pictureTab = By.linkText("Картинки");
    private By newsTab = By.linkText("Новости");
    private By mapsTab = By.linkText("Карты");
    private By marketTab = By.linkText("Маркет");
    private By translateTab = By.linkText("Переводчик");
    private By musicTab = By.linkText("Музыка");
    private ControlWebElement controlWebElement = new ControlWebElement();
    public static By searchBtn = By.className("search2__button");

    public void goToMarket(){
        controlWebElement.clickWebElement(marketTab);
    }
}

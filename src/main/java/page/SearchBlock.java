package page;

import Control.ControlWebElement;
import org.openqa.selenium.By;

public class SearchBlock {

    private By videoTab = By.linkText("�����");
    private By pictureTab = By.linkText("��������");
    private By newsTab = By.linkText("�������");
    private By mapsTab = By.linkText("�����");
    private By marketTab = By.linkText("������");
    private By translateTab = By.linkText("����������");
    private By musicTab = By.linkText("������");
    private ControlWebElement controlWebElement = new ControlWebElement();
    public static By searchBtn = By.className("search2__button");

    public void goToMarket(){
        controlWebElement.clickWebElement(marketTab);
    }
}

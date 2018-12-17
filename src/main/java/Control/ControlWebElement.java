package Control;


import org.openqa.selenium.By;



public class ControlWebElement extends Waits {


    public ControlWebElement(){
    }

    public void clickWebElement(By locator){
        waitElementToClick(locator).click();
    }

    public void typeText(By locator, String text){
        type(locator, text);
    }
}

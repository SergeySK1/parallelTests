package Control;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventPage implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
   //     new WaitReady().waitReadyPage();
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
    //    new WaitReady().waitReadyPage();
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        new WaitReady().waitReadyPage();
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
   //     new WaitReady().waitReadyPage();
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}

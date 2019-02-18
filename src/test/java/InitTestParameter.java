
import Driver.SetupDriver;

import org.testng.*;


public class InitTestParameter implements  ITestListener {


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        String url = context.getSuite().getParameter("url");
        SetupDriver.getDriver().get(url);
    }

    @Override
    public void onFinish(ITestContext context) {
        SetupDriver.removeDriver();
    }


}
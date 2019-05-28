package util.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.DriverManager;

public class Listener implements ITestListener {
    private static Logger LOG = Logger.getLogger(DriverManager.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {


    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.info("TEST FAILURE");
        DriverManager.failed();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

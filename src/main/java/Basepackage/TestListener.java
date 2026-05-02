package Basepackage;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener  extends BaseTest implements ITestListener  {
	
	
	@Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        log.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        log.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        // Screenshot
        String path = takeScreenshot(result.getName());
        test.addScreenCaptureFromPath(path);

        log.error("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
        log.warn("Test Skipped: " + result.getName());
    }

}

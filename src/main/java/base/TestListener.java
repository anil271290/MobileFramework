package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

import static base.ExtentReport.getTest;

public class TestListener extends AppiumBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " test cases started");
        ExtentReport.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of test case passed is: " + result.getMethod().getMethodName());
        ExtentTest test = getTest();
        test.log(Status.PASS, "Test passed");
        // Add additional logs to extent report
        test.log(Status.INFO, "Additional log message here");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase skipped is: " + result.getMethod().getMethodName());
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case '" + result.getMethod().getMethodName() + "' failed");

        Throwable throwable = result.getThrowable();
        String failureMessage = "Test failed";

        // Check if the failure is due to an assertion error
        if (throwable instanceof AssertionError) {
            failureMessage = "Assertion failed: " + throwable.getMessage();
        }

        getTest().log(Status.FAIL, failureMessage);

        Object ob = result.getInstance();
        AppiumDriver driver = ((AppiumBase) ob).getAppiumDriver();

        // Take screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);

        // Attach screenshot to Extent report
        try {
            getTest().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // If failure is due to an assertion, log the assertion message separately
        if (throwable instanceof AssertionError) {
            String assertionMessage = "Assertion failed: " + throwable.getMessage();
            getTest().log(Status.FAIL, assertionMessage);
        }
    }


    @Override
    public void onFinish(ITestContext context) {
        System.out.println("The " + context.getName() + " is Finished");
        ExtentReport.endTest();
        ExtentReport.getInstance().flush(); // Flush ExtentReports instance
    }

    // Redirect console output to Extent report
    public static void logToExtentReport(String logMessage) {
        getTest().log(Status.INFO, logMessage);
    }

    public static void handleSoftAssertions(SoftAssert softAssert) {
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            // Log soft assertion failure message
            String assertionMessage = "Soft Assertion failed: " + e.getMessage();
            getTest().log(Status.FAIL, assertionMessage);
        }
    }
}

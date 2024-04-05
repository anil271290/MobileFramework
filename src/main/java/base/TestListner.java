package base;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Objects;
import static base.ExtentTestManager.getTest;

public class TestListner extends AppiumBase implements ITestListener{
  //  public static AppiumDriver driver;

      private static final Logger logger = LogManager.getLogger(base.TestListner.class);

    public static String getTestClassName(String instanceName) {
        // Extract the class name from the instance name
        String[] parts = instanceName.split("\\.");
        return parts[parts.length - 1];
    }
        @Override
        public void onTestStart(ITestResult result) {
          //  ITestListener.super.onTestStart(result);
            logger.info(result.getMethod().getMethodName()+" test cases started");
            ExtentTestManager.startTest(result.getMethod().getMethodName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
           // ITestListener.super.onTestSuccess(result);
            logger.info("The name of test case passed is :"+result.getMethod().getMethodName());
            getTest().log(Status.PASS, "Test passed");

        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ITestListener.super.onTestSkipped(result);
            logger.info("The name of the testcase skipped is :"+result.getMethod().getMethodName());
            getTest().log(Status.SKIP,"Test Skipped");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
          //  ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
            logger.info("Test Failed but within Percentage :" +result.getMethod().getMethodName());
        }

        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
            ITestListener.super.onTestFailedWithTimeout(result);
            logger.info("The test case Failed with TimeOut is: "+result.getName());
        }

        @Override
        public void onStart(ITestContext context) {
            ITestListener.super.onStart(context);
        }
        @Override
        public void onTestFailure(ITestResult result) {
            logger.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
            logger.info((result.getMethod().getMethodName() + " failed!"));

            Object ob = result.getInstance();
            AppiumDriver driver = ((AppiumBase) ob).getAppiumDriver();
            //Take base64Screenshot screenshot for extent reports
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
            //ExtentReports log and screenshot operations for failed tests.
           getTest().log(Status.FAIL, "Test Failed", getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

        }


    @Override
        public void onFinish(ITestContext context) {

           // ITestListener.super.onFinish(context);
            //logger.info("OnFinishTest is :"+context.getName());
            logger.info("The "+context.getName() + " is Finished");
            ExtentTestManager.endTest();
            ExtentManager.getInstance().flush();
        }
    }



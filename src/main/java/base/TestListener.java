package base;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static base.ExtentTestManager.getTest;

public class TestListener extends AppiumBase implements ITestListener {
    //  public static AppiumDriver driver;

    private static final Logger logger = LogManager.getLogger(base.TestListener.class);
    private static final List<String> logMessages = new ArrayList<>();
    private static final List<Throwable> softAssertionErrors = new ArrayList<>();


    public static String getTestClassName(String instanceName) {
        // Extract the class name from the instance name
        String[] parts = instanceName.split("\\.");
        return parts[parts.length - 1];
    }

    @Override
    public void onStart(ITestContext context) {
        configureLogger();
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        //  ITestListener.super.onTestStart(result);
        logger.info(result.getMethod().getMethodName() + " test cases started");
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // ITestListener.super.onTestSuccess(result);
        logger.info("The name of test case passed is :" + result.getMethod().getMethodName());
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("The name of the testcase skipped is :" + result.getMethod().getMethodName());
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //  ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("Test Failed but within Percentage :" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("The test case Failed with TimeOut is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        logger.error((result.getMethod().getMethodName() + " failed!"));

        // Log test failure in Extent Report
        getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        Object ob = result.getInstance();
        AppiumDriver driver = ((AppiumBase) ob).getAppiumDriver();
        // Take base64Screenshot screenshot for extent reports
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        // ExtentReports log and screenshot operations for failed tests.
        getTest().fail("Test Failed", getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

        // Log assertion results
        if (result.getThrowable() instanceof AssertionError) {
            String assertionMessage = result.getThrowable().getMessage();
            getTest().log(Status.FAIL, "Assertion Error: " + assertionMessage);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // Log soft assertion failures to the console
        if (!softAssertionErrors.isEmpty()) {
            System.out.println("Soft Assertion Failures:");
            for (Throwable failure : softAssertionErrors) {
                System.out.println(failure.getMessage());
            }
        }

        // Your existing implementation
        logger.info("The " + context.getName() + " is Finished");
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }
    private void configureLogger() {
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        builder.setStatusLevel(Level.ERROR);
        builder.setStatusLevel(Level.INFO);
        builder.setConfigurationName("CustomLogger");

        // Creating ThresholdFilter using builder pattern
        FilterComponentBuilder filterBuilder = builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT, Filter.Result.DENY);
        filterBuilder.addAttribute("level", Level.ERROR);
        filterBuilder.addAttribute("level",Level.INFO);

        // Creating Console appender
        AppenderComponentBuilder appenderBuilder = builder.newAppender("Console", "CONSOLE")
                .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

        // Adding ThresholdFilter to Console appender
        appenderBuilder.add(filterBuilder);

        // Creating PatternLayout for console appender
        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout")
                .addAttribute("pattern", "[%d{HH:mm:ss.SSS}] [%-5level] %logger{36} - %msg%n");

        // Adding PatternLayout to Console appender
        appenderBuilder.add(layoutBuilder);

        // Adding Console appender to logger
        builder.add(appenderBuilder);

        // Creating logger for TestListener class
        builder.add(builder.newLogger(TestListener.class.getName(), Level.INFO)
                .add(builder.newAppenderRef("Console"))
                .addAttribute("additivity", false));

        // Configuring root logger
        builder.add(builder.newRootLogger(Level.INFO).add(builder.newAppenderRef("Console")));

        // Initializing logger context
        LoggerContext ctx = Configurator.initialize(builder.build());
        ctx.start();
    }

}

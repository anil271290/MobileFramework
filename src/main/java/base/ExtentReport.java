package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {

    private static ExtentReports extent;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
    private static final String timestamp = dateFormat.format(new Date());
    private static final String reportFileName = "Test-Automation-Report_" + timestamp + ".html";
    private static final String reportFilePath = System.getProperty("user.dir") + File.separator + "TestReport" + File.separator + reportFileName;
    private static final Map<Long, ExtentTest> extentTestMap = new HashMap<>();

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        try {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Test Report");
            sparkReporter.config().setTheme(Theme.DARK);
            extent.attachReporter(sparkReporter);
            System.out.println("ExtentReports instance created successfully.");
        } catch (Exception e) {
            System.err.println("Error initializing ExtentReports: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = getInstance().createTest(testName); // Ensure ExtentReports instance is initialized
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    public static synchronized void endTest() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }
}

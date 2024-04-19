package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
    private static final String timestamp = dateFormat.format(new Date());
    private static final String reportFileName = "Test-Automaton-Report_" + timestamp + ".html";
    private static final String reportFilepath = System.getProperty("user.dir") + File.separator + "TestReport";
    private static final String reportFileLocation = reportFilepath + File.separator + reportFileName;
    private static final String logFilePath = "logs" + File.separator + "application.log";

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Author", "Anill");

        // Create a test instance for logs
        test = extent.createTest("Log Details");

        // Include log file contents in extent report
        includeLogFileContents();

        return extent;
    }

    public static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdirs()) {
                System.out.println("Directory: " + path + " is created!");
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return reportFileLocation;
    }

    private static void includeLogFileContents() {
        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                test.log(Status.INFO, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
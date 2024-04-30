package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppiumBase {

    protected static final Logger logger = LogManager.getLogger(AppiumBase.class);
    private AppiumDriver driver;

    DesiredCapabilities cap = new DesiredCapabilities();
    public void setup() throws MalformedURLException {
       /* DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "samsung SM-N960F");
        cap.setCapability("udid", "5138364c57393498");
        cap.setCapability("udid", "RZ8T50JH5XP");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("appPackage", "com.commonfriend");
        cap.setCapability("appActivity", "com.commonfriend.splashActivity");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("videoRecordingEnabled", "true");*/



        cap.setCapability("deviceName", "motorola moto g72");
        cap.setCapability("udid", "ZD22284NN5");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("appPackage", "com.commonfriend");
        cap.setCapability("appActivity", "com.commonfriend.SplashActivity");
        cap.setCapability("appWaitActivity","com.commonfriend.TutorialActivity");
        cap.setCapability("appWaitForLaunch",false);
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appWaitActivity", "com.commonfriend.TutorialActivity");
        cap.setCapability("enforceXPath1", true);

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }

    public void setupEmulator() throws MalformedURLException {
        cap.setCapability("app","C:\\Users\\ANIL PATEL\\Automation Library\\Appium\\cm1550.apk");
        cap.setCapability("deviceName","pixel13");
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        URL url=new URL("http://127.0.0.1:4723");
        driver=new AppiumDriver(url,cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

    }

    public AppiumDriver getAppiumDriver() {
        return driver;
    }

    public void continueButton() {
       driver.findElement(By.id("com.commonfriend:id/btnContinue")).click();
    }


    public void skipButton() {
        driver.findElement(By.id("com.commonfriend:id/txtSkipAll")).click();
    }

    public void startRecord(){
       // ((CanRecordScreen) androidDriver).startRecordingScreen();
   }

    public  void takeScreenshot(String description) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);

            // Format current date and time as ddMMyyyy-HHmmss
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HHmmss");
            String currentDate = dateFormat.format(new Date());

            // Construct screenshot file name
            String screenshotName = currentDate + ".png";

            // Save screenshot to the screenshots directory
            File screenshotFile = new File("./TestReport/screenshots/" + screenshotName);
            FileUtils.writeByteArrayToFile(screenshotFile, OutputType.BYTES.convertFromBase64Png(base64Screenshot));

            // Provide media entity for the extent report
            ExtentReport.getTest().info(description, MediaEntityBuilder.createScreenCaptureFromPath("../TestReport/screenshots/" + screenshotName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

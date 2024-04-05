package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumBase {


    private AppiumDriver driver;



    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "samsung SM-N960F");
       // cap.setCapability("udid", "5138364c57393498");
        cap.setCapability("udid", "RZ8T50JH5XP");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("appPackage", "com.commonfriend");
        cap.setCapability("appActivity", "com.commonfriend.SplashActivity");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appWaitActivity", "com.commonfriend.TutorialActivity");
        cap.setCapability("autoGrantPermissions", "true"); // Grant necessary permissions
        cap.setCapability("videoRecordingEnabled", "true");
        cap.setCapability("outputDirectory", "./TestReport/videos/");
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

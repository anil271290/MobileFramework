package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public class Priority {

    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Age']")
    public WebElement age;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Height']")
    public WebElement hight;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    public WebElement education;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profession']")
    public WebElement profession;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Income']")
    public WebElement income;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Looks']")
    public WebElement looks;

   public String start= "//*[@resource-id='com.commonfriend:id/llPriority'][%s]";
   public String end="//*[@resource-id='com.commonfriend:id/llPriority'][%s]";




    public String priorityDownBtn1 = "//*[@text='%s']/..//android.widget.ImageView[1]";
    public String priorityUpBtn1 = "//*[@text='%s']/..//android.widget.ImageView[2]";

    public Priority(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tickpriority() {
        age.click();
        income.click();
        profession.click();
        hight.click();
        education.click();
        looks.click();
    }


    public void changePriorityToUp(String name, int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.xpath(String.format(priorityUpBtn1, name))).click();
        }
    }

    public void changePriorityToDown(String name, int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.xpath(String.format(priorityDownBtn1, name))).click();
        }

    }


}


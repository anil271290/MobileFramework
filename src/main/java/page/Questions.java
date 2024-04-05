package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Questions {

    public AppiumDriver driver;

    public Questions(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[@text='Questions']/../*[2]")
    public WebElement quexpath;
    @AndroidFindBy(id = "com.commonfriend:id/imgCross")
    public WebElement closeQuestions;
}

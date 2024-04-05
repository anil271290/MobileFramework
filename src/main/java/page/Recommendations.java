package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Recommendations {
    public AppiumDriver driver;

    public Recommendations(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.commonfriend:id/llNoProfiles']/*[1]")
    public WebElement crossImageLogo;
    @AndroidFindBy(id = "com.commonfriend:id/btnAction")
    public WebElement okbtn;
    @AndroidFindBy(xpath = "//*[@text='Send Request']")
    public WebElement sendrequest;


}

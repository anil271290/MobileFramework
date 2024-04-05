package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BackGroundAbled {

    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No']")
    public WebElement No;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes']")
    public WebElement Yes;


    public BackGroundAbled(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void ability(WebElement element)
    {
        element.click();
    }

}


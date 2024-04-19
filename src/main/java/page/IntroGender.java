package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroGender {

    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Male']")
    public WebElement Male;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Female']")
    public WebElement Female;
    @AndroidFindBy(xpath = "//*[@text='Introduction']")
    public WebElement headerTitle;
    @AndroidFindBy(id = "com.commonfriend:id/btnLeft")
    public WebElement backArrow;
    @AndroidFindBy(xpath = "//*[@text='2/6']")
    public WebElement SecondPageNo;
    @AndroidFindBy(xpath = "//*[@text=\"What's your gender?\"]")
    public WebElement secondPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement privacyText;






    public IntroGender(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectgender(WebElement element) {
        element.click();
    }


}







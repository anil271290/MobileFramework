package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    public AppiumDriver driver;

    @AndroidFindBy(id = "edtNumber")
    public WebElement entermobile;

    @AndroidFindBy(id = "com.commonfriend:id/imgContinue")
    public WebElement goerrow;


    public Loginpage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void entermono(String number)

    {
        entermobile.sendKeys(number);
    }

    public void continuebutton() {
        goerrow.click();
    }


}

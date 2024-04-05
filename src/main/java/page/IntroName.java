package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroName {
    public AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/edtFirstName")
    public WebElement fname;

    @AndroidFindBy(id = "com.commonfriend:id/edtLastName")
    public WebElement lname;

    @AndroidFindBy(id = "com.commonfriend:id/btnContinue")
    public WebElement cntn;

    public IntroName(AppiumDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterfirstname(String startname) {
        fname.sendKeys(startname);
    }

    public void enterlastname(String endname) {

        lname.sendKeys(endname);
    }

    public void clkcont() {
        cntn.click();
    }

}

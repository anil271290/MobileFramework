package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YourProgress {

    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    public WebElement editprofile;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public WebElement continuebtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement permissionbtn;
    @AndroidFindBy(xpath = "//*[@text='Background']")
    public WebElement backgroundBtn;

    public YourProgress(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void editprofilebutton() {
        editprofile.click();
    }

    public void continuBtn() {
        continuebtn.click();
           }
    public void backGroundClick(){
        backgroundBtn.click();
    }

}

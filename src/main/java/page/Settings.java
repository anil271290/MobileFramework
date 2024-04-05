package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Settings {
    public AppiumDriver driver;

    public Settings(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/btnSettings")
    public WebElement settingbtn;
    @AndroidFindBy(xpath = "//*[@text='Priority']")
    public WebElement prioritybtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    public WebElement editprofilebtn;
    @AndroidFindBy(id = "com.commonfriend:id/imgEditBirth")
    public WebElement birtheditbtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Change now']")
    public WebElement confirmbtn;
    @AndroidFindBy(xpath = "//*[@text='Questions']")
    public WebElement questionbtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnCross")
    public WebElement crossbtn;
    @AndroidFindBy(xpath = "//*[@text='Logout']")
    public WebElement logoutBtn;


    public void clickonsetting() {
        settingbtn.click();
    }

    public void clickonpriority() {
        prioritybtn.click();
    }

    public void clickOnEditProfile() {
        editprofilebtn.click();
    }

    public void editBirth() {
        birtheditbtn.click();
        confirmbtn.click();
    }
    public void clickOnQuestions(){
        questionbtn.click();
    }
    public void close(){
        crossbtn.click();
    }


}

package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Education {
    public AppiumDriver driver;


    @AndroidFindBy(xpath = "//*[@text='Should take about 30 seconds.']")
    public WebElement TimeInfoText;
    @AndroidFindBy(id = "btnAdd")
    public WebElement continueeducation;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtTagLine\"]")
    public WebElement educationHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtQuestion\"]")
    public WebElement education1stScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement educationPrivacyText;
    @AndroidFindBy(xpath = "//*[@text=\"Visible to your recommendations only\"]")
    public WebElement privacyText;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/llPrivacy\"]/../*[3]/*[1]/*")
    public WebElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text=\"Add qualification\"]")
    public WebElement qualificationHeader;

    @AndroidFindBy(xpath = "//*[@text='B.Tech']")
    public WebElement BtechXpath;       //for scroll down and select text: @Text='B.Tech' , 'M.Tech'


    @AndroidFindBy(id = "edtSearch")
    public WebElement addqualification;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Full-Time']")
    public WebElement degreetype;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtTypeQuestion\"]")
    public WebElement DegreeScreenQueText;
    @AndroidFindBy(id = "com.commonfriend:id/txtHeaderTitle")
    public WebElement CollageScreenHeaderText;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement SearchCollege;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='University of Oxford']")
    public WebElement collegeselect;
    @AndroidFindBy(id = "com.commonfriend:id/imgDelete")
    public WebElement deletButton;
    @AndroidFindBy(xpath = "//*[@text='Add']/../*[1]")
    public WebElement PlusButtonImage;
    @AndroidFindBy(id = "com.commonfriend:id/btnContinue")
    public WebElement BtnContinue;

    public Education(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void continueeducationbtn() {
        continueeducation.click();
    }


}

package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WaitingList {
    private static final Logger logger = LogManager.getLogger(WaitingList.class);
    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//(android.widget.EditText)[1]")
    public WebElement entrycode;

    @AndroidFindBy(id = "btnSetCode")
    public WebElement arrow;

    @AndroidFindBy(id = "com.commonfriend:id/txtAccessCode")
    public WebElement txtdisplay;
    @AndroidFindBy(id = "btnRemoveAccessCode")
    public WebElement removecode;

    @AndroidFindBy(id = "imgCustomProfile")
    public WebElement clickprofile;
    @AndroidFindBy(id = "com.commonfriend:id/imgAadharError")
    public WebElement locksymbol;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement permission;

    @AndroidFindBy(id = "com.commonfriend:id/edtFeedback")
    public WebElement editfeedback;
    @AndroidFindBy(id = "com.commonfriend:id/btnDone")
    public WebElement submit;

    @AndroidFindBy(id = "com.commonfriend:id/edtNumber")
    public WebElement invitation;

    @AndroidFindBy(id = "com.commonfriend:id/txtWordCount")
    public WebElement textCount;


    @AndroidFindBy(xpath = "//*[@text='Refer me']/..//following-sibling::android.widget.ImageView")
    public WebElement invitationImage;

    @AndroidFindBy(id = "com.commonfriend:id/txtMsg")
    public WebElement feedbackHeader;

    @AndroidFindBy(xpath = "//*[@text='Waitlist!']")
    public WebElement waitListText;

    @AndroidFindBy(id = "com.commonfriend:id/btnAccount")
    public WebElement recommendationBtn;
    @AndroidFindBy(xpath = "//*[@text='Recommendations']/../*[2]")
    public WebElement recommendationField;


    public WaitingList(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clkpermission() {
        permission.click();
    }


    public void getdisplaytxt() {
        System.out.println(txtdisplay.getText());
    }

    public void verifydisplaytxt() {
        if (txtdisplay.getText() == null) {
            entrycode.sendKeys("595959");
        } else {
            logger.info("Already applied");
        }

    }

    public void removeaccesscode() {
        removecode.click();
    }

    public void profileclickbutton() {
        clickprofile.click();
    }

    public void checkProfileActivation() {
        Assert.assertFalse(locksymbol.isDisplayed(),"Profile Activated");
    }

    public void feedback() {
        editfeedback.sendKeys("hello hi how r u,khaana khake jana");
        submit.click();
    }

    public void invitationField() {
        invitation.sendKeys("7265883883");
        invitationImage.click();
    }

    public void permission() {
        permission.click();
    }

}

package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Photos {

    public AppiumDriver driver;

    @AndroidFindBy(id = "btnAdd")
    public WebElement continuebttn;
    @AndroidFindBy(xpath = "//*[@text=\"And finally, share any photos you'd like.\"]")
    public WebElement PhotoHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@text='Should take about a minute.']")
    public WebElement TimeInfoText;
    @AndroidFindBy(id = "btnAction")
    public WebElement okbutn;
    @AndroidFindBy(id = "com.commonfriend:id/txtMsgDesc")
    public WebElement DialogBoxMsg;
    @AndroidFindBy(xpath = "//*[@text='Just FYI']")
    public WebElement DialogBoxHeader;

    @AndroidFindBy(id = "com.commonfriend:id/imgDisplayPicture")
    public WebElement plusphoto;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement allow;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Screenshots\")")
    public WebElement selectPhotoFolder;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Photo taken on 07-Dec-2023 10:54:05 am\")")
    public WebElement selectPhoto;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*[2]")
    public WebElement firstphoto;

    public Photos(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continuephoto() throws InterruptedException {
        continuebttn.click();
        Thread.sleep(3000);

    }

    public void tapphoto() {
       plusphoto.click();
       allow.click();

    }
}

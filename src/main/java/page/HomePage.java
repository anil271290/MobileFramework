package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/imgAccount")
    public WebElement recommendationbtn;
    @AndroidFindBy(id = "com.commonfriend:id/imgHome")
    public WebElement homebtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnChat")
    public WebElement chatbtn;
    @AndroidFindBy(id = "com.commonfriend:id/imgSettings")
    public WebElement settingbtn;
    @AndroidFindBy(id = "com.commonfriend:id/txtChannelName")
    public WebElement chatperson;
    @AndroidFindBy(id = "com.commonfriend:id/messageEditText")
    public WebElement editchat;
    @AndroidFindBy(id = "com.commonfriend:id/sendMessageButton")
    public WebElement senttext;
    @AndroidFindBy(id = "com.commonfriend:id/imgBack")
    public WebElement backfromchat;
    @AndroidFindBy(id = "com.commonfriend:id/txtUserInits")
    public WebElement clickimage;
    @AndroidFindBy(id = "com.commonfriend:id/btnCross")
    public WebElement closefrndprofile;

    public void clickrecommendaation() {
        recommendationbtn.click();
    }

    public void clickhome() {
        homebtn.click();
    }

    public void clickchat() {
        chatbtn.click();
    }

    public void clicksetting() {
        settingbtn.click();
    }

    public void clickchatperson() {
        chatperson.click();
    }

    public void startChat() {
        editchat.sendKeys("hiii");
        senttext.click();
    }

    public void backFromChatting() {
        backfromchat.click();
    }

    public void clickonProfileImage() {
        clickimage.click();
    }

    public void closeFriendProfile() {
        closefrndprofile.click();
    }


}

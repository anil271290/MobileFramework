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
    @AndroidFindBy(id = "btnAction")
    public WebElement okbutn;

    @AndroidFindBy(id = "com.commonfriend:id/imgDisplayPicture")
    public WebElement plusphoto;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement allow;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*[2]")
    public WebElement firstphoto;

    public Photos(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continuephoto() throws InterruptedException {
        continuebttn.click();
        Thread.sleep(3000);
        okbutn.click();
    }

    public void tapphoto() {
       plusphoto.click();
       allow.click();
       firstphoto.click();
    }
}

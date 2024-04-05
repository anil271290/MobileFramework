package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfessionHome {

    public AppiumDriver driver;
    @AndroidFindBy(id = "btnAdd")
    public WebElement continueprofession;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Add job title']")
    public WebElement addjobtitle;

    @AndroidFindBy(id = "edtSearch")
    public WebElement editsearch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Software Developer']")
    public WebElement selectjob;

    public ProfessionHome(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continueprofessionbtn() {
        continueprofession.click();
    }

    public void jobentry() {
        addjobtitle.click();
    }

    public void editjob() {
        editsearch.sendKeys("Software developer");
        selectjob.click();

    }
}

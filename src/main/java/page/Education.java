package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Education {
    public AppiumDriver driver;

    @AndroidFindBy(id = "btnAdd")
    public WebElement continueeducation;

    @AndroidFindBy(id = "txtLocationName")
    public WebElement addeducation;

    @AndroidFindBy(id = "edtSearch")
    public WebElement addqualification;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='B.E']")
    public WebElement clickqualification;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Full-Time']")
    public WebElement degreetype;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement addcollege;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='University of Oxford']")
    public WebElement collegeselect;

    public Education(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void educationadddropdown() {
        addeducation.click();
    }

    public void qulificationselection() {
        addqualification.sendKeys("B.E");
        clickqualification.click();
        degreetype.click();
    }

    public void collageselection() {
        addcollege.sendKeys("oxford");
        collegeselect.click();

    }

    public void continueeducationbtn() {
        continueeducation.click();
    }


}

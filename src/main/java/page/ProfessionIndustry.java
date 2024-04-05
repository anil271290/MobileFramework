package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfessionIndustry {

    public AppiumDriver driver;

    @AndroidFindBy(id = "edtCompanyName")
    public WebElement organizationname;

    @AndroidFindBy(id = "edtIndustry")
    public WebElement industry;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    public WebElement addindustry;

    public ProfessionIndustry(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void entrorganization() {
        organizationname.sendKeys("Innovate");
    }

    public void clickindustry() {
        industry.click();
    }

    public void selectindustry() {
        addindustry.click();
    }
}

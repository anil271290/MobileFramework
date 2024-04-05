package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Finance {
    public AppiumDriver driver;

    @AndroidFindBy(id = "btnAdd")
    public WebElement enterfinance;

    @AndroidFindBy(id = "txtLocationName")
    public WebElement work;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Private company']")//Private company,Family business,Own business,Own firm,Civil services,Do not work
    public WebElement selectwork;

    @AndroidFindBy(id = "btnIncrease")
    public WebElement tapmoney;

    @AndroidFindBy(id = "btnAction")
    public WebElement okaybutton;
    @AndroidFindBy(xpath = "//*[@content-desc=\"Value, 0\"]")
    public WebElement dotbutton;

    public Finance(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void financehome() {
        enterfinance.click();
    }

    public void enterwork() {
        work.click();
    }

    public void workselection() {
        selectwork.click();
    }

    public void makemoney() {
        tapmoney.click();
    }

    public void okbutton() {
        okaybutton.click();
    }

    /**
     * @param key between 1 to 12
     */
    public void dotBtnPlusMinus(String key){
        dotbutton.sendKeys(key);
    }
}

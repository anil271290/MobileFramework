package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroRelationship {
    public AppiumDriver driver;

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@text='Awaiting divorce']")//Annulled,Awaiting divorce,Widow,Divorced
    public WebElement rstatus;*/
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Never married']")
    public WebElement rstatus;

    @AndroidFindBy(xpath = "//*[@text='No']")
    public WebElement Nokids;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public WebElement buttonadd;


    public IntroRelationship(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void relationst() throws InterruptedException {
        rstatus.click();
        Thread.sleep(500);
      //  Nokids.click();
    }
}

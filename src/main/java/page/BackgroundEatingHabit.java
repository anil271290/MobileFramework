package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BackgroundEatingHabit {

    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vegeterian']")
    public WebElement ehabit;
    @AndroidFindBy(xpath = "//*[@text='What are your eating habits?']")
    public WebElement EatScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='6/6']")
    public WebElement SixthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement EatingPrivacyText;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public List<WebElement> allEatHabitsXpath;



    public BackgroundEatingHabit(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void eathabit() {
        ehabit.click();
    }


}

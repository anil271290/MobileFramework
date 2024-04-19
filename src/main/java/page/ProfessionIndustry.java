package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfessionIndustry {

    public AppiumDriver driver;
    @AndroidFindBy(xpath = "//*[@text='2/2']")
    public WebElement SecondPageNo;
    @AndroidFindBy(xpath = "//*[@text='Which industry?']")
    public WebElement profession2ndScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Industry']")
    public WebElement DropDown2ndScreenPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Profession']")
    public WebElement ProfessionHeaderTitle;






    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public WebElement AllIndustriesXpath;

    @AndroidFindBy(xpath = "//*[@text='Technology']")
    public WebElement addindustry;

    public ProfessionIndustry(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }




}

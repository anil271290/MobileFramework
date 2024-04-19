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


    @AndroidFindBy(xpath = "//*[@text='Should take about 30 seconds.']")
    public WebElement TimeInfoText;
    @AndroidFindBy(xpath = "//*[@text='1/2']")
    public WebElement FirstPageNo;

    @AndroidFindBy(xpath = "//*[@text='Add job title']")
    public WebElement addjobtitle;

    @AndroidFindBy(id = "edtSearch")
    public WebElement editsearch;

    @AndroidFindBy(xpath = "//*[@text='Software Developer']")
    public WebElement selectjob;

    //@Text='IT & Software Engineering' or 'Software Developer' //for scroll down to visible text
    @AndroidFindBy(xpath = "//*[@text='Tell me about your profession.']")
    public WebElement professionHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@text=\"What's your job title?\"]")
    public WebElement profession1stScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Add job title']")
    public WebElement DropDown1stScreenPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Profession']")
    public WebElement ProfessionHeaderTitle;


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


    }
}

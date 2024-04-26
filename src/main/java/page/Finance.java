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
    @AndroidFindBy(xpath = "//*[@text='Money matters! Lets discuss it.']")
    public WebElement FinanceHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@text='Should take about 30 seconds.']")
    public WebElement TimeInfoText;
    @AndroidFindBy(xpath = "//*[@text='Finances']")
    public WebElement FinanceScreenHeaderTitle;
    @AndroidFindBy(xpath = "//*[@text=\"What's your line of work?\"]")
    public WebElement FinanceFirstScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='1/3']")
    public WebElement FirstPageNo;
    @AndroidFindBy(id = "txtLocationName")
    public WebElement work;
    @AndroidFindBy(xpath = "//*[@text='Select line of work']")
    public WebElement DropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public WebElement AllWorksXpath;
    @AndroidFindBy(xpath = "//*[@text='Student']")
    public WebElement verifyText;
    @AndroidFindBy(xpath = "//*[@text='2/3']")
    public WebElement SecondPageNo;
    @AndroidFindBy(xpath = "//*[@text='3/3']")
    public WebElement ThirdPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement Finance2ndPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='Visible to yourself only']")
    public WebElement Finance3rdPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='How much money do you make in a year?']")
    public WebElement finance2ndscreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text=\"What is your family's net worth?\"]")
    public WebElement finance3rdscreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='No Income']")
    public WebElement SecondScreenDefaultIncomeTitle;
    @AndroidFindBy(xpath = "//*[@text='Below ₹1 crores']")
    public WebElement ThirdScreenDefaultIncomeTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Private company']")//Private company,Family business,Own business,Own firm,Civil services,Do not work
    public WebElement selectwork;

    @AndroidFindBy(id = "btnIncrease")
    public WebElement PlusButton;
    @AndroidFindBy(id = "btnDecrease")
    public WebElement MinusButton;

    @AndroidFindBy(id = "btnAction")
    public WebElement okaybutton;

    @AndroidFindBy(xpath = "//*[@text='Proceed']")
    public WebElement proceedBtn;
    @AndroidFindBy(xpath = "//*[@text='Prefer not to say']")
    public WebElement preferNotToSayBtn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Value, 0\"]")
    public WebElement dotbutton;
    @AndroidFindBy(xpath = "//*[@text='About Net worth']")
    public WebElement DialogBoxHeaderText;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/*[2]/*[2]")
    public WebElement DialogBoxTexts;


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

package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class BackgroundHeight {
    public AppiumDriver driver;

    public BackgroundHeight(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//*[@text='How tall are you?']")
    public WebElement HeightScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement heightPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='4/6']")
    public WebElement FourthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Inches']")
    public WebElement HeightContainerText;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='0\"']")
    public WebElement DefaultInchXpath;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='8\"']")
    public WebElement EightInchXpath;
    public void scrollDownToInches(String targetInch) {
        String InchLocator = "//*[contains(@text,'0\"')]";
        WebElement currentInchElement = driver.findElement(By.xpath(InchLocator));
        String currentInch = currentInchElement.getText();

        while (!currentInch.equals(targetInch)) {
            // Identify the element to scroll to (the month picker)
            WebElement inchElement = driver.findElement(By.xpath(InchLocator));

            // Create parameters for the mobile:scroll command
            Map<String, Object> scrollParams = new HashMap<>();
            scrollParams.put("strategy", "accessibility id"); // Specify the strategy
            scrollParams.put("selector", inchElement.getAttribute("xpath")); // Specify the selector
            scrollParams.put("toVisible", "true");

            // Execute the mobile:scroll command
            driver.executeScript("mobile:scroll", scrollParams);

            // Update current month after scrolling
            currentInch = inchElement.getText();
        }
    }

}

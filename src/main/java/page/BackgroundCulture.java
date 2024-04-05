package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BackgroundCulture {
    public AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public WebElement addculture;

    @AndroidFindByAllSet(value = {@AndroidFindAll(value = {@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.commonfriend:id/txtCulture']")})})
    public static List<WebElement> cultures;

    public static List<String> getCultureTexts() {
        List<String> CultureTexts = new ArrayList<>();
        for (WebElement element : cultures) {
            CultureTexts.add(element.getText());
        }
        return CultureTexts;
    }

    public static void clickCulture(int index) {
        if (index >= 0 && index < cultures.size()) {
            cultures.get(index).click();
        } else {
            System.out.println("Invalid index.");
        }
    }

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public WebElement coninuecl;


    public BackgroundCulture(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void AddCulture() {
        addculture.click();
    }

    public void tickculture() {
        // Interacting with elements
        for (WebElement element : cultures) {
            System.out.println(element.getText());
            // Perform other actions if needed
        }

        // Using page object methods
        List<String> CultureTexts = getCultureTexts();
        for (String culturetext : CultureTexts) {
            System.out.println(culturetext);


        }

        BackgroundCulture.clickCulture(0);// Click on the first location
        BackgroundCulture.clickCulture(1);
        BackgroundCulture.clickCulture(2);

    }

    public void cltrcontinu() {
        coninuecl.click();
    }


}

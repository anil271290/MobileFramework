package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;


public class EditProfile {

    public AppiumDriver driver;


    @AndroidFindBy(id = "btnSave")
    public WebElement savebutton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.commonfriend:id/imgEditRelationShip']")
    public WebElement relationshipeditbtn;
    @AndroidFindBy(xpath = "//*[@text='Divorced']")
    public WebElement divorcebtn;
    @AndroidFindBy(xpath = "//*[@text='Yes']")
    public WebElement yesbtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnCross")
    public WebElement crossbtn;
    @AndroidFindBy(xpath = "//*[@text='Gender']")
    public WebElement textGender;


    public EditProfile(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clicksavebtn() {
        savebutton.click();
    }

    public void clickOnEditRelationship(){
        relationshipeditbtn.click();
        divorcebtn.click();
        yesbtn.click();
        crossbtn.click();
    }
}


package util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


public class Utils {
    protected static final Logger logger = LogManager.getLogger(Utils.class);

    public static AppiumDriver driver;
    protected WebDriverWait wait;

    public Utils(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void scrolldown(int startX, int startY, int endX, int endY, int scrollCount) {
        for (int i = 0; i < scrollCount; i++) {
            PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(input, 0);
            swipe.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
            //swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));
        }
    }

    public void scrolldown(WebElement sourceElement, int scrollCount) {
        Dimension size = driver.manage().window().getSize();
        int startX = sourceElement.getLocation().x;
        int startY = sourceElement.getLocation().y;
        //int endX = sourceElement.getLocation().x + 50;
        int endX = startX;
        //  int endY = (int) (size.height * 0.7);
        int endY = sourceElement.getLocation().y + 200;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < scrollCount; i++) {
            PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(input, 0);
            swipe.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
           // driver.perform(Arrays.asList(swipe));
            driver.perform(Collections.singletonList(swipe));

        }
    }


    public void swipeToAGivenTextAndClick(String elementText) {
        String uiSelector = "new UiSelector().textMatches(\"" + elementText
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
        driver.findElement(AppiumBy.androidUIAutomator(command)).click();
    }


    public void swipeToHorizontal(String elementText) {
        String uiSelector = "new UiSelector().textMatches(\"" + elementText
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView("
                + uiSelector + ");";
        driver.findElement(AppiumBy.androidUIAutomator(command)).click();
    }


    public void swipeToAGivenResourceIDAndClick(String resourceId) {
        String uiSelector = "new UiSelector().resourceIdMatches(\"" + resourceId
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
        driver.findElement(AppiumBy.androidUIAutomator(command)).click();
    }


    public void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException ex) {
            logger.error("Element not found: {}", ex.getMessage());
        }
    }


    public void waitForElementWithFluentWait(WebElement element) {
        FluentWait<AppiumDriver> fluent = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        fluent.until(t -> element.isDisplayed());
    }



    public  String getCurrentTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        return dateFormat.format(new Date());
    }

    public static void dragAndDrop(String sourceElementXpath, int sourceIndex, String destinationElementXpath, int destinationIndex) {
        // Locate source and destination elements
        WebElement source = driver.findElement(By.xpath(String.format(sourceElementXpath, sourceIndex)));
        WebElement target = driver.findElement(By.xpath(String.format(destinationElementXpath, destinationIndex)));

        Point sourceElementCenter = getCenterOfElement(source.getLocation(), source.getSize());
        Point targetElementCenter = getCenterOfElement(target.getLocation(), target.getSize());
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(588)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetElementCenter))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2,
                location.getY() + size.getHeight() / 2);
    }

    public void swipeInContainer(WebElement element) {
        // WebElement container = driver.findElement(MobileBy.id("your_container_id"));
        Point containerLocation = element.getLocation();
        Dimension containerSize = element.getSize();

        int startX = (int) (containerLocation.getX() + containerSize.getWidth() / 1.11);
        int startY = (int) (containerLocation.getY() + containerSize.getHeight() / 1.30);

        int endX = (int) (containerLocation.getX() + containerSize.getWidth() / 1.11);
        int endY = (int) (containerLocation.getY() + containerSize.getHeight() / 1.03); // Adjust this value based on where you want to swipe

        PointerInput swipeAction = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipeSequence = new Sequence(swipeAction, 0);
        swipeSequence.addAction(swipeAction.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipeSequence.addAction(swipeAction.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeSequence.addAction(swipeAction.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipeSequence.addAction(swipeAction.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipeSequence));

    }


}

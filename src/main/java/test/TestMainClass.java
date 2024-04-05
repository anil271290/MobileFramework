package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import base.AppiumBase;
import org.testng.asserts.SoftAssert;
import page.*;
import util.OTPService;
import util.SmsOtp;
import util.Utils;


import java.io.IOException;
import java.net.MalformedURLException;

import static util.Utils.takeScreenshot;

@Listeners(base.TestListner.class)


public class TestMainClass extends AppiumBase{
    protected static final Logger logger = LogManager.getLogger(TestClass.class);

    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void launchApp() throws MalformedURLException {
        setup();
    }

    @Test(enabled = false)
    public void registration() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());
        WelcomePage wp=new WelcomePage(getAppiumDriver());
        OTPService ot = new OTPService(getAppiumDriver());
        IntroName name=new IntroName(getAppiumDriver());
        IntroGender gender=new IntroGender(getAppiumDriver());
        CurrentLocation cl=new CurrentLocation(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        IntroLocations il=new IntroLocations(getAppiumDriver());
        IntroRelationship ir=new IntroRelationship(getAppiumDriver());
        BackgroundReligion religion=new BackgroundReligion(getAppiumDriver());
        BackgroundCulture bc=new BackgroundCulture(getAppiumDriver());
        BackGroundAbled abled=new BackGroundAbled(getAppiumDriver());
        BackgroundEatingHabit habit=new BackgroundEatingHabit(getAppiumDriver());
        Finance fc=new Finance(getAppiumDriver());
        ProfessionHome ph=new ProfessionHome(getAppiumDriver());
        ProfessionIndustry pi=new ProfessionIndustry(getAppiumDriver());
        Education education=new Education(getAppiumDriver());
        Photos phs=new Photos(getAppiumDriver());
        Priority pr=new Priority(getAppiumDriver());
        BackgroundBday bday=new BackgroundBday(getAppiumDriver());
        BackgroundHeight height=new BackgroundHeight(getAppiumDriver());
        WaitingList wl=new WaitingList(getAppiumDriver());
        Settings st=new Settings(getAppiumDriver());
        Recommendations rc=new Recommendations(getAppiumDriver());
        EditProfile edit=new EditProfile(getAppiumDriver());

        sp.clickButton();
        log.entermono("6446644668");
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);

        // Get OTP from server
        String countryCode = "+91";
        String mobileNumber = "6446644668";
        String otp = OTPService.getOTPFromServer(countryCode, mobileNumber);
        logger.info("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);
        wp.allow.click();
        wp.clikcontnu1();
        name.enterfirstname("Sruti");
        takeScreenshot("Name");
        name.enterlastname("thapar");
        continueButton();
        gender.selectgender(gender.Female);
        takeScreenshot("Gender");
        wp.clikcontnu1();

       // continueButton();
        il.clicklocation();
        takeScreenshot("MultiLocations");
        logger.info("Choose Locations");
        il.selectlocat();
        ir.relationst();
        takeScreenshot("Relationship");
        ir.buttonadd.click();
        Thread.sleep(1000);
        religion.religion();
        logger.info("Select Religion that you Belief");
        religion.checkreligion();
        takeScreenshot("religion");
        logger.info("Religion selected");
        bc.AddCulture();
        bc.tickculture();
        logger.info("Culture Selected");
        bc.cltrcontinu();
        ut.waitForElementToBeVisible(bday.year);
        takeScreenshot("Scroll Bday");
        ut.scrolldown(502,1029,502,1245,1);
        takeScreenshot("Birthday selected");
        continueButton();
        ut.waitForElementToBeVisible(height.headerText);
        ut.scrolldown(511,1242,511,1020,1);
        takeScreenshot("Height selected");
        logger.info("Hieght scrolled and selected");
        continueButton();
        ut.waitForElementToBeVisible(abled.No);
        takeScreenshot("Ability");
        abled.ability(abled.No);
        habit.eathabit();
        fc.financehome();
        takeScreenshot("Finance");
        fc.enterwork();
        takeScreenshot("Area of work");
        fc.workselection();
        // fc.makemoney();
        fc.dotBtnPlusMinus("1");
        takeScreenshot("yearly Income");
        continueButton();
        fc.okbutton();
        continueButton();
        ph.continueprofessionbtn();
        ph.jobentry();
        ph.editjob();
        pi.clickindustry();
        takeScreenshot("Industry");
        pi.selectindustry();
        education.continueeducationbtn();
        education.educationadddropdown();
        takeScreenshot("Qualification");
        education.qulificationselection();
        education.collageselection();
        takeScreenshot("college Name");
        continueButton();
        phs.continuephoto();
        phs.tapphoto();
        continueButton();
        ut.waitForElementWithFluentWait(edit.textGender);
        ut.swipeToAGivenTextAndClick("Save");
        ut.swipeToAGivenTextAndClick("Save");
        pr.tickpriority();
        ut.dragAndDrop(pr.start,6,pr.end,1);
        continueButton();
        ut.swipeToAGivenTextAndClick("100 words left");
        String actualTitle= wl.textCount.getText();
        logger.info(actualTitle);
        takeScreenshot("Before entering feedback");
        softAssert.assertTrue(wl.feedbackHeader.isDisplayed());
        softAssert.assertEquals("Have any feedback?",wl.feedbackHeader.getText());
        wl.feedback();
        ut.waitForElementToBeVisible(wl.textCount);
        String expectedTitle = wl.textCount.getText();
        logger.info(expectedTitle);
        Assert.assertNotEquals(actualTitle, expectedTitle, "Feedback sent");
        takeScreenshot("After entering feedback");
        softAssert.assertTrue(st.settingbtn.isDisplayed(), "Element present");
        logger.info("scroll to up");
        ut.swipeToAGivenTextAndClick("Questions");
       logger.info("starting screen");
       takeScreenshot("Waitlist screen");
        softAssert.assertEquals("Waitlist!",wl.waitListText.getText());
        wl.recommendationBtn.click();
        softAssert.assertTrue(rc.crossImageLogo.isDisplayed(),"No recommendation available");
        takeScreenshot("Recommendation");
        st.settingbtn.click();
        logger.info("setting button clicked");
        softAssert.assertAll();
    }
    @Test()
    public void chatAndQuestions() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());
        OTPService ot = new OTPService(getAppiumDriver());
        WelcomePage wp=new WelcomePage(getAppiumDriver());
        WaitingList wl=new WaitingList(getAppiumDriver());
        Recommendations rc=new Recommendations(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        HomePage home=new HomePage(getAppiumDriver());
        Questions qc=new Questions(getAppiumDriver());
        Settings st=new Settings(getAppiumDriver());

        sp.clickButton();
        log.entermono("6446644668");
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);

        // Get OTP from server
        String countryCode = "+91";
        String mobileNumber = "6446644668";
        String otp = OTPService.getOTPFromServer(countryCode, mobileNumber);
        logger.info("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);
      //  wp.permission1();
       ut.swipeToAGivenTextAndClick("Invitations");
       wl.recommendationField.click();
       takeScreenshot("recommendation");
        ut.scrolldown(694,402,15,384,4);
       /* home.clickhome();
        qc.quexpath.click();
        takeScreenshot("Questions");
        ut.scrolldown(326,1437,353,207,15);
        qc.closeQuestions.click();
        st.settingbtn.click();*/
      //  ut.swipeToAGivenTextAndClick("Logout");

    }


    @AfterTest
    public void close() {

        tearDown();
    }

}

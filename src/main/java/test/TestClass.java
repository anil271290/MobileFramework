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


public class TestClass extends AppiumBase {
    protected static final Logger logger = LogManager.getLogger(TestClass.class);

    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void launchApp() throws MalformedURLException {
        setup();
    }
   
    @Test(priority = 1,description = "StartPage")
    public void StartPage() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());
        WelcomePage wp=new WelcomePage(getAppiumDriver());
        OTPService ot = new OTPService(getAppiumDriver());

        sp.clickButton();
        log.entermono("2112211255");
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);

        // Get OTP from server
        String countryCode = "+91";
        String mobileNumber = "2112211255";
        String otp = OTPService.getOTPFromServer(countryCode, mobileNumber);
        logger.info("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);

        wp.permission1();
        wp.clikcontnu1();

    }

    @Test(priority = 2,description = "IntroductionName")
    public void introduction(){
       IntroName name=new IntroName(getAppiumDriver());

       name.enterfirstname("Madhvi");
       takeScreenshot("Name");
       name.enterlastname("Bhide");
       continueButton();
    }

    @Test(priority = 3,description = "IntroductionGender")
    public void gender(){
        IntroGender gender=new IntroGender(getAppiumDriver());

        gender.selectgender(gender.Female);
        takeScreenshot("Gender");
       // continueButton();
    }

    @Test(priority = 4,description = "Location")
    public void locationAccess() {
          CurrentLocation cl=new CurrentLocation(getAppiumDriver());
          Utils ut=new Utils(getAppiumDriver());
          softAssert.assertTrue(cl.conti.isDisplayed(),"Element not found");
          cl.location();
          ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.xpath("//*[@text='Ahmedabad']")));
          takeScreenshot("Location Detected");
          continueButton();
          softAssert.assertAll();
    }
    @Test(priority = 5,description = "Locations to settle")
    public void locationsToSettle(){
        IntroLocations il=new IntroLocations(getAppiumDriver());

        il.clicklocation();
        takeScreenshot("MultiLocations");
        logger.info("Choose Locations");
        il.selectlocat();

    }
    @Test(priority = 6,description = "RelationShip")
    public void relationShip() throws InterruptedException {
        IntroRelationship ir=new IntroRelationship(getAppiumDriver());
        ir.relationst();
        takeScreenshot("Relationship");
        Thread.sleep(1000);
    }
    @Test(priority = 7,description = "BackGround Religion")
    public void selectReligion(){
        BackgroundReligion religion=new BackgroundReligion(getAppiumDriver());
        religion.religion();
        logger.info("Select Religion that you Belief");
        religion.checkreligion();
        takeScreenshot("religion");
        logger.info("Religion selected");
    }
    @Test(priority = 8,description = "BackGround Cultures")
    public void backCultures(){
        BackgroundCulture bc=new BackgroundCulture(getAppiumDriver());
        bc.AddCulture();
        bc.tickculture();
        logger.info("Culture Selected");
        bc.cltrcontinu();
    }
    @Test(priority = 9,description = "BackGround Birthday")
    public void birthDay(){
        Utils ut=new Utils(getAppiumDriver());
        takeScreenshot("Scroll Bday");
        ut.scrolldown(502,1029,502,1242,3);
        takeScreenshot("Birthday selected");
        continueButton();
    }
    @Test(priority = 10,description = "BackGround Height")
    public void height(){
        Utils ut=new Utils(getAppiumDriver());
        takeScreenshot("Scroll Height");
        ut.scrolldown(511,1242,511,1020,2);
        takeScreenshot("Height selected");
        logger.info("Hieght scrolled and selected");
        continueButton();
    }
    @Test(priority = 11,description = "BackGround Hendicap")
    public void hendicap(){
        BackGroundAbled abled=new BackGroundAbled(getAppiumDriver());
        abled.ability(abled.No);
       // continueButton();
    }
    @Test(priority = 12,description = "BackGround Eating Habits")
    public void eatingHabit(){
        BackgroundEatingHabit habit=new BackgroundEatingHabit(getAppiumDriver());
        habit.eathabit();

    }
    @Test(priority = 13,description = "Finance")
    public void money(){
        Finance fc=new Finance(getAppiumDriver());
        fc.financehome();
        fc.enterwork();
        fc.workselection();
       // fc.makemoney();
        fc.dotBtnPlusMinus("3");
        continueButton();
        fc.okbutton();
        continueButton();
    }
    @Test(priority = 14,description = "Profession Home")
    public void profession(){
        ProfessionHome ph=new ProfessionHome(getAppiumDriver());

        ph.continueprofessionbtn();
        ph.jobentry();
        ph.editjob();
    }
    @Test(priority = 15,description = "Profession Industry")
    public void industry(){
        ProfessionIndustry pi=new ProfessionIndustry(getAppiumDriver());
        pi.clickindustry();
        pi.selectindustry();
    }
    @Test(priority = 16,description = "EducationBackground")
    public void education(){
        Education education=new Education(getAppiumDriver());
        education.continueeducationbtn();
        education.educationadddropdown();
        education.qulificationselection();
        education.collageselection();
        continueButton();
    }
    @Test(priority = 17,description = "AddPhotos")
    public void photo() throws InterruptedException {
        Photos ph=new Photos(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        EditProfile edit=new EditProfile(getAppiumDriver());
        ph.continuephoto();
        ph.tapphoto();
        continueButton();
        ut.waitForElementWithFluentWait(edit.textGender);
    }
    @Test(priority = 18,description = "EditProfile")
    public void editProfile(){
        EditProfile edit=new EditProfile(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());

        ut.swipeToAGivenTextAndClick("Save");
    }
    @Test(priority = 19,description = "CheckList")
    public void checkList(){
        CheckList list=new CheckList(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.swipeToAGivenTextAndClick("Save");
    }
    @Test(priority = 20,description = "Priority")
    public void priority(){
        Priority pr=new Priority(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        pr.tickpriority();
        ut.dragAndDrop(pr.start,6,pr.end,1);
        continueButton();
    }

    @Test(priority = 21,description = "Setting")
    public void setting() throws Exception {
        Utils ut = new Utils(getAppiumDriver());
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage lp = new Loginpage(getAppiumDriver());
        WaitingList wl = new WaitingList(getAppiumDriver());
        Settings st = new Settings(getAppiumDriver());
        Priority pr = new Priority(getAppiumDriver());
        HomePage home = new HomePage(getAppiumDriver());



        ut.swipeToAGivenTextAndClick("100 words left");
       // String actualTitle = String.valueOf(wl.textCount);
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
        st.clickonsetting();
        softAssert.assertTrue(st.prioritybtn.isDisplayed(), "Element present on screen");
        st.clickonpriority();
        takeScreenshot("Priority page before editing");
        ut.dragAndDrop(pr.start,6,pr.end,1);
        takeScreenshot("After drag and drop");
        continueButton();
        st.clickOnQuestions();
        Thread.sleep(1000);
        takeScreenshot("Questions field");
        st.close();
        softAssert.assertAll();
    }

    @Test(priority = 22,description = "priority with different scenario")
    public void testPriority() throws InterruptedException {
        Settings st=new Settings(getAppiumDriver());
        HomePage home=new HomePage(getAppiumDriver());
        Priority pr=new Priority(getAppiumDriver());

        st.clickonpriority();
        softAssert.assertTrue(st.prioritybtn.isDisplayed(),"Element not Found");
        logger.info("element found", st.prioritybtn.isDisplayed());
        pr.changePriorityToUp("Height",1);
        Thread.sleep(1000);
        takeScreenshot("after change priority through btn");
        continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 23,description = "recommendation")
    public void recommend(){
        HomePage home=new HomePage(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());

        home.clickrecommendaation();
        takeScreenshot("recomendation field");
        ut.swipeToHorizontal("Missed");

    }

    @Test(description = "birthdate")
    public void birthContainer() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());
        WelcomePage wp=new WelcomePage(getAppiumDriver());
        OTPService ot = new OTPService(getAppiumDriver());
        YourProgress pg=new YourProgress(getAppiumDriver());
        BackgroundBday bday=new BackgroundBday(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());

        sp.clickButton();
        log.entermono("7046110694");
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);

        // Get OTP from server
        String countryCode = "+91";
        String mobileNumber = "7046110694";
        String otp = OTPService.getOTPFromServer(countryCode, mobileNumber);
        logger.info("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);


    }



    @AfterTest
    public void close() {

    tearDown();
    }
}

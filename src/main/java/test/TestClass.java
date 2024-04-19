package test;

import base.CustomSoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.*;
import base.AppiumBase;
import org.testng.asserts.SoftAssert;
import page.*;
import util.OTPService;
import util.Utils;
import java.net.MalformedURLException;
import java.util.Base64;


@Listeners(base.TestListener.class)


public class TestClass extends AppiumBase {
    protected static final Logger logger = LogManager.getLogger(TestClass.class);

    SoftAssert softAssert = new SoftAssert();
 //  CustomSoftAssert softAssert = new CustomSoftAssert();


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
        Utils ut=new Utils(getAppiumDriver());
        softAssert.assertEquals("Who is it for?",sp.startPageScreenTitle.getText());
        logger.info("StartPage Screen Title is :" +sp.startPageScreenTitle.getText());


        Thread.sleep(2000);
        sp.clickButton();
        softAssert.assertEquals("If required, I shall use this number\n" +
                "to get in touch.",sp.startPageMiniTitle.getText());
        logger.info("Text below title is : "+sp.startPageMiniTitle.getText());
        softAssert.assertEquals("I will send you a text with a verification code.",sp.verificationText.getText());
        logger.info("VerificationCode Text below Enter Mobile Field is "+sp.verificationText.getText());
        log.entermono("3698111125");
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);
        softAssert.assertEquals("By login in you agree to the 'Terms' and 'Privacy policy'",sp.privacyPolicyText.getText());
        logger.info("PrivacyPolicy Text is "+sp.privacyPolicyText.getText());


        // Get OTP from server
        String countryCode = "+91";
        String mobileNumber = "3698111125";
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
       Utils ut=new Utils(getAppiumDriver());
       name.enterfirstname("Julie");
       name.enterlastname("Aahuja");
       ut.waitForElementToBeVisible(name.lastNameText);
       takeScreenshot("Name");
       softAssert.assertEquals("Visible to your matches only",name.privacyText.getText());
       continueButton();

    }

    @Test(priority = 3,description = "IntroductionGender")
    public void gender(){
        IntroGender gender=new IntroGender(getAppiumDriver());
        softAssert.assertEquals("What's your gender?",gender.secondPageQueTitle.getText());
        logger.info("SecondPage Question Title is : "+gender.secondPageQueTitle.getText());
        logger.info("PrivacyText of 2nd Page is : "+gender.privacyText.getText());
        softAssert.assertTrue(gender.backArrow.isDisplayed(),"BackArrow not displayed");
        logger.info("2nd Page Header Title is : "+gender.headerTitle.getText());
        gender.selectgender(gender.Female);
        takeScreenshot("Gender");
       // continueButton();
    }

    @Test(priority = 4,description = "Location")
    public void locationAccess() throws InterruptedException {
          CurrentLocation cl=new CurrentLocation(getAppiumDriver());
          Utils ut=new Utils(getAppiumDriver());
          softAssert.assertTrue(cl.conti.isDisplayed(),"Element not found");
          cl.conti.click();
          takeScreenshot("permission");
          softAssert.assertTrue(cl.approxRadioImage.isDisplayed(),"RadioButtonImage not displayed");
          Thread.sleep(2000);
          cl.gps.click();
          getAppiumDriver().navigate().back();
         // getAppiumDriver().navigate().back();
          continueButton();
          ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.xpath("//*[@text='Navi Mumbai']")));
          takeScreenshot("Location Detected");

          continueButton();

    }
    @Test(priority = 5,description = "Locations to settle")
    public void locationsToSettle(){
        IntroLocations il=new IntroLocations(getAppiumDriver());
        softAssert.assertEquals("Where do you plan to settle?",il.fourthPageQueTitle.getText());
        logger.info("Fourth page Question Title is : "+il.fourthPageQueTitle.getText());
        logger.info("DropDown PlaceHolder Text is: "+il.dropDownPlaceHolderText.getText());
        il.dropDownPlaceHolderText.click();
        logger.info("Below AddLocation Text is : "+il.belowAddLocationsText.getText());
        takeScreenshot("MultiLocations");
        logger.info("Choose Locations");
        il.selectlocat();
        takeScreenshot("Loactions selected");
        logger.info("Location Selected");
        il.conbutton.click();

    }
    @Test(priority = 6,description = "RelationShip")
    public void relationShip() throws InterruptedException {
        IntroRelationship ir=new IntroRelationship(getAppiumDriver());
        logger.info("Question Title is : "+ir.fifthPageQueTitle.getText());
        logger.info("Privacy Text is : "+ir.fifthPagePrivacyText.getText());
        ir.relationst();
        takeScreenshot("Relationship");
        Thread.sleep(1000);
        ir.buttonadd.click();
    }
    @Test(priority = 7,description = "BackGround Religion")
    public void selectReligion(){
        BackgroundReligion religion=new BackgroundReligion(getAppiumDriver());
        logger.info("HeaderTitle is : "+religion.FirstPageHeaderTitle.getText());
        logger.info("ReligionScreen Question Title is : "+religion.FirstPageQueTitle.getText());
        religion.dropDownPlaceHolderText.click();
        logger.info("Select Religion that you Belief");
        softAssert.assertTrue(religion.downArrowButton.isDisplayed(),"DownArrow Button Not Displayed");
        religion.tickreligion.click();
        takeScreenshot("religion");
        logger.info("Religion selected");
    }
    @Test(priority = 8,description = "BackGround Cultures")
    public void backCultures(){
        BackgroundCulture bc=new BackgroundCulture(getAppiumDriver());
        logger.info("2nd Page Header Title is : "+bc.FirstPageHeaderTitle.getText());
        logger.info("Screen number is : "+bc.SecondPageNo.getText());
        logger.info("Privacy Text is : "+bc.secondPagePrivacyText.getText());
        softAssert.assertEquals("Which cultures do you identify with?",bc.SecondPageQueTitle.getText());
        logger.info("Question Title is : "+bc.SecondPageQueTitle.getText());
        logger.info("DropDown PlaceHolder Text is : "+bc.dropDownPlaceHolderText.getText());
        bc.dropDownPlaceHolderText.click();
        bc.tickculture();
        takeScreenshot("cultures");
        logger.info("Culture Selected");
        bc.cltrcontinu();
    }
    @Test(priority = 9,description = "BackGround Birthday")
    public void birthDay(){
        BackgroundBday bday=new BackgroundBday(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.waitForElementToBeVisible(bday.bdayQueTitle);
        logger.info("Birth Page Question Title is : "+bday.bdayQueTitle.getText());
        logger.info("Header Title is : "+bday.ThirdPageHeaderTitle.getText());
        logger.info("Privacy Text is : "+bday.thirdPagePrivacyText.getText());
        takeScreenshot("Scroll Bday");
        ut.scrolldown(502,1029,502,1242,3);
        takeScreenshot("Birthday selected");
        continueButton();
    }
    @Test(priority = 10,description = "BackGround Height")
    public void height(){
        Utils ut=new Utils(getAppiumDriver());
        BackgroundHeight ht=new BackgroundHeight(getAppiumDriver());
        ut.waitForElementToBeVisible(ht.HeightScreenQueTitle);
        logger.info("Height Screen Question Title is : "+ht.HeightScreenQueTitle.getText());
        logger.info("Privacy text is : "+ht.heightPrivacyText.getText());
        softAssert.assertTrue(ht.HeightContainerText.isDisplayed(),"Text not displayed");
        takeScreenshot("Scroll Height");
        ut.scrolldown(511,1242,511,1020,2);
        takeScreenshot("Height selected");
        logger.info("Hieght scrolled and selected");
        continueButton();
    }
    @Test(priority = 11,description = "BackGround Hendicap")
    public void hendicap(){
        BackGroundAbled abled=new BackGroundAbled(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.waitForElementToBeVisible(abled.HandicapScreenQueTitle);
        logger.info("Question Title is :"+abled.HandicapScreenQueTitle.getText());
        logger.info("Privacy text is : "+abled.HandicapPrivacyText.getText());
        takeScreenshot("Handicap");
        abled.ability(abled.No);
        //continueButton();
    }
    @Test(priority = 12,description = "BackGround Eating Habits")
    public void eatingHabit(){
        BackgroundEatingHabit habit=new BackgroundEatingHabit(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.waitForElementToBeVisible(habit.EatScreenQueTitle);
        logger.info("Question Title is : "+habit.EatScreenQueTitle.getText());
        logger.info("Pravacy Text is: "+habit.EatingPrivacyText.getText());
        takeScreenshot("EatingHabits");
        habit.eathabit();

    }
    @Test(priority = 13,description = "Finance")
    public void money() throws InterruptedException {
        Finance fc=new Finance(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.waitForElementToBeVisible(fc.FinanceHomeScreenTitle);
        logger.info("Finance HomeScreen Title : "+fc.FinanceHomeScreenTitle.getText());
        logger.info("Timing Msg is :"+fc.TimeInfoText.getText());
        takeScreenshot("Finance");
        fc.financehome();
        ut.waitForElementToBeVisible(fc.DropDownPlaceHolderText);
        logger.info("1st screen Question title is : "+fc.FinanceFirstScreenQueTitle.getText());
        takeScreenshot("Whats your work?");
        logger.info("Header txt is : "+fc.FinanceScreenHeaderTitle.getText());
        fc.DropDownPlaceHolderText.click();
        ut.waitForElementToBeVisible(fc.verifyText);
        takeScreenshot("Work Selection Screen");
        fc.selectwork.click();
       // fc.makemoney();
        ut.waitForElementToBeVisible(fc.finance2ndscreenQueTitle);
        logger.info("2nd screen title is : "+fc.finance2ndscreenQueTitle.getText());
        takeScreenshot("Yearly Income");
        logger.info("Default Income before Editing is :"+fc.SecondScreenDefaultIncomeTitle.getText());
        fc.dotBtnPlusMinus("3");
        takeScreenshot("Yearly Income after Edit");
        continueButton();
        logger.info("DialogBox HeaderText Is: "+fc.DialogBoxHeaderText.getText());
        logger.info("DialogBox Text Is : "+fc.DialogBoxTexts.getText());
        fc.okbutton();
        ut.waitForElementToBeVisible(fc.ThirdScreenDefaultIncomeTitle);
        logger.info("3rd Screen Question Title is: "+fc.finance3rdscreenQueTitle.getText());
        logger.info("Before editing NetWorth is: "+fc.ThirdScreenDefaultIncomeTitle.getText());
        takeScreenshot("Default NetWorth");
        fc.dotBtnPlusMinus("2");
        takeScreenshot("Edited NetWorth");
        Thread.sleep(2000);
        continueButton();
    }
    @Test(priority = 14,description = "Profession Home")
    public void profession(){
        ProfessionHome ph=new ProfessionHome(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.waitForElementToBeVisible(ph.professionHomeScreenTitle);
        takeScreenshot("Profession");
        ph.continueprofessionbtn();
        ut.waitForElementToBeVisible(ph.profession1stScreenQueTitle);
        logger.info("Profession Home Screen Title is: "+ph.professionHomeScreenTitle.getText());
        logger.info("Header is: "+ph.ProfessionHeaderTitle.getText());
        logger.info("1st Question is : "+ph.profession1stScreenQueTitle.getText());
        logger.info("Page No is: "+ph.FirstPageNo.getText());
        takeScreenshot("Add Job Title");
        ph.addjobtitle.click();
       // ph.editjob();
        ut.swipeToAGivenTextAndClick("Software Developer");
        takeScreenshot("search profession");
       // ph.selectjob.click();
    }
    @Test(priority = 15,description = "Profession Industry")
    public void industry() throws InterruptedException {
        Utils ut=new Utils(getAppiumDriver());
        ProfessionIndustry pi=new ProfessionIndustry(getAppiumDriver());
        ut.waitForElementToBeVisible(pi.profession2ndScreenQueTitle);
        logger.info("2nd Screen Question Title is : "+pi.profession2ndScreenQueTitle.getText());
        logger.info("DropDown Text is : "+pi.DropDown2ndScreenPlaceHolderText.getText());
        takeScreenshot("2nd Screen");
        Thread.sleep(1000);
        pi.DropDown2ndScreenPlaceHolderText.click();
        takeScreenshot("Select Your Industry");
        pi.addindustry.click();


    }
    @Test(priority = 16,description = "EducationBackground")
    public void education() throws InterruptedException {
        Education education=new Education(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        softAssert.assertEquals("Let's explore your educational background.",education.educationHomeScreenTitle.getText());
        takeScreenshot("Education Section Breaker");
        logger.info("EducationHomeScreen Title is "+education.educationHomeScreenTitle.getText());
        education.continueeducationbtn();
        softAssert.assertEquals("Visible to your recommendations only",education.privacyText.getText());
        logger.info("Privacy text is : "+education.privacyText.getText());
        takeScreenshot("Education 1st screen");
        softAssert.assertEquals("What are your education details?",education.education1stScreenQueTitle.getText());
        logger.info("Education 1st Screen title is : "+education.education1stScreenQueTitle.getText());
        Thread.sleep(1000);
        education.dropDownPlaceHolderText.click();
        ut.swipeToAGivenTextAndClick("B.Tech");
        logger.info("Degree Screen Question is : "+education.DegreeScreenQueText.getText());
        education.degreetype.click();
        logger.info("Collage Screen Header is : "+education.CollageScreenHeaderText.getText());
        education.SearchCollege.sendKeys("University of Oxford");
        education.collegeselect.click();
        takeScreenshot("After add ");
        if (education.deletButton.isDisplayed())
        {
            logger.info("DeletButton Displayed");
            return;
        }
        Thread.sleep(2000);
        continueButton();
    }
    @Test(priority = 17,description = "AddPhotos")
    public void photo() throws InterruptedException {
        Photos ph=new Photos(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        EditProfile edit=new EditProfile(getAppiumDriver());
        softAssert.assertEquals("And finally, share any photos you'd like.",ph.PhotoHomeScreenTitle.getText());
        takeScreenshot("Photos");
        logger.info("PhotoSection Breaker Screen title is :"+ph.PhotoHomeScreenTitle.isDisplayed());
        ph.continuephoto();
        softAssert.assertEquals("Your photos will undergo verification by me. Only if they meet our guidelines will your profile be approved. Uploading fake or irrelevant photos will be a wasted effort.",ph.DialogBoxMsg.getText());
        logger.info("Just FYI DialogBox msg is : "+ph.DialogBoxMsg.getText());
        ph.okbutn.click();
        ph.tapphoto();
        takeScreenshot("PhotoSelection");
        continueButton();
        ut.waitForElementWithFluentWait(edit.textGender);
    }
    @Test(priority = 18,description = "EditProfile")
    public void editProfile() throws InterruptedException {
        EditProfile edit=new EditProfile(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        ut.waitForElementToBeVisible(edit.WorkHeaderText);
        takeScreenshot("Image");
        Thread.sleep(2000);
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
        Utils.dragAndDrop(pr.start,6,pr.end,1);
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
        Utils.dragAndDrop(pr.start,6,pr.end,1);
        takeScreenshot("After drag and drop");
        continueButton();
        st.clickOnQuestions();
        Thread.sleep(1000);
        takeScreenshot("Questions field");
        st.close();

    }

    @Test(priority = 22,description = "priority with different scenario")
    public void testPriority() throws InterruptedException {
        Settings st=new Settings(getAppiumDriver());
        HomePage home=new HomePage(getAppiumDriver());
        Priority pr=new Priority(getAppiumDriver());

        st.clickonpriority();
        softAssert.assertTrue(st.prioritybtn.isDisplayed(),"Element not Found");
        logger.info("element found", st.prioritybtn.isDisplayed());
        pr.changePriorityToUp("Profession",1);
        Thread.sleep(1000);
        takeScreenshot("after change priority through btn");
        continueButton();

    }

    @Test(priority = 23,description = "recommendation")
    public void recommend(){
        HomePage home=new HomePage(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());

        home.clickrecommendaation();
        takeScreenshot("recomendation field");
        ut.swipeToHorizontal("Missed");

    }




    @AfterTest
    public void close() {
    softAssert.assertAll();
    tearDown();
    }
}

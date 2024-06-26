package test;

import base.ExtentReport;
import base.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import base.AppiumBase;
import org.testng.asserts.SoftAssert;
import page.*;
import util.OTPService;
import util.Utils;
import java.net.MalformedURLException;
import java.util.Random;


@Listeners(base.TestListener.class)


public class TestClass extends AppiumBase {
    protected static final Logger logger = LogManager.getLogger(TestClass.class);




    @BeforeTest
    public void launchApp() throws MalformedURLException {
        setup();
       // setupEmulator();
    }
   
    @Test(priority = 1,description = "StartPage")
    public void StartPage() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());
        WelcomePage wp=new WelcomePage(getAppiumDriver());
        OTPService ot = new OTPService(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Who is it for?",sp.startPageScreenTitle.getText());
        TestListener.logToExtentReport("StartPage Screen Title is :" +sp.startPageScreenTitle.getText());

        ut.waitForElementWithFluentWait(sp.firstButton);
        Thread.sleep(2000);
        sp.clickButton();
        softAssert.assertEquals("If required, I shall use this number\n" +
                "to get in touch.",sp.startPageMiniTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Text below title is : "+sp.startPageMiniTitle.getText());
        softAssert.assertEquals("I will send you a text with a verification code.",sp.verificationText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("VerificationCode Text below Enter Mobile Field is "+sp.verificationText.getText());

        /*Random Number Generator*/

        Random random = new Random();
        int randomSuffix = 10000000 + random.nextInt(90000000); // Generate a random 8-digit suffix
        String mobileNumber = "61" + String.valueOf(randomSuffix);
        log.entermono(mobileNumber);
        TestListener.logToExtentReport("RandomMobile Number is : +91-" +mobileNumber);
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);
        try {
            softAssert.assertEquals("By login in you agree to my 'Terms' and 'Privacy Policy'", sp.privacyPolicyText.getText());
            TestListener.handleSoftAssertions(softAssert);
            TestListener.logToExtentReport("Assertion Passed");
        }catch (AssertionError e)
        {
            ExtentReport.getTest().fail("Assertion failed: " +e.getMessage());
        }

        TestListener.logToExtentReport("PrivacyPolicy Text is "+sp.privacyPolicyText.getText());


        // Get OTP from server
        String countryCode = "+91";
        String phonNumber = mobileNumber;
        String otp = OTPService.getOTPFromServer(countryCode, phonNumber);
        TestListener.logToExtentReport("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);

        wp.permission1();
        softAssert.assertAll();


    }

    @Test(priority = 2,description = "IntroductionName")
    public void introduction(){
       IntroName name=new IntroName(getAppiumDriver());
       Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


       softAssert.assertEquals("Let's start with an introduction.",name.IntroHomeTitleText.getText());
       TestListener.handleSoftAssertions((softAssert));
       TestListener.logToExtentReport("IntroHomePage Title : "+name.IntroHomeTitleText.getText());
       name.continue1.click();
       softAssert.assertEquals("What's your name?",name.firstPageQueTitle.getText());
       TestListener.handleSoftAssertions(softAssert);
       TestListener.logToExtentReport("Introduction 1st page question : "+name.firstPageQueTitle.getText());
       name.enterfirstname("Priyanka");
       name.enterlastname("Sharma");
       ut.waitForElementToBeVisible(name.lastNameText);
       takeScreenshot("Name");
       softAssert.assertEquals("Visible to your matches only",name.privacyText.getText());
        TestListener.handleSoftAssertions(softAssert);
       continueButton();
        softAssert.assertAll();

    }

    @Test(priority = 3,description = "IntroductionGender")
    public void gender(){
        IntroGender gender=new IntroGender(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("What's your gender?",gender.secondPageQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("SecondPage Question Title is : "+gender.secondPageQueTitle.getText());
        TestListener.logToExtentReport("PrivacyText of 2nd Page is : "+gender.privacyText.getText());
        softAssert.assertTrue(gender.backArrow.isDisplayed(),"BackArrow not displayed");
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("2nd Page Header Title is : "+gender.headerTitle.getText());
        gender.selectgender(gender.Female);
        takeScreenshot("Gender");
       // continueButton();
        softAssert.assertAll();
    }

    @Test(priority = 4,description = "Location")
    public void locationAccess() throws InterruptedException {
          CurrentLocation cl=new CurrentLocation(getAppiumDriver());
          Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


          softAssert.assertTrue(cl.conti.isDisplayed(),"Element not found");
          cl.conti.click();
          takeScreenshot("permission");
          softAssert.assertTrue(cl.approxRadioImage.isDisplayed(),"RadioButtonImage not displayed");
          Thread.sleep(2000);
          cl.gps.click();
          getAppiumDriver().navigate().back();
         // getAppiumDriver().navigate().back();
          continueButton();
          ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.xpath("//*[@text='Mumbai']")));
          takeScreenshot("Location Detected");

          continueButton();
        softAssert.assertAll();

    }
    @Test(priority = 5,description = "Locations to settle")
    public void locationsToSettle(){
        IntroLocations il=new IntroLocations(getAppiumDriver());
        MultiLocations ml=new MultiLocations(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals("Where do you plan to settle?",il.fourthPageQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Fourth page Question Title is : "+il.fourthPageQueTitle.getText());
        TestListener.logToExtentReport("DropDown PlaceHolder Text is: "+il.dropDownPlaceHolderText.getText());
        il.dropDownPlaceHolderText.click();
       // ml.dropDownPlaceHolderText.click();
        TestListener.logToExtentReport("Below AddLocation Text is : "+il.belowAddLocationsText.getText());
        takeScreenshot("MultiLocations");

        il.selectlocat();
       // ml.selectLocations(0,1,3,5,7,9);
        takeScreenshot("Loactions selected");
        TestListener.logToExtentReport("Location Selected");
        //il.conbutton.click();
        ml.conbutton.click();
        softAssert.assertAll();

    }
    @Test(priority = 6,description = "RelationShip")
    public void relationShip() throws InterruptedException {
        IntroRelationship ir=new IntroRelationship(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        TestListener.logToExtentReport("Question Title is : "+ir.fifthPageQueTitle.getText());
        TestListener.logToExtentReport("Privacy Text is : "+ir.fifthPagePrivacyText.getText());
        ir.relationst();
        takeScreenshot("Relationship");
        Thread.sleep(1000);
        softAssert.assertAll();

    }
    @Test(priority = 7,description = "BackGround Religion")
    public void selectReligion(){
        BackgroundReligion religion=new BackgroundReligion(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals("Now, let's dive into your background.",religion.BackgroundHomePageTitleText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("BackgroundSectionBreaker Title : "+religion.BackgroundHomePageTitleText.getText());
        religion.buttonadd.click();
        TestListener.logToExtentReport("HeaderTitle is : "+religion.FirstPageHeaderTitle.getText());
        TestListener.logToExtentReport("ReligionScreen Question Title is : "+religion.FirstPageQueTitle.getText());
        softAssert.assertEquals("Select religion",religion.dropDownPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        religion.dropDownPlaceHolderText.click();
        TestListener.logToExtentReport("Select Religion that you Belief");
        softAssert.assertTrue(religion.downArrowButton.isDisplayed(),"DownArrow Button Not Displayed");
        religion.tickreligion.click();
        takeScreenshot("religion");
        TestListener.logToExtentReport("Religion selected");
        softAssert.assertAll();
    }
    @Test(priority = 8,description = "BackGround Cultures")
    public void backCultures(){
        BackgroundCulture bc=new BackgroundCulture(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        TestListener.logToExtentReport("2nd Page Header Title is : "+bc.SecondPageHeaderTitle.getText());
        TestListener.logToExtentReport("Screen number is : "+bc.SecondPageNo.getText());
        TestListener.logToExtentReport("Privacy Text is : "+bc.secondPagePrivacyText.getText());
        softAssert.assertEquals("Which cultures do you identify with?",bc.SecondPageQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Question Title is : "+bc.SecondPageQueTitle.getText());
        softAssert.assertEquals("Add cultures",bc.dropDownPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("DropDown PlaceHolder Text is : "+bc.dropDownPlaceHolderText.getText());
        bc.dropDownPlaceHolderText.click();
        bc.tickculture();
        takeScreenshot("cultures");
        TestListener.logToExtentReport("Culture Selected");
        bc.cltrcontinu();
        softAssert.assertAll();
    }
    @Test(priority = 9,description = "BackGround Birthday")
    public void birthDay(){
        BackgroundBday bday=new BackgroundBday(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(bday.bdayQueTitle);
        TestListener.logToExtentReport("Birth Page Question Title is : "+bday.bdayQueTitle.getText());
        softAssert.assertEquals("When's your birthday?",bday.bdayQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Header Title is : "+bday.ThirdPageHeaderTitle.getText());
        TestListener.logToExtentReport("Privacy Text is : "+bday.thirdPagePrivacyText.getText());
        takeScreenshot("Scroll Bday");
      //  ut.scrolldown(502,1029,502,1242,3);
       bday.scrollDownToMonth("Mar");
        takeScreenshot("Birthday selected");
        ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.id("com.commonfriend:id/btnContinue")).isEnabled());
        continueButton();
        softAssert.assertAll();
    }
    @Test(priority = 10,description = "BackGround Height")
    public void height(){
        Utils ut=new Utils(getAppiumDriver());
        BackgroundHeight ht=new BackgroundHeight(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(ht.HeightScreenQueTitle);
        TestListener.logToExtentReport("Height Screen Question Title is : "+ht.HeightScreenQueTitle.getText());
        TestListener.logToExtentReport("Privacy text is : "+ht.heightPrivacyText.getText());
        softAssert.assertTrue(ht.HeightContainerText.isDisplayed(),"Text not displayed");
        takeScreenshot("Scroll Height");
      //  ut.scrolldown(511,1242,511,1020,2);
      //  ut.scrollToElementInContainer(ht.DefaultInchXpath,ht.EightInchXpath);
        ht.scrollDownToInches("8\"");
        takeScreenshot("Height selected");
        TestListener.logToExtentReport("Hieght scrolled and selected");
        ut.waitForElementToBeVisible(getAppiumDriver().findElement(By.id("com.commonfriend:id/btnContinue")).isEnabled());
        continueButton();
        softAssert.assertAll();
    }
    @Test(priority = 11,description = "BackGround Hendicap")
    public void hendicap(){
        BackGroundAbled abled=new BackGroundAbled(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(abled.HandicapScreenQueTitle);
        TestListener.logToExtentReport("Question Title is :"+abled.HandicapScreenQueTitle.getText());
        TestListener.logToExtentReport("Privacy text is : "+abled.HandicapPrivacyText.getText());
        takeScreenshot("Handicap");
        abled.ability(abled.No);
        //continueButton();
        softAssert.assertAll();
    }
    @Test(priority = 12,description = "BackGround Eating Habits")
    public void eatingHabit(){
        BackgroundEatingHabit habit=new BackgroundEatingHabit(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(habit.EatScreenQueTitle);
        TestListener.logToExtentReport("Question Title is : "+habit.EatScreenQueTitle.getText());
        TestListener.logToExtentReport("Pravacy Text is: "+habit.EatingPrivacyText.getText());
        takeScreenshot("EatingHabits");
        habit.getEatHabitTexts();
        habit.eathabit();
        softAssert.assertAll();

    }
    @Test(priority = 13,description = "Finance")
    public void money() throws InterruptedException {
        Finance fc=new Finance(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(fc.FinanceHomeScreenTitle);
        softAssert.assertEquals("Money matters! Lets discuss it.",fc.FinanceHomeScreenTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Finance HomeScreen Title : "+fc.FinanceHomeScreenTitle.getText());
        TestListener.logToExtentReport("Timing Msg is :"+fc.TimeInfoText.getText());
        takeScreenshot("Finance");
        fc.financehome();
        ut.waitForElementToBeVisible(fc.DropDownPlaceHolderText);
        TestListener.logToExtentReport("1st screen Question title is : "+fc.FinanceFirstScreenQueTitle.getText());
        softAssert.assertEquals("What's your line of work?",fc.FinanceFirstScreenQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Whats your work?");
        TestListener.logToExtentReport("Header txt is : "+fc.FinanceScreenHeaderTitle.getText());
        softAssert.assertEquals("Select line of work",fc.DropDownPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        fc.DropDownPlaceHolderText.click();
        ut.waitForElementToBeVisible(fc.verifyText);
        takeScreenshot("Work Selection Screen");
        fc.selectwork.click();
       // fc.makemoney();
        ut.waitForElementToBeVisible(fc.finance2ndscreenQueTitle);
        softAssert.assertEquals("How much money do you make in a year?",fc.finance2ndscreenQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("2nd screen title is : "+fc.finance2ndscreenQueTitle.getText());
        takeScreenshot("Yearly Income");
        TestListener.logToExtentReport("Default Income before Editing is :"+fc.SecondScreenDefaultIncomeTitle.getText());
        fc.dotBtnPlusMinus("2");
        takeScreenshot("Yearly Income after Edit");
        continueButton();
        TestListener.logToExtentReport("DialogBox HeaderText Is: "+fc.DialogBoxHeaderText.getText());
        TestListener.logToExtentReport("DialogBox Text Is : "+fc.DialogBoxTexts.getText());
        fc.proceedBtn.click();
        ut.waitForElementToBeVisible(fc.ThirdScreenDefaultIncomeTitle);
        TestListener.logToExtentReport("3rd Screen Question Title is: "+fc.finance3rdscreenQueTitle.getText());
        TestListener.logToExtentReport("Before editing NetWorth is: "+fc.ThirdScreenDefaultIncomeTitle.getText());
        takeScreenshot("Default NetWorth");
        Thread.sleep(2000);
        fc.dotBtnPlusMinus("1");
        takeScreenshot("Edited NetWorth");
        Thread.sleep(2000);
        continueButton();
        softAssert.assertAll();
    }
    @Test(priority = 14,description = "Profession Home")
    public void profession(){
        ProfessionHome ph=new ProfessionHome(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(ph.professionHomeScreenTitle);
        takeScreenshot("Profession");
        softAssert.assertEquals("Tell me about your profession.",ph.professionHomeScreenTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Profession Home Screen Title is: "+ph.professionHomeScreenTitle.getText());
        ph.continueprofessionbtn();
        ut.waitForElementToBeVisible(ph.profession1stScreenQueTitle);
        softAssert.assertEquals("What's your job title?",ph.profession1stScreenQueTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Header is: "+ph.ProfessionHeaderTitle.getText());
        TestListener.logToExtentReport("1st Question is : "+ph.profession1stScreenQueTitle.getText());
        TestListener.logToExtentReport("Page No is: "+ph.FirstPageNo.getText());
        softAssert.assertEquals("Add job title",ph.addjobtitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Add Job Title");
        ph.addjobtitle.click();
       // ph.editjob();
        ut.swipeToAGivenTextAndClick("Software Developer");
       // ut.scrollToElementByText("Software Developer");
        takeScreenshot("search profession");
       // ph.selectjob.click();
        softAssert.assertAll();
    }
    @Test(priority = 15,description = "Profession Industry")
    public void industry() throws InterruptedException {
        Utils ut=new Utils(getAppiumDriver());
        ProfessionIndustry pi=new ProfessionIndustry(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(pi.profession2ndScreenQueTitle);
        TestListener.logToExtentReport("2nd Screen Question Title is : "+pi.profession2ndScreenQueTitle.getText());
        softAssert.assertEquals("Add industry",pi.DropDown2ndScreenPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("DropDown Text is : "+pi.DropDown2ndScreenPlaceHolderText.getText());
        takeScreenshot("2nd Screen");
        Thread.sleep(1000);
        pi.DropDown2ndScreenPlaceHolderText.click();
        Thread.sleep(2000);
        takeScreenshot("Select Your Industry");
        pi.addindustry.click();
        softAssert.assertAll();

    }
    @Test(priority = 16,description = "EducationBackground")
    public void education() throws InterruptedException {
        Education education=new Education(getAppiumDriver());
        Settings st=new Settings(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals("Let's explore your educational background.",education.educationHomeScreenTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Education Section Breaker");
        TestListener.logToExtentReport("EducationHomeScreen Title is "+education.educationHomeScreenTitle.getText());
        education.continueeducationbtn();
        softAssert.assertEquals("Visible to your recommendations only",education.privacyText.getText());
        TestListener.logToExtentReport("Privacy text is : "+education.privacyText.getText());
        takeScreenshot("Education 1st screen");
        softAssert.assertEquals("What are your education details?",education.education1stScreenQueTitle.getText());
        TestListener.logToExtentReport("Education 1st Screen title is : "+education.education1stScreenQueTitle.getText());
        softAssert.assertEquals("Add qualification",education.dropDownPlaceHolderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        Thread.sleep(1000);
        education.dropDownPlaceHolderText.click();
        ut.swipeToAGivenTextAndClick("B.Tech");
        TestListener.logToExtentReport("Degree Screen Question is : "+education.DegreeScreenQueText.getText());
        softAssert.assertEquals("What was the type of degree?",education.DegreeScreenQueText.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Degree");
        education.degreetype.click();
        softAssert.assertEquals("Add college name",education.CollageScreenHeaderText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Collage Screen Header is : "+education.CollageScreenHeaderText.getText());
        education.SearchCollege.sendKeys("University of Oxford");
        education.collegeselect.click();
        ut.waitForElementToBeVisible(education.PlusButtonImage);
        takeScreenshot("After add ");
        logger.info(education.deletButton.isDisplayed());
        if (education.BtnContinue.isEnabled())
        {
            continueButton();
        }
        else {
            ut.waitForElementToBeVisible(education.BtnContinue.isEnabled());
        }
        softAssert.assertAll();
    }
    @Test(priority = 17,description = "AddPhotos")
    public void photo() throws InterruptedException {
        Photos ph=new Photos(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        EditProfile edit=new EditProfile(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals("And finally, share a photo that you'd like.",ph.PhotoHomeScreenTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Photos Home screen Title is :" +ph.PhotoHomeScreenTitle.getText());
        softAssert.assertEquals("Should take about 30 seconds.",ph.TimeInfoText.getText());
        TestListener.handleSoftAssertions(softAssert);
        takeScreenshot("Photos");
        ph.continuephoto();
        softAssert.assertEquals("Your photos will undergo verification by me. Only if they meet our guidelines will your profile be approved. Uploading fake or irrelevant photos will be a wasted effort.",ph.DialogBoxMsg.getText());
        TestListener.logToExtentReport("Just FYI DialogBox msg is : "+ph.DialogBoxMsg.getText());
        ph.okbutn.click();
        ph.tapphoto();
        ph.selectPhotoFolder.click();
        ut.swipeToAGivenTextAndClick("Thu, 7 Dec, 2023");
        ph.selectPhoto.click();
        takeScreenshot("PhotoSelection");
        continueButton();
        ut.waitForElementWithFluentWait(edit.textGender);
        softAssert.assertAll();
    }
    @Test(priority = 18,description = "EditProfile")
    public void editProfile() throws InterruptedException {
        EditProfile edit=new EditProfile(getAppiumDriver());
        Utils ut=new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        ut.waitForElementToBeVisible(edit.WorkHeaderText);
        takeScreenshot("Image");
        Thread.sleep(2000);
        ut.swipeToAGivenTextAndClick("Save");
        softAssert.assertAll();
    }
    @Test(priority = 19,description = "CheckList")
    public void checkList(){
        CheckList list=new CheckList(getAppiumDriver());



        Utils ut=new Utils(getAppiumDriver());
        ut.swipeToAGivenTextAndClick("Eating habits");
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
        SoftAssert softAssert = new SoftAssert();


        ut.swipeToAGivenTextAndClick("100 words left");
       // String actualTitle = String.valueOf(wl.textCount);
        String actualTitle= wl.textCount.getText();
        TestListener.logToExtentReport(actualTitle);
        takeScreenshot("Before entering feedback");
        softAssert.assertTrue(wl.feedbackHeader.isDisplayed());
        softAssert.assertEquals("Have any feedback?",wl.feedbackHeader.getText());
        TestListener.handleSoftAssertions(softAssert);
        wl.feedback();
        ut.waitForElementToBeVisible(wl.textCount);
        String expectedTitle = wl.textCount.getText();
        TestListener.logToExtentReport(expectedTitle);
        Assert.assertNotEquals(actualTitle, expectedTitle, "Feedback sent");
        TestListener.handleSoftAssertions(softAssert);
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
        softAssert.assertAll();

    }

    @Test(priority = 22,description = "priority with different scenario")
    public void testPriority() throws InterruptedException {
        Settings st=new Settings(getAppiumDriver());
        HomePage home=new HomePage(getAppiumDriver());
        Priority pr=new Priority(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        st.clickonpriority();
        softAssert.assertTrue(st.prioritybtn.isDisplayed(),"Element not Found");
        TestListener.logToExtentReport("element found");
        pr.changePriorityToUp("Profession",1);
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

    @Test(enabled = false)
    public void scroll() throws InterruptedException {
        StartPage sp=new StartPage(getAppiumDriver());
        Loginpage lp=new Loginpage(getAppiumDriver());
        BackgroundBday bday=new BackgroundBday(getAppiumDriver());
        BackgroundHeight ht=new BackgroundHeight(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        sp.clickButton();
        lp.entermono("2525255252");
        lp.continuebutton();
        bday.scrollDownToMonth("Jan");
        Thread.sleep(5000);
        continueButton();
        TestListener.logToExtentReport("Height Screen Question Title is : "+ht.HeightScreenQueTitle.getText());
        TestListener.logToExtentReport("Privacy text is : "+ht.heightPrivacyText.getText());
        softAssert.assertTrue(ht.HeightContainerText.isDisplayed(),"Text not displayed");
        takeScreenshot("Scroll Height");
        softAssert.assertAll();

    }




    @AfterTest
    public void close() {

    tearDown();
    }
}

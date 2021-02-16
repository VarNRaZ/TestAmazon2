package com.amazon.testcases;

import com.amazon.Pages.AmazonHomePage;
import com.amazon.Pages.AmazonHomePageAfterSignin;
import com.amazon.Pages.AmazonLoginNavigation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonHomePageAfterSigninTest extends TestBase{

    AmazonHomePage homePage;

    AmazonLoginNavigation amazonLoginNavigation;

    AmazonHomePageAfterSignin amazonHomePageAfterSignin;




    @Test(priority=1)

    public void landingToHomePage() throws Exception {

        logger = report.createTest("Landing to AmazonPage");

        // logger.log(Status.INFO, "execution started on"  + " " + " " + "and URL is used for this" + " );
        //report.flush();

        homePage = PageFactory.initElements(driver, AmazonHomePage.class);
        logger.log(Status.INFO, "LogintoAmazon");

        homePage.mouseHover();
        logger.log(Status.INFO, "Mouse hover done");
        homePage.clickOnSignIn();
        logger.log(Status.INFO, "Clicked on sign in button");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        report.flush();
        Thread.sleep(10000);


    }

    @Test(priority=2)

    public void navigateToSignInpage() throws Exception
    {

        amazonLoginNavigation=PageFactory.initElements(driver, AmazonLoginNavigation.class);
        String uname=dataProvider.getUserName();
        System.out.println("username is"+uname);
        amazonLoginNavigation.enterEmail(uname);
       logger=report.createTest("NavigatetoSigninPage");
        logger.log(Status.PASS, "User NAme entered");
        amazonLoginNavigation.clickOnContinue();
        logger.log(Status.PASS, "Continue Button clicked");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(7000);
        amazonLoginNavigation.enterPassword(dataProvider.getPassword());
        logger.log(Status.PASS, "Password entered");
        amazonLoginNavigation.clickOnSignIn();
        logger.log(Status.INFO, "Sign in button clicked");
        report.flush();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       // report.flush();
        Thread.sleep(10000);
    }


    @Test(priority=3)

    public void homePageValidation() {

        logger=report.createTest("ValidateHomePageAfterLoggedin");

        amazonHomePageAfterSignin=PageFactory.initElements(driver, AmazonHomePageAfterSignin.class);
        try {
            amazonHomePageAfterSignin.clickLinkOnHomePage();
            logger.log(Status.PASS, "Link clicked on Homepage");
        }catch(Exception ex) {
            System.out.println("failed to click link on homepage"+ex.getMessage());
            logger.log(Status.FAIL, "Failed to click on Link on HOmePage");
        }


    }

    @Test(priority=4)

    public void verifyLoggedUser() {

        logger=report.createTest("ValidateLoggedinUserName");

        boolean status=amazonHomePageAfterSignin.VerifyUserName("varun");
        if(status) {
            logger.log(Status.PASS, "Username is displayed as expected");
        }else
        {
            logger.log(Status.FAIL, "User name is not displayed as expected");
        }


    }

    @Test(priority=5)

    public void verifyPageTitle() {

        logger=report.createTest("ValidatePageTitle");

        boolean pageTitleStatus=amazonHomePageAfterSignin.verifyPageTitle("Best Sellers: The most");
        if(pageTitleStatus) {

            logger.log(Status.PASS, "Page title id displayed as expected");
        }else
        {
            logger.log(Status.FAIL, "Page title id did not displayed as expected");
        }
    }



    @Test(priority=6)
    public void productSearch() {

        logger=report.createTest("validate product entered and Searched");
        boolean product=amazonHomePageAfterSignin.searchProductOnHomePage("iphone");
        boolean searching=amazonHomePageAfterSignin.clickSearchIcon();
        if(product==true&&searching==true) {
            logger.log(Status.PASS, "Product entered and search icon is clicked");
        }else {
            logger.log(Status.FAIL, "Either one of the operation(Product entered/search icon) is failed");
        }

        report.flush();
    }

}

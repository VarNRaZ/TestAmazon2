package com.amazon.Pages;

import com.amazon.testcases.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonHomePageAfterSignin {

    WebDriver driver;


    boolean product = false;
    boolean search = false;


    public AmazonHomePageAfterSignin(WebDriver ldriver) {
        driver = ldriver;

    }

    @FindBy(xpath = "//*[@class='nav-line-1-container']/span")
    WebElement nameofUser;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchIcon;
    //@FindBy(xpath="(//*[contains(text(),'Apple iPhone')])[1]") WebElement link;
    @FindBy(xpath = "//*(@class='nav-link nav-item')/span")
    WebElement account;
    @FindBy(xpath = "(//*[contains(text(),'Best Sellers')])[1]")
    WebElement bestSeller;
    @FindBy(xpath = "//*[contains(text(),'Account & Lists')]")
    WebElement mouseHover;

    public boolean VerifyUserName(String user) {

        boolean UserStatus = false;
        String LoggedinUser = nameofUser.getText();


        if (LoggedinUser.contains(user)) {
            System.out.println("UserName is displayed as expected");
            UserStatus = true;
        } else {
            System.out.println("USer name did not display as expected");
        }

        return UserStatus;



    }

    public boolean verifyPageTitle(String pageTitle) {

        boolean PagetitleStatus=false;
        String TitileOfpage=driver.getTitle();

        if(TitileOfpage.contains(pageTitle)) {
            System.out.println("Page title is displayed as expected");
            PagetitleStatus=true;
        }else
        {
            System.out.println("Page title is not displayed as expected and Expected message is"+pageTitle+" "+"and actual is"+TitileOfpage );
        }
        return PagetitleStatus;
    }

    public void clickLinkOnHomePage() {
        try {
            bestSeller.click();
            System.out.println("Clicked on one of the links on home page locator name is:"+bestSeller);
        }catch(Exception cls){
            cls.printStackTrace();
        }
    }

    public boolean searchProductOnHomePage(String productName) {
        try {
            searchBox.sendKeys(productName);
            product=true;
            System.out.println("Product name entered");
        }catch(Exception ex) {
            System.out.println("exception occured in search product:"+ex.getMessage());
        }
        return product;
    }

    public boolean clickSearchIcon() {

        try {
            searchIcon.click();

            search=true;
            System.out.println("Search icon is clicked");
            Thread.sleep(10000);
        }catch(Exception ex) {
            System.out.println("exception occured in search icon:"+ex.getMessage());

        }
        String title=driver.getTitle();
        //Assert.assertEquals(title.contains("iphone"), "iphone");
        if(title.contains("iphone")) {
            System.out.println("title is displayed as expected after clicked on product");
        }else {
            System.out.println("title is not displayed as expected");
        }

        return search;
    }




}

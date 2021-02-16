package com.amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AmazonLoginNavigation {

    WebDriver driver;


    public AmazonLoginNavigation(WebDriver ldriver) {
        driver=ldriver;

    }

    @FindBy(id="ap_email")
    WebElement email;
    @FindBy(id="continue") WebElement continueBtn;
    @FindBy(id="ap_password") WebElement password;
    @FindBy(id="signInSubmit") WebElement signIn;


    public void enterEmail(String mail){
        try {

            email.sendKeys(mail);
        }catch(Exception ex) {
            System.out.println("exception in email is:"+ex.getMessage());
        }


    }

    public void clickOnContinue() {
        try {
            continueBtn.click();
        }catch(Exception e) {
            System.out.println("exception while clicking continue:"+e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }
    public void enterPassword(String pwd){
        password.sendKeys(pwd);

    }

    public void clickOnSignIn() {
        signIn.click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    }



}

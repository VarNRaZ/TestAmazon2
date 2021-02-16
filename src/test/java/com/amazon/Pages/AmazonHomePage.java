package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

    WebDriver driver;


    WebDriverWait wait;

    public AmazonHomePage(WebDriver ldriver) {
        driver=ldriver;

    }

    @FindBy(xpath="//*[contains(text(),'Account & Lists')]")
    WebElement mouseHover;
    @FindBy(xpath="//*[@id='nav-flyout-ya-signin']/a")
    WebElement btnSignIn;

    public  void mouseHover() {
        try {
            wait=new WebDriverWait(driver,15);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Account & Lists')]")));
        }catch(Exception e) {
            System.out.println("exception message:"+e.getMessage());
        }

        Actions act=new Actions(driver);
        act.moveToElement(mouseHover).build().perform();

    }

    public void clickOnSignIn() {

        try {
            wait=new WebDriverWait(driver,25);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-flyout-ya-signin']/a")));
        }catch(Exception e) {
            System.out.println("execption message:"+e.getMessage());
        }
        btnSignIn.click();

    }


}

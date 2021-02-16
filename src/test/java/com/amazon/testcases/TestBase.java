package com.amazon.testcases;

import com.amazon.utilities.ConfigureDataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public RemoteWebDriver driver;


    public ConfigureDataProvider dataProvider;

    public ExtentHtmlReporter htmlreport;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite() {
        // reader=new ExcelReader();
        dataProvider=new ConfigureDataProvider();

        htmlreport = new ExtentHtmlReporter("./Reports/AmazonTest.html");
        report = new ExtentReports();
        report.attachReporter(htmlreport);
        logger=report.createTest("ConfigurationDetails");




    }
    @BeforeClass
    @Parameters("Browser")
    public void setUp(String br) throws MalformedURLException {

        if(br.equals("chrome")) {

            String CAUrl = dataProvider.getDataFromConfig("CAAmazonURL");

            logger.log(Status.INFO, "execution started on "+br+" "+" "+"and URL is used for this "+" "+CAUrl);


            DesiredCapabilities dc = DesiredCapabilities.chrome();

        URL url = new URL("http://localhost:4444/wd/hub");

        driver = new RemoteWebDriver(url,dc);

        driver.get(CAUrl);


        }

        else if (br.equals("firefox")){

            String USAUrl = dataProvider.getDataFromConfig("USAmazonURL");

            logger.log(Status.INFO, "execution started on"+br+" "+" "+"and URL is used for this"+" "+USAUrl);

            DesiredCapabilities dc = DesiredCapabilities.firefox();

            URL url = new URL("http://localhost:4444/wd/hub");

            driver = new RemoteWebDriver(url,dc);

            driver.get(USAUrl);

        }


    }

    @AfterClass
        public void tearDown() {
        driver.quit();
    }
}



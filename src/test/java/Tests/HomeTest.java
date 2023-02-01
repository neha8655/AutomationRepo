package Tests;

import Pages.HomePage;
import Testbase.WebTestBase;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.logging.FileHandler;

public class HomeTest extends WebTestBase {
    HomePage homePage;

    public HomeTest()

    {
        super();
    }
    @BeforeMethod
    public void beforeMethod()
    {
        initialization();
       // WebDriver driver = null;
        //String chrome ="url";
        homePage=new HomePage();

    }

    @Test
    public void verifySearchFunctionality(){
        SoftAssert softAssert = new SoftAssert();
        homePage.popUp();
        homePage.searchBox(prob.getProperty("searchText"));
        softAssert.assertEquals(homePage.getTextOfMyHomePage(),"24/7 help","my homme page text should be match");

        softAssert.assertAll();



    }
    @Test
    public void verifyCookiesFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        homePage.popUp();
        homePage.cookiesSelect();
        softAssert.assertAll();


    }
    @Test
    public void verifyWindowHandle() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.popUp();
        homePage.searchBox(prob.getProperty("searchText"));
        homePage.windowHandle();
        softAssert.assertEquals(homePage.getTextOfMyHomePage(),"24/7 help","my homme page text should be match");

        softAssert.assertAll();

    }
    @Test
    public void verifyCheckBox(){
        SoftAssert softAssert = new SoftAssert();
        homePage.popUp();
        homePage.searchBox(prob.getProperty("searchText"));
        homePage.check();
       softAssert.assertEquals(homePage.getTextOfMyHomePage(),"24/7 help","my homme page text should be match");

        softAssert.assertAll();
    }
    @AfterMethod
    public void afterMethod()  {

        //FileHandler driver = new FileHandler();
        driver.close();
}
}

package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Testbase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.sound.sampled.AudioFileFormat;
import java.util.logging.FileHandler;

public class LoginTest extends WebTestBase{
    HomePage homePage;
    LoginPage loginPage;

    public LoginTest() { super();}

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }



    @Test
    public void verifyLoginWithValidCredential()  {
        SoftAssert softAssert = new SoftAssert();
        homePage.popUp();
         loginPage.loginClick();
        // homePage.loginClick();
        //dioFileFormat prop = null;
        loginPage.login(prob.getProperty("username"),prob.getProperty("password"));
        softAssert.assertAll();

    }
    @AfterMethod
    public void aftermethod() {
       //ileHandler driver;
        driver.close();}

}

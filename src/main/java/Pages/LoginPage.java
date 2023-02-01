package Pages;

import Testbase.WebTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebTestBase{
    @FindBy(xpath = "//input[@type='email']")
    WebElement userNameTextBox;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordTextBox;

    @FindBy(xpath="//button[text()='Login']")
    WebElement loginBtn;
    @FindBy(xpath = "//span[@class='text-sm rounded-lg p-3 px-3 bg-white flex justify-between items-center text-gray-600 mx-2 cursor-pointer']")
    WebElement SignUPBtn;
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public void loginClick()
    {
        SignUPBtn.click();
    }

    public void login(String userName, String password) {
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
        loginBtn.click();
        // return new Homepage();

    }

}
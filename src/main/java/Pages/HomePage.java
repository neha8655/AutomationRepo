package Pages;

import Testbase.WebTestBase;
import Utiles.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebTestBase {
    @FindBy(id = "onesignal-slidedown-cancel-button")
    WebElement cancel;
    @FindBy(xpath = "//input[@class='p-3 w-full rounded-lg pl-10']")
    WebElement textbox;
    @FindBy(xpath = "//button[@class='bg-theme p-3 text-xl rounded-lg']")
    WebElement search;
    @FindBy(xpath = "//a[1]//div[1]//img[1]")
    WebElement roundedSelect;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[2]/div/div[1]/div/div[3]/div/label[1]/div/input")
    WebElement checkBox;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/div[3]/a")
    WebElement rounded;
    public HomePage()
    {
        PageFactory.initElements(driver,this);
}
public void popUp(){
    Utility.waitUntilElementToClick(driver,cancel);
    cancel.click();
    }
    public void searchBox(String searchText){
        textbox.sendKeys(searchText);
        search.click();
    }
public void windowHandle() throws InterruptedException {
        roundedSelect.click();
        Utility.switchToWindows(driver);
}
public void check(){
        checkBox.click();
}
public String getTextOfMyHomePage(){
        return rounded.getText();

}
public void cookiesSelect(){
        Utility.addCookie();
        Utility.setCookies();


}
}

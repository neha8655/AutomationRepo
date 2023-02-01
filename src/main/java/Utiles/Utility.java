package Utiles;

import Testbase.WebTestBase;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Utility extends WebTestBase {
    public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long IMPLICITLY_WAIT = 20;

    public static void waitUntilElementToClick(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void addCookie() {
        Cookie cookie = new Cookie("Hi", "EveryOne");
        driver.manage().addCookie(cookie);

    }

    public static void setCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println(c);
        }
    }



    public static void getWindowsHandles(WebDriver driver) {
        driver.getWindowHandles();
    }

    public static void switchToWindows(WebDriver driver) throws InterruptedException {


        String parentWindows = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String s : allWindow) {
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
                Thread.sleep(5000);
                driver.close();
            }
            driver.switchTo().window(parentWindows);

        }
    }
}


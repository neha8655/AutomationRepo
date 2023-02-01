package Testbase;


import Utiles.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

    public class WebTestBase
    {
        public static WebDriver driver;
        public Properties prob;
        public WebTestBase()
        {
            prob = new Properties();
            try
            {
                FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Property/config.properties");
                prob.load(fileInputStream);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        public void initialization()
        {
            String browserName=prob.getProperty("browser");
            if (browserName.equals("chrome"))
            {
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/Driver/chromedriver.exe");
                driver= new ChromeDriver();
            }else if (browserName.equals("firefox"))
            {
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/Driver/chromedriver.exe");
                driver= new FirefoxDriver();
            }else if (browserName.equals("edge"))
            {
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/main/resources/Driver/chromedriver.exe");
                driver= new EdgeDriver();
            }else if (browserName.equals("ie"))
            {
                System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/src/main/resources/Driver/chromedriver.exe");
                driver= new InternetExplorerDriver();
            }else
            {
                System.out.println("Please select correct browser name");
            }
            driver.navigate().to(prob.getProperty("url"));


            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIMEOUT));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICITLY_WAIT));
            driver.manage().deleteAllCookies();
}
    }



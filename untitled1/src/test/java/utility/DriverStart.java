package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static utility.Constant.DRIVER;


public class DriverStart {


    public static void driverSetup(String browser) throws MalformedURLException {

         System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");

        if(browser.equalsIgnoreCase("Chrome")) {
            // Chrome
            WebDriverManager.chromedriver().setup();
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions chOption = new ChromeOptions();
            chOption.addArguments("--no-sandbox");
            chOption.addArguments("--window-size=1920,1080");
            chOption.addArguments("--start-maximized");
            chOption.addArguments("--disable-dev-shm-usage");
            chOption.addArguments("--verbose");
            Constant.DRIVER = new ChromeDriver(chOption);
            Constant.DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        else
            {
            System.out.println("Browser Not Set");
        }

    }
}

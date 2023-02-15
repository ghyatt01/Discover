package stepdefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constant;
import utility.DriverStart;

import static utility.Constant.DRIVER;


public class UIsteps {
    WebDriver driver;

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(pageLoadCondition);
    }

    @Before
    public void setupTest() throws MalformedURLException {
        DriverStart.driverSetup(Constant.BROWSER);

    }

    @After
    public void close() throws MalformedURLException {
        DRIVER.close();
    }


    @FindBy(how = How.CSS, using = ".current-slide .silde--text")
    private WebElement ccIcon;


        @Given("I navigate to discover website")
        public void iNavigateToDiscoverWebsite() {
            DRIVER.get(Constant.URL);
            DRIVER.manage().window().maximize();
            waitForLoad(DRIVER);
        }

        @And("I click on the Credit Cards Icon")
        public void iClickOnTheCreditCardsIcon() throws InterruptedException {
           // JavascriptExecutor js = (JavascriptExecutor) DRIVER;
           // js.executeScript("arguments[0].click();", ccIcon);
           // DRIVER.findElement(By.cssSelector(".current-slide .silde--text"));
                DRIVER.get(Constant.URLcc);
                waitForLoad(DRIVER);
        }

        @And("I click the apply now secured credit card")
        public void iClickTheApplyNowSecuredCreditCard() {
           // List<WebElement> cclist = driver.findElements(By.className("cmp-button__text"));
           // cclist.get(2).click();
            DRIVER.get(Constant.URLsecure);
            waitForLoad(DRIVER);

        }


    @And("I skip the pre-fill step")
    public void iSkipThePreFillStep() {
            DRIVER.findElement(By.id("adaptive-skip-this-step")).click();
            waitForLoad(DRIVER);
    }

    @Then("I will see the cash advance is greater than {int} percent")
    public void iWillSeeTheCashAdvanceIsGreaterThanPercent(int percent) {
       String apr = DRIVER.findElement(By.cssSelector(".terms-and-conditions:nth-child(1) .cash-rate")).getText();
       int apr_int=Integer.parseInt(apr);
       assert apr_int > 20;

    }
}

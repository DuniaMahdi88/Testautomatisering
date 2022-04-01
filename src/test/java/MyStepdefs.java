import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MyStepdefs {

    //Attribute
    private String myEmail, myName, myPassword;
    private WebDriver driver;

    @Given("I have started {string} browser")
    public void iHaveStartedBrowser(String browser) {
        DriveCreator creator = new DriveCreator();
        driver = creator.createBrowser(browser);
    }

    @Given("I have written my email {string}")
    public void iHaveWrittenMyEmail(String email) {
        //Navigera till en specifik sida som vi vill testa
        driver.get("https://login.mailchimp.com/signup/");
        myEmail = email;
        sendKeys(driver, By.id("email"), email);

    }

    @Given("I have written my name {string}")
    public void iHaveWrittenMyName(String name) {
        myName = name;
        sendKeys(driver, By.id("new_username"), name);
    }


    @Given("I have written my password {string}")
    public void iHaveWrittenMyPassword(String password) {
        myPassword = password;
        sendKeys(driver, By.id("new_password"), password);

    }

    @When("I click the Sign Up button")
    public void iClickTheSignUpButton() {
        scroll(driver);
        click(driver, By.id("create-account"));
    }


    @Then("when I register I get the text pass. When I type a long name, I get an error message {string}.")
    public void whenIRegisterIGetTheTextMessageWhenITypeALongNameIGetAnMessage(String message) {
        //Verifiering
        String actual = getText(driver, By.cssSelector("h1[class='!margin-bottom--lv3 no-transform center-on-medium']"));
        String expected = message;
        assertEquals(expected, actual);
    }

    @Then("when I register I get the text faild. When I type a long name, I get an error message {string}.")
    public void whenIRegisterIGetTheTextMessageWhenITypeALongNameIGetAnErrorMessage(String errorMessage) {
        //Verifiering första scenario
        String actual = getText(driver, By.cssSelector("span[class='invalid-error']"));
        String expected = errorMessage;

        assertEquals(expected, actual);

        //Stänger webbläsaren
        driver.quit();

    }

    private String getText(WebDriver driver, By by) {
        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        String text = element.getText();
        return text;
    }


    private static void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    private static void sendKeys(WebDriver driver, By by, String text) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));

        element.sendKeys(text);

    }

    private static void click(WebDriver driver, By by) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.elementToBeClickable(by));

        element.click();
    }


}



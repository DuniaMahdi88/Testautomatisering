import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriveCreator {

    public WebDriver createBrowser(String browser) {
        WebDriver driver;


        if(browser.equals("edge")){
        System.setProperty("webdriver.edge.driver", "C:/Selenium/msedgedriver.exe");
        //Skapas ett nytt fönster
        driver = new EdgeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
            //Skapas ett nytt fönster
            driver = new ChromeDriver();
        }


        return driver;
    }
}

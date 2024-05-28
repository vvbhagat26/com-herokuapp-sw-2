package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;//declare driver

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();

        driver.get(baseUrl);//assign to driver

        driver.manage().window().maximize();//maximise

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//wait
    }

    public void closeBrowser() {
        driver.quit();
    }
}

package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    /**Write down the following test into ‘LoginTest’ class
     1. userSholdLoginSuccessfullyWithValidCredentials
     * Enter “tomsmith” username
     * Enter “SuperSecretPassword!” password
     * Click on ‘LOGIN’ button
     * Verify the text “Secure Area”
     2. verifyTheUsernameErrorMessage
     * Enter “tomsmith1” username
     * Enter “SuperSecretPassword!” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your username
     is invalid!”

     3. verifyThePasswordErrorMessage
     * Enter “tomsmith” username
     * Enter “SuperSecretPassword” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your password
     is invalid!”
 */

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on login button
        driver.findElement(By.className("radius")).click();

        //Verify the text 'Secure Area'
         String expectedText="Secure Area";
         WebElement welcomeText=driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
         String actualText=welcomeText.getText();
         Assert.assertEquals("Not expected text",expectedText,actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on login button
        driver.findElement(By.className("radius")).click();

        //Verify that username is invalid
         String expectedText="Your username is invalid!\n×";

         WebElement welcometext=driver.findElement(By.xpath("//div[@id='flash-messages']"));
         String actualText= welcometext.getText();
         Assert.assertEquals("Not expected text",expectedText,actualText);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //enter email
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Click on login button
        driver.findElement(By.className("radius")).click();

        //Verify wrong password
        String expectedText="Your password is invalid!\n" + "×";
        WebElement welcomeText=driver.findElement(By.xpath("//div[@id='flash-messages']"));
        String actualText= welcomeText.getText();
        Assert.assertEquals("Not expected text",expectedText,actualText);
    }

    public void closeBrowser() {
        driver.quit();
    }
}

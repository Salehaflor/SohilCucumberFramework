package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Log;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndNavigateToURL();
//       driver=new ChromeDriver();
//       driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
//       driver.manage().window().maximize();
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
       // LoginPage loginPage=new LoginPage();
//        WebElement userName=driver.findElement(By.cssSelector("input#txtUsername"));
//        WebElement password=driver.findElement(By.cssSelector("input#txtPassword"));
       // userName.sendKeys(ConfigReader.getPropertyValue("username"));
      //  password.sendKeys(ConfigReader.getPropertyValue("password"));
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My batch 16 test case starts here");
        sendText(ConfigReader.getPropertyValue("username"), loginPage.usernameField);
        Log.info("my username has been entered");
        sendText(ConfigReader.getPropertyValue("password"), loginPage.passwordField);
        Log.info("My password has been entered");


    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       // WebElement loginBtn=driver.findElement(By.cssSelector("input[type='submit'"));
        //LoginPage loginPage = new LoginPage();
        // WebElement loginButton = driver.findElement(By.name("Submit"));
        //loginButton.click();
        click(loginPage.loginButton);
       // loginBtn.click();
        //click(loginBtn);

    }
    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        WebElement welcomeAdmin=driver.findElement(By.xpath("//a[text()='Welcome Admin']"));
        String actualResult=welcomeAdmin.getText();
        String expectResult="Welcome Admin";
        Assert.assertEquals(expectResult,actualResult);

    }
    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
       // LoginPage loginPage = new LoginPage();
        //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
        //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //logged in via normal employee
        //usernameField.sendKeys("dalima123");
        //  passwordField.sendKeys("Hum@nhrm123");
        sendText("dalima123", loginPage.usernameField);
        sendText("Hum@nhrm123", loginPage.passwordField);

    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        // WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        // usernameField.sendKeys("admin123");
        //  passwordField.sendKeys("Hum@nhrm123");
      //  LoginPage loginPage = new LoginPage();
        sendText("admin123", loginPage.usernameField);
        sendText("Hum@nhrm123", loginPage.passwordField);
    }
    @Then("error message is displayed")
    public void error_message_is_displayed() {
        System.out.println("Error message is displayed");

    }

    @When("user enters {string} and {string} and verifying the {string} for the combinations")
    public void user_enters_and_and_verifying_the_for_the_combinations
            (String username, String password, String errorMessage) {
        //we need to write the code here to match the errors

        sendText(username, loginPage.usernameField);
        sendText(password, loginPage.passwordField);
        click(loginPage.loginButton);
        //fetching the error message from the web element
        String errorMessageActual = loginPage.errorMessageField.getText();
        //error message coming from feature file too which we can compare
        Assert.assertEquals("value does not match", errorMessage, errorMessageActual);
    }




}

package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver;
    WebDriverManager driverManager;
    JavascriptExecutor jse;
    @Given("browser is open")
    public void browser_is_open() {
        driverManager.chromedriver().setup();
        System.out.println("Test Step - browser is open");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Test Step - user is on login page");
        driver.get("https://example.testproject.io/web/");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("Test Step - user enters username and password");
        driver.findElement(By.id("name")).sendKeys("Mertcan");
        driver.findElement(By.id("password")).sendKeys("12345");

    }

    @And("user clicks on login")
    public void user_clicks_on_login() {
        System.out.println("Test Step - user clicks on login");
        jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("login")).click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        System.out.println("Test Step - user is navigated to the home page");
        if (driver.findElement(By.id("logout")).isDisplayed()){
            System.out.println("This is right page");
        }
        driver.quit();
    }

}

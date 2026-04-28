import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginForm;
import Pages.PersonalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Smoke {
    private WebDriver driver;

    @BeforeTest
    @Parameters({"browser","env"})
    public void setUp(String browser, String env){
        System.out.println("Running tests in browser: "+browser);
        System.out.println("Running tests in environment: "+env);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Open web application
        driver.get("https://demoblaze.com/");

    }

    @Parameters({"username","password"})
    @Test
    public void loginValidUser(String username, String password)  {
        LandingPage landingPage = new LandingPage(driver);
        LoginForm loginForm = landingPage.openLoginForm();
        PersonalPage personalPage = loginForm.loginValidUser(username,password);
        Assert.assertEquals(personalPage.getWelcomeText(),"Welcome "+username);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
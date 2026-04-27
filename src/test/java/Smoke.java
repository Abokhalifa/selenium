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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Smoke {

    @Parameters({"browser","env","username","password"})
    @Test
    public void test1(String browser,String env,String username, String password) throws InterruptedException {
        //Test Data
        //Creating webdriver instance
        System.out.println("Running tests in browser: "+browser);
        System.out.println("Running tests in environment: "+env);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Open web application
        driver.get("https://demoblaze.com/");

        //Fluent wait
        /*FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(ExpectedCondition.class);
        */



        //Click the home link
        LandingPage landingPage = new LandingPage(driver);
        //HomePage homePage = landingPage.openHomePage();
        LoginForm loginForm = landingPage.openLoginForm();
        PersonalPage personalPage = loginForm.loginValidUser(username,password);
        //Thread.sleep(10000);
        Assert.assertEquals(personalPage.getWelcomeText(),"Welcome "+username);

        driver.quit();
    }

}
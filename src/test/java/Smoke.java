import Pages.LandingPage;
import Pages.LoginForm;
import Pages.PersonalPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DataAdapter;

import java.io.IOException;
import java.time.Duration;

public class Smoke {
    private WebDriver driver;
    private String testCaseName;
    private String username;
    private String password;
    private LandingPage landingPage;
    private LoginForm loginForm;
    private PersonalPage personalPage;


    @BeforeTest
    @Parameters({"browser","env"})
    public void setUp(String browser, String env) throws IOException {
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
    public void loginValidUserFromTestNg(String username_testng, String password_testng) throws IOException {
        testCaseName = DataAdapter.readDataFromExcelFile()[0];
        username = username_testng;
        password = password_testng;
        DataAdapter.readDataFromTextFile();
        landingPage = new LandingPage(driver);
        loginForm = landingPage.openLoginForm();
        personalPage = loginForm.loginValidUser(username_testng,password_testng);
        Assert.assertEquals(personalPage.getWelcomeText(),"Welcome "+username_testng);
    }

    @Test
    public void loginValidUserFromExcel() throws IOException {
        testCaseName = DataAdapter.readDataFromExcelFile()[0];
        username = DataAdapter.readDataFromExcelFile()[1];
        password = DataAdapter.readDataFromExcelFile()[2];
        DataAdapter.readDataFromTextFile();
        landingPage = new LandingPage(driver);
        loginForm = landingPage.openLoginForm();
        personalPage = loginForm.loginValidUser(username, password);
        Assert.assertEquals(personalPage.getWelcomeText(),"Welcome "+username);
    }

    @Test
    public void loginValidUserFromText() throws IOException {
        testCaseName = DataAdapter.readDataFromTextFile()[0];
        username = DataAdapter.readDataFromTextFile()[1];
        password = DataAdapter.readDataFromTextFile()[2];
        DataAdapter.readDataFromTextFile();
        landingPage = new LandingPage(driver);
        loginForm = landingPage.openLoginForm();
        personalPage = loginForm.loginValidUser(username, password);
        Assert.assertEquals(personalPage.getWelcomeText(),"Welcome "+username);
    }

    @Test
    public void loginValidUserFromJson() throws IOException {
        testCaseName = DataAdapter.readDataFromJsonFile()[0];
        username = DataAdapter.readDataFromTextFile()[1];
        password = DataAdapter.readDataFromTextFile()[2];
        DataAdapter.readDataFromTextFile();
        landingPage = new LandingPage(driver);
        loginForm = landingPage.openLoginForm();
        personalPage = loginForm.loginValidUser(username, password);
        Assert.assertEquals(personalPage.getWelcomeText(),"Welcome "+username);
    }


    @AfterMethod
    public void afterMethod(){
        landingPage = personalPage.clickLogoutLink();
    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver){
        super(driver);
    }
    private By usernameTextbox = By.id("loginusername");
    private By passwordTextbox = By.id("loginpassword");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By closeButton = By.xpath("//div[@id='logInModal']//button[contains(text(),'Close')]");




    private void insertUsername(String username){
        driver.findElement(usernameTextbox).sendKeys(username);
    }
    private void insertPassword(String password){
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    private void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

        private LandingPage clickCloseButton(){
        driver.findElement(closeButton).click();
        return new LandingPage(driver);
    }

    public PersonalPage loginValidUser(String username, String password){
        insertUsername(username);
        insertPassword(password);
        clickLoginButton();
        return new PersonalPage(driver);
    }





}

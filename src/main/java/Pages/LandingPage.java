package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver){
        super(driver);
        if(!driver.getTitle().equals("STORE")){
            throw new IllegalStateException("This is not the landing page of the store."+ " Current page is : "+driver.getCurrentUrl());
        }
    }

    //protected WebDriver driver;



    public HomePage openHomePage(){
        driver.findElement(homeLink).click();
        return new HomePage(driver);
    }

    public LoginForm openLoginForm(){
        driver.findElement(loginLink).click();
        return new LoginForm(driver);
    }










}

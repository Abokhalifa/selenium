package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public LandingPage(WebDriver driver){
        this.driver = driver;
        if(!driver.getTitle().equals("STORE")){
            throw new IllegalStateException("This is not the landing page of the store."+ " Current page is : "+driver.getCurrentUrl());
        }
    }

    protected WebDriver driver;
    private By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private By contactLink = By.xpath("//a[contains(text(),'Contact')]");
    private By aboutusLink = By.xpath("//a[contains(text(),'About us')]");
    private By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private By loginLink = By.xpath("//a[contains(text(),'Log in')]");
    private By signupLink = By.xpath("//a[contains(text(),'Sign up')]");

    public HomePage openHomePage(){
        driver.findElement(homeLink).click();
        return new HomePage(driver);
    }

    public LoginForm openLoginForm(){
        driver.findElement(loginLink).click();
        return new LoginForm(driver);
    }










}

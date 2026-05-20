package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public BasePage(WebDriver driver){
        this.driver = driver;
        if(!driver.getTitle().equals("STORE")){
            throw new IllegalStateException("This is not the landing page of the store."+ " Current page is : "+driver.getCurrentUrl());
        }
    }

    protected WebDriver driver;
    protected By homeLink = By.xpath("//a[contains(text(),'Home')]");
    protected By contactLink = By.xpath("//a[contains(text(),'Contact')]");
    protected By aboutusLink = By.xpath("//a[contains(text(),'About us')]");
    protected By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    protected By loginLink = By.xpath("//a[contains(text(),'Log in')]");
    protected By signupLink = By.xpath("//a[contains(text(),'Sign up')]");
    protected By carouselNextLink = By.xpath("//a[contains(@class,'carousel-control-next')]");
    protected By carouselPreviousLink = By.xpath("//a[contains(@class,'carousel-control-prev')]");
    protected By categoriesLink = By.xpath("//a[contains(text(),'CATEGORIES')]");
    protected By phonesLink = By.xpath("//a[contains(text(),'Phones')]");
    protected By laptopsLink = By.xpath("//a[contains(text(),'Laptops')]");
    protected By monitorsLink = By.xpath("//a[contains(text(),'Monitors')]");
    protected By nextPageLink = By.xpath("//button[contains(text(),'Next')]");
    protected By previousPageLink = By.xpath("//button[contains(text(),'Previous')]");



    public HomePage openHomePage(){
        driver.findElement(homeLink).click();
        return new HomePage(driver);
    }

    public LoginForm openLoginForm(){
        driver.findElement(loginLink).click();
        return new LoginForm(driver);
    }












}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private By samsung_galaxy_s6 = By.xpath("//div[@id='tbodyid']/div[1]//a[contains(text(),'Samsung galaxy s6')]");
    private By nokia_lumia_1520 = By.xpath("//div[@id='tbodyid']/div[2]//a[contains(text(),'Nokia lumia 1520')]");
    private By nexus_6 = By.xpath("//div[@id='tbodyid']/div[3]//a[contains(text(),'Nexus 6')]");
    private By samsung_galaxy_s7 = By.xpath("//div[@id='tbodyid']/div[3]//a[contains(text(),'Samsung galaxy s7')]");





    public LandingPage(WebDriver driver){
        super(driver);
        if(!driver.getTitle().equals("STORE")){
            throw new IllegalStateException("This is not the landing page of the store."+ " Current page is : "+driver.getCurrentUrl());
        }
    }




    public HomePage openHomePage(){
        driver.findElement(homeLink).click();
        return new HomePage(driver);
    }

    public LoginForm openLoginForm(){
        driver.findElement(loginLink).click();
        return new LoginForm(driver);
    }
}

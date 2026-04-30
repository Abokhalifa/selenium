package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalPage {
    private WebElement welcomeTextArea;
    private WebElement logoutLink;
    protected WebDriver driver;


    public PersonalPage(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        welcomeTextArea =wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
        logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
    }

    public String getWelcomeText(){
        String welcomeText =  welcomeTextArea.getText();
        System.out.println("The welcome text is : "+welcomeText);
        return welcomeText;
    }

    public LandingPage clickLogoutLink(){
        logoutLink.click();
        return new LandingPage(driver);
    }
}

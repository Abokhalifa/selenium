package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalPage {

    private WebElement welcomeTextArea;
    protected WebDriver driver;


    public PersonalPage(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        welcomeTextArea =wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
    }

    public String getWelcomeText(){
        String welcomeText =  welcomeTextArea.getText();
        //String welcomeText =  driver.findElement(welcomeTextArea).getAttribute("innerHTML");
        //String welcomeText =  driver.findElement(welcomeTextArea).getAttribute("textContent");
        System.out.println("The welcome text is : "+welcomeText);
        return welcomeText;
    }
}

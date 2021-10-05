package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    private By userNameField = By.id("txtUsername");
    private By passwordField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUserNameField(String email){
        driver.findElement(userNameField).sendKeys(email);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void doLogin(String userName ,String password){
        setUserNameField(userName);
        setPasswordField(password);
        clickLoginButton();
    }

}

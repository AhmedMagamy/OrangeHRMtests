package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
    private WebDriver driver;

    private By userRoleSelect = By.id("systemUser_userType");
    private By employeeNameField = By.id("systemUser_employeeName_empName");
    private By userNameField = By.id("systemUser_userName");
    private By statusSelect = By.id("systemUser_status");
    private By passwordField = By.id("systemUser_password");
    private By confirmPasswordField = By.id("systemUser_confirmPassword");
    private By saveBtn = By.id("btnSave");



    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUserType(String userType){
        Select userRoleMenu = new Select(driver.findElement(userRoleSelect));
        userRoleMenu.selectByVisibleText(userType);
    }

    public void setEmployeeNameField(String employeeName){
        driver.findElement(employeeNameField).sendKeys(employeeName);
    }

    public void setUserNameField(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void selectStatusType(String statusType){
        Select userRoleMenu = new Select(driver.findElement(statusSelect));
        userRoleMenu.selectByVisibleText(statusType);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }


    public void setConfirmPasswordField(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickSave(){
        driver.findElement(saveBtn).click();
    }
    public void addNewUser(String userRole , String employeeName , String userName , String statusType , String password , String confirmPassword){
        selectUserType(userRole);
        setEmployeeNameField(employeeName);
        setUserNameField(userName);
        selectStatusType(statusType);
        setPasswordField(password);
        setConfirmPasswordField(confirmPassword);
        clickSave();
    }

















}

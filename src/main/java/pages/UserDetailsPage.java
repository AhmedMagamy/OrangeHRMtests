package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UserDetailsPage {

    private WebDriver driver;

    private By userRoleSelect = By.id("systemUser_userType");
    private By employeeNameField = By.id("systemUser_employeeName_empName");
    private By userNameField = By.id("systemUser_userName");
    private By statusSelect = By.id("systemUser_status");

    public UserDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getUserRoleSelect() {
        Select userRoleMenu = new Select(driver.findElement(userRoleSelect));
        return userRoleMenu.getFirstSelectedOption().getText();
    }

    public String getEmployeeNameField() {
        return driver.findElement(employeeNameField).getAttribute("value");
    }

    public String getUserNameField() {
        return driver.findElement(userNameField).getAttribute("value");
    }

    public String getStatusSelect() {
        Select userRoleMenu = new Select(driver.findElement(statusSelect));
        return userRoleMenu.getFirstSelectedOption().getText();    }
}

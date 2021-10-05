package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;


    private By adminMenu = By.id("menu_admin_viewAdminModule");
    private By userManagementMenu = By.id("menu_admin_UserManagement");
    private By usersItem = By.id("menu_admin_viewSystemUsers");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUsersPage(){
        //Make instance from actions class to use it in hover
        Actions actions = new Actions(driver);
        WebElement admin = driver.findElement(adminMenu);
        //hover on admin menu
        actions.moveToElement(admin);
        actions.perform();
        WebElement userMang = driver.findElement(userManagementMenu);
        //hover on user Management menu
        actions.moveToElement(userMang);
        actions.perform();
        WebElement users = driver.findElement(usersItem);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(users));
        //click on users
        users.click();
    }
}

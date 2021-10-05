package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UsersPage {

    private WebDriver driver;

    private By addUsersBtn = By.id("btnAdd");
    private By searchField = By.id("searchSystemUser_userName");
    private By seacrhBtn = By.id("searchBtn");
    private By userNameClm = By.xpath("//tbody/tr/td[2]");


    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddUser(){
        driver.findElement(addUsersBtn).click();
    }

    public  void openUserDetails(String userName){
        driver.findElement(By.linkText(userName)).click();
    }
    public void searchForAddedUser(String userName){
        driver.findElement(searchField).sendKeys(userName);
        driver.findElement(seacrhBtn).click();
    }


}

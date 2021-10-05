package tests;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilites.ExcelUtility;

import java.security.Timestamp;
import java.util.Date;


@Listeners(utilites.ReportsGenerator.class)
public class Tests extends Base {
    ExcelUtility excel = new ExcelUtility("TestData.xlsx");
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private UsersPage usersPage;
    private AddUserPage addUserPage;
    private UserDetailsPage userDetailsPage;





    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        usersPage = new UsersPage(driver);
        addUserPage = new AddUserPage(driver);
        userDetailsPage = new UserDetailsPage(driver);

    }

    //in this method we do our tests
    @Test
    public void tc_1AddNewUserAndVerifyAdded() {
        //Read login data from excel
        String userNameLogin = excel.getCellDataString("loginData",1,0);
        String passwordLogin =excel.getCellDataString("loginData",1,1);


        //we use time stamp to generate unique username every time to avoid duplicated username error
        Date date= new Date();
        Long time = date.getTime();
        //Read the user to add data from excel file
        String userRole =excel.getCellDataString("UserData",1,0);
        String employeeName = excel.getCellDataString("UserData",1,1);
        String userName = excel.getCellDataString("UserData",1,2)+time.toString();
        String statusType= excel.getCellDataString("UserData",1,3);
        String password = excel.getCellDataString("UserData",1,4);
        String confirmPassword = excel.getCellDataString("UserData",1,5);


        //open OrangeHRM Login page
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        //Login
        loginPage.doLogin(userNameLogin,passwordLogin);
        //open users page
        dashboardPage.openUsersPage();
        //open add new user page
        usersPage.clickAddUser();
        //fill the form and add new user
        addUserPage.addNewUser(userRole,employeeName,userName,statusType,password,confirmPassword);
        //search for the added uses
        usersPage.searchForAddedUser(userName);
        //open user details
        usersPage.openUserDetails(userName);
        //Verify that all data are the same as I inserted in creating
        Assert.assertEquals(userDetailsPage.getStatusSelect(),statusType);
        Assert.assertEquals(userDetailsPage.getEmployeeNameField(),employeeName);
        Assert.assertEquals(userDetailsPage.getUserRoleSelect(),userRole);
        Assert.assertEquals(userDetailsPage.getUserNameField(),userName);














    }
}

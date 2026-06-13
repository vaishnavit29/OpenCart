package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Tc_Login extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void login(){
        HomePage home=new HomePage(driver);
        home.clickMyAccount();
        home.clickLogin();
        LoginPage login=new LoginPage(driver);
        login.enterEmail(prop.getProperty("Email"));
        login.enterPassword(prop.getProperty("Password"));
        login.clickSubmit();

    }


}

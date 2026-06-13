package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_Login_DDT extends BaseClass {

    @Test(groups = {"Master"},dataProvider = "Login",dataProviderClass = DataProviders.class)
    public void testLogin(String email, String Pass, String validity){
    HomePage home=new HomePage(driver);
    home.clickMyAccount();
    home.clickLogin();
    LoginPage log=new LoginPage(driver);
    log.enterEmail(email);
    log.enterPassword(Pass);
    log.clickSubmit();

    if(validity.equalsIgnoreCase("invalid")){
        if(log.error.isDisplayed()){
            System.out.println(validity+" Test Case is passed");
            Assert.assertTrue(true);
        }
        else{
            System.out.println(validity+" Test case is failed");
            Assert.assertTrue(false);
        }
    }

    else{
        if(validity.equalsIgnoreCase("valid")) {
            MyAccountPage acc = new MyAccountPage(driver);
            if(acc.btnLogOut.isDisplayed()){
                Assert.assertTrue(true);
                System.out.println(validity + " Test Case is passed");
                acc.clickLogOut();
            }
            else{
                System.out.println(validity+" Test case is failed");
                Assert.assertTrue(false);
            }

        }
    }
}

}

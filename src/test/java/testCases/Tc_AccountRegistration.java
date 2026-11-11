package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_AccountRegistration extends BaseClass {

    @Test(groups = {"Sanity","Regression","Master"})
    public void testAccountRegistration(){
        HomePage home=new HomePage(driver);
        home.clickMyAccount();
        home.clickRegister();
        AccountRegistrationPage acc=new AccountRegistrationPage(driver);
        logger.info("Providing details");
        acc.setTxtRegFirstName("vaish");
        acc.setTxtRegLastName("T");
        String generatedEmail=generateAlphabetic()+"@gmail.com";
        System.out.println(generatedEmail);
        acc.setTxtRegEmail(generatedEmail);
        acc.setTxtRegTelephone("9876543216");
        acc.setTxtRegPassword("Vt@13");
        acc.setTxtRegConfirmPassword("Vt@13");
        acc.setChkRegNewsLetter();
        acc.setChkRegRead();
        acc.setBtnRegSubmit();
        String AccCreationText= acc.getSuccessTxt();
        //Assert.assertEquals(AccCreationText,"Your Account Has Been Created!");
        acc.clickContinue();

    }

}

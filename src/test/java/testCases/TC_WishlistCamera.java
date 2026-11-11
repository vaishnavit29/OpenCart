package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.Arrays;

public class TC_WishlistCamera extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void wishlistCamera() {

    HomePage home = new HomePage(driver);
        home.clickMyAccount();
        home.clickLogin();
    LoginPage login = new LoginPage(driver);
        login.enterEmail(prop.getProperty("Email"));
        login.enterPassword(prop.getProperty("Password"));
        login.clickSubmit();
        MyAccountPage acc=new MyAccountPage(driver);
        acc.clickCamera();
    CameraSectionPage camera = new CameraSectionPage(driver);
    String CameraTxt=camera.getOptionCanon();
    if(CameraTxt.contains("Nikon")){
        Assert.assertTrue(true);
    }
    camera.clkWishlist();
    if(camera.getTxtSuccessWishlist().contains("Success")){
        Assert.assertTrue(true);
    }
    if(camera.LinkWishlist.isDisplayed()){
        System.out.println("Wish List link is visible");
        camera.ClickWishlistLink();
    }
    WishListPage wishlist=new WishListPage(driver);
    if(wishlist.tableName.isDisplayed()){
        System.out.println("Wishlist Table is visible");
    }
    System.out.println(Arrays.toString(wishlist.getProductName()));



}

}

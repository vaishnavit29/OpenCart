package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    //PgaeFactory
    @FindBy(linkText="Logout") public WebElement btnLogOut;
    @FindBy(xpath = "//li/a[text()='Cameras']") public WebElement btnCamera;

    //Actions
    public void clickLogOut(){
        btnLogOut.click();
    }
    public void clickCamera(){btnCamera.click();}


}

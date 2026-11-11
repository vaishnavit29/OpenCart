package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CameraSectionPage extends BasePage{
    public CameraSectionPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h4/a[contains(text(), 'Nikon')]") WebElement optCanon;
    @FindBy(xpath = "(//button)[14]") WebElement optWishlist;
    @FindBy(xpath="(//div[contains(., 'Success')])[2]") WebElement TxtSuccessWishlist;
    @FindBy(xpath="//a[contains(text(),'wish')]") public WebElement LinkWishlist;

    public String getOptionCanon(){
        return optCanon.getText();
    }
    public void clkWishlist(){optWishlist.click();}
    public String getTxtSuccessWishlist(){return TxtSuccessWishlist.getText();}
    public void ClickWishlistLink(){
        LinkWishlist.click();
    }

}

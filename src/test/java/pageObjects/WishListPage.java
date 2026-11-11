package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.util.List;

public class WishListPage extends BasePage{

    public WishListPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'My Wish')]") public WebElement tableName;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> productName;

    public String[] getProductName(){
        String[] prodctList = new String[productName.size()];

            for(int i=0;i<productName.size();i++){
                prodctList[i]=productName.get(i).getText();
            }

        return prodctList;
    }
}

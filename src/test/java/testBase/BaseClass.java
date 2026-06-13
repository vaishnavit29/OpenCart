package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {


    static public WebDriver driver;
    public Logger logger;
    public Properties prop;


    @BeforeClass(groups = {"Sanity","Regression","Master"})
    @Parameters({"browser"})
    public void setUp(String browser) throws IOException {
        FileReader File=new FileReader("./src//test//resources//config.properties");
        prop=new Properties();
        prop.load(File);
        logger= LogManager.getLogger(this.getClass());
        switch (browser){
            case "chrome":driver=new ChromeDriver();break;
            case "edge":driver=new EdgeDriver();break;
            case "firefox":driver=new FirefoxDriver(); break;
            default:
                System.out.println("provided browser name is not correct");
                return;

        }
        logger.info("used browser is "+ browser);

        driver.get(prop.getProperty("Url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterClass(groups = {"Sanity","Regression","Master"})
//    public void tearDown(){
//        driver.close();
//    }

    public String generateAlphabetic(){
        String Alphabetic=RandomStringUtils.randomAlphabetic(5);
        System.out.println(Alphabetic);
        return Alphabetic;
    }

    public String screenshot(String TestcaseName){

        String TimeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot Ts=(TakesScreenshot) driver;
        File src=Ts.getScreenshotAs(OutputType.FILE);
        String targetPath=".\\reports\\"+TestcaseName+"_"+TimeStamp;
        File target=new File(targetPath);
        src.renameTo(target);
        return targetPath;
    }
}

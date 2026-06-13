package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener  {

    public ExtentSparkReporter ExSpark;
    public ExtentReports ExReports;
    public ExtentTest ExTest;
    String repName;


    public void onStart(ITestContext context) {
        String Timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName="Test-Report-"+Timestamp+".html";

        ExSpark=new ExtentSparkReporter(".\\reports\\"+repName);
        ExSpark.config().setTheme(Theme.DARK);
        ExSpark.config().setReportName("OpenCart Functional Test");
        ExSpark.config().setDocumentTitle("Opencart Test Results");

        ExReports=new ExtentReports();
        ExReports.attachReporter(ExSpark);
        ExReports.setSystemInfo("Application","OpenCart");
        ExReports.setSystemInfo("Module","Admin");
        ExReports.setSystemInfo("Sub Module","Customers");
        ExReports.setSystemInfo("Environment","QA");

        String os=context.getCurrentXmlTest().getParameter("browser");
        ExReports.setSystemInfo("BrowserName",os);

        List<String> groupNames=context.getCurrentXmlTest().getIncludedGroups();
        if(!groupNames.isEmpty()){
            ExReports.setSystemInfo("Groups",groupNames.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExTest=ExReports.createTest(result.getTestClass().getName());
        ExTest.assignCategory(result.getMethod().getGroups());
        ExTest.log(Status.PASS,result.getName()+" got successfully executed");


        BaseClass BC=new BaseClass();
        String imgPath=BC.screenshot(result.getTestClass().getName());
        ExTest.addScreenCaptureFromPath(imgPath);
    }

    public void onTestFailure(ITestResult result) {
        ExTest=ExReports.createTest(result.getTestClass().getName());
        ExTest.assignCategory(result.getMethod().getGroups());
        ExTest.log(Status.FAIL,result.getName()+" got failed");
        ExTest.log(Status.INFO,result.getThrowable().getMessage());

        BaseClass BC=new BaseClass();
        String imgPath=BC.screenshot(result.getTestClass().getName());
        ExTest.addScreenCaptureFromPath(imgPath);

    }


    public void onTestSkipped(ITestResult result) {
        ExTest=ExReports.createTest(result.getTestClass().getName());
        ExTest.assignCategory(result.getMethod().getGroups());
        ExTest.log(Status.SKIP,result.getName()+" Got Skipped");
        ExTest.log(Status.INFO,result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExReports.flush();
    }
}

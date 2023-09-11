package BasePackage;

import com.aventstack.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShotListener extends ScreeenshotMechanism implements ITestListener {

    ExtentReports test;
    public void onTestStart(ITestResult result) {
        test =  ExtentReportMechanism.getReports();
        test.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result ) {
    System.out.println(result.getMethod().getMethodName() + " Failed!");
      String filePath  = getScreenShot(result.getMethod().getMethodName().trim());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        test.flush();

    }



}









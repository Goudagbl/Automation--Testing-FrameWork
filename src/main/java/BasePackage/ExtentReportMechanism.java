package BasePackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportMechanism {

    public static ExtentReports getReports(){
        String path = System.getProperty("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("FireFlink Results");
        sparkReporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester","UAT Team");
        return extent;

    }


}

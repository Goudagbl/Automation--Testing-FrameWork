package BasePackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreeenshotMechanism extends BaseTest{
    public String getScreenShot(String scriptName){
       /* TakesScreenshot screenShot = (TakesScreenshot) driver;
        File scrFile = screenShot.getScreenshotAs(OutputType.FILE);

        */
        Date currentDate = new Date();
        String date = currentDate.toString().trim().replace(" ","-").replace(":","-" );
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File desFile = new File("C:/Users/User/Downloads/Fireflink/ScreenShots/" + date + scriptName +".png");

        try {
            FileUtils.copyFile(scrFile,desFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String scrShotStoredLoc = "C:/Users/User/Downloads/Fireflink/ScreenShots/" + date + scriptName +".png";
         return scrShotStoredLoc;
    }

}

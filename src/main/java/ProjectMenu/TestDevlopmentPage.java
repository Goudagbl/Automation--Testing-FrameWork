package ProjectMenu;

import BasePackage.Libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestDevlopmentPage extends Libraries {

   public  WebDriver driver;
    TestDevlopmentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[contains(@class,'project_label')]/..//button[contains(text(),'Module')]")
    WebElement addModule;

    @FindBy(xpath = "//label[contains(@class,'project_label')]")
    WebElement scripts;

    public void validate_userNavigated_TestDevSection(String expectedString){
        wait_elementToBeClickable(addModule,10);
        Assert.assertEquals(scripts.getText(),expectedString);
    }

}

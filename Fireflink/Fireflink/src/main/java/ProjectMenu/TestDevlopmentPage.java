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

    @FindBy(xpath = "//label[text()='Scripts']")
    WebElement scripts;

    public void validate_userNavigated_TestDevSection(String expectedString){
        wait_Element_To_Be_Visual(scripts,5);
        Assert.assertEquals(scripts.getText(),expectedString);
    }

}

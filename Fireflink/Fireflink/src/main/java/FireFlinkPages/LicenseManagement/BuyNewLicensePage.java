package FireFlinkPages.LicenseManagement;

import BasePackage.Libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BuyNewLicensePage extends Libraries {
public WebDriver driver;
    BuyNewLicensePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[contains(@class,'stepper_step-button')]")
    List<WebElement> tabs;

    public void tabsDisplayed(){
        wait_Elements_To_Be_Visual(tabs,5);
        for(WebElement tab:tabs){
            Assert.assertTrue(tab.isDisplayed());
            System.out.println(tab.findElement(By.xpath("//span[contains(@class,'stepper_step-button')]//span")).getText());
        }
    }

}

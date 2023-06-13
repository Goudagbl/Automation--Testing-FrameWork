package ProjectMenu;

import BasePackage.Libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RolesPage extends Libraries {


    public WebDriver driver;
    public RolesPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//button[contains(@class,'primary' ) or contains(text(),'Role')]")
    WebElement addRoleButton;

    @FindBy(xpath = "//div[contains(@class,'Popup-header')]//label")
    WebElement createRolePopup;


    @FindBy(css = "#roleName")
    WebElement roleName;

    @FindBy(xpath = "//button[@class='primary-btn']//span")
    WebElement createButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement addUserTosterMessage;




    public void createARole(String roleValue, String expectedTosterMessage){
        clickOnElement(addRoleButton);
        Assert.assertEquals(createRolePopup.getText(),"Create Role");
        enterIntoElement(roleName,roleValue);
        clickOnElement(createButton);
        wait_textToBePresentInElement(addUserTosterMessage,5,expectedTosterMessage);
        Assert.assertEquals(addUserTosterMessage.getText(),expectedTosterMessage);

    }





}

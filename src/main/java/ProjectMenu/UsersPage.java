package ProjectMenu;

import BasePackage.Libraries;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class UsersPage extends Libraries {
    public WebDriver driver;
    public UsersPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//button[@class='primary-btn ml-4' or text()= '+ User']")
    WebElement userButton;

    @FindBy(xpath = "//div[contains(@class,'Popup-header')]//label")
    WebElement addUserPopup;

    @FindBy(css = "#emailId")
    WebElement emailTextField;

    @FindBy(css = "#pprivilege")
    WebElement privilegeDrop;

    @FindBy(xpath = "//li[@id='sideLeft']//span[contains(@class,'text')]")
    List<WebElement> privilegeTypes;

    @FindBy(css = "#name")
    WebElement username;

    @FindBy(xpath = "//button[@class='primary-btn']")
    WebElement createButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement addUserTosterMessage;


    public void createUser(String emailId, String privilegeType, String userName, String expectedTosterMessage ){
        avoidStalenessOfWebElement(userButton).click();
        Assert.assertEquals(addUserPopup.getText(),"Add user to License");
        enterIntoElement(emailTextField,emailId);
        clickOnElement(privilegeDrop);
        wait_Elements_To_Be_Visual(privilegeTypes,5);
        for(WebElement pri: privilegeTypes){
            if(pri.getText().equalsIgnoreCase(privilegeType)){
                clickOnElement(pri);
                break;
            }

        }
        wait_Element_To_Be_Visual(username,3);
        enterIntoElement(username,userName);
        wait_attributeContains(username,5,"value",userName);
        clickOnElement(createButton);
        wait_textToBePresentInElement(addUserTosterMessage,5,expectedTosterMessage);
        System.out.println(addUserTosterMessage.getText());
        Assert.assertEquals(addUserTosterMessage.getText(),expectedTosterMessage);




    }


}

package ProjectMenu;

import BasePackage.Libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditProjectPage extends Libraries {

    public WebDriver driver;
    public EditProjectPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//span[contains(@class,'slider1')]")
    WebElement projectToggler;
    @FindBy(xpath="//button[contains(text(),'Change')]")
    WebElement changeButton;

    @FindBy(xpath="//div[text()='Closed']")
    WebElement closedText;
    //span[text()='safesa']/../../..//div[text()='Closed']

    @FindBy(xpath="//div[text()='Open']")
    WebElement OpenText;

    @FindBy(css = "#buttonId")
    WebElement projectUpdateButton;


    @FindBy(xpath = "/div[contains(@class,'alert')]")
    WebElement updateTosterMessage;

    public void closeProject(String expectedTosterMessage){
        clickOnElement(projectToggler);
        clickOnElement(changeButton);
        clickOnElement(projectUpdateButton);
        try{
            wait_textToBePresentInElement(updateTosterMessage,30,expectedTosterMessage);

            }
        catch(Exception exe){

        }

    }


    public void reOpenProject(){
        clickOnElement(projectToggler);
        clickOnElement(changeButton);
        clickOnElement(projectUpdateButton);
        try{
            wait_Element_To_Be_Visual(OpenText,10);
            if(OpenText.getText().contains("Open")){
                Assert.assertTrue(true);
            }
            else{
                Assert.assertTrue(false);
            }
        }
        catch(Exception exe){

        }


    }

}

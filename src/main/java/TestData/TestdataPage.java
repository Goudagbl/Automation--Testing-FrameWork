package TestData;

import BasePackage.Libraries;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

public class TestdataPage extends Libraries {

   WebDriver driver;
    public TestdataPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@title='Test Data']")
    WebElement testDataTitle;

    @FindBy(xpath = "//button[contains(@class,'primary-btn ')]")
    WebElement plusFolder;

    @FindBy(xpath = "//h2[contains(@class, 'title Popup-header')]")
    WebElement createFolderPopUpHeaderText;

    @FindBy(css = "#folderName")
    WebElement folderNameTextField;

    @FindBy(xpath = "//button[contains(@class,'gray-btn')]")
    WebElement chooseFolderBtn;

    @FindBy(xpath = "//span[contains(@class,'Popup-header')]")
    WebElement selectFolderPopupText;

    @FindBy(css="#rootRB")
    WebElement rootFolderRadioButton;

    @FindBy(xpath="//button[text()='Select']")
    WebElement selectButton;

    @FindBy(xpath="//label[@for='parentPage']/following-sibling :: div//p[@title='Root Folder']")
    WebElement selectedFolder;

    @FindBy(xpath = "//span[text()='Create']")
    WebElement folderCreateButton;

    @FindBy(xpath = "//div[contains(@class,'message')]")
    WebElement testDataTosterMessage;

    @FindBy(xpath = "//*[contains(@id,'account_tree')]")
    WebElement createdFolderExpander;


    @FindBy(xpath = "//span[@class='fancytree-title ']")
    List<WebElement> createdFolderList;


    //button[@class='add-btn']/../..//span[text()='dsv']



    //

    public void verify_UserNavigatedTO_TestDataSection(String SectionName){
        Assert.assertEquals(testDataTitle.getText(),SectionName);
    }

    public void createAFolder(String actual_CreateFolderPopupHeader, String folderName, String actualConfirmationMessage){
        wait_elementToBeClickable(plusFolder,5);
        clickOnElement(plusFolder);
        Assert.assertEquals(createFolderPopUpHeaderText.getText(),actual_CreateFolderPopupHeader);
        enterIntoElement(folderNameTextField,folderName);

        try{
            clickOnElement(chooseFolderBtn);
            Assert.assertEquals(selectFolderPopupText.getText(),"Select Folder");
            clickOnElement(rootFolderRadioButton);
            wait_elementToBeClickable(selectButton,5);
            clickOnElement(selectButton);
            wait_Element_To_Be_Visual(selectedFolder,3);
            Assert.assertEquals(selectedFolder.getText(),"Root Folder");
            clickOnElement(folderCreateButton);
            wait_Element_To_Be_Visual(testDataTosterMessage,5);
            Assert.assertEquals(testDataTosterMessage.getText(),actualConfirmationMessage);
            wait_InVisualityOfElement(testDataTosterMessage,5);
            wait_elementToBeClickable(createdFolderExpander,5);
            clickOnElement(createdFolderExpander);
            wait_Elements_To_Be_Visual(createdFolderList,5);

            for(WebElement folder: createdFolderList){
                boolean folderFlag = false;
                if(folder.getText().equalsIgnoreCase(folderName)){
                    folderFlag = true;
                    System.out.println(folderName + " Created Successfully");

                }


            }
        }catch(NoSuchElementException exe){
            clickOnElement(folderCreateButton);
            wait_Element_To_Be_Visual(testDataTosterMessage,5);
            Assert.assertEquals(testDataTosterMessage.getText(),actualConfirmationMessage);
            wait_elementToBeClickable(createdFolderExpander,5);
            clickOnElement(createdFolderExpander);
            wait_Elements_To_Be_Visual(createdFolderList,5);

            for(WebElement folder: createdFolderList){
                boolean folderFlag = false;
                if(folder.getText().equalsIgnoreCase(folderName)){
                    folderFlag = true;
                    System.out.println(folderName + " Created Successfully");

                }
        }
            wait_InVisualityOfElement(testDataTosterMessage,5);


    }


}

public void addAFileToFolder(String createdFolderName){
WebElement createdFolder= driver.findElement(By.xpath("//button[@class='add-btn']/../..//span[text()='"+ createdFolderName +"']"));
mouse_Hover_Action(createdFolder).click();


}
}

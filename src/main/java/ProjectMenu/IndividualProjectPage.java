package ProjectMenu;

import BasePackage.Libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IndividualProjectPage extends Libraries {

public WebDriver driver;

    public IndividualProjectPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[contains(@class,'project_label')]")
    WebElement projectDetails;

    @FindBy(xpath = "//label[text()='Name'] /following-sibling:: label")
    WebElement createdProject;

    @FindBy(xpath = "//label[text()='Type'] /following-sibling:: label")
    WebElement createdProjectType;

    @FindBy(xpath="//button[contains(text(),'Edit')]")
    WebElement editButton;

    @FindBy(css="#projectName")
    WebElement nameTextField;

    @FindBy(xpath = "//span[contains(@class,'slider1 ')]")
    WebElement toggleSlider;

    @FindBy(xpath = "//button[text()='Change']")
    WebElement changeButton;

    @FindBy(css="#buttonId")
    WebElement updateButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement updateTosterMessage;
    @FindBy(xpath = "//li[contains(@aria-label,'Project Selected')]")
    WebElement selectedProject_leftnav;

    @FindBy(xpath = "//span[text()='All Projects']")
    WebElement allProjectsOption;



    public void validate_Created_Project( String createdProjectName, String createdProjectTypeName){
        wait_elementToBeClickable(editButton , 10);
        Assert.assertEquals(createdProject.getText(),createdProjectName);
        Assert.assertEquals(createdProjectType.getText(),createdProjectTypeName);
    }

    public void editProjectFromIndividualProjectLevel(String projectNeedToBeEdited, String expectedUpdateProjectTosterMessage){
        clickOnElement(editButton);
        wait_elementToBeClickable(updateButton,5);
       //    nameTextField.sendKeys(Keys.chord(Keys.CONTROL+"A"));
        nameTextField.clear();
        enterIntoElement(nameTextField,projectNeedToBeEdited+"s");
        clickOnElement(updateButton);
        wait_textToBePresentInElement(updateTosterMessage,5,expectedUpdateProjectTosterMessage);
      //  Assert.assertEquals( updateTosterMessage.getText(), expectedUpdateProjectTosterMessage);

    }

    public void closeProjectFromIndividualProjectLevel(){
        clickOnElement(editButton);
        wait_elementToBeClickable(toggleSlider,10);
        clickOnElement(toggleSlider);
        clickOnElement(changeButton);
        clickOnElement(updateButton);
    }



    public void navigate_ToProjectsListPage(){
        clickOnElement(selectedProject_leftnav);
        clickOnElement(allProjectsOption);
       // driver.navigate().refresh();


    }



}
package ProjectMenu;

import BasePackage.Libraries;
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

    @FindBy(xpath = "//li[contains(@aria-label,'Project Selected')]")
    WebElement selectedProject_leftnav;

    @FindBy(xpath = "//span[text()='All Projects']")
    WebElement allProjectsOption;



    public void validate_Created_Project( String createdProjectName, String createdProjectTypeName){
     //   Assert.assertEquals(projectDetails.getText(),createdProjectName);
        Assert.assertEquals(createdProject.getText(),createdProjectName);
        Assert.assertEquals(createdProjectType.getText(),createdProjectTypeName);
    }

    public void navigate_ToProjectsListPage(){
        clickOnElement(selectedProject_leftnav);
        clickOnElement(allProjectsOption);
       // driver.navigate().refresh();


    }



}

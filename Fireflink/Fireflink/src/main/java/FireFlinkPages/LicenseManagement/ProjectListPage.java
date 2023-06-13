package FireFlinkPages.LicenseManagement;

import BasePackage.Libraries;
import ProjectMenu.CreateProjectPage;
import ProjectMenu.EditProjectPage;
import ProjectMenu.IndividualProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProjectListPage extends Libraries {
   public WebDriver driver;
    ProjectListPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//p[contains(text(),'Quick Start')]")
    WebElement quickStart;

    @FindBy(xpath = "//p[contains(text(),'Quick Start')]/..//button")
    WebElement center_projectButton;


    @FindBy(xpath ="//label[contains(@class,'project_label')]/..//button")
    WebElement projectButton;



    @FindBy(xpath ="//span[text()='Project']")
    WebElement projectSection_Leftnav;

    @FindBy(xpath="//a[contains(@class,'hyper_link')]//span")
    List<WebElement> projectsList;

    // Don't use anywhere
    @FindBy(xpath="//span[text()='{{@projectName}}']/../../..//span[@data-title='Edit']")
   WebElement projectEditIcon;

    // Don't use anywhere
    @FindBy(xpath = "//button[contains(@class,'delete-style')]")
    List<WebElement> deleteProjectIcon;
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteProjectButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement deleteProjectTosterMessage;

    //div[contains(@class,'alert')]


    @FindBy(xpath = "//span[text()='License']")
    WebElement license_Management;

    @FindBy(css = "#user-profile")
    WebElement userProfile;

    @FindBy(xpath = "//li[contains(text(),'Sign out')]")
    WebElement signOutButton;


    @FindBy(xpath="//button[contains(@class,'switch-license-dropdown')]//span//span")
    WebElement selectedLicense;

    public void validate_QuickStartButton(String expectedstring ){

        Assert.assertEquals(quickStart.getText(),expectedstring);
    }

   public CreateProjectPage navigateTo_createProjectPage(){
        wait_elementToBeClickable(projectButton,5);
        clickOnElement(projectButton);
       CreateProjectPage createPro = new CreateProjectPage(driver);
       return createPro;

   }

   public EditProjectPage navigateToEditProjectPage(String createdProjectName){
        for(WebElement project : projectsList){
         if(project.getText().equalsIgnoreCase(createdProjectName)){
               mouse_Hover_Action(driver.findElement(By.xpath("//span[text()='"+ createdProjectName +"']/../../..//span[@data-title='Edit']"))).click().build().perform();
                break;
            }

        }
       EditProjectPage editProject = new EditProjectPage(driver);
        return editProject;

   }


   public IndividualProjectPage navigate_Individual_ProjectSection(){
        // wait_elementToBeClickable(projectSection_Leftnav,15);

        mouse_Hover_Action(projectSection_Leftnav).click().build().perform();

       IndividualProjectPage iproject = new IndividualProjectPage(driver);
      return  iproject;

   }




    public void deleteProject(String deleteProjectName,String expectedTosterMessage){
        try {
            wait_Elements_To_Be_Visual(projectsList, 5);
        }
        catch(Exception exe){

        }
        for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(deleteProjectName)){
                mouse_Hover_Action(project);
                    WebElement projectToBeDelete = driver.findElement(By.xpath("//span[text()='"+ deleteProjectName +"']/../../..//button[contains(@class,'delete-style')]"));
                   // wait_elementToBeClickable(projectToBeDelete,5);
                    javaScriptClick(projectToBeDelete);
                break;
            }
            clickOnElement(deleteProjectButton);
        }

        wait_textToBePresentInElement(deleteProjectTosterMessage,30,expectedTosterMessage);

      /*  for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(deleteProjectName)){
                System.out.println("Project is not deleted successfully");
            }
            else{
                System.out.println("Project is deleted successfully");
            }

        } */

    }

    public void openProjectDeletion(String deleteProjectName){
            wait_Elements_To_Be_Visual(projectsList, 10);
        for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(deleteProjectName)){
                WebElement projectToBeDeleteIcon = driver.findElement(By.xpath("//span[text()='"+ deleteProjectName +"']/../../..//button[contains(@class,'delete-style')]"));
                Assert.assertFalse(projectToBeDeleteIcon.isEnabled());
            }
            else{
                System.out.println("Searching project is not available in project list");
            }
        }
    }


    public LicensePage navigateTo_License_Management(){
        wait_elementToBeClickable(license_Management,5);
        clickOnElement(license_Management);
        LicensePage license = new LicensePage(driver);

        return license;
    }

    public void sign_Out(){
        clickOnElement(userProfile);
        clickOnElement(signOutButton);

    }
}

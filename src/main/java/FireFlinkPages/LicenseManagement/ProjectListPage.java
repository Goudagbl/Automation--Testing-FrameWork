package FireFlinkPages.LicenseManagement;

import BasePackage.Libraries;
import ProjectMenu.*;
import Repository.RepoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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



    @FindBy(xpath ="//div[@class='MuiListItemText-root css-1nmt8ps']//span[text()='Project']")
    WebElement projectSection_Leftnav;

    @FindBy(xpath ="//span[text()='Repository']")
    WebElement repo_Leftnav;



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

    @FindBy(xpath = "//label[text()='Add to Archive']")
    WebElement addToArchie;

    @FindBy(xpath = "//label[text()='Add to UnArchive']")
    WebElement addToUnArchive;

    @FindBy(xpath= "//a[text()='Users' or href = '/projectmenu/use']")
    WebElement usersTab;


    @FindBy(xpath = "//label[contains(@class,'project_label')]")
    WebElement userTabLabel;

    @FindBy(xpath= "//a[@href='/projectmenu/role' or text() = Roles]")
    WebElement rolesTab;

    @FindBy(xpath= " //label[contains(@class,'project_label') or text() ='Roles List']")
    WebElement rolesTabLabel;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement deleteProjectTosterMessage;

    //div[contains(@class,'alert')]
    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement archiveProjectTosterMessage;

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
        wait_elementToBeClickable(projectButton,10);
        clickOnElement(projectButton);
       CreateProjectPage createPro = new CreateProjectPage(driver);
       return createPro;

   }

   public EditProjectPage navigateToEditProjectPage(String createdProjectName){

       try {
            wait_Elements_To_Be_Visual(projectsList, 5);
        }
        catch (StaleElementReferenceException exe){

        }
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
        driver.findElement(By.xpath("//a[text()='Execution Dashboard']")).click();
        wait_elementToBeClickable(projectSection_Leftnav,10);
        mouse_Hover_Action(projectSection_Leftnav).doubleClick().build().perform();
       IndividualProjectPage iproject = new IndividualProjectPage(driver);
      return  iproject;

   }

    public RepoPage navigateToRepository(){
            clickOnElement(repo_Leftnav);
        RepoPage repo = new RepoPage(driver);
        return repo;
    }



    public void deleteProject(String deleteProjectName,String expectedTosterMessage){

        avoidStalenessOfWebElement(projectButton);

       /* try {
            wait_Elements_To_Be_Visual(projectsList, 5);
        }
        catch(StaleElementReferenceException exe){
        }

        */


      for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(deleteProjectName)){
                   mouse_Hover_Action(project);
                    WebElement projectToBeDelete = driver.findElement(By.xpath("//span[text()='"+ deleteProjectName +"']/../../..//button[contains(@class,'delete-style')]"));
               //     wait_elementToBeClickable(projectButton,5);
                    javaScriptClick(projectToBeDelete);
                  clickOnElement(deleteProjectButton);
                break;
            }
        }
        wait_textToBePresentInElement(deleteProjectTosterMessage,40,expectedTosterMessage);
        System.out.println(deleteProjectName +" Project deleted successfully");

       /*
         avoidStalenessOfWebElement(projectButton);
      try{
          wait_Elements_To_Be_Visual(projectsList,5);
      }catch(StaleElementReferenceException exe){

      }
      for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(deleteProjectName)){
                System.out.println(project.getText() + " Project is not deleted successfully");
                Assert.assertTrue(false);
            }
        }

        */

    }

    public void openProjectDeletion(String deleteProjectName){
            wait_Elements_To_Be_Visual(projectsList, 5);
        for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(deleteProjectName)){
                WebElement projectToBeDeleteIcon = driver.findElement(By.xpath("//span[text()='"+ deleteProjectName +"']/../../..//button[contains(@class,'delete-style')]"));
                Assert.assertFalse(projectToBeDeleteIcon.isEnabled());
                System.out.println(deleteProjectName + " is open & user can't delete it");
            }
        }
    }

    public void validating_ClosedProject(String closedProjectName){
        for(WebElement project : projectsList){
            if(project.getText().equalsIgnoreCase(closedProjectName)){
                WebElement projectSupposeToHaveClosedText = driver.findElement(By.xpath("//span[text()='"+ closedProjectName +"']/../../..//div[@class='float-left ml-4 fontPoppinsRegularMd']"));
               Assert.assertTrue (projectSupposeToHaveClosedText.getText().contains("Closed"));
               System.out.println(project.getText()+ " Project is Closed Successfully");
            }
        }
    }
    public void archiveProject(String closedProjectName, String expectedArchieTosterMessage){
        WebElement moreIcon = driver.findElement(By.xpath("//span[text()='"+closedProjectName+"']/../../..//div[@id='more']"));
        mouse_Hover_Action(driver.findElement(By.xpath("//span[text()='"+closedProjectName+"']"))).build().perform();
        mouse_Hover_Action(moreIcon).click().build().perform();
        WebElement archivedButton = driver.findElement(By.xpath("//span[text()='"+closedProjectName+"']/../../..//label[text()='Add to Archive']"));
        wait_elementToBeClickable(archivedButton,5);
        mouse_Hover_Action(archivedButton).click().build().perform();
        wait_textToBePresentInElement(archiveProjectTosterMessage,15,expectedArchieTosterMessage);
    }

    public UsersPage navigateToUserTab(String expectedString){
        clickOnElement(usersTab);
        try{
            Assert.assertEquals(userTabLabel.getText(),expectedString);
        }
        catch(StaleElementReferenceException exe){

        }
        UsersPage user = new UsersPage(driver);
        return user;


    }

    public RolesPage navigateToRolesTab(String expectedString) {
        clickOnElement(rolesTab);
        avoidStalenessOfWebElement(rolesTabLabel);
        Assert.assertEquals(rolesTabLabel.getText(), expectedString);
        RolesPage role = new RolesPage(driver);
        return role ;
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

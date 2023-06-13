package AutomationScripts;

import BasePackage.BaseTest;
import FireFlinkPages.LicenseManagement.ProjectListPage;
import ProjectMenu.CreateProjectPage;
import ProjectMenu.TestDevlopmentPage;
import ProjectMenu.IndividualProjectPage;
import ProjectMenu.EditProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectMenu extends BaseTest {

     String webProjectName = "Ajio-" + randomNumberGenerator();
     String projectType = "Web";
     String wProjectDescription = "This web type of project ";

    String webserviceName = "postman-" +randomNumberGenerator();
    String webServiceprojectType = "Web Services";
    String webServiceprojectDescription = "This Web Services type of project ";


    String salesforceName = "CRM-"+ randomNumberGenerator();
    String salesforceprojectType = "Salesforce";
    String salesforceprojectDescription = "This  salesforce type of project ";

    String nativeAndroidProjectName = "PhonePayAndroid-"+ randomNumberGenerator();
    String nativeAndroidProjectType = "Mobile";
    String nativeAndroidProjectDescription = "This nativeAndroidProject type of project ";



    String nativeIosProjectName = "PhonePayIos-"+ randomNumberGenerator();
    String nativeIosProjectType = "Mobile";
    String nativeIosProjectDescription = "This nativeIosProject type of project ";

    String nativeAndroidAndIosProjectName = "PhonePayAndroidAndIos-"+ randomNumberGenerator();
    String nativeAndroidAndIosProjectType = "Mobile";
    String nativeAndroidAndIosDescription = "This  nativeAndroidAndIos type of project ";



   String  hybridAndroidProjectName = "bookMyShow-"+ randomNumberGenerator();
   String  hybridAndroidProjectType = "Mobile" ;
    String hybridAndroidProjectDescription = "This hybrid Android type of project" ;

    String  hybridIosProjectName = "bookMyShow-"+ randomNumberGenerator();
    String  hybridIosProjectType = "Mobile" ;
    String hybridIosProjectDescription = "This hybrid Ios  type of project" ;


    String  hybridAndroidAndIosProjectName = "bookMyShow-" +randomNumberGenerator();
    String  hybridAndroidAndIosProjectType = "Mobile" ;
    String hybridAndroidAndIosProjectDescription = "This hybrid Android And Ios  type of project" ;


    @Test()
    public void verify_QuickStart_Button(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        plist.validate_QuickStartButton("Quick Start");

    }
@Test()
    public void verify_userAble_to_Create_WebProject() throws InterruptedException {
    ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
    CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
    TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType, wProjectDescription);
    testDev.validate_userNavigated_TestDevSection("Scripts");
    IndividualProjectPage iproject =  plist.navigate_Individual_ProjectSection();
   //  Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'project_label')]")).getText(),"");
    iproject.validate_Created_Project(webProjectName,projectType);
    iproject.navigate_ToProjectsListPage();
    WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
    //  iproject.avoidStalenessOfWebElement(projectlist,8);
    Thread.sleep(10000);
    EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
    editProject.closeProject();
    plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }

@Test()
public void verify_userAble_to_Create_WebserviceProject() throws InterruptedException {
    ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
    CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
    TestDevlopmentPage testDev = createPro.create_Project(webserviceName,webServiceprojectType,webServiceprojectDescription);
    testDev.validate_userNavigated_TestDevSection("Scripts");
    IndividualProjectPage iproject =  plist.navigate_Individual_ProjectSection();
    //  Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'project_label')]")).getText(),"");
    iproject.validate_Created_Project(webserviceName,webServiceprojectType);
    iproject.navigate_ToProjectsListPage();
    WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
    //  iproject.avoidStalenessOfWebElement(projectlist,8);
    Thread.sleep(10000);
    EditProjectPage editProject = plist.navigateToEditProjectPage(webserviceName);
    editProject.closeProject();
    Thread.sleep(10000);
    plist.deleteProject(webserviceName, webserviceName + " Project deleted successfully");
}

@Test()
    public void verify_userAble_to_Create_SalesforceProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.create_Project(salesforceName,salesforceprojectType,salesforceprojectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject =  plist.navigate_Individual_ProjectSection();
        //  Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'project_label')]")).getText(),"");
        iProject.validate_Created_Project(salesforceName,salesforceprojectType);
        iProject.navigate_ToProjectsListPage();
        WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
    //  iProject.avoidStalenessOfWebElement(projectlist,8);
        Thread.sleep(10000);
        EditProjectPage editProject = plist.navigateToEditProjectPage(salesforceName);
        editProject.closeProject();
        plist.deleteProject(salesforceName, salesforceName + " Project deleted successfully");

    }


  @Test
    public void verify_userAble_to_Create_nativeAndroidMobileProject() throws InterruptedException {
      ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
      CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
      Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
      TestDevlopmentPage testDev = createPro.createNativeAndroidProject(nativeAndroidProjectName,nativeAndroidProjectType,nativeAndroidProjectDescription);
      testDev.validate_userNavigated_TestDevSection("Scripts");
      IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
      iProject.validate_Created_Project(nativeAndroidProjectName,nativeAndroidProjectType);
      iProject.navigate_ToProjectsListPage();
      WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
      // iProject.wait_Elements_To_Be_Visual(driver.findElements(projectlist);
      Thread.sleep(10000);
      EditProjectPage editProject = plist.navigateToEditProjectPage(nativeAndroidProjectName);
      editProject.closeProject();
      plist.deleteProject(nativeAndroidProjectName,nativeAndroidProjectName+ " Project deleted successfully");
    }


  @Test
    public void verify_userAble_to_Create_nativeIosPMobileProject() throws InterruptedException {
      ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
      CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
      Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
      TestDevlopmentPage testDev = createPro.createNativeIosProject(nativeIosProjectName,nativeIosProjectType,nativeIosProjectDescription);
      testDev.validate_userNavigated_TestDevSection("Scripts");
      IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
      iProject.validate_Created_Project(nativeIosProjectName,nativeIosProjectType);
      iProject.navigate_ToProjectsListPage();

      WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
      iProject.avoidStalenessOfWebElement(projectlist,10);
      // iProject.wait_Elements_To_Be_Visual(driver.findElements(By.xpath("//tr[contains(@class,'project-row')]")),10);
      Thread.sleep(10000);
      EditProjectPage editProject = plist.navigateToEditProjectPage(nativeIosProjectName);
      editProject.closeProject();
       plist.deleteProject(nativeIosProjectName,nativeIosProjectName+ " Project deleted successfully");

    }


    @Test
    public void verify_userAble_to_Create_nativeAndroidAndIosPMobileProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.createNativeAndroidAndIosProject(nativeAndroidAndIosProjectName,nativeAndroidAndIosProjectType,nativeAndroidAndIosDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(nativeAndroidAndIosProjectName,nativeAndroidAndIosProjectType);
        iProject.navigate_ToProjectsListPage();
        WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
       //iProject.avoidStalenessOfWebElement(projectlist,10);
        Thread.sleep(10000);
        EditProjectPage editProject = plist.navigateToEditProjectPage(nativeAndroidAndIosProjectName);
        editProject.closeProject();
        plist.deleteProject(nativeAndroidAndIosProjectName,nativeAndroidAndIosProjectName+ " Project deleted successfully");
    }


    @Test
    public void verify_userAble_to_Create_hybridAndroidMobileProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.createHybridAndroidProject(hybridAndroidProjectName,hybridAndroidProjectType,hybridAndroidProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(hybridAndroidProjectName,hybridAndroidProjectType);
        iProject.navigate_ToProjectsListPage();
        WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
       //  iProject.avoidStalenessOfWebElement(projectlist,5);
        Thread.sleep(10000);
        EditProjectPage editProject = plist.navigateToEditProjectPage(hybridAndroidProjectName);
        editProject.closeProject();
        plist.deleteProject(hybridAndroidProjectName,hybridAndroidProjectName+ " Project deleted successfully");
}

    @Test
    public void verify_userAble_to_Create_hybridIosMobileProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.createHybridIosProject(hybridIosProjectName,hybridIosProjectType,hybridIosProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(hybridIosProjectName,hybridIosProjectType);
        iProject.navigate_ToProjectsListPage();
        WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
       //  iProject.avoidStalenessOfWebElement(projectlist,5);
        Thread.sleep(10000);
        EditProjectPage editProject = plist.navigateToEditProjectPage(hybridIosProjectName);
        editProject.closeProject();
        plist.deleteProject(hybridIosProjectName,hybridIosProjectName+ " Project deleted successfully");
    }





    @Test
    public void verify_userAble_to_Create_hybridAndroidAndIosMobileProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.createHybridAndroidAndIosProject(hybridAndroidAndIosProjectName, hybridAndroidAndIosProjectType,hybridAndroidAndIosProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(hybridAndroidAndIosProjectName,hybridAndroidAndIosProjectType);
        iProject.navigate_ToProjectsListPage();
        WebElement projectlist= driver.findElement(By.xpath("//tr[contains(@class,'project-row')]"));
        iProject.avoidStalenessOfWebElement(projectlist,5);
        Thread.sleep(10000);
        EditProjectPage editProject = plist.navigateToEditProjectPage(hybridAndroidAndIosProjectName);
        editProject.closeProject();
        plist.deleteProject(hybridAndroidAndIosProjectName,hybridAndroidAndIosProjectName+ " Project deleted successfully");
    }


    @Test
    public void verify_userAble_to_ReopenWebProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType, wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject =  plist.navigate_Individual_ProjectSection();
        //  Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'project_label')]")).getText(),"");
        iproject.validate_Created_Project(webProjectName,projectType);
        iproject.navigate_ToProjectsListPage();
        Thread.sleep(10000);
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject();
        plist.navigateToEditProjectPage(webProjectName);
        editProject.reOpenProject();
    }

    @Test
    public void verify_userUnable_to_DeleteOpenProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType, wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject =  plist.navigate_Individual_ProjectSection();
        //  Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'project_label')]")).getText(),"");
        iproject.validate_Created_Project(webProjectName,projectType);
        iproject.navigate_ToProjectsListPage();
        Thread.sleep(10000);
        plist.openProjectDeletion(webProjectName);

    }



}

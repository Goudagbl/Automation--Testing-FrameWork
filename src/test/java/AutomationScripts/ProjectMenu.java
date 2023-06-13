package AutomationScripts;

import BasePackage.BaseTest;
import FireFlinkPages.LicenseManagement.ProjectListPage;
import ProjectMenu.CreateProjectPage;
import ProjectMenu.TestDevlopmentPage;
import ProjectMenu.IndividualProjectPage;
import ProjectMenu.EditProjectPage;
import ProjectMenu.UsersPage;
import ProjectMenu.RolesPage;
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

    String nativeAndroidProjectName = "PhoneAndroid-"+ randomNumberGenerator();
    String nativeAndroidProjectType = "Mobile";
    String nativeAndroidProjectDescription = "This nativeAndroidProject type of project ";



    String nativeIosProjectName = "PhoneIos-"+ randomNumberGenerator();
    String nativeIosProjectType = "Mobile";
    String nativeIosProjectDescription = "This nativeIosProject type of project ";

    String nativeAndroidAndIosProjectName = "PhoneoIos-"+ randomNumberGenerator();
    String nativeAndroidAndIosProjectType = "Mobile";
    String nativeAndroidAndIosDescription = "This  nativeAndroidAndIos type of project ";



   String  hybridAndroidProjectName = "bookMy-"+ randomNumberGenerator();
   String  hybridAndroidProjectType = "Mobile" ;
    String hybridAndroidProjectDescription = "This hybrid Android type of project" ;

    String  hybridIosProjectName = "bookMy-"+ randomNumberGenerator();
    String  hybridIosProjectType = "Mobile" ;
    String hybridIosProjectDescription = "This hybrid Ios  type of project" ;


    String  hybridAndroidAndIosProjectName = "bookMy-" +randomNumberGenerator();
    String  hybridAndroidAndIosProjectType = "Mobile" ;
    String hybridAndroidAndIosProjectDescription = "This hybrid Android And Ios  type of project" ;


    String WebMobileprojectName = "Cultfit-"+ randomNumberGenerator();
    String  WebMobileProjectType = "Web & Mobile" ;

    String WebandMobileProjectDescription = "This Web and Mobile of project";



    String emailId = "Gouda" + randomNumberGenerator()+"@gmail.com";

    String privilegeType = "Admin";

    String userName = "Gouda" +randomNumberGenerator();

    String roleValue = "SystemAdmin" + randomNumberGenerator();



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
    iproject.validate_Created_Project(webProjectName,projectType);
    iproject.navigate_ToProjectsListPage();
    EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
    editProject.closeProject(webProjectName + " Project updated successfully");
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
    iproject.validate_Created_Project(webserviceName,webServiceprojectType);
    iproject.navigate_ToProjectsListPage();

    EditProjectPage editProject = plist.navigateToEditProjectPage(webserviceName);
    editProject.closeProject(webserviceName + " Project updated successfully");
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
        iProject.validate_Created_Project(salesforceName,salesforceprojectType);
        iProject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(salesforceName);
        editProject.closeProject( salesforceName+ " Project updated successfully");
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
      EditProjectPage editProject = plist.navigateToEditProjectPage(nativeAndroidProjectName);
      editProject.closeProject(nativeAndroidProjectName +" Project updated successfully" );
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
      EditProjectPage editProject = plist.navigateToEditProjectPage(nativeIosProjectName);
      editProject.closeProject(nativeIosProjectName + " Project updated successfully");
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
        EditProjectPage editProject = plist.navigateToEditProjectPage(nativeAndroidAndIosProjectName);
        editProject.closeProject(nativeAndroidAndIosProjectName + " Project updated successfully");
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
        EditProjectPage editProject = plist.navigateToEditProjectPage(hybridAndroidProjectName);
        editProject.closeProject(hybridAndroidProjectName + " Project updated successfully");
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
        EditProjectPage editProject = plist.navigateToEditProjectPage(hybridIosProjectName);
        editProject.closeProject(hybridIosProjectName + " Project updated successfully");
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
        EditProjectPage editProject = plist.navigateToEditProjectPage(hybridAndroidAndIosProjectName);
        editProject.closeProject(hybridAndroidAndIosProjectName + " Project updated successfully");
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
        iproject.validate_Created_Project(webProjectName,projectType);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName+ " Project updated successfully");
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
        iproject.validate_Created_Project(webProjectName,projectType);
        iproject.navigate_ToProjectsListPage();
        plist.openProjectDeletion(webProjectName);

    }


    @Test
    public void verify_userAble_to_ArchiveClosedProjectAndDelete() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType, wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject =  plist.navigate_Individual_ProjectSection();
        //  Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'project_label')]")).getText(),"");
        iproject.validate_Created_Project(webProjectName,projectType);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.validating_ClosedProject(webProjectName);
        plist.archiveProject(webProjectName,webProjectName+" project has been Archived successfully");
        plist.deleteProject(webProjectName,webProjectName+" Project deleted successfully");

    }

    @Test
    public void verify_UserAble_to_EditProjectFromIndividualProjectLevel() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType, wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject =  plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        iproject.editProjectFromIndividualProjectLevel(webProjectName,webProjectName +"s Project updated successfully");
        iproject.closeProjectFromIndividualProjectLevel();

    }


    @Test
    public void verify_UserAble_to_createWebAndMobileTypeOfProject() throws InterruptedException{
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        TestDevlopmentPage testDev = createPro.createWebAndMobileProject(WebMobileprojectName,WebMobileProjectType,WebandMobileProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(WebMobileprojectName,WebMobileProjectType);
        iProject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(WebMobileprojectName);
        editProject.closeProject(WebMobileprojectName + " Project updated successfully");
        plist.deleteProject(WebMobileprojectName,WebMobileprojectName+ " Project deleted successfully");

    }

    @Test
    public void verify_userAble_to_CreateNewUser(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        UsersPage user=  plist.navigateToUserTab("Users List");
        user.createUser(emailId,privilegeType,userName, "Success.\n" +
                "Gouda User created successfully");

    }



    @Test
    public void verify_userAble_to_CreateRole(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        RolesPage role=  plist.navigateToRolesTab("Roles List");
        role.createARole(roleValue,"Success.\n" +
                "SystemAdmin Role created successfully");
    }





}

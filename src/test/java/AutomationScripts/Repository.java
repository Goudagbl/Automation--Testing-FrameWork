package AutomationScripts;

import BasePackage.BaseTest;
import FireFlinkPages.LicenseManagement.ProjectListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ProjectMenu.CreateProjectPage;
import ProjectMenu.TestDevlopmentPage;
import ProjectMenu.IndividualProjectPage;
import ProjectMenu.EditProjectPage;
import Repository.RepoPage;
import Repository.StepGroupsPage;


public class Repository extends BaseTest {
    String webProjectName = "Ajio-" + randomStringGenerator();
    String projectType = "Web";
    String wProjectDescription = "This web type of project ";

    String page = "Page-" + randomStringGenerator();
    String pageDescription = "Simple Description of " + page;
    String screen = "screen-" + randomStringGenerator();

    String screenDescription = "Simple Description of " + screen;




    String mobileProjectName = "Flipkart-" + randomStringGenerator();
    String MprojectType = "Mobile";
    String MProjectDescription = "This Native&Android type of project ";


    String WebMobileprojectName = "Cultfit-"+ randomStringGenerator();
    String  WebMobileProjectType = "Web & Mobile" ;

    String WebandMobileProjectDescription = "This Web and Mobile of project";



    String eleName = "element-" + randomStringGenerator();
    String elementType= "textfield";
    String locatorType = "Xpath";
    String valueType = "static";
    String locatorValue = "//span[text()='Create']";

    String parentLibrary = "Root Library";

    String stepGroupType = "Web";

    String stepGroupDescription = "webType of stepGroup this is ";



    @Test
    public void verify_userAble_to_CreatePage_And_AddElementInWebProject()  {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageForWebAndAddElement(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");

    }


    @Test
    public void verify_UserAble_to_CreateScreen_And_AddElementInMobileProject(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String mobileProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.createNativeAndroidProject(mobileProjectName,MprojectType,MProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(mobileProjectName,MprojectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createScreenForMobileAndAddElement(screen,eleName,elementType,locatorType,valueType,locatorValue,screenDescription);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(mobileProjectName);
        editProject.closeProject(mobileProjectName + " Project updated successfully");
        plist.deleteProject(mobileProjectName, mobileProjectName + " Project deleted successfully");

    }

    @Test()
    public void verify_UserAble_to_createPageAndScreenInWebAndMobileTypeProject() throws InterruptedException {
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String WebMobileprojectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.createWebAndMobileProject(WebMobileprojectName,WebMobileProjectType,WebandMobileProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(WebMobileprojectName,WebMobileProjectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageAndScreenForWebAndMobileProject(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue,screen,screenDescription);
        iProject.navigate_ToProjectsListPage();

        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");

    }

@Test
 public void verify_UserAble_to_MakeSharedElement() throws InterruptedException {
     ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
     CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
     Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
     String webProjectName = randomStringGenerator();
     TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
     testDev.validate_userNavigated_TestDevSection("Scripts");
     IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
     iproject.validate_Created_Project(webProjectName,projectType);
     RepoPage repo = plist.navigateToRepository();
     repo.createPageForWebAndAddElement(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue);
     repo.shareElement(page,eleName,elementType);
    iproject.navigate_ToProjectsListPage();
    EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
    editProject.closeProject(webProjectName + " Project updated successfully");
    plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }


    @Test
    public void verify_UserAble_to_AddElementsFrom_SharedElement(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageForWebAndAddElement(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue);
        repo.shareElement(page,eleName,elementType);
        repo.addElementFromSharedElement(randomStringGenerator(),pageDescription,"Root Page",eleName);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");

    }

    @Test
    public  void verify_UserAble_to_AddSubpageForCreatedPage(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String  webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageForWebAndAddElement(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue);
        repo.createSubPage(page,"Create Page",randomStringGenerator(),pageDescription,"Page created successfully");
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }

    @Test
    public void verify_UserAble_to_EditAnElement(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String  webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageForWebAndAddElement(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue);
        repo.editAnElement(page,eleName);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }


    @Test void verify_UserAble_to_DeleteAnElement(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String  mobileProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.createNativeAndroidProject(mobileProjectName,MprojectType,MProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(mobileProjectName,MprojectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createScreenForMobileAndAddElement(screen,eleName,elementType,locatorType,valueType,locatorValue,screenDescription);
        repo.deleteAnElement(screen,eleName,elementType);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }



    @Test
    public void verify_UserAble_to_EditCreatedPage(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String  WebMobileprojectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.createWebAndMobileProject(WebMobileprojectName,WebMobileProjectType,WebandMobileProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(WebMobileprojectName,WebMobileProjectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageAndScreenForWebAndMobileProject(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue,screen,screenDescription);
        String subScreen = randomStringGenerator();
        repo.createSubPage(screen,"Create Screen",subScreen,pageDescription,"Screen created successfully");
        repo.editCreatedPage(subScreen,"Edit Screen - " + subScreen, subScreen + "s Screen updated successfully");
        iProject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }


    @Test
    public void verify_UserAble_to_DeleteCreatedPage(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String  WebMobileprojectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.createWebAndMobileProject(WebMobileprojectName,WebMobileProjectType,WebandMobileProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iProject = plist.navigate_Individual_ProjectSection();
        iProject.validate_Created_Project(WebMobileprojectName,WebMobileProjectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageAndScreenForWebAndMobileProject(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue,screen,screenDescription);
        String subpage = randomStringGenerator();
        repo.createSubPage(screen,"Create Screen",subpage,pageDescription,"Screen created successfully");
        repo.deleteCreatedPage(subpage);
        WebElement repoTosterMessage = driver.findElement(By.xpath("//div[contains(@class,'message')]"));
        Assert.assertEquals(repoTosterMessage.getText().trim(),subpage + " Screen deleted successfully");
        iProject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }


    @Test
    public void verify_UserAble_to_EditSharedElement(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        repo.createPageForWebAndAddElement(page,pageDescription,eleName,elementType,locatorType,valueType,locatorValue);
        repo.shareElement(page,eleName,elementType);
        repo.editElementFromSharedElementPage(eleName,elementType);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }

    @Test
    public void verify_UserAble_to_CreateLibraryAddStepGroup(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        StepGroupsPage stepGroup  = repo.navigateStepGroupsPage();
        String libraryName =randomStringGenerator();
        stepGroup.createLibrary(libraryName,parentLibrary);
        stepGroup.addStepGroupTOLibrary(libraryName,randomStringGenerator(),stepGroupType,stepGroupDescription);
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }

    @Test
        public void verify_UserAble_to_ParametersAndVariableInStepGroup(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        RepoPage repo = plist.navigateToRepository();
        StepGroupsPage stepGroup  = repo.navigateStepGroupsPage();
        String libraryName =randomStringGenerator();
        stepGroup.createLibrary(libraryName,parentLibrary);
        stepGroup.addStepGroupTOLibrary(libraryName,randomStringGenerator(),stepGroupType,stepGroupDescription);
        stepGroup.navigateToParameter();
        stepGroup.createParameters(randomStringGenerator(),"BigDecimal");
        stepGroup.createVariable(randomStringGenerator(),randomStringGenerator());
        iproject.navigate_ToProjectsListPage();
        EditProjectPage editProject = plist.navigateToEditProjectPage(webProjectName);
        editProject.closeProject(webProjectName + " Project updated successfully");
        plist.deleteProject(webProjectName, webProjectName + " Project deleted successfully");
    }












}

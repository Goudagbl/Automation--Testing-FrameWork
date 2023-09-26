package AutomationScripts;

import BasePackage.BaseTest;
import FireFlinkPages.LicenseManagement.ProjectListPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ProjectMenu.*;
import TestData.*;




public class TestData extends BaseTest {


    String projectType = "Web";
    String wProjectDescription = "This web type of project ";


    TestdataPage testdata;
    String folderName;

    @Test
    public TestdataPage navigate_To_Testdata(){
        ProjectListPage plist = signIn.signInToFlinko(pro.getProperty("emailId"), pro.getProperty("Password"));
        CreateProjectPage createPro  = plist.navigateTo_createProjectPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'header-layout-style-project')]//label")).getText(),"Create Project");
        String webProjectName = randomStringGenerator();
        TestDevlopmentPage testDev = createPro.create_Project(webProjectName,projectType,wProjectDescription);
        testDev.validate_userNavigated_TestDevSection("Scripts");
        IndividualProjectPage iproject = plist.navigate_Individual_ProjectSection();
        iproject.validate_Created_Project(webProjectName,projectType);
        TestdataPage testdata = iproject.navigateToTestData();
        testdata.verify_UserNavigatedTO_TestDataSection("Test Data");
        return testdata;
    }
    @Test
    public void verify_UserAble_ToNavigate_TestDataSection(){
        testdata =  navigate_To_Testdata();

    }

    @Test
    public TestdataPage verify_userAble_ToCreate_Folder(){
       testdata =  navigate_To_Testdata();
       folderName = randomStringGenerator();
        testdata.createAFolder("Create Folder",folderName, folderName + " Folder created successfully");
        return testdata;

    }

    @Test
    public void verify_userAble_ToCreateMultipleFolder(){
      testdata = verify_userAble_ToCreate_Folder();
        String folderName = randomStringGenerator();
        testdata.createAFolder("Create Folder",folderName,folderName + " Folder created successfully");

    }


    @Test
    public void verify_UserAble_to_AddFile_ForCreatedFolder(){
        testdata = verify_userAble_ToCreate_Folder();
        testdata.addAFileToFolder(folderName);
    }



}

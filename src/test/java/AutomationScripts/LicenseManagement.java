package AutomationScripts;

import BasePackage.BaseTest;
import FireFlinkPages.LicenseManagement.BuyNewLicensePage;
import FireFlinkPages.LicenseManagement.ProjectListPage;
import FireFlinkPages.LicenseManagement.LicensePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LicenseManagement extends BaseTest {

@Test
    public void signInToFlinko(){
     signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    Assert.assertEquals(driver.getTitle(),"FireFlink");


}
@Test
    public void  navigate_To_LicenseManagement_Section(){
    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    home.navigateTo_License_Management();
    Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),"License Management");


}

@Test
    public void navigated_To_License_Management_Is_license_Selected_Default(){
    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    LicensePage license = home.navigateTo_License_Management();
    license.selected_As_Default();


}

@Test
public void user_Landing_To_The_Default_License(){
    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    LicensePage license = home.navigateTo_License_Management();
    license.set_License_AsDefault(pro.getProperty("licenseId"));
    home.sign_Out();
    signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    license.validate_LandedLicense(pro.getProperty("licenseId"));
    home.navigateTo_License_Management();
    license.set_License_AsDefault(pro.getProperty("Change_licenseId"));

}

@Test
    public void Validate_License_Information_Details_Getting_Displayed(){

    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    LicensePage license = home.navigateTo_License_Management();
   license.license_Information_Details_Getting_Displayed(pro.getProperty("Change_licenseId"));

}
@Test
    public void Validate_clickingOn_BuyNew_license_Will_Be_navigated_To_Buy_New_License_Page(){
     ProjectListPage home= signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
     LicensePage license = home.navigateTo_License_Management();
     license.navigateToBuyNewLicensePage();
     Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'license-form_form-layout__2xvqY')]/../h1")).getText(), "Buy New License");

}

@Test
    public void validate_SelectPlan_And_PaymentDetails_DisplayedIn_BuyNewLicensePage(){
    ProjectListPage home =signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    LicensePage license = home.navigateTo_License_Management();
    BuyNewLicensePage buyNewLic = license.navigateToBuyNewLicensePage();
    buyNewLic.tabsDisplayed();

}

@Test
public void validate_ByClicking_ManagedByText_UserInformation_Displayed() throws InterruptedException {
    LicensePage license = new LicensePage(driver);
   ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
  Thread.sleep(5000);
   if(driver.findElement(By.xpath("//p[text()='License Expired!']")).isDisplayed()){
       license.anyLicenseExpired(pro.getProperty("Change_licenseId"),pro.getProperty("Password"));
   }
    Assert.assertEquals(driver.getTitle(),"FireFlink");
  // driver.navigate().refresh();
    Thread.sleep(5000);
    home.navigateTo_License_Management();
    license.click_On_ManageBy(pro.getProperty("emailId"));

}

@Test
    public void validate_ByClicking_ActiveButton_ActiveStatus_license_Displayed() throws Throwable {
    LicensePage license = new LicensePage(driver);
    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    Assert.assertEquals(driver.getTitle(),"FireFlink");
    license.waitingForSection();
    home.navigateTo_License_Management();
    license.clinkOnActiveButton("ACTIVE");
}

@Test
  public void  validate_clicking_ExpiredButton_ExpiredStatus_LicenseDisplayed(){
    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    Assert.assertEquals(driver.getTitle(),"FireFlink");
    LicensePage license = home.navigateTo_License_Management();
    license.clinkOnExpireButton("EXPIRED");
}

@Test
    public void Validate_By_clicking_ClearFilter_TheApplied_Filter_Cleared() throws Throwable{
    ProjectListPage home = signIn.signInToFlinko(pro.getProperty("emailId"),pro.getProperty("Password"));
    Assert.assertEquals(driver.getTitle(),"FireFlink");
    LicensePage license =home.navigateTo_License_Management();
    license.clinkOnActiveButton("ACTIVE");
    license.wait_Element_To_Be_Visual(driver.findElement(By.xpath("//button[contains(@class,'licenses_active')]")),5);
    license.clickOnClearButton();
    Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class,'licenses_clear-filters-button')]")).isEnabled());
}

}

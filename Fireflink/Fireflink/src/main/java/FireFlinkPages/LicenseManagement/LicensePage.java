package FireFlinkPages.LicenseManagement;

import BasePackage.Libraries;
import FireFlinkPages.LicenseManagement.BuyNewLicensePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class LicensePage extends Libraries {

    public WebDriver driver;

    public LicensePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[text()='License']")
    WebElement licenseSection;

    @FindBy(xpath = "//div[contains(@class,'license-row-card_wrapper__WE3gS')]")
    List<WebElement> captured_All_License_Item;

    @FindBy(xpath = "//label[@class='license-row-card_radio-control__hnxMt']//input")
    List<WebElement> captured_All_LicenseRadioButton;

    @FindBy(xpath = "//button[@class='license-row-card_value__1wvzp overflow-hidden overflow-ellipsis whitespace-nowrap fontPoppinsRegularMd']")
    List<WebElement> captured_All_License_Buttons;
    @FindBy(xpath = "//button[contains(text(),'Change')]")
    WebElement captured_ChangeButton;

    @FindBy(xpath = "//button[contains(@class,'switch-license-dropdown')]//span//span")
    WebElement captured_selectedLicense;

    @FindBy(xpath = "//div[text()='License Information']")
    WebElement license_Information;
    @FindBy(xpath = "//p[text()='License Name']//following-sibling::p")
    WebElement license_Info_In_side_popup;
    @FindBy(xpath = "//*[@data-testid='ArrowBackIcon']")
    WebElement LicenseInfo_BackButton;

    @FindBy(partialLinkText = "Buy New License")
    WebElement buyNewLicenseButton;

    @FindBy(xpath = "//h1[text()='Buy New License']")
    WebElement buyNewLicenseText;

    @FindBy(xpath = "//div[@class='flex overflow-hidden overflow-ellipsis whitespace-nowrap']//button")
    List<WebElement> managed_By;
    //p[@class='-ml-7 text-black break-words']

    //div[contains(text(),'User Information')]
    @FindBy(xpath = "//div[contains(text(),'User Information')]")
    WebElement userInfoPopUp;
    @FindBy(xpath = "//p[@class='-ml-7 text-black break-words']")
    WebElement userMailId;


    @FindBy(xpath = "//h2[text()='Status']//following-sibling::span")
    List<WebElement> statusOfLic;

    //button[contains(@class,'licenses_active')]
    @FindBy(xpath = "//button[contains(@class,'licenses_active')]")
    WebElement filterActiveButton;

    @FindBy(xpath="//button[contains(@class,'licenses_expired')]")
    WebElement filterExpireButton;

    @FindBy(xpath ="//button[contains(@class,'licenses_clear-filters-button')]")
    WebElement filterClearButton;
    @FindBy(xpath = "(//*[@id='change_circle_black_24dp'])[2]")
    WebElement chaneLicenseIcon;

    //h1[text()='Select License']
    @FindBy(xpath = "//h1[text()='Select License']")
    WebElement selectLicensePopup;
    @FindBy(css = "#selectBox")
    WebElement licenseNameDropdown;
    @FindBy(xpath = "//li[@id='sideLeft']//span[1]")
    List<WebElement> availLicense;

    @FindBy(xpath = "//div[contains(@class,'footerForSelectLicense')]//button[text()='Done']")
    WebElement doneButton;


    @FindBy(xpath = "//h1[text()='Switch License']")
    WebElement switchLicensePopup;

    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[text()='Switch License']")
    WebElement switchLicenseButton;





    public void selected_As_Default() {
        wait_Elements_To_Be_Visual(captured_All_License_Item, 5);
        for (WebElement element : captured_All_License_Item) {
            Boolean value = element.isSelected();
            System.out.println(value);

           /* if(element.isSelected()){
           return driver.findElement(By.xpath("//button[contains(@aria-label,'fire-flink')]")).getText();

            }

            */
        }
    }

    public void set_License_AsDefault(String defaultLicense) {
        wait_Elements_To_Be_Visual(captured_All_License_Item,5);
        for (WebElement radioButton : captured_All_LicenseRadioButton) {
            System.out.println(radioButton.getAttribute("id"));
            if (Objects.equals(radioButton.getAttribute("id"), defaultLicense)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", radioButton);
                mouse_Hover_Action(radioButton).click(radioButton).build().perform();
                clickOnElement(captured_ChangeButton);
                break;
            }
        }

    }

    public void validate_LandedLicense(String landedLicense) {
/*
String selected_License=driver.findElement(By.xpath("//button[contains(@class,'switch-license-dropdown')]//span//span")).getText();
    selected_License.contains(pro.getProperty("licenseId"));
    System.out.println((selected_License.contains(pro.getProperty("licenseId"))));
 */
        wait_Element_To_Be_Visual(captured_selectedLicense,5);
        if (captured_selectedLicense.getText().contains(landedLicense)) {
            System.out.println(captured_selectedLicense.getText());

        }
    }

    public void license_Information_Details_Getting_Displayed(String chosenLicense) {
        wait_Elements_To_Be_Visual(captured_All_License_Item,5);
        for (WebElement licenseText : captured_All_License_Buttons) {
            mouse_Hover_Action(licenseText).click(licenseText).build().perform();
            wait_Element_To_Be_Visual(license_Information,5);
            System.out.println(license_Info_In_side_popup.getText());
            Assert.assertTrue(license_Info_In_side_popup.getText().contains(chosenLicense));
            mouse_Hover_Action(LicenseInfo_BackButton).click(LicenseInfo_BackButton).build().perform();
            break;

        }


    }

    public BuyNewLicensePage navigateToBuyNewLicensePage() {
        wait_elementToBeClickable(buyNewLicenseButton,5);
        clickOnElement(buyNewLicenseButton);
        wait_Element_To_Be_Visual(buyNewLicenseText,5);
        BuyNewLicensePage buynewli = new BuyNewLicensePage(driver);
        return buynewli;
    }

    public void anyLicenseExpired(String Change_licenseId, String passwordValue) {
        if (!(filterActiveButton.isSelected())) {
            mouse_Hover_Action(chaneLicenseIcon).click().build().perform();
            wait_Element_To_Be_Visual(selectLicensePopup,5);
            mouse_Hover_Action(licenseNameDropdown).click().build().perform();
            wait_Elements_To_Be_Visual(availLicense,5);
            for (WebElement element : availLicense) {
                if (element.getText().contains(Change_licenseId)) {
                    mouse_Hover_Action(element).click().build().perform();
                }

            }
            clickOnElement(doneButton);
            wait_Element_To_Be_Visual(switchLicensePopup,5);
            enterIntoElement(password, passwordValue);
            clickOnElement(switchLicenseButton);
        }
    }

    public void waitingForSection() {
        wait_elementToBeClickable(licenseSection,5);
    }

    public void click_On_ManageBy(String user_mailId) {
        wait_Elements_To_Be_Visual(managed_By,5);
        for (WebElement manage : managed_By) {
            //String ownerName = manage.getText();
            clickOnElement(manage);
            wait_Element_To_Be_Visual(userInfoPopUp,5);
            Assert.assertTrue(userMailId.getText().equals(user_mailId));
            clickOnElement(LicenseInfo_BackButton);
            wait_Elements_To_Be_Visual(managed_By,5);
        }

    }

    public void clinkOnActiveButton(String licenseStatus) throws Throwable {
        wait_Elements_To_Be_Visual(captured_All_License_Item,5);
        clickOnElement(filterActiveButton);
        Thread.sleep(5000);
        for(WebElement element : statusOfLic){
            Assert.assertEquals(element.getText(),licenseStatus);

        }



    }


    public void clinkOnExpireButton(String licenseStatus){
        wait_Elements_To_Be_Visual(captured_All_License_Item,5);
        clickOnElement(filterExpireButton);
        wait_Elements_To_Be_Visual(captured_All_License_Item,5);
        for(WebElement element : statusOfLic){
            Assert.assertEquals(element.getText(),licenseStatus);

        }



    }


    public void clickOnClearButton(){
        clickOnElement(filterClearButton);
    }
}

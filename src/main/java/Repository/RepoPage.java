package Repository;

import BasePackage.Libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.lang.model.util.Elements;
import java.util.List;

public class RepoPage extends Libraries {
    WebDriver driver;
    public RepoPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(this.driver,this);

    }

    @FindBy(xpath = "//label[text()='Project Elements']")
    WebElement projectElements;

    @FindBy(css = "#createcontainerbutton")
    WebElement addPage;

    @FindBy(css = "#createcontainerbutton")
    WebElement addScreen;

    @FindBy(xpath = "//h2[@class='title']")
    WebElement createPagePopup;

    @FindBy(css = "#pageName")
    WebElement pageNameTextField;

    @FindBy(css = "#description")
    WebElement pageDescription;

    @FindBy(xpath = "//div[@aria-haspopup='listbox']")
    WebElement pageDropDown;

    @FindBy(xpath = "//li[text()='Web']")
    WebElement webType;

    @FindBy(xpath = "//li[text()='Android']")
    WebElement androidType;

    @FindBy(xpath = "//li[text()='MobileWeb']")
    WebElement mobileWeb;
    @FindBy(xpath = "//div[@class='py-2']//button")
    WebElement choosePage;

    @FindBy(xpath = "//span[contains(@class,'Popup-header')]")
    WebElement selectPage;


   @FindBy(css = "#rootRB")
   WebElement rootPageRadioButton;

    @FindBy(xpath = "//button[text()='Select']")
    WebElement selectButton;

    @FindBy(xpath = "//div[@class='popup-input-bg']//p")
    WebElement selectedPage;



    @FindBy(xpath = "//span[text()='Create']")
    WebElement pageCreateButton;
    @FindBy(xpath = " //button[@title='Add Page']")
    WebElement addPageButton;

    @FindBy(xpath = "//button[text()='Add Element']")
    WebElement addElementButton;
    @FindBy(xpath = "//button[text()='Add Manually']")
    WebElement addManually;

    @FindBy(xpath = "//button[text()='Add from shared Elements']")
    WebElement addFromSharedElement;

    //h2[@class='title']

    @FindBy(xpath = "//h2[@class='title']")
    WebElement CreateElementPopupHeaderText;

    @FindBy(xpath = "//input[@name='elementName']")
    WebElement elementName;

    @FindBy(xpath = "//div[contains(@id,'-select-elementTypes')]")
    WebElement elementTypeDropDown;

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> elementTypes;

    @FindBy(xpath = "//div[@class='popup-input-bg']//p")
    WebElement validatePageInCreateElementPopup;

    @FindBy(xpath = "//div[contains(text(),'Select locators type')]")
    WebElement selectLocatorDropdown;

    @FindBy(xpath = "//li[@role='option']")
   List <WebElement> locatorsTypes;

    @FindBy(xpath = "//div[text()='Select value type']")
    WebElement valueDropdown;

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> valueTypes;

    @FindBy(xpath = "//input[@placeholder='Enter locator value']")
    WebElement locatorTextField;

    @FindBy(xpath = "//span[text()='Create']")
    WebElement elementCreateButton;

    @FindBy(xpath = "//*[@id='account_tree_black_48dp']")
    WebElement elementExpandIcon;

    // below dropdown for to access shared elements & Projects elements
    @FindBy(xpath = "//img[contains(@alt,'DropDownArrow')]")
    WebElement elementsDropdown;

    @FindBy(xpath = "//label[@role='menuitem']")
   List <WebElement> projectElementsAndSharedElementOptions;

    @FindBy(xpath = "//span[contains(@class,'pageHeading')]")
    WebElement sharedElements;

    @FindBy(xpath = "//tr[@role='row']//div[contains(@class,'fontPoppinsRegularMd ')]")
   List <WebElement> listOfSharedElements;

    @FindBy(xpath = "//div[contains(@class,'message')]")
    WebElement repoTosterMessage;





    public void createPageForWebAndAddElement(String pageName, String ExpectedPageDescription,String eleName,String elementType, String locatorType,String valueType, String locatorValue){
        Assert.assertEquals(projectElements.getText(),"Project Elements");
        wait_elementToBeClickable(addPage,5);
        clickOnElement(addPage);
        Assert.assertEquals(createPagePopup.getText(),"Create Page");
        enterIntoElement(pageNameTextField,pageName);
        enterIntoElement(pageDescription,ExpectedPageDescription);
        clickOnElement(pageCreateButton);
        wait_Element_To_Be_Visual(repoTosterMessage,5);
        Assert.assertEquals(repoTosterMessage.getText().trim(),pageName +  " Page created successfully");
        wait_InVisualityOfElement(repoTosterMessage,5);
        navigateToCreateElementPopup(pageName);
        Assert.assertEquals(CreateElementPopupHeaderText.getText(),"Create Element");
        enterIntoElement(elementName,eleName);
        clickOnElement(elementTypeDropDown);
        wait_Elements_To_Be_Visual(elementTypes,3);
        for(WebElement eleType: elementTypes) {
            if (eleType.getText().equalsIgnoreCase(elementType)) {
                wait_elementToBeClickable(eleType, 3);
                eleType.click();
                break;
            }
        }
            Assert.assertEquals(validatePageInCreateElementPopup.getText().trim(), pageName);
            clickOnElement(selectLocatorDropdown);
            wait_Elements_To_Be_Visual(locatorsTypes, 3);
            for (WebElement loType : locatorsTypes) {
                if (loType.getText().equalsIgnoreCase(locatorType)) {
                    wait_elementToBeClickable(loType, 3);
                    clickOnElement(loType);
                    break;
                }

            }
            avoidStalenessOfWebElement(valueDropdown).click();
            wait_Elements_To_Be_Visual(valueTypes, 3);
            for (WebElement value : valueTypes) {
                if (value.getText().equalsIgnoreCase(valueType)) {
                    wait_elementToBeClickable(value, 3);
                    clickOnElement(value);
                    break;

                }
            }

            enterIntoElement(locatorTextField, locatorValue);
            clickOnElement(elementCreateButton);
            wait_Element_To_Be_Visual(repoTosterMessage, 10);
            Assert.assertEquals(repoTosterMessage.getText().trim(),eleName + " "+ elementType + " created successfully");
            wait_InVisualityOfElement(repoTosterMessage,10);
        }


    public void createScreenForMobileAndAddElement(String screenName,String eleName,String elementType,String locatorType,String valueType,String locatorValue,String ExpectedScreenDescription){
        Assert.assertEquals(projectElements.getText(),"Project Elements");
        wait_elementToBeClickable(addScreen,5);
        clickOnElement(addScreen);
        Assert.assertEquals(createPagePopup.getText(),"Create Screen");
        enterIntoElement(pageNameTextField,screenName);
        enterIntoElement(pageDescription,ExpectedScreenDescription);
        clickOnElement(pageCreateButton);
        wait_Element_To_Be_Visual(repoTosterMessage,5);
        Assert.assertEquals(repoTosterMessage.getText().trim(),screenName +  " Screen created successfully");
        wait_InVisualityOfElement(repoTosterMessage,5);
        navigateToCreateElementPopup(screenName);
        Assert.assertEquals(CreateElementPopupHeaderText.getText(),"Create Element");
        enterIntoElement(elementName,eleName);
        clickOnElement(elementTypeDropDown);
        wait_Elements_To_Be_Visual(elementTypes,3);
        for(WebElement eleType: elementTypes) {
            if (eleType.getText().equalsIgnoreCase(elementType)) {
                wait_elementToBeClickable(eleType, 3);
                eleType.click();
                break;
            }
        }
        Assert.assertEquals(validatePageInCreateElementPopup.getText().trim(), screenName);
        clickOnElement(selectLocatorDropdown);
        wait_Elements_To_Be_Visual(locatorsTypes, 3);
        for (WebElement loType : locatorsTypes) {
            if (loType.getText().equalsIgnoreCase(locatorType)) {
                wait_elementToBeClickable(loType, 3);
                clickOnElement(loType);
                break;
            }

        }

        clickOnElement(valueDropdown);
        wait_Elements_To_Be_Visual(valueTypes, 3);
        for (WebElement value : valueTypes) {
            if (value.getText().equalsIgnoreCase(valueType)) {
                wait_elementToBeClickable(value, 3);
                clickOnElement(value);
                break;

            }
        }

        enterIntoElement(locatorTextField, locatorValue);
        clickOnElement(elementCreateButton);
        wait_Element_To_Be_Visual(repoTosterMessage, 10);
        Assert.assertEquals(repoTosterMessage.getText().trim(),eleName + " "+ elementType + " created successfully");
        wait_InVisualityOfElement(repoTosterMessage,10);
    }


    public void createPageAndScreenForWebAndMobileProject(String pageName, String ExpectedPageDescription,String eleName,String elementType, String locatorType,String valueType, String locatorValue,String ExpectedAndroidScreenName,String ExpectedAndroidScreenNameDescription) throws InterruptedException {
       clickOnElement(pageDropDown);
       clickOnElement(webType);
        createPageForWebAndAddElement(pageName,ExpectedPageDescription,eleName,elementType,locatorType,valueType, locatorValue);
       wait_elementToBeClickable(pageDropDown,5);
       mouse_Hover_Action(pageDropDown).build().perform();
        Thread.sleep(5000);
       clickOnElement(pageDropDown);
       clickOnElement(androidType);
        wait_elementToBeClickable(addScreen,5);
        createScreenForMobileAndAddElement(ExpectedAndroidScreenName,eleName,elementType,locatorType,valueType,locatorValue,ExpectedAndroidScreenNameDescription);
        wait_elementToBeClickable(pageDropDown,5);
        clickOnElement(pageDropDown);
        clickOnElement(mobileWeb);
       createScreenForMobileAndAddElement(ExpectedAndroidScreenName,eleName,elementType,locatorType,valueType,locatorValue,ExpectedAndroidScreenNameDescription);
    }

    public void navigateToCreateElementPopup(String CreatedPage){
        wait_elementToBeClickable(driver.findElement(By.xpath("//span[@class='fancytree-title ' and text()='"+CreatedPage+"']")),5);
        mouse_Hover_Action(driver.findElement(By.xpath("//span[@class='fancytree-title ' and text()='"+CreatedPage+"']"))).build().perform();
       WebElement add = driver.findElement(By.xpath("//span[@class='fancytree-title ' and text()='"+CreatedPage+"']/..//button[@class='add-btn']"));
       clickOnElement(add);
       wait_elementToBeClickable(addElementButton,3);
       mouse_Hover_Action(addElementButton).click().build().perform();
       wait_elementToBeClickable(addManually,3);
       mouse_Hover_Action(addManually).click().build().perform();

    }


    public void shareElement(String pageName,String eleName, String elementType){
        // wait_elementToBeClickable(elementExpandIcon,5);
       clickOnElement(elementExpandIcon);
       WebElement pageExpandIcon = driver.findElement(By.xpath("//span[text()='"+pageName+"']/../preceding-sibling :: span[@class='fancytree-expander']"));
       mouse_Hover_Action(pageExpandIcon).click().build().perform();
       wait_Element_To_Be_Visual(driver.findElement(By.xpath("//span[text()='"+eleName+"']")),5);
       WebElement shareIcon = driver.findElement(By.xpath("//span[text()='"+eleName+"']/../../..//span[@class='slider round']"));
       wait_elementToBeClickable(shareIcon,5);
       clickOnElement(shareIcon);
       wait_Element_To_Be_Visual(repoTosterMessage,15);
      // wait_textToBePresentInElement(repoTosterMessage,10,eleName + " " +elementType+ " has been shared to shared elements page successfully");
        wait_InVisualityOfElement(repoTosterMessage,10);
       clickOnElement(elementsDropdown);
       wait_Elements_To_Be_Visual(projectElementsAndSharedElementOptions,2);
       for(WebElement option : projectElementsAndSharedElementOptions){
           if(option.getText().contains("Shared Elements")){
               clickOnElement(option);
               break;
           }
       }
       Assert.assertEquals(sharedElements.getText(),"Shared Elements");
       wait_Elements_To_Be_Visual(listOfSharedElements,10);
       for(WebElement element : listOfSharedElements){
           // System.out.println(element.getText());
           if(element.getText().equalsIgnoreCase(eleName)){
        Assert.assertTrue(true);
        System.out.println(eleName + " is shared to shared element Page");
           }


       }

    }


    public void createPageByChosePage(String pageName,String ExpectedPageDescription,String parentPage){
        clickOnElement(addPage);
        Assert.assertEquals(createPagePopup.getText(),"Create Page");
        enterIntoElement(pageNameTextField,pageName);
        enterIntoElement(pageDescription,ExpectedPageDescription);
        clickOnElement(choosePage);
        if (selectPage.getText().contains("Select Page")){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
        clickOnElement(rootPageRadioButton);
        wait_elementToBeClickable(selectButton,3);
        Assert.assertEquals(selectedPage.getText(),parentPage);
        clickOnElement(pageCreateButton);
        Assert.assertEquals(repoTosterMessage.getText(),pageName + " Page created successfully");
    }

    public void addElementFromSharedElement(String pageName,String PageDescription,String parentPage){
        clickOnElement(elementsDropdown);
        wait_Elements_To_Be_Visual(projectElementsAndSharedElementOptions,3);
        for(WebElement option : projectElementsAndSharedElementOptions){
            if(option.getText().contains("Project Elements")){
                clickOnElement(option);
                break;

            }
        }
        Assert.assertEquals(projectElements.getText(),"Project Elements");
        wait_elementToBeClickable(addPage,5);
        createPageByChosePage(pageName,PageDescription,parentPage);





    }


}

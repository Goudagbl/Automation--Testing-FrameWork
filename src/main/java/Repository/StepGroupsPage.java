package Repository;

import BasePackage.Libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class StepGroupsPage extends Libraries {
WebDriver driver;
   public StepGroupsPage(WebDriver driver){
       super(driver);
      this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#createcontainerbutton")
    WebElement plusLibrary;

   @FindBy(xpath = "//h2[@class='title']")
    WebElement createLibraryText;

    @FindBy(css = "#libraryName")
    WebElement name;

    @FindBy(xpath = "//button[text()='Choose ']")
    WebElement chooseLibrary;

    @FindBy(xpath="//span[contains(@class,'Popup-header')]")
    WebElement selectLibraryText;

    @FindBy(css="#rootRB")
    WebElement rootLibrary;

    @FindBy(xpath = "//button[text()='Select']")
    WebElement select;

    @FindBy(xpath = "//p[contains(@class,'text-overflow-style')]")
    WebElement selectedParentLibrary;

    @FindBy(xpath = "//span[text()='Create']")
    WebElement create;

    @FindBy(xpath = "//div[contains(@class,'message')]")
    WebElement repoTosterMessage;

    @FindBy(xpath = "//span[@class='fancytree-title ']")
    List<WebElement> listOfLibraries;

    @FindBy(xpath = "//span[contains(@class,' absolute')]")
    WebElement libraryExpander;

    @FindBy(xpath = "//button[@title='Add Step Group']")
    WebElement addStepGroup;

    @FindBy(xpath = "//h2[@class='title']")
    WebElement createStepGroupPopUp;

    @FindBy(css="#name")
    WebElement stepGroupName;


    @FindBy(css="#type")
    WebElement stepGroupType;

    //#description
    @FindBy(xpath = "//li[@role='option']")
   List <WebElement> stepGroupTypeOptions;

    @FindBy(css="#description")
    WebElement stepGroupDescription;

    //#passMessage

    @FindBy(css="#passMessage")
    WebElement passMessageForStep;


    @FindBy(css=" #failMessage")
    WebElement failMessageForStep;


    @FindBy(xpath="//label[contains(@class,'project_label')]")
    WebElement stepGroupPageHeader;

    @FindBy(xpath = "//a[text()='Parameters']")
    WebElement parametersTab;


    @FindBy(xpath="//button[contains(@class,'primary-btn')]")
    WebElement plusParameter;

    @FindBy(xpath="//label[contains(@class,'project_label')]")
    WebElement parametersPageHeader;

    @FindBy(xpath="//h2[@class='title']")
    WebElement createParameterPopUpHeader;

    @FindBy(css="#name")
    WebElement parameterName;

    @FindBy(xpath = "//div[@role='button']")
    WebElement parameterTypeDropDown;

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> parameterTypes;

    @FindBy(xpath = "//button[@class='primary-btn']")
    WebElement createParameterButton;

    @FindBy(xpath = "//ul[contains(@class,'navBar')]//a[text()='Variables']")
    WebElement VariablesTab;

    @FindBy(xpath = "//label[contains(@class,'project_label')]")
    WebElement stepGroupVariableHeader;

    @FindBy(xpath="//label[contains(@class,'project_label')]/..//button[contains(text(),'Variable')]")
    WebElement plusVariable;

    @FindBy(xpath = "//h2[@class='title']")
    WebElement CreateStepGroupVariablePopUp;

    @FindBy(id="name")
    WebElement variableName;

    @FindBy(css="#mui-component-select-type")
    WebElement varTypeDropDown;


    @FindBy(id="value")
    WebElement variableValue;

    @FindBy(xpath = "//button[@class='primary-btn' or contains(text(),'Create')]")
    WebElement createVariable;














    public void createLibrary(String libraryName, String parentLibrary){
        wait_elementToBeClickable(plusLibrary,5);
        clickOnElement(plusLibrary);
        wait_Element_To_Be_Visual(createLibraryText,2);
        Assert.assertEquals(createLibraryText.getText(),"Create Library");
        enterIntoElement(name,libraryName);
        clickOnElement(chooseLibrary);
        wait_Element_To_Be_Visual(selectLibraryText,2);
        Assert.assertEquals(selectLibraryText.getText(),"Select Library");
        clickOnElement(rootLibrary);
        wait_elementToBeClickable(select,3);
        clickOnElement(select);
        wait_Element_To_Be_Visual(createLibraryText,2);
        Assert.assertEquals(selectedParentLibrary.getText(),parentLibrary);
        clickOnElement(create);
        wait_Element_To_Be_Visual(repoTosterMessage,5);
        Assert.assertEquals(repoTosterMessage.getText(),libraryName + " Library created successfully");
    }

    public void addStepGroupTOLibrary(String createdLibrary, String stepgroupName, String Type, String stepgroupdescription){
        wait_Elements_To_Be_Visual(listOfLibraries,5);
        for(WebElement library: listOfLibraries){
            if(library.getText().equalsIgnoreCase(createdLibrary)){
                clickOnElement(libraryExpander);
                wait_Elements_To_Be_Visual(listOfLibraries,5);
               WebElement add = driver.findElement(By.xpath("//span[text()='"+createdLibrary+"']/..//button[@class='add-btn']"));
               clickOnElement(add);
               wait_elementToBeClickable(addStepGroup,3);
               mouse_Hover_Action(addStepGroup).click().build().perform();
               wait_Element_To_Be_Visual(createStepGroupPopUp, 3);
               Assert.assertEquals(createStepGroupPopUp.getText(),"Create Step Group");
               enterIntoElement(stepGroupName,stepgroupName);
               clickOnElement(stepGroupType);
               wait_Elements_To_Be_Visual(stepGroupTypeOptions,3);
               for(WebElement option: stepGroupTypeOptions){
                   if(option.getText().equalsIgnoreCase(Type)){
                       option.click();
                       break;
                   }

               }
               wait_elementToBeClickable(stepGroupDescription,3);
               enterIntoElement(stepGroupDescription,stepgroupdescription);
               Assert.assertEquals(selectedParentLibrary.getText(),createdLibrary);
               wait_attributeContains(passMessageForStep,3,"value",stepgroupName + " is passed");
                wait_attributeContains(failMessageForStep,3,"value",stepgroupName + " is failed");
               clickOnElement(create);
               wait_elementToBeClickable(parametersTab,3);
               wait_Element_To_Be_Visual(stepGroupPageHeader,5);
               Assert.assertEquals(stepGroupPageHeader.getText(),stepgroupName);
            }

        }

    }

    public void navigateToParameter(){
        clickOnElement(parametersTab);
        wait_elementToBeClickable(plusParameter,3);
        Assert.assertEquals(parametersPageHeader.getText(),"Parameters");
    }

    public void createParameters(String parName, String parameterType){
        clickOnElement(plusParameter);
        wait_Element_To_Be_Visual(createParameterPopUpHeader,3);
        Assert.assertEquals(createParameterPopUpHeader.getText(),"Create Parameter");
        enterIntoElement(parameterName,parName);
        clickOnElement(parameterTypeDropDown);
        wait_Elements_To_Be_Visual(parameterTypes,3);
        for(WebElement paraType : parameterTypes)
            if(paraType.getText().equalsIgnoreCase(parameterType)){
                paraType.click();
                break;
        }
        wait_elementToBeClickable(createParameterButton,1);
        clickOnElement(createParameterButton);
        wait_Element_To_Be_Visual(repoTosterMessage,3);
        Assert.assertEquals(repoTosterMessage.getText(),parName+" Parameter created successfully");
    }

    public void createVariable(String varName,String varValue){
        clickOnElement(VariablesTab);
        wait_elementToBeClickable(plusVariable,3);
        System.out.println(stepGroupVariableHeader.getText());
        if(stepGroupVariableHeader.getText().contains("Step Group Variables")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    /*   String headerText= stepGroupVariableHeader.getText();
       String [] arr = headerText.split(" ");
       Assert.assertEquals(arr[0],"Step Group Variables");

     */
       clickOnElement(plusVariable);
       wait_Element_To_Be_Visual(CreateStepGroupVariablePopUp,2);
       Assert.assertEquals(CreateStepGroupVariablePopUp.getText(), "Create Step Group Variable");
       enterIntoElement(variableName,varName);
       enterIntoElement(variableValue,varValue);
       clickOnElement(createVariable);
    }


}

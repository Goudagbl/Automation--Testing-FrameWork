package ProjectMenu;

import BasePackage.Libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateProjectPage extends Libraries {

    public WebDriver driver;
   public  TestDevlopmentPage testDev;
   public CreateProjectPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "projectName")
    WebElement name;

    @FindBy(xpath = "//div[@id='projecttype']")
    WebElement projectType_Dropdown;
    //span[contains(text(),'project type')]
    //*[@data-testid='ArrowDropDownIcon']
    //div[@id='projecttype']

    @FindBy(xpath = "//li[@id='sideLeft']//span[contains(@class,'text')]")
    List<WebElement> projectTypes;

    @FindBy(xpath = "//div[@id='projecttype']//span")
    WebElement projectTypeContainsText;


    @FindBy(css = "#description")
    WebElement description;

    @FindBy(xpath = "//p[text()='Native']")
    WebElement nativeRadioButton;

    @FindBy(xpath = "//p[text()='Hybrid']")
    WebElement hybridRadioButton;

    @FindBy(xpath = " //p[text()='Android']")
    WebElement androidRadioButton;

    @FindBy(xpath = " //p[text()='iOS']")
    WebElement iosRadioButton;

    @FindBy(xpath = " //p[text()='Android & iOS']")
    WebElement androidAndIosRadioButton;

    @FindBy(css = "#Url")
    WebElement webUrl;

    @FindBy(css = "#buttonId")
    WebElement createButton;

    public TestDevlopmentPage create_Project(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for( WebElement type: projectTypes ){
            if(type.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(type,10);
                clickOnElement(type);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }
        }

        enterIntoElement(description, projectDescription);
        clickOnElement(createButton);


        testDev = new TestDevlopmentPage(driver);
        return testDev;

    }

    public TestDevlopmentPage createNativeAndroidProject(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(nativeRadioButton);
        clickOnElement(androidRadioButton);
        clickOnElement(createButton);
        testDev = new TestDevlopmentPage(driver);
        return testDev;
    }
    public TestDevlopmentPage createNativeIosProject(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(nativeRadioButton);
        clickOnElement(iosRadioButton);
        clickOnElement(createButton);
        testDev = new TestDevlopmentPage(driver);
        return testDev;
    }


    public TestDevlopmentPage createNativeAndroidAndIosProject(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);;
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(nativeRadioButton);
        clickOnElement(androidAndIosRadioButton);
        clickOnElement(createButton);
        testDev = new TestDevlopmentPage(driver);
        return testDev;
    }

    public TestDevlopmentPage createHybridAndroidProject(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(hybridRadioButton);
        clickOnElement(androidRadioButton);
        clickOnElement(createButton);
        testDev = new TestDevlopmentPage(driver);
        return testDev;
    }


    public TestDevlopmentPage createHybridIosProject(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(hybridRadioButton);
        clickOnElement(iosRadioButton);
        clickOnElement(createButton);
        testDev = new TestDevlopmentPage(driver);
        return testDev;
    }


    public TestDevlopmentPage createHybridAndroidAndIosProject(String projectName, String projectType, String projectDescription ){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(hybridRadioButton);
        clickOnElement(androidAndIosRadioButton);
        clickOnElement(createButton);
        testDev = new TestDevlopmentPage(driver);
        return testDev;
    }


    public TestDevlopmentPage createWebAndMobileProject(String projectName,String projectType, String projectDescription){
        enterIntoElement(name,projectName);
        clickOnElement(projectType_Dropdown);
        for(WebElement project : projectTypes){
            if(project.getText().equalsIgnoreCase(projectType)){
                wait_elementToBeClickable(project,10);
                clickOnElement(project);
                wait_textToBePresentInElement(projectTypeContainsText,5,projectType);
                break;
            }

        }
        enterIntoElement(description,projectDescription);
        clickOnElement(nativeRadioButton);
        clickOnElement(androidRadioButton);
        clickOnElement(createButton);

        TestDevlopmentPage testdev = new TestDevlopmentPage(driver);
             return testdev;
    }
}


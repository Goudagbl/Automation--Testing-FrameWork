package FireFlinkPages.LicenseManagement;

import BasePackage.Libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_InPage extends Libraries {
    public WebDriver driver;


    public Sign_InPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="emailId")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//button[text()='Sign in']")
    WebElement signIn;

    public ProjectListPage signInToFlinko(String EmailId, String passwordValue ){
        enterIntoElement(email,EmailId);
        enterIntoElement(password,passwordValue);
        clickOnElement(signIn);
        ProjectListPage home = new ProjectListPage(driver);
        return home;
    }

}

package BasePackage;

import FireFlinkPages.LicenseManagement.Sign_InPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.Math;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;


public class BaseTest {
    public static WebDriver driver;
   public  Properties  pro;
    public Sign_InPage signIn;
    public  void browserInitialization() throws Throwable {
       pro = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\User\\Downloads\\Fireflink\\GlobalFile.Properties");
        pro.load(fis);
        String Browser= System.getProperty("browser") != null ? System.getProperty("browser") : pro.getProperty("browser");
        if(Browser.contains("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            if(Browser.equals("chrome headless")){
                options.addArguments("--window-size=1440x900");
                options.addArguments("headless");

            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        else if(Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        }

    }

    public void readExelSheet() throws Exception {
        File src = new File("C:\\Users\\User\\Downloads\\Test Date.xlsx");
        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook workBook = new XSSFWorkbook(fis);
           XSSFSheet sheet = workBook.getSheetAt(0);
           sheet.getRow(0).getCell(0).getStringCellValue();

    }


    public String randomNumberGenerator(){
        /*double randomNumber  = Math.random();
        int sizeofNum = (int) (randomNumber *1000);
        return sizeofNum ;
        */

        // create a string of all characters
        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnPpQqRrSsTtUuVvWwXxYyZz";
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        int length =4;
        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return  randomString;

    }



    @BeforeMethod(alwaysRun = true)
    public Sign_InPage setUp() throws Throwable {
        browserInitialization();
        driver.get(pro.getProperty("Url"));
        signIn = new Sign_InPage(driver);
        return signIn;
    }
    @AfterMethod()
    public void tearDown(){

        driver.close();
    }


}

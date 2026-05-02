package Basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static Logger log;
    public static Properties prop;

    //==========================================================
    //                 REPORT INITIALIZATION
    //==========================================================
    @BeforeSuite
    public void startReport() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        log = Logger.getLogger("AutomationLog");
        log.info("===== Test Suite Started =====");
    }

    //==========================================================
    //                 LOAD CONFIG + LAUNCH BROWSER
    //==========================================================
    @BeforeClass
    public void setup() {

        // Load config.properties
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        // Browser setup with WebDriverManager
        if (browser.equalsIgnoreCase("chrome")) {
          WebDriverManager.chromedriver().setup();
        //  driver=new ChromeDriver();
          
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless=new");

            // Stability options (Recommended for CI/CD)
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // Optional but recommended
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
           // WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
          //  WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            throw new RuntimeException("Invalid browser name in config.properties");
        }

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
        log.info("Navigated to URL: " + url);
    }

    //==========================================================
    //   CREATE EXTENT TEST BEFORE EVERY @Test METHOD
    //==========================================================
    @BeforeMethod
    public void createExtentTest(Method method) {
        test = extent.createTest(method.getName());
        log.info("===== Starting Test: " + method.getName() + " =====");
    }

    //==========================================================
    //                      SCREENSHOT
    //==========================================================
 
//==========================================================
    //                      SCREENSHOT
    //==========================================================
    public String takeScreenshot(String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    //==========================================================
    //           ADD SCREENSHOT TO EXTENT ON FAILURE
    //==========================================================
 /*   @AfterMethod
    public void tearDownMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            // Capture screenshot (file)
            String filePath = takeScreenshot(result.getName());
            // Capture Base64 screenshot (best for HTML report)
            String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            test.fail("Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(filePath);  // physical file
            test.addScreenCaptureFromBase64String(base64); // Base64 attachment
            log.error("Test failed: " + result.getName());
        }
    }*/

    //==========================================================
    //                 CLOSE BROWSER
    //==========================================================
    @AfterClass
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
    }

    //==========================================================
    //             FLUSH REPORT
    //==========================================================
    @AfterSuite
    public void flushReport() {
        extent.flush();
        log.info("===== Test Suite Finished =====");
    }
}
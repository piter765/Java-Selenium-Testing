package seleniumEndToEnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    private String username = System.getenv("USERNAME");
    private String accessKey = System.getenv("ACCESSKEY");
    private String hub = "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();

    @Parameters("Browser")
    @BeforeMethod
    public void setUp(@Optional String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

//    @Parameters(value = {"Browser", "Version", "Platform"})
//    @BeforeMethod
//    public void setUp(String browser, String version, String platform) {
//        caps.setCapability("build", "1.0");
//        caps.setCapability("name", "seleniumEndToEnd");
//        caps.setCapability("platform", platform);
//        caps.setCapability("browserName", browser);
//        caps.setCapability("version", version);
//        caps.setCapability("network", true);
//        caps.setCapability("console", true);
//        caps.setCapability("visual", true);
//        caps.setCapability("video", true);
//
//        try {
//            driver = new RemoteWebDriver(
//                    new URL("https://" + username + ":" +
//                            accessKey + hub), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        driver.get("https://ecommerce-playground.lambdatest.io/");
//    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }


}

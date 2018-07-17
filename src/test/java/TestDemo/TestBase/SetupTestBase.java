package TestDemo.TestBase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hvargas on 7/12/2018.
 */
public class SetupTestBase {
    private Properties props;
    private String appURL;
    private String browserType;
    private WebDriver driver;

    private void loadProperties() {
        props = new Properties();
        InputStream input = getClass().getResourceAsStream("/automation.properties");
        try {
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }



    @BeforeSuite
    public void initSuite() {
        loadProperties();
        appURL = props.getProperty("ServerPath");
        browserType = props.getProperty("Browser");
        setDriver(browserType, appURL);

    }

    @AfterSuite
    public void clos() {
       driver.close();
       driver.quit();
    }

    private void setDriver(String browserType, String appURL) {
        if (driver == null) {
            if (browserType.equals("chrome")) {
                driver = initChromeDriver(appURL);
            } else {
             //driver Internet explorer
            }
        } else {
            driver.get(appURL);
        }
    }

    private WebDriver initChromeDriver(String appURL) {
        String pathDriver = "resource/driver/chromedriver.exe";
        String path= getClass().getResource("/driver/chromedriver.exe").getFile();
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }



}
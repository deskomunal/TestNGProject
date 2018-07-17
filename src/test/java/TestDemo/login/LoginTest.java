package TestDemo.login;

import TestDemo.PageObject.LoginPage;
import TestDemo.PageObject.WellcomePage;
import TestDemo.TestBase.SetupTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends SetupTestBase {

    private WebDriver driver;
    @BeforeClass
    public void init(){
        driver=getDriver();
    }

    @Test
    public void testlogin(){
        LoginPage login = PageFactory.initElements(driver,LoginPage.class);
        WellcomePage wellcome = PageFactory.initElements(driver,WellcomePage.class);
        login.setUsername("henryvargas");
        login.setPassword("Password1!");
        login.clickSingup();
        Assert.assertTrue(wellcome.getLabel().contains("Learn Git and GitHubs without any"),"The message is :"+wellcome.getLabel());
    }
}

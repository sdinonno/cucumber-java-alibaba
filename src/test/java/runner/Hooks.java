package runner;

import com.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setUp() {
        WebDriver driver = DriverManager.createDriver(DriverManager.Browser.CHROME);
        /*if(Boolean.parseBoolean(ConfigUtil.getConfigs("isMobileView"))){
            Dimension d = new Dimension(390,1020);
            driver.manage().window().setSize(d);
        }
        else
            driver.manage().window().maximize();*/
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String url = "https://aliexpress.com/";
        driver.navigate().to(url);
    }

    @After()
    public void tearsDown() {
        DriverManager.quitDriver();
    }
}

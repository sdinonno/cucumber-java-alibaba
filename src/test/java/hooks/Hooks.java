package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp(String url) {
        driver = WebDriverManager.chromedriver().getWebDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu","--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get();
    }

    @After
    public void quit(){
        driver.close();
        driver.quit();
    }
}

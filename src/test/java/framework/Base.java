package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Base {

    static WebDriver driver;

    public static void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);

        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void quit(){
        driver.close();
        driver.quit();
    }
}

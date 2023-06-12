package com.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static WebDriver driver;

    public enum Browser { EDGE, FIREFOX, CHROME, IPHONE12PROVIEW, SAMSUNGA51VIEW }

    public static WebDriver getDriver(){
        if(driver == null) driver = createDriver(Browser.CHROME);
        return driver;
    }

    private static WebDriver setFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(profile);
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver setEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        return new EdgeDriver(edgeOptions);
    }

    private static ChromeOptions setBasicChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.managed_default_content_settings.ads", 1);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--whitelisted-ips");
        chromeOptions.addArguments("--user-agent='Mozilla/5.0 (X11; Linux x86_64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36");
        return chromeOptions;
    }

    private static WebDriver setChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = setBasicChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--window-size=1920,1080");
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver setChromeDriverForMobileView(String deviceModel){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = setBasicChromeOptions();
        Map<String, String> deviceMobEmu = new HashMap<>();
        chromeOptions.setExperimentalOption("mobileEmulation", deviceMobEmu);
        deviceMobEmu.put("deviceName", deviceModel);
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver createDriver(Browser browser) {
        switch (browser) {
            case FIREFOX:
                driver = setFirefoxDriver();
                break;
            case EDGE:
                driver = setEdgeDriver();
                break;
            /*case IPHONE12PROVIEW:
                driver = setChromeDriverForMobileView("iPhone 12 Pro");
                break;
            case SAMSUNGA51VIEW:
                driver = setChromeDriverForMobileView("Samsung Galaxy A51/71");
                break;*/
            default:
                driver = setChromeDriver();
        }

        return driver;
    }

    public static void quitDriver() {
        driver.close();
        driver.quit();
    }
}

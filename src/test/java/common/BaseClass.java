package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {


        public String baseURL = "https://aliexpress.com/";
        public WebDriver driver;

        public void setUp(String url) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-gpu","--ignore-certificate-errors");

                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(url);
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }

        public void quit(){
                close();
                driver.quit();
        }

        public void navigate(String url){
                driver.navigate().to(url);
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }

        public WebElement findElement(By locator){
                try {
                        WebElement element = driver.findElement(locator);
                        return element;
                }
                catch (NoSuchElementException e){
                        System.out.println("Element not found: " + locator);
                        throw new NoSuchElementException(e.getMessage());
                }
        }

        public List<WebElement> findElements(By locator){
                try {
                        List<WebElement> element = driver.findElements(locator);
                        return element;
                }
                catch (NoSuchElementException e){
                        System.out.println("Elements not found: " + locator);
                        throw new NoSuchElementException(e.getMessage());
                }
        }

        public void clickElement(By locator){

                WebElement element = findElement(locator);

                try{
                        if(element.isDisplayed())
                                element.click();

                }
                catch (Exception e) {
                        System.out.println("Error trying to click element.");
                        throw new NoSuchElementException(e.getMessage());
                }
        }

        public void inputText(By locator, String text){
                try {
                        findElement(locator).sendKeys(text);
                }
                catch (Exception e) {
                        System.out.println("Error trying to enter text.");
                        throw new NoSuchElementException(e.getMessage());
                }
        }

        public boolean elementIsVisible(By locator){
                try {
                        findElement(locator).isDisplayed();
                        return true;
                }
                catch (Exception e){
                        System.out.println("Error trying to find element.");
                        throw new NoSuchElementException(e.getMessage());
                }

        }

        public void clickOnContainingValue(List<WebElement> elements, String valueToBeContained){
                for (WebElement element : elements) {
                        if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
                                element.click();
                                return;
                        }
                }
        }

        public void switchTo(String window){
                driver.switchTo().window(window);
        }

        public String getWindowHandle(){
                return driver.getWindowHandle();
        }

        public Set<String> getWindowHandles(){
                return driver.getWindowHandles();
        }

        public String getCurrentUrl(){
                return driver.getCurrentUrl();
        }

        public String close(){
                driver.close();
        }

}




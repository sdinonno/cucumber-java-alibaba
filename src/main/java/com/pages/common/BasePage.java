package com.pages.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BasePage {

        protected WebDriver driver;
        public String baseURL = "https://aliexpress.com/";

        public BasePage(WebDriver driver) {
                this.driver = driver;
        }

        public void navigate(String url){
                driver.navigate().to(url);
        }

        public void clickElement(WebElement element){
                element.click();
        }

        public void inputText(WebElement element, String text){
                element.sendKeys(text);
        }

        public boolean elementIsVisible(WebElement element){
                return element.isDisplayed();
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

        public void close(){
                driver.close();
        }

        protected WebElement getElementFromList(List<WebElement> elements, String text){
                for(WebElement e : elements){
                        if(e.getText().equals(text)){
                                return e;
                        }
                }
                throw new NoSuchElementException("Cannot find element.");
        }
}




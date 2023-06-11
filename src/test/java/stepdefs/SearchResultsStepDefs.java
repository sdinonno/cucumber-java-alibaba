package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Set;

public class SearchResultsStepDefs {

    @Given("that I am on the Aliexpress website")
    public void thatIAmOnTheAliexpressWebsite() {
        clickElement(homePage.dontAllowNotificationsButton);
        clickElement(homePage.closeDiscountButton);
    }

    @When("I do a search with the word {string}")
    public void iDoASearchWithTheWordIphone(String word) {
        inputText(homePage.searchBox, word);
        clickElement(homePage.searchButton);
    }

    @And("I go to the second page results")
    public void iGoToTheSecondPageResults() {
        String currentURL = getCurrentUrl();
        navigate(currentURL+"&page=2");
    }

    @And("click the second result")
    public void clickTheSecondResult() throws InterruptedException {
        homePage.mainWindow = getWindowHandle();
        clickElement(homePage.secondProduct);
    }

    @Then("I see has at least {string} item")
    public void iSeeHasAt1Item(String number) {

        Set<String> allWindowHandles  = getWindowHandles();

        for (String windowHandle : allWindowHandles){
            if(!homePage.mainWindow.equals(windowHandle)){
                switchTo(windowHandle);
                Assert.assertTrue(elementIsVisible(homePage.quantityItems));
                String quantity = findElement(homePage.quantityItems).getAttribute("value");
                Assert.assertTrue(Integer.parseInt(quantity) >= Integer.parseInt(number));
            }

        }
        switchTo(homePage.mainWindow);

    }


}

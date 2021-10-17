package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.HomePage;
import framework.Base;

import java.util.List;

public class Search extends Base {


    @Given("that I am on the Aliexpress website")
    public void thatIAmOnTheAliexpressWebsite() {
        setUp("https://aliexpress.com/");
        HomePage.clickElement(HomePage.dontAllowNotificationsButton);
        HomePage.clickElement(HomePage.closeDiscountButton);
    }

    @When("I input {string} to search box")
    public void iInputWordToSearchBox(String word) {
        HomePage.inputText(HomePage.searchBox, word);
    }

    @And("click the search button")
    public void clickTheSearchButton() {
        HomePage.clickElement(HomePage.searchButton);
    }

    @And("click the second page results")
    public void clickTheSecondPageResults() {
        List<WebElement> buttons = HomePage.findElements(HomePage.numberPagesButtons);
        HomePage.clickOnContainingValue(buttons, "2");
    }

    @And("click the second result")
    public void clickTheSecondResult() {
        HomePage.clickElement(HomePage.secondProduct);
    }

    @Then("I see has at least {string} item")
    public void iSeeHasAt1Item(String number) {
        boolean quantityIsVisible = HomePage.elementIsVisible(HomePage.quantityItems);
        String quantity = HomePage.getValueOnInput(HomePage.quantityItems);

        Assert.assertTrue(quantityIsVisible);
        Assert.assertTrue(Integer.parseInt(quantity) >= Integer.parseInt(number));
        quit();
    }
}

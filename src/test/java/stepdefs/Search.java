package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;

import java.util.List;

public class Search {


    @Given("that I have gone to the Alibaba page")
    public void thatIHaveGoneToTheAlibabaPage() {
        HomePage.navigate("https://aliexpress.com/");
    }

    @When("I input \"Iphone\" to search box")
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

    @Then("I see has at least \"1\" item")
    public void iSeeHasAt1Item(String number) {
        boolean quantityIsVisible = HomePage.elementIsVisible(HomePage.quantityItems);
        String quantity = HomePage.getValueOnInput(HomePage.quantityItems);

        Assert.assertTrue(quantityIsVisible);
        Assert.assertTrue(Integer.parseInt(quantity) >= Integer.parseInt(number));
    }
}

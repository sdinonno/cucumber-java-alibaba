package stepdefs;

import com.cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.pages.HomePage;
import org.testng.Assert;

import java.util.Set;

public class HomeStepDefs {
    HomePage homePage;
    TestContext testContext;

    public HomeStepDefs(TestContext context){
        testContext = context;
        homePage = context.getPageObjectManager().getHomePage();
    }

    @Given("I am on the Aliexpress website")
    public void iAmOnTheAliexpressWebsite() {
        Assert.assertTrue(homePage.getCurrentUrl().contains("aliexpress.com"));
    }

    @When("I perform a search with the word {string}")
    public void performASearch(String word) {
        homePage.performSearch(word);
    }

    @And("I go to results page number {string}")
    public void iGoToResultsPageNumber(String number) {
        homePage.goToSearchResultsPage(number);
    }

    @And("I click the item result number {string}")
    public void clickItemResultByNumber(String number) {
        homePage.openItemByOrder(number);
    }
}

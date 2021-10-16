package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
    @Given("that I have gone to the Alibaba page")
    public void thatIHaveGoneToTheAlibabaPage() {
    }

    @When("I input \"Iphone\" to search box")
    public void iInputWordToSearchBox(String word) {
        
    }

    @And("click the search button")
    public void clickTheSearchButton(String number) {
        
    }

    @And("I go to the second results page")
    public void iGoToTheSecondResultsPage() {
        
    }

    @Then("the second ad has at least \"1\" item")
    public void theSecondAdHasAtLeastNumberItem() {
    }
}

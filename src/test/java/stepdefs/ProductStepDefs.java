package stepdefs;

import com.cucumber.TestContext;
import com.pages.ProductPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ProductStepDefs {

    TestContext testContext;
    ProductPage productPage;
    public ProductStepDefs(TestContext context){
        testContext = context;
        productPage = context.getPageObjectManager().getProductPage();
    }

    @Then("I see that the product has at least one item available")
    public void iSeeTheProductHasAtLeastOneItemAvailable() {
        Assert.assertTrue(productPage.getDefaultQuantity() > 0);
    }
}

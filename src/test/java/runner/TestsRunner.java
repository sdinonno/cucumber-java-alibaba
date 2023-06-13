package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/resources/features/",glue="stepdefs")
public class TestsRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

package RunnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features" , glue = {"StepDefinitions"} ,
monochrome = true , plugin = {"json:target/cucumber.json"}  , dryRun = false) 

public class AdidasTestRunner {

}


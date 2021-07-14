package cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.base.CucumberBaseClass;

@CucumberOptions (features = {"src/test/java/features"}, glue = "cucumber.steps",
					monochrome = true, tags = "@Loans")
public class CucumberRunner extends CucumberBaseClass {

}

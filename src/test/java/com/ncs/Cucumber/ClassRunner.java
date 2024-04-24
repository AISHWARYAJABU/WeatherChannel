package com.ncs.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/com/ncs/Cucumber/Terms.feature",
				"src/test/java/com/ncs/Cucumber/PrivacyPolicy.feature",
				"src/test/java/com/ncs/Cucumber/Accessibilty.feature"
				},			
		glue = {"com.ncs.Cucumber"},
		plugin = {"html:cucumber-reports-regular/cucumber.html"}
	    		)
public class ClassRunner extends AbstractTestNGCucumberTests {

}

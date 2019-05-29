package com.sofia.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty", "html:target/cucumber"},
        features = {"src/test/java/com/sofia/cucumber/loginAndDelete.feature"},
        glue = {"src/test/java/com/sofia/cucumber/loginAndUndoDeleteStepDef"})
public class CucumberRunner {

}

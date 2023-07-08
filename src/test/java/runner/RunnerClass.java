package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        // features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        // glue keyword we use to provide the path of the package where steps defs are available
        glue= "steps", dryRun =  false,  // if dryRun is =true it will not execute the actual testing but it will give us the missing step
        // definition but if  dryRun=false will run the actual code and execution
        tags= " @login",

        monochrome = true ,
        plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.txt"}
        // monochrome =true :: it means sometimes the console output for cucumber test is having some
        // irrelevant information, when you set it to true, it removes all that
        // irrelevant information from the console and will give you simple output
)




public class RunnerClass {
}

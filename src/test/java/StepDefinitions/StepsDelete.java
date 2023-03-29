package StepDefinitions;

import ScenarioContext.ScenarioContext;
import io.cucumber.java.en.*;
import org.springframework.web.client.RestTemplate;

import static StepDefinitions.StepsGet.*;
import static StepDefinitions.StepsGetId.*;


public class StepsDelete {
    private String empDltURI;
    private RestTemplate restTemplate;

    private ScenarioContext scenarioContext;

    public StepsDelete(ScenarioContext context) {
        this.scenarioContext = context;
    }


    @Given("I set Delete Employee service endpoint")
    public void setDeleteEndpoint() {
        scenarioContext.setScenarioContext(empId);
        empDltURI=empURI+"/delete/"+scenarioContext.getScenarioContext();;
        System.out.println(" URL :"+empDltURI);
    }
    @When("I send Delete HTTP request")
    public void setDeleteRequest() {
        restTemplate=new RestTemplate();
        restTemplate.delete(empDltURI);

    }
    @Then("I receive valid Delete response")
    public void verifyDeleteResponse(){
        System.out.println("The employee is delete");
    }

}

package StepDefinitions;

import ScenarioContext.ScenarioContext;
import io.cucumber.java.en.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import static StepDefinitions.StepsGet.*;

public class StepsGetId {
    private String empIdURI;
    public static final String empId="1";
    private ResponseEntity<String> response;
    private String responseIdBody;

    private ScenarioContext scenarioContext;

    public StepsGetId(ScenarioContext context) {
        this.scenarioContext = context;
    }

    @Given("I set GET Id employee service api")
    public void setGetIdEndpoint() {
        scenarioContext.setScenarioContext(empId);
        empIdURI=empURI+"/"+scenarioContext.getScenarioContext();
        System.out.println("URL :"+empIdURI);
    }
    @When("Send GET with Id HTTP request")
    public void setGetIdRequest() {
        //GET Method to get an Employee
        RestTemplate restTemplate=new RestTemplate();
        response=restTemplate.getForEntity(empIdURI,String.class);

    }

    @Then("I receive valid Response for an employee")
    public void verifyGetIdResponse() {
        responseIdBody = response.getBody();
        System.out.println("responseBody --->"+responseIdBody);

        // Check if the status code is 201
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK);


    }

}

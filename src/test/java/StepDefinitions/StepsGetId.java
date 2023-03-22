package StepDefinitions;

import io.cucumber.java.en.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class StepsGetId {
    private static String empIdURI;
    private ResponseEntity<String> response;
    private String responseIdBody;

    @Given("I set GET Id employee service api")
    public void setGetIdEndpoint() {
        empIdURI="https://dummy.restapiexample.com/api/v1/employee/1";
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

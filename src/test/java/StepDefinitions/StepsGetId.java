package StepDefinitions;

import io.cucumber.java.en.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class StepsGetId {

    private HttpHeaders headers=new HttpHeaders();

    private static String empIdURI;
    private ResponseEntity<String> response;
    private String responseIdBody;
    public String responseIdBodyGet;

    @Given("I set GET Id employee service api")
    public void setGetIdEndpoint() {
        empIdURI="https://dummy.restapiexample.com/api/v1/employee/1";
        System.out.println("Add URL :"+empIdURI);
    }

    @When("I set request HEADER for an employee")
    public void setGetIdRequestHeader() {

        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");
    }
    @When("Send GET with Id HTTP request")
    public void setGetIdRequest() {
        //GET Method to Add New Employee
        RestTemplate restTemplate=new RestTemplate();
        response=restTemplate.getForEntity(empIdURI,String.class);
    }

    @Then("I receive valid Response for an employee")
    public void verifyGetIdResponse() {
        responseIdBodyGet = response.getBody();
        //Write response to file
        responseIdBody= response.getBody().toString();
        System.out.println("responseBody --->"+responseIdBody);

        // Check if the status code is 201
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK);


    }

}

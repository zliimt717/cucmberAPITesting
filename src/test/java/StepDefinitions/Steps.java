package StepDefinitions;

import io.cucumber.java.en.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;



public class Steps {

    private static String addURI;

    private HttpHeaders headers=new HttpHeaders();

    private ResponseEntity<String> response;
    private String responseBody;
    public String responseBodyPOST;

    @Given("I set GET employee service api endpoint")
    public void setPostEndpoint(){
       addURI="https://dummy.restapiexample.com/api/v1/employees";
       System.out.println("Add URL :"+addURI);
    }
    @When("I set request HEADER")
    public void setRequestHeader() {

        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");
    }
    @When("Send a GET HTTP request")
    public void setPostRequest() {
        //GET Method to Add New Employee
        RestTemplate restTemplate=new RestTemplate();
        response=restTemplate.getForEntity(addURI,String.class);
    }
    @Then("I receive valid Response")
    public void verifyPostResponse() {
        responseBodyPOST = response.getBody();
        //Write response to file
        responseBody= response.getBody().toString();
        System.out.println("responseBody --->"+responseBody);

        // Check if the status code is 201
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK);


    }



}

package StepDefinitions;

import io.cucumber.java.en.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;




public class StepsGet {

    private static String empURI;

    private HttpHeaders headers=new HttpHeaders();

    private ResponseEntity<String> response;
    private String responseBody;
    public String responseBodyGET;

    @Given("I set GET employee service api endpoint")
    public void setGetEndpoint(){
       empURI ="https://dummy.restapiexample.com/api/v1/employees";
       System.out.println("Add URL :"+ empURI);
    }
    @When("I set request HEADER")
    public void setRequestHeader() {

        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");
    }
    @When("Send a GET HTTP request")
    public void setGetRequest() {
        //GET Method to Add New Employee
        RestTemplate restTemplate=new RestTemplate();
        response=restTemplate.getForEntity(empURI,String.class);
    }
    @Then("I receive valid Response")
    public void verifyGetResponse() {
        responseBodyGET = response.getBody();
        //Write response to file
        responseBody= response.getBody().toString();
        System.out.println("responseBody --->"+responseBody);

        // Check if the status code is 201
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK);


    }



}


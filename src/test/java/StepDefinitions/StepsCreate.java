package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StepsCreate {
    private String empURI,jsonBody_new;
    private RestTemplate restTemplate;
    private ResponseEntity<String> response_new;

    private HttpHeaders headers=new HttpHeaders();
    @Given("I set new employee service api endpoint")
    public void setPOSTEndpoint() {
        empURI="https://dummy.restapiexample.com/api/v1/create";
        System.out.println(" URL :"+empURI);
    }
    @When("I set Create new employee request Body")
    public void setPOSTRequest() {

       jsonBody_new=" {\"id\": 24," +
                "\"employee_name\": \"Jenetts Caldasc\"," +
                "\"employee_salary\": 445000," +
                "\"employee_age\": 34," +
                "\"profile_image\": \"\"" +
                "}";
        System.out.println("jsonBody: "+jsonBody_new);

    }
    @When("Send POST HTTP request, so that add new employee")
    public void sendPostRequest() {


        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");

        HttpEntity<String> entity_new=new HttpEntity<>(jsonBody_new,headers);
        restTemplate=new RestTemplate();
        response_new=restTemplate.postForEntity(empURI,entity_new,String.class);

    }

    @Then("I receive POST HTTP response")
    public void verifyPostResponse() {
        Assert.assertEquals(response_new.getStatusCode(),HttpStatus.OK);
    }

}

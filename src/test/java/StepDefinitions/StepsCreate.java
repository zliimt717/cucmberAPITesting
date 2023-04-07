package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static StepDefinitions.StepsGet.*;

public class StepsCreate {
    private String empCreateURI,jsonBody_new;
    private RestTemplate restTemplate;
    private ResponseEntity<String> response_new;

    private HttpHeaders headers=new HttpHeaders();
    @Given("I set new employee service api endpoint")
    public void setPOSTEndpoint() {
        empCreateURI =empURI+"/post/employee";
        System.out.println(" URL :"+ empCreateURI);
    }
    @When("I set Create new employee request Body")
    public void setPOSTRequest() {

       jsonBody_new="{\n" +
               "        \"firstname\": \"Jane\",\n" +
               "        \"lastname\": \"Emma\"\n" +
               "    }";
        System.out.println("jsonBody: "+jsonBody_new);

    }
    @When("Send POST HTTP request, so that add new employee")
    public void sendPostRequest() {


        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");

        HttpEntity<String> entity_new=new HttpEntity<>(jsonBody_new,headers);
        restTemplate=new RestTemplate();
        response_new=restTemplate.postForEntity(empCreateURI,entity_new,String.class);

    }

    @Then("I receive POST HTTP response")
    public void verifyPostResponse() {
        Assert.assertEquals(response_new.getStatusCode(),HttpStatus.OK);
    }

}

package StepDefinitions;

import ScenarioContext.ScenarioContext;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static StepDefinitions.StepsGet.*;
import static StepDefinitions.StepsGetId.*;

public class StepsUpdate {
    private ResponseEntity<String> responseGetId,response;

    private String empIdURI,empUpdateURI, jsonBody,replaceBody, responseBody;
    private RestTemplate restTemplate;

    private ScenarioContext scenarioContext;

    public StepsUpdate(ScenarioContext context) {
        this.scenarioContext = context;
    }

    @Given("I set PUT employee service api endpoint")
    public void setPutEndpoint() {
        scenarioContext.setScenarioContext(empId);
        empUpdateURI=empURI+"/put/"+scenarioContext.getScenarioContext();;
        System.out.println(" URL :"+empUpdateURI);
    }
    @When("I set Update request Body")
    public void setUpdateRequest() {
        // get employee response body
        empIdURI=empURI+"/"+empId;
        restTemplate=new RestTemplate();
        responseGetId=restTemplate.getForEntity(empIdURI,String.class);
        jsonBody =responseGetId.getBody();
        System.out.println("JsonBody: "+ jsonBody);
        //update employee response body, for example salary
        replaceBody= jsonBody.replace("Jane","Anne");
        System.out.println("replace body: "+replaceBody);
    }
    @When("Send PUT HTTP request")
    public void sendPutRequest() throws InterruptedException {
        HttpHeaders headers=new HttpHeaders();
        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");
        HttpEntity<String> entity=new HttpEntity<>(replaceBody,headers);
        // Using put method to update employ response body
        restTemplate=new RestTemplate();
        response=restTemplate.exchange(empUpdateURI, HttpMethod.PUT,entity,String.class);
        responseBody =response.getBody();

        System.out.println("jsonBody: "+ responseBody);
    }
    @Then("I receive valid HTTP response")
    public void verifyUpdateResponse() {
        Assert.assertTrue(responseBody.contains("Anne"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}

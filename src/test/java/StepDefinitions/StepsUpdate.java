package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StepsUpdate {
    private ResponseEntity<String> responseGetId,response;

    private String empIdURI,empUpdateURI, jsonBody,replaceBody, responseBody;

    private RestTemplate restTemplate=new RestTemplate();

    @Given("I set PUT employee service api endpoint")
    public void setPutEndpoint() {
        empUpdateURI="https://dummy.restapiexample.com/api/v1/update/21";
        System.out.println(" URL :"+empUpdateURI);
    }
    @When("I set Update request Body")
    public void setUpdateRequest() {
        // get employee response body
        empIdURI="https://dummy.restapiexample.com/api/v1/employee/21";
        responseGetId=restTemplate.getForEntity(empIdURI,String.class);
        jsonBody =responseGetId.getBody();
        System.out.println("JsonBody: "+ jsonBody);
        //update employee response body, for example salary
        replaceBody= jsonBody.replace("345000","445000");
        System.out.println("replace body: "+replaceBody);
    }
    @When("Send PUT HTTP request")
    public void sendPutRequest() throws InterruptedException {
        HttpHeaders headers=new HttpHeaders();
        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");
        HttpEntity<String> entity=new HttpEntity<>(replaceBody,headers);
        // Using put method to update employ response body
        response=restTemplate.exchange(empUpdateURI, HttpMethod.PUT,entity,String.class);
        responseBody =response.getBody();

        System.out.println("jsonBody: "+ responseBody);
    }
    @Then("I receive valid HTTP response")
    public void verifyUpdateResponse() {
        Assert.assertTrue(responseBody.contains("445000"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}

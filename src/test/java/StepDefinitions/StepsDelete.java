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


public class StepsDelete {
    private String empDltURI;
    private RestTemplate restTemplate;

    private ScenarioContext scenarioContext;

    ResponseEntity response;

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
    public ResponseEntity<Void> setDeleteRequest() {
        restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        HttpEntity<String> entity=new HttpEntity<>(headers);
        response=restTemplate.exchange(empDltURI, HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getBody());
        return response;
    }
    /*public void setDeleteRequest() {
        restTemplate=new RestTemplate();
        restTemplate.delete(empDltURI);
    }*/
    @Then("I receive valid Delete response")
    public void verifyDeleteResponse(){
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}

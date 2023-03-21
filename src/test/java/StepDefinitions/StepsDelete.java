package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StepsDelete {
    private String empDltURI;
    private HttpHeaders headers=new HttpHeaders();

    private ResponseEntity<String> response;

    private String responseDltBody;
    @Given("I set Delete Employee service endpoint")
    public void setDeleteEndpoint() {
        empDltURI="https://dummy.restapiexample.com/api/v1/delete/24";
        System.out.println("Add URL :"+empDltURI);
    }
    @When("I send Delete HTTP request")
    public void setDeleteRequest() {

        RestTemplate restTemplate=new RestTemplate();
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        response=restTemplate.exchange(empDltURI, HttpMethod.DELETE,entity,String.class);
    }
    @Then("I receive valid Delete response")
    public void verifyDeleteResponse() {
        //Write response to file
        responseDltBody= response.getBody().toString();
        System.out.println("responseBody --->"+responseDltBody);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

}

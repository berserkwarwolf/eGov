package tests.mSevaAndLeaseAndAgreement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import resources.CreateSevaServiceResource;
import entities.CreateSevaServiceRequest;
import builders.CreateSevaServiceBuilder;

import tests.BaseAPITest;
import utils.RequestHelper;

public class CreateSevaService extends BaseAPITest {

	   @Test
	    public void CreateSevaServiceShouldRespondWithSucessStatus() throws IOException{
	        CreateSevaServiceRequest request = new CreateSevaServiceBuilder()
	                .build();

        Response response = new CreateSevaServiceResource().serviceTypeValidation(RequestHelper.getJsonString(request));
        Assert.assertTrue(isGoodResponse(response), "Actual response code " + response.getStatusCode());

    }

 } 
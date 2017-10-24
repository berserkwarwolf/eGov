package tests.propertyTax.billingServices;

import builders.propertyTax.RequestInfoBuilder;
import builders.propertyTax.billingServices.BillingServiceSearchRequestBuilder;
import builders.propertyTax.billingServices.businessServiceMaster.BusinessServiceDetailsBuilder;
import builders.propertyTax.billingServices.businessServiceMaster.BusinessServiceMasterRequestBuilder;
import com.jayway.restassured.response.Response;
import entities.requests.propertyTax.RequestInfo;
import entities.requests.propertyTax.billingServices.BillingServiceSearchRequest;
import entities.requests.propertyTax.billingServices.businessServiceMaster.BusinessServiceDetails;
import entities.requests.propertyTax.billingServices.businessServiceMaster.BusinessServiceMasterRequest;
import entities.responses.propertyTax.billingServices.businessService.BusinessServiceMasterResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.propertyTax.billingServices.BusinessServiceMasterResource;
import tests.BaseAPITest;
import utils.APILogger;
import utils.LoginAndLogoutHelper;
import utils.RequestHelper;
import utils.ResponseHelper;

import java.io.IOException;

import static data.UserData.NARASAPPA;

public class BusinessServiceMasterVerificationTest extends BaseAPITest{

    private BusinessServiceDetails[] details;
    private RequestInfo requestInfo;

    public BusinessServiceMasterVerificationTest(){
        details = new BusinessServiceDetails[1];
    }

    @Test
    public void businessServiceTest() throws IOException{
        LoginAndLogoutHelper.login(NARASAPPA);                                             //Login
        requestInfo = new RequestInfoBuilder().withAuthToken(scenarioContext.getAuthToken()).build();

        details[0] = new BusinessServiceDetailsBuilder().build();
        BusinessServiceMasterResponse createObject = createBusinessServiceMaster(details);//Create
        searchBusinessServiceMaster(createObject);                                       // Search

        BusinessServiceMasterResponse updateObject =                                    //Update
                updateBusinessServiceMaster(createObject.getBusinessServiceDetails()[0].getId());
        searchBusinessServiceMaster(updateObject);                                     //Search

        LoginAndLogoutHelper.logout();                                                //Logout
    }

    public String getBusinessService() throws IOException{
        requestInfo = new RequestInfoBuilder().withAuthToken(scenarioContext.getAuthToken()).build();
        details[0] = new BusinessServiceDetailsBuilder().withBusinessService("Service_"+get3DigitRandomInt()).build();
        BusinessServiceMasterResponse createObject = createBusinessServiceMaster(details);      //Create

        return createObject.getBusinessServiceDetails()[0].getBusinessService();
    }

    private BusinessServiceMasterResponse updateBusinessServiceMaster(String id) throws IOException {

        new APILogger().log("Update Business Service Master API is Started --");
        details[0] = new BusinessServiceDetailsBuilder().withId(Integer.valueOf(id)).build();
        BusinessServiceMasterRequest request = new BusinessServiceMasterRequestBuilder().withRequestInfo(requestInfo)
                .withBusinessServiceDetails(details).build();

        Response response = new BusinessServiceMasterResource().update(RequestHelper.getJsonString(request));
        BusinessServiceMasterResponse responseObject = checkAssertsForCreate(request,response);
        new APILogger().log("Update Business Service Master API is Completed --");

        return responseObject;
    }

    private void searchBusinessServiceMaster(BusinessServiceMasterResponse createObject) throws IOException {

        new APILogger().log("Search Business Service Master API is Started --");
        BillingServiceSearchRequest request = new BillingServiceSearchRequestBuilder().withRequestInfo(requestInfo).build();

        Response response = new BusinessServiceMasterResource().search(RequestHelper.getJsonString(request),"&id="+createObject.getBusinessServiceDetails()[0].getId());
        checkAssertsForSearch(createObject,response);
        new APILogger().log("Search Business Service Master API is Completed --");
    }

    private void checkAssertsForSearch(BusinessServiceMasterResponse createObject, Response response) throws IOException {
        BusinessServiceMasterResponse responseObject = (BusinessServiceMasterResponse)
                ResponseHelper.getResponseAsObject(response.asString(),BusinessServiceMasterResponse.class);

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(responseObject.getResponseInfo().getStatus(),"200");
        Assert.assertEquals(responseObject.getBusinessServiceDetails()[0].getId(),createObject.getBusinessServiceDetails()[0].getId());
        Assert.assertEquals(responseObject.getBusinessServiceDetails()[0].getBusinessService(),createObject.getBusinessServiceDetails()[0].getBusinessService());
        Assert.assertEquals(responseObject.getBusinessServiceDetails()[0].getCallBackApportionURL(),createObject.getBusinessServiceDetails()[0].getCallBackApportionURL());
    }

    private BusinessServiceMasterResponse createBusinessServiceMaster(BusinessServiceDetails[] details) throws IOException {

        new APILogger().log("Create Business Service Master API is Started --");
        BusinessServiceMasterRequest request = new BusinessServiceMasterRequestBuilder().withRequestInfo(requestInfo)
                .withBusinessServiceDetails(details).build();

        Response response = new BusinessServiceMasterResource().create(RequestHelper.getJsonString(request));
        BusinessServiceMasterResponse responseObject = checkAssertsForCreate(request,response);
        new APILogger().log("Create Business Service Master API is Completed --");

        return responseObject;
    }

    private BusinessServiceMasterResponse checkAssertsForCreate(BusinessServiceMasterRequest request, Response response) throws IOException {
        BusinessServiceMasterResponse responseObject = (BusinessServiceMasterResponse)
                ResponseHelper.getResponseAsObject(response.asString(),BusinessServiceMasterResponse.class);

        Assert.assertEquals(response.getStatusCode(),201);
        Assert.assertEquals(responseObject.getResponseInfo().getStatus(),"200");
        Assert.assertEquals(responseObject.getBusinessServiceDetails()[0].getBusinessService(),request.getBusinessServiceDetails()[0].getBusinessService());
        Assert.assertEquals(responseObject.getBusinessServiceDetails()[0].getCallBackApportionURL(),request.getBusinessServiceDetails()[0].getCallBackApportionURL());
        Assert.assertTrue(responseObject.getBusinessServiceDetails()[0].getCallBackForApportioning());

        return responseObject;
    }
}
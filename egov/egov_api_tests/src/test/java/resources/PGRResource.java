package resources;

import com.jayway.restassured.response.Response;
import entities.responses.login.LoginResponse;
import utils.APILogger;
import utils.Properties;

import static com.jayway.restassured.RestAssured.given;

public class PGRResource {

    public Response createComplaint(String json) {

        new APILogger().log("Creating complaint Request for PGR is started  with-- "+ json);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post(Properties.complaintUrl);

        new APILogger().log("Creating complaint Response for PGR is generated as-- "+ response.asString());
        return response;
    }

    public Response getPGRComplaint(String serviceRequestId) {

        new APILogger().log("Getting a PGR complaint Request is started for-- " + serviceRequestId);

        Response response = given().request().with()
                .urlEncodingEnabled(false)
                .header("api_id", "org.egov.pgr")
                .header("ver", "1.0")
                .header("ts", "28-03-2016 10:22:33")
                .header("action", "GET")
                .header("did", "4354648646")
                .header("msg_id", "654654")
                .header("requester_id", "61")
                .header("auth_token", "null")
                .when()
                .get(Properties.getPGRComplaintUrl + serviceRequestId);

        new APILogger().log("Getting a PGR complaint Response is generated as-- "+response.asString());
        return response;
    }

    public Response getParticularLocationName(String locationName) {

        new APILogger().log("Getting a location details Request with name is started for--"+locationName);

        Response response = given().request().with()
                .urlEncodingEnabled(true)
                .when()
                .get(Properties.locationNameUrl + locationName);

        new APILogger().log("Getting a location details Response with name is generated as-- "+response.asString());

        return response;
    }

    public Response getAllLocationNames() {

        new APILogger().log("Getting all location details Request with name is started-- ");

        Response response = given().request().with()
                .urlEncodingEnabled(true)
                .when()
                .get(Properties.locationNameUrl);

        new APILogger().log("Getting all location details Response with name is generated as-- "+ response.asString());

        return response;
    }

    public Response getFetchComplaint() {

        new APILogger().log("Fetch all Complaints Request is started -- ");

        Response response = given().request().with()
                .urlEncodingEnabled(true)
                .when()
                .get(Properties.fetchComplaintsUrl);

        new APILogger().log("Fetch all Complaints Response is generated as-- "+ response.asString());

        return response;
    }

    public Response getFrequentlyFilledComplaints(int count) {

        new APILogger().log("Get Frequently filled Complaints Request is started  for-- "+count);

        Response response = given().request().with()
                .urlEncodingEnabled(true)
                .when()
                .get(Properties.frequentlyFilledComplaintsUrl + count + "&tenantId=ap.public");

        new APILogger().log("Get Frequently filled Complaints Response is generated as-- "+response.asString());

        return response;
    }

    public Response updateAndClosePGRComplaint(String json) {

        new APILogger().log("Update/Close complaint Request for PGR is started  with-- "+json);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .put(Properties.complaintUrl);

        new APILogger().log("Update/Close complaint Response for PGR is started  with-- "+response.asString());

        return response;
    }

    public Response getReceivingCenter(LoginResponse loginResponse) {

        new APILogger().log("Receiving Centers Request for PGR is started  -- ");
        Response response = given().request().with()
                .header("auth-token", loginResponse.getAccess_token())
                .when()
                .get(Properties.pgrReceivingCenterUrl);

        new APILogger().log("Receiving Centers Response for PGR is generated as-- "+response.asString());

        return response;
    }

    public Response getPGRApplicationStatus(LoginResponse loginResponse) {

        new APILogger().log("Get All Application Status Request for PGR is started  -- ");
        Response response = given().request().with()
                .header("auth-token", loginResponse.getAccess_token())
                .when()
                .post(Properties.pgrStatusUrl);

        new APILogger().log("Get All Application Status Response for PGR is generated as-- "+response.asString());

        return response;
    }

    public Response getSearchCitizenComplaints(LoginResponse loginResponse) {

        new APILogger().log("Search Citizen Complaints Request for PGR is started-- ");
        Response response = given().request().with()
                .header("auth-token", loginResponse.getAccess_token())
                .when()
                .post(Properties.pgrSearchCitizenComplaintUrl);

        new APILogger().log("Search Citizen Complaints Response for PGR is generated-- "+response.asString());
        return response;
    }

    public Response getReceivingModes() {

        new APILogger().log("Get Different Receiving Modes For PGR is started-- ");
        Response response = given().request().with()
                .when()
                .get(Properties.pgrReceivingModesUrl);

        new APILogger().log("Receiving Modes For PGR is Response is generated-- "+response.asString());
        return response;
    }
}

package entities.responses.propertyTax.masters.propertyTypes.search;

public class SearchPropertyTypesResponse {
    private PropertyTypes[] propertyTypes;
    private ResponseInfo responseInfo;

    public PropertyTypes[] getPropertyTypes() {
        return this.propertyTypes;
    }

    public void setPropertyTypes(PropertyTypes[] propertyTypes) {
        this.propertyTypes = propertyTypes;
    }

    public ResponseInfo getResponseInfo() {
        return this.responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }
}
package org.egov.ptis.nmc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("taxcalculationinfo")
public class TaxCalculationInfo {
    @XStreamAsAttribute
    private String propertyOwnerName;
    @XStreamAsAttribute
    private String propertyAddress;
    private String houseNumber;
    private String area;
    private String zone;
    private String ward;
    private BigDecimal propertyArea;
    private BigDecimal totalTaxPayable;
    private String propertyType;
    private String parcelId;
    private String indexNo;
    private String taxCalculationInfoXML;
    private BigDecimal totalAnnualLettingValue;
    private BigDecimal buildingCost;
    private String amenities;
    private Double alvPercentage;
    private Date occupencyDate;

    /**
	 * unitTaxCalculationInfos is a list of UnitTaxCalculation(s)
	 * In case of multiple UnitTaxCalculation each object represent tax
	 * calculation for different base rents
	 */
    @XStreamAlias("unittax")
    private List<List<UnitTaxCalculationInfo>> unitTaxCalculationInfos = new ArrayList<List<UnitTaxCalculationInfo>>();

    @XStreamAlias("consolidatedunittax")
    private List<UnitTaxCalculationInfo> consolidatedUnitTaxCalculationInfo = new ArrayList<UnitTaxCalculationInfo>();

    private List<ConsolidatedUnitTaxCalReport> consolidatedUnitTaxCalReportList = new ArrayList<ConsolidatedUnitTaxCalReport>();

    public String getPropertyOwnerName() {
        return propertyOwnerName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getArea() {
        return area;
    }

    public String getZone() {
        return zone;
    }

    public String getWard() {
        return ward;
    }

    public BigDecimal getTotalTaxPayable() {
        return totalTaxPayable;
    }

    public List<List<UnitTaxCalculationInfo>> getUnitTaxCalculationInfos() {
        return unitTaxCalculationInfos;
    }

    public void setPropertyOwnerName(String propertyOwnerName) {
        this.propertyOwnerName = propertyOwnerName;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setTotalTaxPayable(BigDecimal totalTaxPayable) {
        this.totalTaxPayable = totalTaxPayable;
    }

    public void setUnitTaxCalculationInfo(List<List<UnitTaxCalculationInfo>> unitTaxCalculationInfos) {
        this.unitTaxCalculationInfos = unitTaxCalculationInfos;
    }

    public BigDecimal getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(BigDecimal propertyArea) {
        this.propertyArea = propertyArea;
    }

    public void addUnitTaxCalculationInfo(List<UnitTaxCalculationInfo> unitTaxCalculationInfos) {
        getUnitTaxCalculationInfos().add(unitTaxCalculationInfos);
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getTaxCalculationInfoXML() {
        return taxCalculationInfoXML;
    }

    public void setTaxCalculationInfoXML(String taxCalculationInfoXML) {
        this.taxCalculationInfoXML = taxCalculationInfoXML;
    }

    public BigDecimal getTotalAnnualLettingValue() {
        return totalAnnualLettingValue;
    }

    public void setTotalAnnualLettingValue(BigDecimal totalAnnualLettingValue) {
        this.totalAnnualLettingValue = totalAnnualLettingValue;
    }

    public BigDecimal getBuildingCost() {
		return buildingCost;
	}

	public void setBuildingCost(BigDecimal buildingCost) {
		this.buildingCost = buildingCost;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public Double getAlvPercentage() {
		return alvPercentage;
	}

	public void setAlvPercentage(Double alvPercentage) {
		this.alvPercentage = alvPercentage;
	}

	public Date getOccupencyDate() {
		return occupencyDate;
	}

	public void setOccupencyDate(Date occupencyDate) {
		this.occupencyDate = occupencyDate;
	}

	public List<UnitTaxCalculationInfo> getConsolidatedUnitTaxCalculationInfo() {
		return consolidatedUnitTaxCalculationInfo;
	}

	public void setConsolidatedUnitTaxCalculationInfo(List<UnitTaxCalculationInfo> consolidatedUnitTaxCalculationInfo) {
		this.consolidatedUnitTaxCalculationInfo = consolidatedUnitTaxCalculationInfo;
	}


	public List<ConsolidatedUnitTaxCalReport> getConsolidatedUnitTaxCalReportList() {
		return consolidatedUnitTaxCalReportList;
	}

	public void setConsolidatedUnitTaxCalReportList(
			List<ConsolidatedUnitTaxCalReport> consolidatedUnitTaxCalReportList) {
		this.consolidatedUnitTaxCalReportList = consolidatedUnitTaxCalReportList;
	}

	public void addConsolidatedUnitTaxCalculationInfo(UnitTaxCalculationInfo consolidatedUnitTaxCalculationInfo) {
        getConsolidatedUnitTaxCalculationInfo().add(consolidatedUnitTaxCalculationInfo);
    }
	public void addConsolidatedUnitTaxCalReportList(ConsolidatedUnitTaxCalReport consolidatedUnitTaxCalReportList) {
        getConsolidatedUnitTaxCalReportList().add(consolidatedUnitTaxCalReportList);
    }

	@Override
    public int hashCode() {
        int hashCode = this.propertyOwnerName.hashCode() + this.propertyAddress.hashCode()
                + this.houseNumber.hashCode() + this.area.hashCode() + this.zone.hashCode() + this.ward.hashCode()
                + this.totalTaxPayable.hashCode() + this.propertyType.hashCode()
                + this.parcelId.hashCode() + this.indexNo.hashCode() + this.taxCalculationInfoXML.hashCode()
                + this.totalAnnualLettingValue.hashCode();
        return hashCode;
    }

}

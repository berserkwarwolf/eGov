<%--
  ~ eGov suite of products aim to improve the internal efficiency,transparency,
  ~    accountability and the service delivery of the government  organizations.
  ~
  ~     Copyright (C) <2015>  eGovernments Foundation
  ~
  ~     The updated version of eGov suite of products as by eGovernments Foundation
  ~     is available at http://www.egovernments.org
  ~
  ~     This program is free software: you can redistribute it and/or modify
  ~     it under the terms of the GNU General Public License as published by
  ~     the Free Software Foundation, either version 3 of the License, or
  ~     any later version.
  ~
  ~     This program is distributed in the hope that it will be useful,
  ~     but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~     GNU General Public License for more details.
  ~
  ~     You should have received a copy of the GNU General Public License
  ~     along with this program. If not, see http://www.gnu.org/licenses/ or
  ~     http://www.gnu.org/licenses/gpl.html .
  ~
  ~     In addition to the terms of the GPL license to be adhered to in using this
  ~     program, the following additional terms are to be complied with:
  ~
  ~         1) All versions of this program, verbatim or modified must carry this
  ~            Legal Notice.
  ~
  ~         2) Any misrepresentation of the origin of the material is prohibited. It
  ~            is required that all modified versions of this material be marked in
  ~            reasonable ways as different from the original version.
  ~
  ~         3) This license does not grant any rights to any user of the program
  ~            with regards to rights under trademark law for use of the trade names
  ~            or trademarks of eGovernments Foundation.
  ~
  ~   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/taglibs/cdn.tld" prefix="cdn"%>
		<form:form name="SearchRequest" role="form" action="" modelAttribute="workProgressRegisterSearchRequest" id="workProgressRegisterSearchRequest" class="form-horizontal form-groups-bordered">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary" data-collapsed="0">
						<div class="panel-heading">
							<div class="panel-title" style="text-align:center;"><spring:message code="lbl.title.search.workprogressregister" /></div>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-3 control-label text-right"><spring:message code="lbl.adminsanctionfromdate" /></label>
								<div class="col-sm-3 add-margin">
									<form:input path="adminSanctionFromDate" class="form-control datepicker" id="adminSanctionFromDate" data-inputmask="'mask': 'd/m/y'" />
									<form:errors path="adminSanctionFromDate" cssClass="add-margin error-msg" />
								</div>
								<label class="col-sm-2 control-label text-right"><spring:message code="lbl.adminsanctiontodate" /></label>
								<div class="col-sm-3 add-margin">
									<form:input path="adminSanctionToDate" class="form-control datepicker"	id="adminSanctionToDate" data-inputmask="'mask': 'd/m/y'" />
									<form:errors path="adminSanctionToDate" cssClass="add-margin error-msg" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label text-right"><spring:message code="lbl.wincode" /></label>
								<div class="col-sm-3 add-margin">
									<form:input path="workIdentificationNumber" class="form-control" id="workIdentificationNumber" placeholder="Type first 3 letters of Work Identification Number" />
									<form:errors path="workIdentificationNumber" cssClass="add-margin error-msg" />
								</div>
								<label class="col-sm-2 control-label text-right"><spring:message code="lbl.contractorcode.or.name" /></label>
								<div class="col-sm-3 add-margin">
									<form:input path="contractor" id="contractor" class="form-control" />
									<form:errors path="contractor" cssClass="add-margin error-msg" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label text-right"><spring:message code="lbl.department" /></label>
								<div class="col-sm-3 add-margin">
									<form:select path="department" data-first-option="false" id="department" class="form-control">
										<form:option value=""><spring:message code="lbl.select" /></form:option>
										<form:options items="${departments}" itemValue="id" itemLabel="name" />
									</form:select>
									<form:errors path="department" cssClass="add-margin error-msg" />
								</div>
								<label class="col-sm-2 control-label text-right"><spring:message code="lbl.spilloverwork" /></label>
								<div class="col-sm-3 add-margin">
								<form:checkbox path="spillOverFlag" id="spillOverFlag" />
								</div>
							</div>
							<div class="form-group">
					 			<label class="col-sm-3 control-label text-right"><spring:message code="lbl.workstatus" /></label>
					 			<div class="col-sm-3 add-margin">
					 				<form:select path="workStatus" data-first-option="false" id="workStatus" class="form-control" >
					 					<form:option value="">
					 						<spring:message code="lbl.select" />
					 					</form:option>
					 					<c:forEach items="${workStatus}" var="status">
					 						<form:option value="${status.toString() }">${status.toString() }</form:option>
					 					</c:forEach>
					 				</form:select>
					 				<form:errors path="workStatus" cssClass="add-margin error-msg" /> 
					 			</div>
					 		</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 text-center">
					<button type='button' class='btn btn-primary' id="btnsearch">
						<spring:message code='lbl.search' />
					</button>
					<a href='javascript:void(0)' class='btn btn-default'
				onclick='self.close()'><spring:message code='lbl.close' /></a>
				</div>
			</div>
		</form:form>  

<jsp:include page="workprogressregister-searchresult.jsp"/>
<script>
	$('#btnsearch').click(function(e) {
		if ($('form').valid()) {
		} else {
			e.preventDefault();
		}
	});
</script>
<script
 	src="<cdn:url value='/resources/global/js/jquery/plugins/jquery.stickytableheaders.min.js?rnd=${app_release_no}' context='/egi'/>"
 	type="text/javascript"></script>
<script src="<cdn:url value='/resources/js/reports/searchworkprogressregisterhelper.js?rnd=${app_release_no}'/>"></script>

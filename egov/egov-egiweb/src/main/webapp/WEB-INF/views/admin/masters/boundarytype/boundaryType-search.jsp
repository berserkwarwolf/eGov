<%--
  ~ eGov suite of products aim to improve the internal efficiency,transparency,
  ~ accountability and the service delivery of the government  organizations.
  ~
  ~  Copyright (C) 2016  eGovernments Foundation
  ~
  ~  The updated version of eGov suite of products as by eGovernments Foundation
  ~  is available at http://www.egovernments.org
  ~
  ~  This program is free software: you can redistribute it and/or modify
  ~  it under the terms of the GNU General Public License as published by
  ~  the Free Software Foundation, either version 3 of the License, or
  ~  any later version.
  ~
  ~  This program is distributed in the hope that it will be useful,
  ~  but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~  GNU General Public License for more details.
  ~
  ~  You should have received a copy of the GNU General Public License
  ~  along with this program. If not, see http://www.gnu.org/licenses/ or
  ~  http://www.gnu.org/licenses/gpl.html .
  ~
  ~  In addition to the terms of the GPL license to be adhered to in using this
  ~  program, the following additional terms are to be complied with:
  ~
  ~      1) All versions of this program, verbatim or modified must carry this
  ~         Legal Notice.
  ~
  ~      2) Any misrepresentation of the origin of the material is prohibited. It
  ~         is required that all modified versions of this material be marked in
  ~         reasonable ways as different from the original version.
  ~
  ~      3) This license does not grant any rights to any user of the program
  ~         with regards to rights under trademark law for use of the trade names
  ~         or trademarks of eGovernments Foundation.
  ~
  ~  In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="egov" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/taglib/cdn.tld" prefix="cdn" %>
<div class="row" id="page-content">
    <div class="col-md-12">
        <c:if test="${not empty message}">
            <div class="alert alert-success" role="alert"><spring:message code="${message}"/></div>
        </c:if>
        <form:form mothod="post" class="form-horizontal form-groups-bordered" modelAttribute="boundaryType" id="boundaryTypeSearch">
            <div class="panel panel-primary" data-collapsed="0">
                <div class="panel-heading">
                    <div class="panel-title">
                        <strong><spring:message code="title.searchBoundaryType"/></strong>
                    </div>
                </div>
                <div class="panel-body custom-form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            <spring:message code="lbl.hierarchyType"/>
                            <span class="mandatory"></span>
                        </label>
                        <div class="col-sm-6 add-margin">
                            <form:select path="name"
                                         id="hierarchyTypeSelect" cssClass="form-control" onchange="populateBoundaryTypes(this);" cssErrorClass="form-control error" required="required">
                                <form:option value=""> <spring:message code="lbl.select"/> </form:option>
                                <form:options items="${hierarchyTypes}" itemValue="id" itemLabel="name"/>
                            </form:select>
                            <form:errors path="name" cssClass="error-msg"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label"><spring:message
                                code="lbl.boundaryType"/><span class="mandatory"></span></label>
                        <div class="col-sm-6 add-margin">
                            <egov:ajaxdropdown id="boundaryTypeAjax" fields="['Text','Value']"
                                               dropdownId="boundaryTypeSelect" url="boundarytype/ajax/boundarytypelist-for-hierarchy"/>
                            <form:select path="name"
                                         id="boundaryTypeSelect" cssClass="form-control" cssErrorClass="form-control error" required="required">
                                <form:option value=""> <spring:message code="lbl.select"/> </form:option>
                            </form:select>
                            <form:errors path="name" cssClass="error-msg"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <c:if test="${mode == 'addChild'}">
                        <button type="button" class="btn btn-primary" onclick="checkForChild()"><spring:message code="lbl.search"/></button>
                    </c:if>
                    <c:if test="${mode != 'addChild'}">
                        <button type="submit" class="btn btn-primary"><spring:message code="lbl.search"/></button>
                    </c:if>
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="self.close()"><spring:message code="lbl.close"/></button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<script src="<cdn:url  value='/resources/js/app/boundarytype.js?rnd=${app_release_no}'/>"></script>
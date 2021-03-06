<%--
  ~ eGov suite of products aim to improve the internal efficiency,transparency,
  ~    accountability and the service delivery of the government  organizations.
  ~
  ~     Copyright (C) <2017>  eGovernments Foundation
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


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<br>
<br>
<c:forEach var="doc" items="${stakeHolderDocumentList}"
	varStatus="status">
		<div class="form-group">
			<div class="col-sm-1"></div>
		<%-- 	<form:hidden id="documents[${status.index}].id"
				path="stakeHolderDocument[${status.index}].id" value="${doc.id}" /> --%>
			<form:hidden id="checkListDocuments[${status.index}].id" path="checkListDocuments[${status.index}].id" value="${doc.id}" />
			<div class="col-sm-4 add-margin text-right">
				<c:out value="${doc.description}"></c:out><c:if test="${doc.isMandatory}"><span class="mandatory"></span></c:if>
			</div>
			<div class="col-sm-2 add-margin text-center">
				<%-- <input type="file" id="file${status.index}id"
					name="checkListDocuments[${status.index}].file"
					class="file-ellipsis upload-file">
				<form:errors path="checkListDocuments[${status.index}].file"
					cssClass="add-margin error-msg" /> --%>
					
				<c:choose>
		<c:when test="${doc.isMandatory}">
			<input type="file" id="file${status.index}id" name="checkListDocuments[${status.index}].file" class="file-ellipsis upload-file" required="required">
		</c:when>
		<c:otherwise>
			<input type="file" id="file${status.index}id" name="checkListDocuments[${status.index}].file" class="file-ellipsis upload-file">
		</c:otherwise>
		</c:choose>	
			<form:errors path="checkListDocuments[${status.index}].file" cssClass="add-margin error-msg" />
			</div>
			<div class="col-sm-2">
				<c:set value="false" var="isDocFound"></c:set>
				<c:forEach items="${stakeHolder.stakeHolderDocument}" var="shdoc"
					varStatus="loopStatus">
					<c:if test="${shdoc.checkListDetail.id == doc.id}">
						<c:set value="true" var="isDocFound"></c:set>
						<input type="hidden" id="stakeholderfile${status.index}"
							value="${shdoc.documentId.fileName}|${shdoc.documentId.contentType}|${regdoc.base64EncodedFile}">
						<a id="shdoc${status.index}">
							${shdoc.documentId.fileName}</a>
					</c:if>
				</c:forEach>
				<c:if test="${!isDocFound}">
				NA
			</c:if>
			</div>
		</div>
</c:forEach>


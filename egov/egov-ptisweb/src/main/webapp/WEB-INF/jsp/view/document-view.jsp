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

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<script>
	function viewDocument(fileStoreId) {
		var sUrl = "/egi/downloadfile?fileStoreId="+fileStoreId+"&moduleName=PTIS";
		window.open(sUrl,"window",'scrollbars=yes,resizable=no,height=400,width=400,status=yes');	
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">
			<table class="tablebottom" id="nameTable" width="100%" border="0"
				cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<th class="bluebgheadtd"><s:text name="doctable.sno" /></th>
						<th class="bluebgheadtd"><s:text name="doctable.doctype" /></th>
						<th class="bluebgheadtd"><s:text name="file" /></th>
					</tr>
					<s:iterator value="documents" status="status" var="document">
						<tr>
							<td class="blueborderfortd" style="text-align: center"><span
								class="bold"><s:property value="#status.index + 1" /></span></td>
							<td class="blueborderfortd" style="text-align: left"><span
								class="bold"><s:property
										value="documents[#status.index].type.name" /></span></td>
							<td class="blueborderfortd" style="text-align: center"><s:if
									test="%{documents.isEmpty() || documents[#status.index].files.isEmpty()}">
									<span class="bold">N/A</span>
								</s:if> <s:else>
									<s:iterator value="%{documents[#status.index].files}">
										<a
											href="javascript:viewDocument('<s:property value="fileStoreId"/>')">
											<s:property value="%{fileName}" />
										</a>
									</s:iterator>
								</s:else></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</td>
	</tr>
</table>
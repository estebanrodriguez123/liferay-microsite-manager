<%--
/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 */
--%>
<%@page import="com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil"%>
<%@ include file="init.jsp"%>

<%
	long siteRequestId = ParamUtil.getLong(request, MicroSiteConstants.SITE_REQUEST_ID);
	SiteRequest siteRequest = SiteRequestLocalServiceUtil.getSiteRequest(siteRequestId);
%>

<liferay-ui:header
		backURL="<%= redirect %>"
		escapeXml="<%= false %>"
		localizeTitle="<%= true %>"
		showBackURL="<%= true %>"
		title="site-request-reject"/>

<portlet:actionURL name="updateStatus" var="rejectURL">
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<p><liferay-ui:message key="site-request-reject-message"/></p>
<liferay-ui:message key="site-request-user" />: <%=PortalUtil.getUserName(siteRequest.getUserId(), "") %><br/>
<liferay-ui:message key="site-request-name" />: <%=siteRequest.getName() %><br/>
<liferay-ui:message key="site-request-description" />: <%=siteRequest.getDescription() %><br/>
<hr/>

<aui:form action="<%=rejectURL.toString() %>">
	<aui:input name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%= siteRequestId %>" type="hidden" />
	<aui:input name="<%=MicroSiteConstants.SITE_REQUEST_STATUS %>" 
				value="<%= MicroSiteConstants.REQUEST_STATUS_REJECTED %>" type="hidden" />
	<aui:fieldset>
		<aui:field-wrapper>
			<aui:input name="<%=MicroSiteConstants.SITE_REQUEST_RESPONSE %>" label="message" type="textarea">
				<aui:validator name="maxLength">75</aui:validator>
			</aui:input>
		</aui:field-wrapper>
		<aui:button type="submit" cssClass="btn-danger" />
	</aui:fieldset>
</aui:form>
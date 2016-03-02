<%@include file="/html/microsite/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	SiteRequest siteRequest = (SiteRequest) row.getObject();
	
	long companyId = CompanyThreadLocal.getCompanyId();
%>

<portlet:renderURL var="portletURL">
	<portlet:param name="tabs1" value="micro-sites-requests"/>
</portlet:renderURL>

<portlet:renderURL var="rejectURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
	<portlet:param name="jspPage" value="/html/microsite/reject.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="updateStatus" var="processURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%= portletURL.toString() %>"/>
	<portlet:param name="<%= MicroSiteConstants.SITE_REQUEST_STATUS %>"
		 value="<%= MicroSiteConstants.REQUEST_STATUS_PROCESSING %>" />
</portlet:actionURL>
			
<portlet:actionURL name="updateStatus" var="completeURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%= portletURL.toString() %>"/>
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_STATUS %>"
		 value="<%= MicroSiteConstants.REQUEST_STATUS_COMPLETE %>" />
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_USER_ID %>" value="<%=Long.toString(siteRequest.getUserId()) %>" />
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_COMPANY_ID %>" value="<%= Long.toString(companyId) %>" />
</portlet:actionURL>
			
<portlet:actionURL name="updateStatus" var="cancelURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%= portletURL.toString() %>"/>
	<portlet:param name="<%= MicroSiteConstants.SITE_REQUEST_STATUS %>"
		 value="<%= MicroSiteConstants.REQUEST_STATUS_PENDING %>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<c:choose>
		<c:when test="<%= siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PENDING) %>">
			<liferay-ui:icon image="request-process" src="/micro-site-portlet/icons/request-process.png"
				 message="site-request-process" url="<%=processURL.toString() %>"  />
			<liferay-ui:icon image="request-reject" src="/micro-site-portlet/icons/request-reject.png"
				 message="site-request-reject" url="<%=rejectURL.toString() %>"  />
		</c:when>
		<c:when test="<%= siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PROCESSING) %>">
			<liferay-ui:icon image="request-complete" src="/micro-site-portlet/icons/request-complete.png"
				 message="site-request-complete" id="completeMicroSite" url="<%=completeURL.toString() %>" />
			<liferay-ui:icon image="request-cancel" src="/micro-site-portlet/icons/request-cancel.png" 
				message="site-request-cancel" url="<%=cancelURL.toString() %>"  />
		</c:when>
	</c:choose>
</liferay-ui:icon-menu>
<%@include file="/html/microsite/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	SiteRequest siteRequest = (SiteRequest) row.getObject();
	
%>

<portlet:renderURL var="rejectURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="jspPage" value="/html/microsite/reject.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="updateStatus" var="processURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%=currentURL %>"/>
	<portlet:param name="<%= MicroSiteConstants.SITE_REQUEST_STATUS %>"
		 value="<%= MicroSiteConstants.REQUEST_STATUS_PROCESSING %>" />
</portlet:actionURL>
			
<portlet:actionURL name="updateStatus" var="completeURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%=currentURL %>"/>
	<portlet:param name="<%= MicroSiteConstants.SITE_REQUEST_STATUS %>"
		 value="<%= MicroSiteConstants.REQUEST_STATUS_COMPLETE %>" />
</portlet:actionURL>
			
<portlet:actionURL name="updateStatus" var="cancelURL">
	<portlet:param name="<%=MicroSiteConstants.SITE_REQUEST_ID %>" value="<%=Long.toString(siteRequest.getSiteRequestId()) %>"/>
	<portlet:param name="redirect" value="<%=currentURL %>"/>
	<portlet:param name="<%= MicroSiteConstants.SITE_REQUEST_STATUS %>"
		 value="<%= MicroSiteConstants.REQUEST_STATUS_PENDING %>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<c:choose>
		<c:when test="<%= siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PENDING) %>">
			<liferay-ui:icon image="edit" message="site-request-process" url="<%=processURL.toString() %>"  />
			<liferay-ui:icon image="close" message="site-request-reject" url="<%=rejectURL.toString() %>"  />
		</c:when>
		<c:when test="<%= siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PROCESSING) %>">
			<liferay-ui:icon image="check" message="site-request-complete" url="<%=completeURL.toString() %>" />
			<liferay-ui:icon image="undo" message="site-request-cancel" url="<%=cancelURL.toString() %>"  />
		</c:when>
	</c:choose>
</liferay-ui:icon-menu>
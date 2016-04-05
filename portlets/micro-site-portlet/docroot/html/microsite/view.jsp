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


<%@include file="init.jsp" %>
<%
	String tabs1 = ParamUtil.getString(request, "tabs1", "micro-sites-list");

	PortletURL portletURL = renderResponse.createRenderURL();
    portletURL.setParameter("tabs1", tabs1);    

    List<MicroSiteBean> microSitesList = MicroSiteUtil.getMicroSitesList(request);
    List<SiteRequest> siteRequests = (List<SiteRequest>) request.getAttribute(MicroSiteConstants.SITE_REQUESTS_LIST);
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/y");
%>

<portlet:renderURL var="addMicroSitesURL">
    <portlet:param name="mvcPath" value="/html/microsite/edit.jsp" />
    <portlet:param name="micro_site_edit_mode" value="<%=MicroSiteConstants.MICRO_SITE_DEFAULT_EDIT_MODE%>"/>
    <portlet:param name="cmd" value="<%=Constants.ADD%>"/>
</portlet:renderURL>

<liferay-ui:success key="rivet_create_micro_site_success_msg" message="created-micro-site-success-msg"/>

<div class="microsites-portlet-requests">
<liferay-ui:tabs names="micro-sites-list,micro-sites-requests" tabsValues="micro-sites-list,micro-sites-requests"
	url="<%= portletURL.toString() %>" >
	<liferay-ui:section>
		<aui:fieldset>
			<aui:fieldset>
				<aui:a href="${addMicroSitesURL}">
					<aui:button type="button" value="&nbsp;Add" cssClass="btn btn-large  btn-primary icon-plus"/>
				</aui:a>
			</aui:fieldset>
			<liferay-ui:search-container curParam="sitesCur" delta="<%=MicroSiteConstants.NUMBER_OF_ROWS%>"
				 emptyResultsMessage="no-micro-sites-were-found">
				<liferay-ui:search-container-results 
					results="<%= MicroSiteUtil.subList(microSitesList, searchContainer.getStart(), searchContainer.getEnd()) %>" 
					total="<%=microSitesList.size() %>"/>
				<liferay-ui:search-container-row className="com.rivetlogic.microsite.bean.impl.MicroSiteBeanImpl" modelVar="microsite">
					<liferay-ui:search-container-column-text name="micro-site-name" cssClass="micro-sites-column-name">
						${microsite.name}
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="micro-site-description" cssClass="micro-sites-column-description">
						<p class="break-text">${microsite.description}</p>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="micro-site-membership-type" cssClass="micro-sites-column-type">
						<p class="break-text">${microsite.typeString}</p>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="micro-site-active" cssClass="micro-sites-column-action">
						<c:choose>
							<c:when test="${microsite.active }">
								<p class="break-text">${microsite.activeString}</p>
							</c:when>
							<c:otherwise>
								<portlet:actionURL var="activateSiteURL" name="activateSite">
									<portlet:param name="microSiteId" value="${microsite.microSiteId}"/>
								</portlet:actionURL>
								<aui:a href="${activateSiteURL}">
									<aui:button type="submit" href="${activateSiteURL}" value="activate"/>
								</aui:a>
							</c:otherwise>
						</c:choose>
						
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="micro-site-url" cssClass="micro-sites-column-url">
						<p class="break-text"></p>
						<a href="<%= MicroSiteUtil.getMicroSiteURL(renderRequest, microsite.getGroupId()) %>" 
							target="_blank" class="taglib-icon"
							title="open"> 
							<span class="taglib-text "><liferay-ui:message key="micro-site-open"/></span> 
							<span class="opens-new-window-accessible"><liferay-ui:message key="micro-site-open"/></span>
						</a>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator searchContainer="<%=searchContainer %>"/>
			</liferay-ui:search-container>
		</aui:fieldset>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<liferay-ui:search-container curParam="requestsCur" delta="<%=MicroSiteConstants.NUMBER_OF_ROWS%>"
			 emptyResultsMessage="no-site-requests-were-found"
			iteratorURL="<%=portletURL %>">
				<liferay-ui:search-container-results 
					results="<%= ListUtil.subList(siteRequests, searchContainer.getStart(), searchContainer.getEnd()) %>" 
					total="<%=siteRequests.size() %>"/>
				<liferay-ui:search-container-row className="com.rivetlogic.microsite.model.SiteRequest" modelVar="siteRequest">
					<liferay-ui:search-container-column-text name="site-request-date">
						<%= simpleDateFormat.format(siteRequest.getCreateDate()) %>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="site-request-user">
						<%=PortalUtil.getUserName(siteRequest.getUserId(), "")%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="site-request-name">
						${siteRequest.name}
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="site-request-description">
						${siteRequest.description}
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="site-request-status">
						<liferay-ui:message key="site-request-status-${ siteRequest.status}" />
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="site-request-user-settings" cssClass="site-request-user-settings">
						<c:choose>
							<c:when test="<%= siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_PROCESSING) %>">
								<label class=""><input type="checkbox" class="microsite-admin-checkbox" id="${pns}microSiteAdminCheckbox" /> <liferay-ui:message key="site-request-make-user-admin" /></label>
								<aui:select name="microSiteList" label="site-request-site-list">
									<c:forEach var="microSite" items="<%= microSitesList %>">
										<aui:option label="${microSite.getName() }" value="${microSite.getMicroSiteId() }"></aui:option>
									</c:forEach>
								</aui:select>
							</c:when>
							<c:when test="<%= siteRequest.getStatus().equals(MicroSiteConstants.REQUEST_STATUS_COMPLETE) %>">
								<c:if test="${siteRequest.isAdmin()}">
									<liferay-ui:message key="site-request-user-set-admin"/>
								</c:if>
							</c:when>
						</c:choose>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-jsp path="/html/microsite/request_actions.jsp" align="right" />
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
			</liferay-ui:search-container>
	</liferay-ui:section>
</liferay-ui:tabs>
</div>
<aui:script use="microsites">
	A.microsites.initUpdateMicroSite('${pns}')
</aui:script>
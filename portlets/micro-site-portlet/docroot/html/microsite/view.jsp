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
    List<MicroSiteBean> microSitesList = MicroSiteUtil.getMicroSitesList(request);
%>

<portlet:renderURL var="addMicroSitesURL">
    <portlet:param name="mvcPath" value="/html/microsite/edit.jsp" />
    <portlet:param name="micro_site_edit_mode" value="<%=MicroSiteConstants.MICRO_SITE_DEFAULT_EDIT_MODE%>"/>
    <portlet:param name="cmd" value="<%=Constants.ADD%>"/>
</portlet:renderURL>

<liferay-ui:success key="rivet_create_micro_site_success_msg" message="created-micro-site-success-msg"/>

<aui:fieldset label="micro-sites-list">
	<aui:fieldset>
		<aui:button type="button" value="&nbsp;Add" cssClass="btn btn-large  btn-primary icon-plus" onClick="${addMicroSitesURL}"/>
	</aui:fieldset>
	<liferay-ui:search-container delta="<%=MicroSiteConstants.NUMBER_OF_ROWS%>" emptyResultsMessage="no-micro-sites-were-found">
		<liferay-ui:search-container-results 
			results="<%= MicroSiteUtil.subList(microSitesList, searchContainer.getStart(), searchContainer.getEnd()) %>" 
			total="${micro_sites_count}"/>
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
						
						<aui:button type="submit" href="${activateSiteURL}" value="activate"/>
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
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</aui:fieldset>

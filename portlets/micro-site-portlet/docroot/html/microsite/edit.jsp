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
<%@ include file="init.jsp"%>

<jsp:useBean id="microSiteBean" class="com.rivetlogic.microsite.bean.impl.MicroSiteBeanImpl" scope="request"/>
<%
boolean editMode = ParamUtil.getBoolean(request, MicroSiteConstants.MICRO_SITE_EDIT_MODE, Boolean.FALSE);
List<SiteTemplateBean> siteTemplateBeans = MicroSiteUtil.getSiteTemplateList(renderRequest);
%>

<liferay-ui:error exception="<%= DuplicateGroupException.class %>" message="please-enter-a-unique-name" />
<liferay-ui:error exception="<%= GroupNameException.class %>" message="please-enter-a-valid-name" />
<liferay-ui:error exception="<%= NoSuchGroupException.class %>" message="the-site-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchLayoutException.class %>" message="the-page-could-not-be-found" />
<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />
<liferay-ui:error exception="<%= SystemException.class %>">
<%SystemException se = (SystemException)errorException;%>
	<liferay-ui:message key="<%= se.getMessage() %>" />
</liferay-ui:error>

<portlet:actionURL var="createMicroSiteURL" name="createMicroSite">
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<portlet:actionURL var="backURL" portletMode="<%= LiferayPortletMode.VIEW.toString() %>" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="jspPage" value="/html/microsite/view.jsp" />
</portlet:actionURL>

<portlet:renderURL var="contentURL"
    windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="jspPage" value="/html/microsite/modal/search_site_template.jsp" />
</portlet:renderURL>

<liferay-ui:header
		backURL="<%= backURL %>"
		escapeXml="<%= false %>"
		localizeTitle="<%= true %>"
		showBackURL="<%= true %>"
		title='<%= editMode ? "edit-micro-site" : "create-micro-site" %>'/>

<aui:fieldset>
	<aui:form action="${createMicroSiteURL}" name="fm">
		<aui:column>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value='<%= editMode ? Constants.EDIT : Constants.ADD %>' />
			<aui:input name="liveGroupId" type="hidden" value="<%= microSiteBean.getGroupId() %>" />
			<!--model-->
			<h3><liferay-ui:message key="details"/></h3>
			<aui:field-wrapper inlineField="false">
				<aui:input name="name" label="micro-site-name" type="text" value="<%= microSiteBean.getName() %>">
					<aui:validator name="required"/>
					<aui:validator name="maxlength">
						'75'
					</aui:validator>
				</aui:input>
				<aui:input name="description" label="micro-site-description" type="textarea" value="<%= microSiteBean.getDescription() %>">
					<aui:validator name="maxlength">
						'400'
					</aui:validator>
				</aui:input>
				<aui:input name="active" label="micro-site-active" type="checkbox" checked="<%= microSiteBean.isActive() %>"></aui:input>
				<aui:input name="friendlyURL" label="micro-site-friendly-url" type="text" value="<%= microSiteBean.getFriendlyURL() %>">
					<aui:validator name="required"/>
					<aui:validator name="maxlength">
						'75'
					</aui:validator>
				</aui:input>
			</aui:field-wrapper>
			<h3><liferay-ui:message key="membership-options"/></h3>
			<aui:select name="type" label="micro-site-membership-type">
				<aui:option label="open" value="1" selected="<%= microSiteBean.getType() == MicroSiteConstants.MICRO_SITE_OPEN_TYPE %>"></aui:option>
				<aui:option label="restricted" value="2" selected="<%= microSiteBean.getType() == MicroSiteConstants.MICRO_SITE_RESTRICTED_TYPE %>"></aui:option>
				<aui:option label="private" value="3" selected="<%= microSiteBean.getType() == MicroSiteConstants.MICRO_SITE_PRIVATE_TYPE %>"></aui:option>
			</aui:select>
			<aui:input name="manualMembership" label="micro-site-manual-membership" type="checkbox" checked="<%= microSiteBean.isManualMembership() %>"></aui:input>
			<aui:fieldset label="pages">

				<aui:field-wrapper label="copy-as" inlineField="false">
					<div class="alert alert-error hide" id="${pns}TemplateError"><liferay-ui:message key="you-must-select-at-least-one-template"/> </div>
					<liferay-ui:panel-container accordion="true" extended="true" cssClass="micro-site-template-accordion">
						<liferay-ui:panel title="public-pages">
							<aui:select name="publicLayoutSetPrototypeId" label="micro-site-template">
								<aui:option label="none" value="0" selected="<%= microSiteBean.getPublicLayoutSetPrototypeId() == MicroSiteConstants.LONG_MIN_VALUE %>"></aui:option>
								<c:forEach var="siteTemplate" items="<%= siteTemplateBeans %>">
									<c:choose>
										<c:when test="<%= microSiteBean.getPublicLayoutSetPrototypeId() != MicroSiteConstants.LONG_MIN_VALUE %>">
											<aui:option label="${siteTemplate.name}" value="${siteTemplate.id}" selected="true"></aui:option>
										</c:when>
										<c:otherwise>
											<aui:option label="${siteTemplate.name}" value="${siteTemplate.id}"></aui:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
							</aui:select>
							<aui:input name="publicLayoutSetPrototypeLinkEnabled" 
								label="micro-site-layout-set-prototype-link-enabled" 
								disabled="true"
								type="checkbox" checked="<%= microSiteBean.isPublicLayoutSetPrototypeLinkEnabled() %>"></aui:input>
						</liferay-ui:panel>
						<liferay-ui:panel title="private-pages">
							<aui:select name="privateLayoutSetPrototypeId" label="micro-site-template" showEmptyOption="true">
								<aui:option label="none" value="0" selected="<%= microSiteBean.getPrivateLayoutSetPrototypeId() == MicroSiteConstants.LONG_MIN_VALUE %>"></aui:option>
								<c:forEach var="siteTemplate" items="<%= siteTemplateBeans %>">
									<c:choose>
										<c:when test="<%= microSiteBean.getPrivateLayoutSetPrototypeId() != MicroSiteConstants.LONG_MIN_VALUE %>">
											<aui:option label="${siteTemplate.name}" value="${siteTemplate.id}" selected="true"></aui:option>
										</c:when>
										<c:otherwise>
											<aui:option label="${siteTemplate.name}" value="${siteTemplate.id}"></aui:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</aui:select>
							<aui:input name="privateLayoutSetPrototypeLinkEnabled" 
								label="micro-site-layout-set-prototype-link-enabled" 
								disabled="true"
								type="checkbox" checked="<%= microSiteBean.isPrivateLayoutSetPrototypeLinkEnabled() %>"></aui:input>
						</liferay-ui:panel>
					</liferay-ui:panel-container>
				</aui:field-wrapper>
				
			</aui:fieldset>
		</aui:column>
		<aui:button-row>
			<aui:button type="cancel" onClick="<%= backURL %>" value="back-button"/>
			<aui:button name="createUpdateButton" value='<%= editMode ? "edit-button" : "create-button" %>' type="submit"/>
		</aui:button-row>
	</aui:form>
</aui:fieldset>

<aui:script use="microsites,micrositeform">
	A.microsites.setIFrameURL('${contentURL}', '${pns}');
	A.one('#${pns}createUpdateButton').on('click', A.microsites.handleSubmitEvent);
	A.one('#${pns}name').on('change', A.microsites.onChangeMicroSiteName());
	A.micrositeform.init('${pns}');
	A.micrositeform.handleChoosePublicLayout();
	A.micrositeform.handleChoosePrivateLayout();
	A.one('#${pns}fm').on('submit', A.micrositeform.onSubmit);
</aui:script>
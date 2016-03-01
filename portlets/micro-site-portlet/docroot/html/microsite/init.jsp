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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.rivetlogic.microsite.bean.SiteTemplateBean"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.rivetlogic.microsite.util.MicroSiteUtil"%>
<%@page import="com.rivetlogic.microsite.bean.MicroSiteBean"%>
<%@page import="com.rivetlogic.microsite.util.MicroSiteConstants"%>
<%@page import="com.rivetlogic.microsite.model.SiteRequest" %>

<%@page import="java.util.List"%>

<%@page import="com.liferay.portal.security.auth.AuthException"%>
<%@page import="com.liferay.portal.security.auth.PrincipalException"%>
<%@page import="com.liferay.portal.security.auth.CompanyThreadLocal"%>
<%@page import="com.liferay.portal.DuplicateGroupException" %>
<%@page import="com.liferay.portal.GroupFriendlyURLException" %>
<%@page import="com.liferay.portal.GroupNameException" %>
<%@page import="com.liferay.portal.NoSuchGroupException" %>
<%@page import="com.liferay.portal.NoSuchLayoutException" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.text.SimpleDateFormat" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<c:set var="pns"><portlet:namespace/></c:set>

<%
String redirect = ParamUtil.getString(request, "redirect");
String currentURL = PortalUtil.getCurrentURL(request);
%>
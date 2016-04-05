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
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.rivetlogic.microsite.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.rivetlogic.microsite.bean.MicroSiteBean;
import com.rivetlogic.microsite.bean.impl.MicroSiteBeanImpl;
import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil;
import com.rivetlogic.microsite.util.MicroSiteConstants;
import com.rivetlogic.microsite.util.MicroSiteUtil;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class MicroSitePortlet
 */
public class MicroSitePortlet extends MVCPortlet {
 
    private static final String MVC_PATH = "mvcPath";
    private static final String ADD_JSP = "/html/microsite/edit.jsp";
    @Override
    public void doView(RenderRequest request, RenderResponse response) 
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String tabs1 = request.getParameter("tabs1");
        request.setAttribute("tabs1", tabs1);
        try {
            long companyId = themeDisplay.getCompanyId();
            long userId = themeDisplay.getUserId();
            request.setAttribute(MicroSiteConstants.MICRO_SITES_LIST,
                    MicroSiteUtil.findAllMicroSites(companyId, userId));
            if(themeDisplay.isSignedIn()) {
                request.setAttribute(MicroSiteConstants.SITE_REQUESTS_LIST,
                        SiteRequestLocalServiceUtil.findByCompanyGroup(
                                themeDisplay.getCompanyGroupId(), themeDisplay.getScopeGroupId()));
            } else {
                request.setAttribute(MicroSiteConstants.SITE_REQUESTS_LIST,
                        new ArrayList<SiteRequest>());
            }
        } catch (SystemException e) {
            _log.error(e);
        } catch (PortalException e) {
            _log.error(e);
        }
        super.doView(request, response);
    }
    
    @Override
    public void render(RenderRequest request, RenderResponse response) 
            throws PortletException, IOException {
        ThemeDisplay themeDisplay;
        MicroSiteBean microSitesBean = null;
        
        long liveGroupId = ParamUtil.getLong(request,
                MicroSiteConstants.MICRO_SITE_LIVE_GROUP_ID,
                MicroSiteConstants.LONG_MIN_VALUE);
        
        if(liveGroupId != MicroSiteConstants.LONG_MIN_VALUE) {
            themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            try {
                microSitesBean = MicroSiteUtil.getMicroSite(themeDisplay.getCompanyId(),
                        liveGroupId, themeDisplay.getUserId());
            } catch (PortalException e) {
                _log.error(e);
            } catch (SystemException e) {
                _log.error(e);
            }
        } else {
            microSitesBean = new MicroSiteBeanImpl();
        }
        request.setAttribute(MicroSiteConstants.MICRO_SITE_BEAN, microSitesBean);
        super.render(request, response);
    }

    public void createMicroSite(ActionRequest request, ActionResponse response) 
            throws PortalException, SystemException {
        try {
            MicroSiteUtil.createMicroSite(request);
            sendRedirect(request, response);
        } catch (Exception e) {
        	PortalUtil.copyRequestParameters(request, response);
        	response.setRenderParameter(MVC_PATH, ADD_JSP);
            _log.error(e);
        }
    }
    
    public void activateSite(ActionRequest request, ActionResponse response) throws IOException{
    	Long microSiteId = ParamUtil.getLong(request, MicroSiteConstants.MICRO_SITE_ID, MicroSiteConstants.LONG_MIN_VALUE);
    	if(microSiteId != MicroSiteConstants.LONG_MIN_VALUE){
    		try {
				Group  group = GroupLocalServiceUtil.getGroup(microSiteId);
				group.setActive(true);
				GroupLocalServiceUtil.updateGroup(group);
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
    	}
    	
    }
    
    
    public void updateStatus(ActionRequest request, ActionResponse response) throws Exception {
        long siteRequestId = ParamUtil.getLong(request, MicroSiteConstants.SITE_REQUEST_ID, -1);
        long userId = ParamUtil.getLong(request, MicroSiteConstants.SITE_REQUEST_USER_ID, -1);
        long companyId =  ParamUtil.getLong(request, MicroSiteConstants.SITE_REQUEST_COMPANY_ID, -1);
        long siteId = ParamUtil.getLong(request, MicroSiteConstants.SITE_REQUEST_SITE_ID, -1);
        boolean setAdmin = ParamUtil.getBoolean(request, MicroSiteConstants.SITE_REQUEST_SET_ADMIN, false);
        User admin = (User) request.getAttribute(WebKeys.USER);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(MicroSitePortlet.class.getName(), request);
        
        if(siteRequestId >= 0) {
            try {
                String newStatus = ParamUtil.getString(request, MicroSiteConstants.SITE_REQUEST_STATUS);
                String message = null;
                if(newStatus.equals(MicroSiteConstants.REQUEST_STATUS_REJECTED)) {
                    message = ParamUtil.getString(request, MicroSiteConstants.SITE_REQUEST_RESPONSE);
                }
                SiteRequestLocalServiceUtil.updateStatus(siteRequestId, siteId, newStatus, message, admin.getUserId(), setAdmin, serviceContext);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        if(setAdmin && siteId >= 0) { // optionally set user as admin of microsite
            try {
                Role role = RoleLocalServiceUtil.getRole(companyId, MicroSiteConstants.MICRO_SITE_ADMINISTRATOR);
                long[] SiteroleIds = {role.getRoleId()};
                UserGroupRoleLocalServiceUtil.addUserGroupRoles(userId, siteId, SiteroleIds);
            } catch (PortalException e) {
                _log.error(e);
            } catch (SystemException e) {
                _log.error(e);
            }
            
        }
        
        sendRedirect(request, response);
    }
    
    private static final Log _log = LogFactoryUtil.getLog(MicroSitePortlet.class);
}

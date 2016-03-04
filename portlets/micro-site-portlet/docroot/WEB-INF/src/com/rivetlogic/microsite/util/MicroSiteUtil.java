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

package com.rivetlogic.microsite.util;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.sites.util.SitesUtil;
import com.rivetlogic.microsite.action.startup.ExpandoStartupAction;
import com.rivetlogic.microsite.bean.MicroSiteBean;
import com.rivetlogic.microsite.bean.SiteTemplateBean;
import com.rivetlogic.microsite.bean.impl.MicroSiteBeanImpl;
import com.rivetlogic.microsite.bean.impl.SiteTemplateBeanImpl;
import com.rivetlogic.microsite.model.MicroSite;
import com.rivetlogic.microsite.service.MicroSiteLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public class MicroSiteUtil {
    
    public static List<MicroSiteBean> subList(List<MicroSiteBean> list, Integer start, Integer end) {
        if (list != null) {
            return ListUtil.subList(list, start, end);
        } else {
            return new ArrayList<MicroSiteBean>();
        }
    }
    
    public static MicroSiteBean getMicroSite(long companyId,long groupId, long userId) throws PortalException, SystemException {
        Group group;
        LayoutSet layoutSet;
        LayoutSetPrototype layoutSetPrototype;
        MicroSiteBean microSitesBean = null;
        try {
            group = GroupLocalServiceUtil.getGroup(groupId);
            microSitesBean = new MicroSiteBeanImpl();
            microSitesBean.setMicroSiteId(group.getGroupId());
            microSitesBean.setGroupId(group.getGroupId());
            microSitesBean.setName(group.getName());
            microSitesBean.setDescription(group.getDescription());
            microSitesBean.setActive(group.isActive());
            microSitesBean.setFriendlyURL(group.getFriendlyURL());
            microSitesBean.setType(group.getType());
            microSitesBean.setManualMembership(group.getManualMembership());
            
            layoutSet = group.getPrivateLayoutSet();
            if(!layoutSet.getLayoutSetPrototypeUuid().isEmpty()) {
                layoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(
                        layoutSet.getLayoutSetPrototypeUuid(), companyId);
                microSitesBean.setPrivateLayoutSetPrototypeId(layoutSetPrototype.getLayoutSetPrototypeId());
                microSitesBean.setPrivateLayoutSetPrototypeLinkEnabled(layoutSet.getLayoutSetPrototypeLinkEnabled());
            }
            layoutSet = group.getPublicLayoutSet();
            if(!layoutSet.getLayoutSetPrototypeUuid().isEmpty()) {
                layoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(
                        layoutSet.getLayoutSetPrototypeUuid(), companyId);
                microSitesBean.setPublicLayoutSetPrototypeId(layoutSetPrototype.getLayoutSetPrototypeId());
                microSitesBean.setPublicLayoutSetPrototypeLinkEnabled(layoutSet.getLayoutSetPrototypeLinkEnabled());
            }
        } catch (NoSuchGroupException e) {
            MicroSite microSite = MicroSiteLocalServiceUtil.findByCompanyGroupUser(companyId, groupId, userId);
            if(microSite != null) {
                MicroSiteLocalServiceUtil.deleteMicroSite(microSite);
            }
        }
        return microSitesBean;
    }

    public static String getMicroSiteNameInList (long microSiteId, List<MicroSiteBean> microSitesList) throws PortalException, SystemException {
        String microSiteName = "";
        for(MicroSiteBean site: microSitesList) {
            if (site.getMicroSiteId() == microSiteId) {
                microSiteName = site.getName();
            }
        }

        return microSiteName;
    }
    
    public static List<SiteTemplateBean> getSiteTemplateList(PortletRequest request) 
            throws SystemException, PortalException {
        SiteTemplateBean siteTemplateBean;
        List<SiteTemplateBean> siteTemplateBeans = new ArrayList<SiteTemplateBean>();
        
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        //Get the layout set prototypes
        List<LayoutSetPrototype> layoutSetPrototypes = 
                LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypes(themeDisplay.getCompanyId());
        for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {
        	
        	Boolean hasAttribute = layoutSetPrototype.getExpandoBridge().hasAttribute(ExpandoStartupAction.COLUMN_NAME);
        	
        	if(hasAttribute){
        		boolean allowedToUse = (Boolean) layoutSetPrototype.getExpandoBridge()
            			.getAttribute(ExpandoStartupAction.COLUMN_NAME);
            	if(allowedToUse){
            		siteTemplateBean = new SiteTemplateBeanImpl();
                    siteTemplateBean.setId(layoutSetPrototype.getLayoutSetPrototypeId());
                    siteTemplateBean.setName(layoutSetPrototype.getNameCurrentValue());
                    siteTemplateBeans.add(siteTemplateBean);
            	}
        	}
        	
            
        }
        return siteTemplateBeans;
    }
    
    public static List<MicroSiteBean> findAllMicroSites(long companyId, long userId)
            throws SystemException, PortalException {
        MicroSiteBean microSitesBean;
        List<MicroSiteBean> microSitesBeans = new ArrayList<MicroSiteBean>();
        List<MicroSite> microSites =  MicroSiteLocalServiceUtil.findByCompanyUser(companyId, userId);
        for (MicroSite microSite : microSites) {
            microSitesBean = getMicroSite(companyId, microSite.getGroupId(),userId);
            if(microSitesBean != null) {
                microSitesBeans.add(microSitesBean);
            }
        }
        return microSitesBeans;
    }
    
    @SuppressWarnings("unchecked")
    public static List<MicroSiteBean> getMicroSitesList(HttpServletRequest request) {
        return (List<MicroSiteBean>) request.getAttribute(MicroSiteConstants.MICRO_SITES_LIST);
    }
    
    public static void createMicroSite(ActionRequest request) throws Exception{
        
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        
        String cmd = ParamUtil.getString(request, Constants.CMD);
        
        try {
            if (cmd.equals(Constants.ADD)) {
                Group group = updateGroup(request);
                long microSiteId = CounterLocalServiceUtil.increment(MicroSite.class.getName());
                MicroSite microSite = MicroSiteLocalServiceUtil.createMicroSite(microSiteId);
                microSite.setCompanyId(themeDisplay.getCompanyId());
                microSite.setUserId(themeDisplay.getUserId());
                microSite.setUserName(themeDisplay.getUser().getScreenName());
                microSite.setCreateDate(new Date());
                microSite.setModifiedDate(new Date());
                microSite.setGroupId(group.getGroupId());
                MicroSiteLocalServiceUtil.updateMicroSite(microSite);
            }
        }
        catch (Exception e) {
            SessionErrors.add(request, e.getClass());
            throw e;
        }
    }

    protected static Group updateGroup(ActionRequest actionRequest) throws Exception {

        String name;
        String description;
        int type;
        String friendlyURL;
        boolean active;
        boolean manualMembership;
        long publicLayoutSetPrototypeId = 0;
        long privateLayoutSetPrototypeId = 0;

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long liveGroupId = ParamUtil.getLong(actionRequest, MicroSiteConstants.MICRO_SITE_LIVE_GROUP_ID);

        long parentGroupId = ParamUtil.getLong(actionRequest, MicroSiteConstants.MICRO_SITE_PARENT_GROUP_ID,
                GroupConstants.DEFAULT_PARENT_GROUP_ID);

        int membershipRestriction = GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION;

        boolean actionRequestMembershipRestriction = ParamUtil.getBoolean(actionRequest,
                MicroSiteConstants.MICRO_SITE_MEMBERSHIP_RESTRICTION);

        if (actionRequestMembershipRestriction && (parentGroupId != GroupConstants.DEFAULT_PARENT_GROUP_ID)) {

            membershipRestriction = GroupConstants.MEMBERSHIP_RESTRICTION_TO_PARENT_SITE_MEMBERS;
        }

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Group.class.getName(), actionRequest);

        Group liveGroup = null;

        if (liveGroupId <= 0) {

            // Add group

            name = ParamUtil.getString(actionRequest, MicroSiteConstants.MICRO_SITE_NAME);
            description = ParamUtil.getString(actionRequest, MicroSiteConstants.MICRO_SITE_DESCRIPTION);
            type = ParamUtil.getInteger(actionRequest, MicroSiteConstants.MICRO_SITE_TYPE);
            friendlyURL = ParamUtil.getString(actionRequest, MicroSiteConstants.MICRO_SITE_FRIENDLY_URL);
            active = ParamUtil.getBoolean(actionRequest, MicroSiteConstants.MICRO_SITE_ACTIVE);
            manualMembership = ParamUtil.getBoolean(actionRequest, MicroSiteConstants.MICRO_SITE_MANUAL_MEMBERSHIP);

            liveGroup = GroupServiceUtil.addGroup(parentGroupId, GroupConstants.DEFAULT_LIVE_GROUP_ID, name,
                    description, type, manualMembership, membershipRestriction, friendlyURL, true, active,
                    serviceContext);

            LayoutSet publicLayoutSet = liveGroup.getPublicLayoutSet();
            LayoutSet privateLayoutSet = liveGroup.getPrivateLayoutSet();

            // Layout set prototypes

            if (!liveGroup.isStaged()) {
                privateLayoutSetPrototypeId = ParamUtil.getLong(actionRequest, 
                        MicroSiteConstants.MICRO_SITE_PRIVATE_LAYOUT_SET_PROTOTYPE_ID);
                publicLayoutSetPrototypeId = ParamUtil.getLong(actionRequest, 
                        MicroSiteConstants.MICRO_SITE_PUBLIC_LAYOUT_SET_PROTOTYPE_ID);

                boolean privateLayoutSetPrototypeLinkEnabled = ParamUtil.getBoolean(actionRequest,
                        MicroSiteConstants.MICRO_SITE_PRIVATE_LAYOUT_SET_PROTOTYPE_LINK_ENABLED, 
                        privateLayoutSet.isLayoutSetPrototypeLinkEnabled());
                boolean publicLayoutSetPrototypeLinkEnabled = ParamUtil.getBoolean(actionRequest,
                        MicroSiteConstants.MICRO_SITE_PUBLIC_LAYOUT_SET_PROTOTYPE_LINK_ENABLED, 
                        publicLayoutSet.isLayoutSetPrototypeLinkEnabled());

                SitesUtil.updateLayoutSetPrototypesLinks(liveGroup, publicLayoutSetPrototypeId,
                        privateLayoutSetPrototypeId, publicLayoutSetPrototypeLinkEnabled,
                        privateLayoutSetPrototypeLinkEnabled);
            }

            if (!privateLayoutSet.isLayoutSetPrototypeLinkActive() 
                    && !publicLayoutSet.isLayoutSetPrototypeLinkActive()) {

                if (liveGroup.hasStagingGroup() && (themeDisplay.getScopeGroupId() != liveGroup.getGroupId())) {

                    Layout firstLayout = LayoutLocalServiceUtil.fetchFirstLayout(liveGroup.getGroupId(), false,
                            LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

                    if (firstLayout == null) {
                        firstLayout = LayoutLocalServiceUtil.fetchFirstLayout(liveGroup.getGroupId(), true,
                                LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
                    }
                }

                StagingUtil.updateStaging(actionRequest, liveGroup);
            }
            if(publicLayoutSetPrototypeId > 0){
                LayoutLocalServiceUtil.getLayouts(liveGroup.getGroupId(), false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
            }
            if(privateLayoutSetPrototypeId > 0){
                LayoutLocalServiceUtil.getLayouts(liveGroup.getGroupId(), true, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
            }
        }
        return liveGroup;
    }
     
    public static String getMicroSiteURL(PortletRequest request, long groupId) 
            throws PortalException, SystemException {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        Group liveGroup = GroupLocalServiceUtil.getGroup(groupId);
        int layoutCount = LayoutLocalServiceUtil.getLayoutsCount(liveGroup, false);
        if(layoutCount > 0) {
            return scheme + HTTP_PREFIX  + serverName + StringPool.COLON + serverPort + StringPool.FORWARD_SLASH 
            		+ PUBLIC_PAGE_PREFIX + liveGroup.getFriendlyURL();
        }
        layoutCount = LayoutLocalServiceUtil.getLayoutsCount(liveGroup, true);
        if(layoutCount > 0) {
            return scheme + HTTP_PREFIX + serverName + StringPool.COLON + serverPort + StringPool.FORWARD_SLASH 
            		+ PRIVATE_PAGE_PREFIX + liveGroup.getFriendlyURL();
        }
        return StringPool.POUND;
    }
    
    private final static String PUBLIC_PAGE_PREFIX = "web";
    private final static String PRIVATE_PAGE_PREFIX = "group";
    private final static String HTTP_PREFIX = "://";
}

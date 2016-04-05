/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
package com.rivetlogic.microsite.notifications;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil;
import com.rivetlogic.microsite.util.MicroSiteConstants;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class MicrositeNotificationHandler extends BaseUserNotificationHandler {
	public static final String MICROSITES_PORTLET_ID = "microsite_WAR_micrositeportlet";
	public static final String MY_SITES_PORTLET_ID = "29";

	public MicrositeNotificationHandler() {
		setPortletId(MICROSITES_PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, 
			ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		long siteRequestId = jsonObject.getLong("siteRequestId");
		SiteRequest microsite = SiteRequestLocalServiceUtil.getSiteRequest(siteRequestId);
		
		if (Validator.isNull(microsite)) {
			UserNotificationEventLocalServiceUtil.deleteUserNotificationEvent(userNotificationEvent.getPrimaryKey());
			return null;
		}
		
		long userId = jsonObject.getLong("userId");
		String notificationType = jsonObject.getString("notificationType");
		String title = getTitle(serviceContext, userId, notificationType);
		
		return StringUtil.replace(
				getBodyTemplate(),
				new String[] { "[$TITLE$]", "[$NAME$]", "[$BODY_TEXT$]" },
				new String[] { title, HtmlUtil.escape(StringUtil.shorten(microsite.getName(), 50)),
						HtmlUtil.escape(StringUtil.shorten(microsite.getDescription(), 50)) });
	}
	
	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent, 
			ServiceContext serviceContext) throws Exception {
	    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
        String notificationType = jsonObject.getString("notificationType");
        ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
        long portletPlid = 0L;
        PortletURL portletUrl = null;
	    
	    switch(notificationType) {
            case MicroSiteConstants.REQUEST_STATUS_PENDING:
                portletPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), MICROSITES_PORTLET_ID);
                if(portletPlid != 0) {
                    portletUrl = PortletURLFactoryUtil.
                          create(serviceContext.getLiferayPortletRequest(), MICROSITES_PORTLET_ID, portletPlid, PortletRequest.RENDER_PHASE);
                    portletUrl.setParameter("redirect", serviceContext.getLayoutFullURL());
                    portletUrl.setParameter("tabs1","micro-sites-requests");
                    return portletUrl.toString();
                }
                return null;
            case MicroSiteConstants.REQUEST_STATUS_COMPLETE:
                long siteId = jsonObject.getLong("siteId");
                Group group = GroupLocalServiceUtil.fetchGroup(siteId);
                if(group != null) {
                    return "/web" + group.getFriendlyURL();
                }
                return null;
            case MicroSiteConstants.REQUEST_STATUS_REJECTED:
                portletPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), MY_SITES_PORTLET_ID);
                if(portletPlid != 0) {
                    portletUrl = PortletURLFactoryUtil.
                          create(serviceContext.getLiferayPortletRequest(), MY_SITES_PORTLET_ID, portletPlid, PortletRequest.RENDER_PHASE);
                    portletUrl.setParameter("redirect", serviceContext.getLayoutFullURL());
                    portletUrl.setParameter("tabs1","micro-sites-requests");
                    return portletUrl.toString();
                }
                return null;
            default:
                return null;
        }
	    
	}

	private String getBodyTemplate() {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">[$TITLE$]</div>");
		sb.append("<div class=\"body\"><i>[$NAME$]:</i> [$BODY_TEXT$]</div>");
		return sb.toString();
	}

	private String getTitle(ServiceContext serviceContext, long userId,
			String notificationType) {
		String title = "";
		switch(notificationType) {
			case MicroSiteConstants.REQUEST_STATUS_COMPLETE:
				title = "site-request-completed-notification";
				break;
			case MicroSiteConstants.REQUEST_STATUS_PENDING:
				title = "site-request-processing-notification";
				break;
			case MicroSiteConstants.REQUEST_STATUS_REJECTED:
				title = "site-request-rejected-notification";
			default:
				break;
		}
		return serviceContext.translate(title, HtmlUtil.escape(PortalUtil.getUserName(userId, StringPool.BLANK)));
	}
}

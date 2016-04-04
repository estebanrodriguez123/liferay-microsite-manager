/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.microsite.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.rivetlogic.microsite.NoSuchSiteRequestException;
import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.notifications.MicrositeNotificationHandler;
import com.rivetlogic.microsite.service.base.SiteRequestLocalServiceBaseImpl;
import com.rivetlogic.microsite.util.MicroSiteConstants;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the Site Request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.microsite.service.SiteRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jose.ross
 * @see com.rivetlogic.microsite.service.base.SiteRequestLocalServiceBaseImpl
 * @see com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil
 */
public class SiteRequestLocalServiceImpl extends SiteRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil} to access the Site Request local service.
	 */
    
    public List<SiteRequest> findAll() 
            throws SystemException {
        return siteRequestPersistence.findAll();
    }
    
    public List<SiteRequest> findAll(int start, int end) 
            throws SystemException {
        return siteRequestPersistence.findAll(start, end);
    }
    
    public List<SiteRequest> findByCompanyGroup(long companyId, long groupId)
            throws SystemException {
        return siteRequestPersistence.findByCompanyGroup(companyId, groupId);
    }
    
    public List<SiteRequest> findByCompanyGroupUser(long companyId, long groupId, long userId)
            throws SystemException {
        return siteRequestPersistence.findByCompanyGroupUser(companyId, groupId, userId);
    }
    
    public List<SiteRequest> findByCompanyGroupUser(long companyId, long groupId, long userId, int start, int end) 
            throws SystemException {
        return siteRequestPersistence.findByCompanyGroupUser(companyId, groupId, userId, start, end);
    }
    
    public void add(long companyId, long groupId, long userId, String name, String description, ServiceContext serviceContext) 
            throws SystemException {
        long id = counterLocalService.increment(SiteRequest.class.getName());
        SiteRequest siteRequest = siteRequestPersistence.create(id);
        
        siteRequest.setCompanyId(companyId);
        siteRequest.setGroupId(groupId);
        siteRequest.setUserId(userId);
        siteRequest.setName(name);
        siteRequest.setDescription(description);
        Date now = new Date();
        siteRequest.setCreateDate(now);
        siteRequest.setModifiedDate(now);
        siteRequest.setStatus(MicroSiteConstants.REQUEST_STATUS_PENDING);
		
		siteRequestPersistence.update(siteRequest);
		
		JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();

		notificationEventJSONObject.put("siteRequestId", id);
		notificationEventJSONObject.put("userId", siteRequest.getUserId());
		notificationEventJSONObject.put("notificationType", MicroSiteConstants.REQUEST_STATUS_PENDING);
        notificationEventJSONObject.put("siteRequestName", siteRequest.getName());
        notificationEventJSONObject.put("siteRequestDescription", siteRequest.getDescription());

		try {
			Role role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "MICROSITE_REQUESTS_MANAGER");
			if (Validator.isNotNull(role)) {
				List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());

				for (User adminUser : users) {
					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(adminUser.getUserId(), 
							MicrositeNotificationHandler.MICROSITES_PORTLET_ID, new Date().getTime(), siteRequest.getUserId(), 
							notificationEventJSONObject.toString(), false, serviceContext);
				}

			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
    }
    
    public void updateStatus(long siteRequestId, long siteId, String newStatus, 
    		String message, long adminId, boolean setAdmin, ServiceContext serviceContext)
            throws NoSuchSiteRequestException, SystemException {
        SiteRequest siteRequest = siteRequestPersistence.findByPrimaryKey(siteRequestId);
        
        if(message != null) {
            siteRequest.setResponse(message);
        }
        siteRequest.setStatus(newStatus);
        siteRequest.setModifiedDate(new Date());
        siteRequest.setSiteId(siteId);
        siteRequest.setAdmin(setAdmin);
        
        siteRequestPersistence.update(siteRequest);

        if (newStatus.equals(MicroSiteConstants.REQUEST_STATUS_COMPLETE) ||
            newStatus.equals(MicroSiteConstants.REQUEST_STATUS_REJECTED)) {
            
        	JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();

    		notificationEventJSONObject.put("siteRequestId", siteRequest.getSiteRequestId());
    		notificationEventJSONObject.put("userId", siteRequest.getUserId());
    		notificationEventJSONObject.put("notificationType", newStatus);
            notificationEventJSONObject.put("siteRequestName", siteRequest.getName());
            notificationEventJSONObject.put("siteRequestDescription", siteRequest.getDescription());
            notificationEventJSONObject.put("siteId", siteId);
            
        	try {
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(siteRequest.getUserId(), 
						MicrositeNotificationHandler.MICROSITES_PORTLET_ID, new Date().getTime(), adminId, 
						notificationEventJSONObject.toString(), false, serviceContext);
				
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
        }
    }
    
    private static final Log _log = LogFactoryUtil.getLog(SiteRequestLocalServiceImpl.class);
    
}
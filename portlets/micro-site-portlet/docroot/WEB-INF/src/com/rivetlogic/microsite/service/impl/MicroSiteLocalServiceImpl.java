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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.rivetlogic.microsite.service.base.MicroSiteLocalServiceBaseImpl;
import com.rivetlogic.microsite.NoSuchMicroSiteException;
import com.rivetlogic.microsite.model.MicroSite;
import com.rivetlogic.microsite.service.persistence.MicroSiteUtil;

/**
 * The implementation of the micro site local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.microsite.service.MicroSiteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author steven.barba
 * @see com.rivetlogic.microsite.service.base.MicroSiteLocalServiceBaseImpl
 * @see com.rivetlogic.microsite.service.MicroSiteLocalServiceUtil
 */
public class MicroSiteLocalServiceImpl extends MicroSiteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.microsite.service.MicroSiteLocalServiceUtil} to access the micro site local service.
	 */
    
    public List<MicroSite> findByCompanyUser(long companyId, long userId) 
            throws SystemException {
        return MicroSiteUtil.findByCompanyUser(companyId, userId);
    }
    
    public MicroSite findByGroupId(long groupId) 
            throws SystemException, NoSuchMicroSiteException {
        return MicroSiteUtil.findByGroupId(groupId);
    }
    
    public MicroSite findByCompanyGroupUser(long companyId, long groupId, long userId) 
            throws NoSuchMicroSiteException, SystemException {
        return MicroSiteUtil.findByCompanyGroupUser(companyId, groupId, userId);
    }
}
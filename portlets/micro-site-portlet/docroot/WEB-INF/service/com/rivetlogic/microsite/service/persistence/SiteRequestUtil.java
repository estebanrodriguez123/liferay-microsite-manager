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

package com.rivetlogic.microsite.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.microsite.model.SiteRequest;

import java.util.List;

/**
 * The persistence utility for the Site Request service. This utility wraps {@link SiteRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author steven.barba
 * @see SiteRequestPersistence
 * @see SiteRequestPersistenceImpl
 * @generated
 */
public class SiteRequestUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SiteRequest siteRequest) {
		getPersistence().clearCache(siteRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SiteRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SiteRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SiteRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SiteRequest update(SiteRequest siteRequest)
		throws SystemException {
		return getPersistence().update(siteRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SiteRequest update(SiteRequest siteRequest,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(siteRequest, serviceContext);
	}

	/**
	* Returns all the Site Requests where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the Site Requests where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of Site Requests
	* @param end the upper bound of the range of Site Requests (not inclusive)
	* @return the range of matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the Site Requests where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of Site Requests
	* @param end the upper bound of the range of Site Requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Site Request, or <code>null</code> if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Site Request, or <code>null</code> if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the Site Requests before and after the current Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param siteRequestId the primary key of the current Site Request
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest[] findByCompanyGroup_PrevAndNext(
		long siteRequestId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(siteRequestId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the Site Requests where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of Site Requests where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Returns a range of all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Site Requests
	* @param end the upper bound of the range of Site Requests (not inclusive)
	* @return the range of matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroupUser(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroupUser(companyId, groupId, userId, start,
			end);
	}

	/**
	* Returns an ordered range of all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Site Requests
	* @param end the upper bound of the range of Site Requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroupUser(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroupUser(companyId, groupId, userId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest findByCompanyGroupUser_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence()
				   .findByCompanyGroupUser_First(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Site Request, or <code>null</code> if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest fetchByCompanyGroupUser_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroupUser_First(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest findByCompanyGroupUser_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence()
				   .findByCompanyGroupUser_Last(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Site Request, or <code>null</code> if a matching Site Request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest fetchByCompanyGroupUser_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroupUser_Last(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the Site Requests before and after the current Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param siteRequestId the primary key of the current Site Request
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest[] findByCompanyGroupUser_PrevAndNext(
		long siteRequestId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence()
				   .findByCompanyGroupUser_PrevAndNext(siteRequestId,
			companyId, groupId, userId, orderByComparator);
	}

	/**
	* Removes all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroupUser(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Returns the number of Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroupUser(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Caches the Site Request in the entity cache if it is enabled.
	*
	* @param siteRequest the Site Request
	*/
	public static void cacheResult(
		com.rivetlogic.microsite.model.SiteRequest siteRequest) {
		getPersistence().cacheResult(siteRequest);
	}

	/**
	* Caches the Site Requests in the entity cache if it is enabled.
	*
	* @param siteRequests the Site Requests
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.microsite.model.SiteRequest> siteRequests) {
		getPersistence().cacheResult(siteRequests);
	}

	/**
	* Creates a new Site Request with the primary key. Does not add the Site Request to the database.
	*
	* @param siteRequestId the primary key for the new Site Request
	* @return the new Site Request
	*/
	public static com.rivetlogic.microsite.model.SiteRequest create(
		long siteRequestId) {
		return getPersistence().create(siteRequestId);
	}

	/**
	* Removes the Site Request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteRequestId the primary key of the Site Request
	* @return the Site Request that was removed
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest remove(
		long siteRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence().remove(siteRequestId);
	}

	public static com.rivetlogic.microsite.model.SiteRequest updateImpl(
		com.rivetlogic.microsite.model.SiteRequest siteRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(siteRequest);
	}

	/**
	* Returns the Site Request with the primary key or throws a {@link com.rivetlogic.microsite.NoSuchSiteRequestException} if it could not be found.
	*
	* @param siteRequestId the primary key of the Site Request
	* @return the Site Request
	* @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest findByPrimaryKey(
		long siteRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		return getPersistence().findByPrimaryKey(siteRequestId);
	}

	/**
	* Returns the Site Request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param siteRequestId the primary key of the Site Request
	* @return the Site Request, or <code>null</code> if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest fetchByPrimaryKey(
		long siteRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(siteRequestId);
	}

	/**
	* Returns all the Site Requests.
	*
	* @return the Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Site Requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Site Requests
	* @param end the upper bound of the range of Site Requests (not inclusive)
	* @return the range of Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Site Requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Site Requests
	* @param end the upper bound of the range of Site Requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Site Requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Site Requests.
	*
	* @return the number of Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SiteRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SiteRequestPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.microsite.service.ClpSerializer.getServletContextName(),
					SiteRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(SiteRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SiteRequestPersistence persistence) {
	}

	private static SiteRequestPersistence _persistence;
}
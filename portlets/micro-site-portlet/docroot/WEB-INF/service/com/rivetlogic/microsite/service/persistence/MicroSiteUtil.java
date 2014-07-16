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

import com.rivetlogic.microsite.model.MicroSite;

import java.util.List;

/**
 * The persistence utility for the micro site service. This utility wraps {@link MicroSitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author steven.barba
 * @see MicroSitePersistence
 * @see MicroSitePersistenceImpl
 * @generated
 */
public class MicroSiteUtil {
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
	public static void clearCache(MicroSite microSite) {
		getPersistence().clearCache(microSite);
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
	public static List<MicroSite> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MicroSite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MicroSite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MicroSite update(MicroSite microSite)
		throws SystemException {
		return getPersistence().update(microSite);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MicroSite update(MicroSite microSite,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(microSite, serviceContext);
	}

	/**
	* Returns the micro site where groupId = &#63; or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns the micro site where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId(groupId);
	}

	/**
	* Returns the micro site where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByGroupId(
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId(groupId, retrieveFromCache);
	}

	/**
	* Removes the micro site where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the micro site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite removeByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of micro sites where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the micro sites where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyUser(companyId, userId);
	}

	/**
	* Returns a range of all the micro sites where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of micro sites
	* @param end the upper bound of the range of micro sites (not inclusive)
	* @return the range of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyUser(companyId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the micro sites where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of micro sites
	* @param end the upper bound of the range of micro sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyUser(companyId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite findByCompanyUser_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence()
				   .findByCompanyUser_First(companyId, userId, orderByComparator);
	}

	/**
	* Returns the first micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByCompanyUser_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyUser_First(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the last micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite findByCompanyUser_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence()
				   .findByCompanyUser_Last(companyId, userId, orderByComparator);
	}

	/**
	* Returns the last micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByCompanyUser_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyUser_Last(companyId, userId, orderByComparator);
	}

	/**
	* Returns the micro sites before and after the current micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param microSiteId the primary key of the current micro site
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite[] findByCompanyUser_PrevAndNext(
		long microSiteId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence()
				   .findByCompanyUser_PrevAndNext(microSiteId, companyId,
			userId, orderByComparator);
	}

	/**
	* Removes all the micro sites where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyUser(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyUser(companyId, userId);
	}

	/**
	* Returns the number of micro sites where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyUser(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyUser(companyId, userId);
	}

	/**
	* Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite findByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence()
				   .findByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByCompanyGroupUser(
		long companyId, long groupId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroupUser(companyId, groupId, userId,
			retrieveFromCache);
	}

	/**
	* Removes the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the micro site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite removeByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence()
				   .removeByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Returns the number of micro sites where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroupUser(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompanyGroupUser(companyId, groupId, userId);
	}

	/**
	* Caches the micro site in the entity cache if it is enabled.
	*
	* @param microSite the micro site
	*/
	public static void cacheResult(
		com.rivetlogic.microsite.model.MicroSite microSite) {
		getPersistence().cacheResult(microSite);
	}

	/**
	* Caches the micro sites in the entity cache if it is enabled.
	*
	* @param microSites the micro sites
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.microsite.model.MicroSite> microSites) {
		getPersistence().cacheResult(microSites);
	}

	/**
	* Creates a new micro site with the primary key. Does not add the micro site to the database.
	*
	* @param microSiteId the primary key for the new micro site
	* @return the new micro site
	*/
	public static com.rivetlogic.microsite.model.MicroSite create(
		long microSiteId) {
		return getPersistence().create(microSiteId);
	}

	/**
	* Removes the micro site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site that was removed
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite remove(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence().remove(microSiteId);
	}

	public static com.rivetlogic.microsite.model.MicroSite updateImpl(
		com.rivetlogic.microsite.model.MicroSite microSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(microSite);
	}

	/**
	* Returns the micro site with the primary key or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite findByPrimaryKey(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getPersistence().findByPrimaryKey(microSiteId);
	}

	/**
	* Returns the micro site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site, or <code>null</code> if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite fetchByPrimaryKey(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(microSiteId);
	}

	/**
	* Returns all the micro sites.
	*
	* @return the micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the micro sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of micro sites
	* @param end the upper bound of the range of micro sites (not inclusive)
	* @return the range of micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the micro sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of micro sites
	* @param end the upper bound of the range of micro sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the micro sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of micro sites.
	*
	* @return the number of micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MicroSitePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MicroSitePersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.microsite.service.ClpSerializer.getServletContextName(),
					MicroSitePersistence.class.getName());

			ReferenceRegistry.registerReference(MicroSiteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MicroSitePersistence persistence) {
	}

	private static MicroSitePersistence _persistence;
}
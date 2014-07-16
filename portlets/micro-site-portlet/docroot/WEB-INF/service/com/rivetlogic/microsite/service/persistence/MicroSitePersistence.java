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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.microsite.model.MicroSite;

/**
 * The persistence interface for the micro site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author steven.barba
 * @see MicroSitePersistenceImpl
 * @see MicroSiteUtil
 * @generated
 */
public interface MicroSitePersistence extends BasePersistence<MicroSite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MicroSiteUtil} to access the micro site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the micro site where groupId = &#63; or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the micro site where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite fetchByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the micro site where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite fetchByGroupId(
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the micro site where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the micro site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite removeByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the number of micro sites where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the micro sites where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.microsite.model.MicroSite findByCompanyUser_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the first micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite fetchByCompanyUser_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.microsite.model.MicroSite findByCompanyUser_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the last micro site in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite fetchByCompanyUser_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.microsite.model.MicroSite[] findByCompanyUser_PrevAndNext(
		long microSiteId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Removes all the micro sites where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyUser(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of micro sites where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyUser(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.microsite.model.MicroSite findByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite fetchByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.microsite.model.MicroSite fetchByCompanyGroupUser(
		long companyId, long groupId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the micro site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite removeByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the number of micro sites where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching micro sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroupUser(long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the micro site in the entity cache if it is enabled.
	*
	* @param microSite the micro site
	*/
	public void cacheResult(com.rivetlogic.microsite.model.MicroSite microSite);

	/**
	* Caches the micro sites in the entity cache if it is enabled.
	*
	* @param microSites the micro sites
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.microsite.model.MicroSite> microSites);

	/**
	* Creates a new micro site with the primary key. Does not add the micro site to the database.
	*
	* @param microSiteId the primary key for the new micro site
	* @return the new micro site
	*/
	public com.rivetlogic.microsite.model.MicroSite create(long microSiteId);

	/**
	* Removes the micro site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site that was removed
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite remove(long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	public com.rivetlogic.microsite.model.MicroSite updateImpl(
		com.rivetlogic.microsite.model.MicroSite microSite)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the micro site with the primary key or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site
	* @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite findByPrimaryKey(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException;

	/**
	* Returns the micro site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site, or <code>null</code> if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.microsite.model.MicroSite fetchByPrimaryKey(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the micro sites.
	*
	* @return the micro sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.microsite.model.MicroSite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.microsite.model.MicroSite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.microsite.model.MicroSite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the micro sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of micro sites.
	*
	* @return the number of micro sites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

package com.rivetlogic.microsite.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SiteRequest. This utility wraps
 * {@link com.rivetlogic.microsite.service.impl.SiteRequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author steven.barba
 * @see SiteRequestLocalService
 * @see com.rivetlogic.microsite.service.base.SiteRequestLocalServiceBaseImpl
 * @see com.rivetlogic.microsite.service.impl.SiteRequestLocalServiceImpl
 * @generated
 */
public class SiteRequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.microsite.service.impl.SiteRequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the Site Request to the database. Also notifies the appropriate model listeners.
	*
	* @param siteRequest the Site Request
	* @return the Site Request that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest addSiteRequest(
		com.rivetlogic.microsite.model.SiteRequest siteRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSiteRequest(siteRequest);
	}

	/**
	* Creates a new Site Request with the primary key. Does not add the Site Request to the database.
	*
	* @param siteRequestId the primary key for the new Site Request
	* @return the new Site Request
	*/
	public static com.rivetlogic.microsite.model.SiteRequest createSiteRequest(
		long siteRequestId) {
		return getService().createSiteRequest(siteRequestId);
	}

	/**
	* Deletes the Site Request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteRequestId the primary key of the Site Request
	* @return the Site Request that was removed
	* @throws PortalException if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest deleteSiteRequest(
		long siteRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSiteRequest(siteRequestId);
	}

	/**
	* Deletes the Site Request from the database. Also notifies the appropriate model listeners.
	*
	* @param siteRequest the Site Request
	* @return the Site Request that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest deleteSiteRequest(
		com.rivetlogic.microsite.model.SiteRequest siteRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSiteRequest(siteRequest);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rivetlogic.microsite.model.SiteRequest fetchSiteRequest(
		long siteRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSiteRequest(siteRequestId);
	}

	/**
	* Returns the Site Request with the primary key.
	*
	* @param siteRequestId the primary key of the Site Request
	* @return the Site Request
	* @throws PortalException if a Site Request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest getSiteRequest(
		long siteRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSiteRequest(siteRequestId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> getSiteRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSiteRequests(start, end);
	}

	/**
	* Returns the number of Site Requests.
	*
	* @return the number of Site Requests
	* @throws SystemException if a system exception occurred
	*/
	public static int getSiteRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSiteRequestsCount();
	}

	/**
	* Updates the Site Request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param siteRequest the Site Request
	* @return the Site Request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.SiteRequest updateSiteRequest(
		com.rivetlogic.microsite.model.SiteRequest siteRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSiteRequest(siteRequest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(start, end);
	}

	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompanyGroupUser(companyId, groupId, userId);
	}

	public static java.util.List<com.rivetlogic.microsite.model.SiteRequest> findByCompanyGroupUser(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCompanyGroupUser(companyId, groupId, userId, start,
			end);
	}

	public static void add(long companyId, long groupId, long userId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.add(companyId, groupId, userId, name, description, serviceContext);
	}

	public static void updateStatus(long siteRequestId, long siteId,
		java.lang.String newStatus, java.lang.String message, long adminId,
		boolean setAdmin,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchSiteRequestException {
		getService()
			.updateStatus(siteRequestId, siteId, newStatus, message, adminId,
			setAdmin, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SiteRequestLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SiteRequestLocalService.class.getName());

			if (invokableLocalService instanceof SiteRequestLocalService) {
				_service = (SiteRequestLocalService)invokableLocalService;
			}
			else {
				_service = new SiteRequestLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SiteRequestLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SiteRequestLocalService service) {
	}

	private static SiteRequestLocalService _service;
}
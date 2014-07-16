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
 * Provides the local service utility for MicroSite. This utility wraps
 * {@link com.rivetlogic.microsite.service.impl.MicroSiteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author steven.barba
 * @see MicroSiteLocalService
 * @see com.rivetlogic.microsite.service.base.MicroSiteLocalServiceBaseImpl
 * @see com.rivetlogic.microsite.service.impl.MicroSiteLocalServiceImpl
 * @generated
 */
public class MicroSiteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.microsite.service.impl.MicroSiteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the micro site to the database. Also notifies the appropriate model listeners.
	*
	* @param microSite the micro site
	* @return the micro site that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite addMicroSite(
		com.rivetlogic.microsite.model.MicroSite microSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMicroSite(microSite);
	}

	/**
	* Creates a new micro site with the primary key. Does not add the micro site to the database.
	*
	* @param microSiteId the primary key for the new micro site
	* @return the new micro site
	*/
	public static com.rivetlogic.microsite.model.MicroSite createMicroSite(
		long microSiteId) {
		return getService().createMicroSite(microSiteId);
	}

	/**
	* Deletes the micro site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site that was removed
	* @throws PortalException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite deleteMicroSite(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMicroSite(microSiteId);
	}

	/**
	* Deletes the micro site from the database. Also notifies the appropriate model listeners.
	*
	* @param microSite the micro site
	* @return the micro site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite deleteMicroSite(
		com.rivetlogic.microsite.model.MicroSite microSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMicroSite(microSite);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rivetlogic.microsite.model.MicroSite fetchMicroSite(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMicroSite(microSiteId);
	}

	/**
	* Returns the micro site with the primary key.
	*
	* @param microSiteId the primary key of the micro site
	* @return the micro site
	* @throws PortalException if a micro site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite getMicroSite(
		long microSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMicroSite(microSiteId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> getMicroSites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMicroSites(start, end);
	}

	/**
	* Returns the number of micro sites.
	*
	* @return the number of micro sites
	* @throws SystemException if a system exception occurred
	*/
	public static int getMicroSitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMicroSitesCount();
	}

	/**
	* Updates the micro site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param microSite the micro site
	* @return the micro site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.microsite.model.MicroSite updateMicroSite(
		com.rivetlogic.microsite.model.MicroSite microSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMicroSite(microSite);
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

	public static java.util.List<com.rivetlogic.microsite.model.MicroSite> findByCompanyUser(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompanyUser(companyId, userId);
	}

	public static com.rivetlogic.microsite.model.MicroSite findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getService().findByGroupId(groupId);
	}

	public static com.rivetlogic.microsite.model.MicroSite findByCompanyGroupUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.microsite.NoSuchMicroSiteException {
		return getService().findByCompanyGroupUser(companyId, groupId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static MicroSiteLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MicroSiteLocalService.class.getName());

			if (invokableLocalService instanceof MicroSiteLocalService) {
				_service = (MicroSiteLocalService)invokableLocalService;
			}
			else {
				_service = new MicroSiteLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MicroSiteLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MicroSiteLocalService service) {
	}

	private static MicroSiteLocalService _service;
}
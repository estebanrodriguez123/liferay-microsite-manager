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

package com.rivetlogic.microsite.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SiteRequest}.
 * </p>
 *
 * @author steven.barba
 * @see SiteRequest
 * @generated
 */
public class SiteRequestWrapper implements SiteRequest,
	ModelWrapper<SiteRequest> {
	public SiteRequestWrapper(SiteRequest siteRequest) {
		_siteRequest = siteRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return SiteRequest.class;
	}

	@Override
	public String getModelClassName() {
		return SiteRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("siteRequestId", getSiteRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("response", getResponse());
		attributes.put("siteId", getSiteId());
		attributes.put("admin", getAdmin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long siteRequestId = (Long)attributes.get("siteRequestId");

		if (siteRequestId != null) {
			setSiteRequestId(siteRequestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String response = (String)attributes.get("response");

		if (response != null) {
			setResponse(response);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		Boolean admin = (Boolean)attributes.get("admin");

		if (admin != null) {
			setAdmin(admin);
		}
	}

	/**
	* Returns the primary key of this Site Request.
	*
	* @return the primary key of this Site Request
	*/
	@Override
	public long getPrimaryKey() {
		return _siteRequest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Site Request.
	*
	* @param primaryKey the primary key of this Site Request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_siteRequest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the site request ID of this Site Request.
	*
	* @return the site request ID of this Site Request
	*/
	@Override
	public long getSiteRequestId() {
		return _siteRequest.getSiteRequestId();
	}

	/**
	* Sets the site request ID of this Site Request.
	*
	* @param siteRequestId the site request ID of this Site Request
	*/
	@Override
	public void setSiteRequestId(long siteRequestId) {
		_siteRequest.setSiteRequestId(siteRequestId);
	}

	/**
	* Returns the group ID of this Site Request.
	*
	* @return the group ID of this Site Request
	*/
	@Override
	public long getGroupId() {
		return _siteRequest.getGroupId();
	}

	/**
	* Sets the group ID of this Site Request.
	*
	* @param groupId the group ID of this Site Request
	*/
	@Override
	public void setGroupId(long groupId) {
		_siteRequest.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this Site Request.
	*
	* @return the company ID of this Site Request
	*/
	@Override
	public long getCompanyId() {
		return _siteRequest.getCompanyId();
	}

	/**
	* Sets the company ID of this Site Request.
	*
	* @param companyId the company ID of this Site Request
	*/
	@Override
	public void setCompanyId(long companyId) {
		_siteRequest.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Site Request.
	*
	* @return the user ID of this Site Request
	*/
	@Override
	public long getUserId() {
		return _siteRequest.getUserId();
	}

	/**
	* Sets the user ID of this Site Request.
	*
	* @param userId the user ID of this Site Request
	*/
	@Override
	public void setUserId(long userId) {
		_siteRequest.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Site Request.
	*
	* @return the user uuid of this Site Request
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteRequest.getUserUuid();
	}

	/**
	* Sets the user uuid of this Site Request.
	*
	* @param userUuid the user uuid of this Site Request
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_siteRequest.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this Site Request.
	*
	* @return the create date of this Site Request
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _siteRequest.getCreateDate();
	}

	/**
	* Sets the create date of this Site Request.
	*
	* @param createDate the create date of this Site Request
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_siteRequest.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Site Request.
	*
	* @return the modified date of this Site Request
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _siteRequest.getModifiedDate();
	}

	/**
	* Sets the modified date of this Site Request.
	*
	* @param modifiedDate the modified date of this Site Request
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_siteRequest.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this Site Request.
	*
	* @return the name of this Site Request
	*/
	@Override
	public java.lang.String getName() {
		return _siteRequest.getName();
	}

	/**
	* Sets the name of this Site Request.
	*
	* @param name the name of this Site Request
	*/
	@Override
	public void setName(java.lang.String name) {
		_siteRequest.setName(name);
	}

	/**
	* Returns the description of this Site Request.
	*
	* @return the description of this Site Request
	*/
	@Override
	public java.lang.String getDescription() {
		return _siteRequest.getDescription();
	}

	/**
	* Sets the description of this Site Request.
	*
	* @param description the description of this Site Request
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_siteRequest.setDescription(description);
	}

	/**
	* Returns the status of this Site Request.
	*
	* @return the status of this Site Request
	*/
	@Override
	public java.lang.String getStatus() {
		return _siteRequest.getStatus();
	}

	/**
	* Sets the status of this Site Request.
	*
	* @param status the status of this Site Request
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_siteRequest.setStatus(status);
	}

	/**
	* Returns the response of this Site Request.
	*
	* @return the response of this Site Request
	*/
	@Override
	public java.lang.String getResponse() {
		return _siteRequest.getResponse();
	}

	/**
	* Sets the response of this Site Request.
	*
	* @param response the response of this Site Request
	*/
	@Override
	public void setResponse(java.lang.String response) {
		_siteRequest.setResponse(response);
	}

	/**
	* Returns the site ID of this Site Request.
	*
	* @return the site ID of this Site Request
	*/
	@Override
	public long getSiteId() {
		return _siteRequest.getSiteId();
	}

	/**
	* Sets the site ID of this Site Request.
	*
	* @param siteId the site ID of this Site Request
	*/
	@Override
	public void setSiteId(long siteId) {
		_siteRequest.setSiteId(siteId);
	}

	/**
	* Returns the admin of this Site Request.
	*
	* @return the admin of this Site Request
	*/
	@Override
	public boolean getAdmin() {
		return _siteRequest.getAdmin();
	}

	/**
	* Returns <code>true</code> if this Site Request is admin.
	*
	* @return <code>true</code> if this Site Request is admin; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdmin() {
		return _siteRequest.isAdmin();
	}

	/**
	* Sets whether this Site Request is admin.
	*
	* @param admin the admin of this Site Request
	*/
	@Override
	public void setAdmin(boolean admin) {
		_siteRequest.setAdmin(admin);
	}

	@Override
	public boolean isNew() {
		return _siteRequest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_siteRequest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _siteRequest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_siteRequest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _siteRequest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _siteRequest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_siteRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _siteRequest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_siteRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_siteRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_siteRequest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SiteRequestWrapper((SiteRequest)_siteRequest.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.microsite.model.SiteRequest siteRequest) {
		return _siteRequest.compareTo(siteRequest);
	}

	@Override
	public int hashCode() {
		return _siteRequest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.microsite.model.SiteRequest> toCacheModel() {
		return _siteRequest.toCacheModel();
	}

	@Override
	public com.rivetlogic.microsite.model.SiteRequest toEscapedModel() {
		return new SiteRequestWrapper(_siteRequest.toEscapedModel());
	}

	@Override
	public com.rivetlogic.microsite.model.SiteRequest toUnescapedModel() {
		return new SiteRequestWrapper(_siteRequest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _siteRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _siteRequest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_siteRequest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SiteRequestWrapper)) {
			return false;
		}

		SiteRequestWrapper siteRequestWrapper = (SiteRequestWrapper)obj;

		if (Validator.equals(_siteRequest, siteRequestWrapper._siteRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SiteRequest getWrappedSiteRequest() {
		return _siteRequest;
	}

	@Override
	public SiteRequest getWrappedModel() {
		return _siteRequest;
	}

	@Override
	public void resetOriginalValues() {
		_siteRequest.resetOriginalValues();
	}

	private SiteRequest _siteRequest;
}
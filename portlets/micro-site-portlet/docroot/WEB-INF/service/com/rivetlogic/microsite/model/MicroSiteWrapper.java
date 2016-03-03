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
 * This class is a wrapper for {@link MicroSite}.
 * </p>
 *
 * @author steven.barba
 * @see MicroSite
 * @generated
 */
public class MicroSiteWrapper implements MicroSite, ModelWrapper<MicroSite> {
	public MicroSiteWrapper(MicroSite microSite) {
		_microSite = microSite;
	}

	@Override
	public Class<?> getModelClass() {
		return MicroSite.class;
	}

	@Override
	public String getModelClassName() {
		return MicroSite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("microSiteId", getMicroSiteId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("siteId", getSiteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long microSiteId = (Long)attributes.get("microSiteId");

		if (microSiteId != null) {
			setMicroSiteId(microSiteId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}
	}

	/**
	* Returns the primary key of this micro site.
	*
	* @return the primary key of this micro site
	*/
	@Override
	public long getPrimaryKey() {
		return _microSite.getPrimaryKey();
	}

	/**
	* Sets the primary key of this micro site.
	*
	* @param primaryKey the primary key of this micro site
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_microSite.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the micro site ID of this micro site.
	*
	* @return the micro site ID of this micro site
	*/
	@Override
	public long getMicroSiteId() {
		return _microSite.getMicroSiteId();
	}

	/**
	* Sets the micro site ID of this micro site.
	*
	* @param microSiteId the micro site ID of this micro site
	*/
	@Override
	public void setMicroSiteId(long microSiteId) {
		_microSite.setMicroSiteId(microSiteId);
	}

	/**
	* Returns the company ID of this micro site.
	*
	* @return the company ID of this micro site
	*/
	@Override
	public long getCompanyId() {
		return _microSite.getCompanyId();
	}

	/**
	* Sets the company ID of this micro site.
	*
	* @param companyId the company ID of this micro site
	*/
	@Override
	public void setCompanyId(long companyId) {
		_microSite.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this micro site.
	*
	* @return the user ID of this micro site
	*/
	@Override
	public long getUserId() {
		return _microSite.getUserId();
	}

	/**
	* Sets the user ID of this micro site.
	*
	* @param userId the user ID of this micro site
	*/
	@Override
	public void setUserId(long userId) {
		_microSite.setUserId(userId);
	}

	/**
	* Returns the user uuid of this micro site.
	*
	* @return the user uuid of this micro site
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _microSite.getUserUuid();
	}

	/**
	* Sets the user uuid of this micro site.
	*
	* @param userUuid the user uuid of this micro site
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_microSite.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this micro site.
	*
	* @return the user name of this micro site
	*/
	@Override
	public java.lang.String getUserName() {
		return _microSite.getUserName();
	}

	/**
	* Sets the user name of this micro site.
	*
	* @param userName the user name of this micro site
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_microSite.setUserName(userName);
	}

	/**
	* Returns the create date of this micro site.
	*
	* @return the create date of this micro site
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _microSite.getCreateDate();
	}

	/**
	* Sets the create date of this micro site.
	*
	* @param createDate the create date of this micro site
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_microSite.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this micro site.
	*
	* @return the modified date of this micro site
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _microSite.getModifiedDate();
	}

	/**
	* Sets the modified date of this micro site.
	*
	* @param modifiedDate the modified date of this micro site
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_microSite.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group ID of this micro site.
	*
	* @return the group ID of this micro site
	*/
	@Override
	public long getGroupId() {
		return _microSite.getGroupId();
	}

	/**
	* Sets the group ID of this micro site.
	*
	* @param groupId the group ID of this micro site
	*/
	@Override
	public void setGroupId(long groupId) {
		_microSite.setGroupId(groupId);
	}

	/**
	* Returns the site ID of this micro site.
	*
	* @return the site ID of this micro site
	*/
	@Override
	public long getSiteId() {
		return _microSite.getSiteId();
	}

	/**
	* Sets the site ID of this micro site.
	*
	* @param siteId the site ID of this micro site
	*/
	@Override
	public void setSiteId(long siteId) {
		_microSite.setSiteId(siteId);
	}

	@Override
	public boolean isNew() {
		return _microSite.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_microSite.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _microSite.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_microSite.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _microSite.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _microSite.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_microSite.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _microSite.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_microSite.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_microSite.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_microSite.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MicroSiteWrapper((MicroSite)_microSite.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.microsite.model.MicroSite microSite) {
		return _microSite.compareTo(microSite);
	}

	@Override
	public int hashCode() {
		return _microSite.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.microsite.model.MicroSite> toCacheModel() {
		return _microSite.toCacheModel();
	}

	@Override
	public com.rivetlogic.microsite.model.MicroSite toEscapedModel() {
		return new MicroSiteWrapper(_microSite.toEscapedModel());
	}

	@Override
	public com.rivetlogic.microsite.model.MicroSite toUnescapedModel() {
		return new MicroSiteWrapper(_microSite.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _microSite.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _microSite.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_microSite.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MicroSiteWrapper)) {
			return false;
		}

		MicroSiteWrapper microSiteWrapper = (MicroSiteWrapper)obj;

		if (Validator.equals(_microSite, microSiteWrapper._microSite)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MicroSite getWrappedMicroSite() {
		return _microSite;
	}

	@Override
	public MicroSite getWrappedModel() {
		return _microSite;
	}

	@Override
	public void resetOriginalValues() {
		_microSite.resetOriginalValues();
	}

	private MicroSite _microSite;
}
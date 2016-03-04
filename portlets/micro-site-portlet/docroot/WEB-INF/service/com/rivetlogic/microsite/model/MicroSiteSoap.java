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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author steven.barba
 * @generated
 */
public class MicroSiteSoap implements Serializable {
	public static MicroSiteSoap toSoapModel(MicroSite model) {
		MicroSiteSoap soapModel = new MicroSiteSoap();

		soapModel.setMicroSiteId(model.getMicroSiteId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setSiteId(model.getSiteId());

		return soapModel;
	}

	public static MicroSiteSoap[] toSoapModels(MicroSite[] models) {
		MicroSiteSoap[] soapModels = new MicroSiteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MicroSiteSoap[][] toSoapModels(MicroSite[][] models) {
		MicroSiteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MicroSiteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MicroSiteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MicroSiteSoap[] toSoapModels(List<MicroSite> models) {
		List<MicroSiteSoap> soapModels = new ArrayList<MicroSiteSoap>(models.size());

		for (MicroSite model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MicroSiteSoap[soapModels.size()]);
	}

	public MicroSiteSoap() {
	}

	public long getPrimaryKey() {
		return _microSiteId;
	}

	public void setPrimaryKey(long pk) {
		setMicroSiteId(pk);
	}

	public long getMicroSiteId() {
		return _microSiteId;
	}

	public void setMicroSiteId(long microSiteId) {
		_microSiteId = microSiteId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	private long _microSiteId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private long _siteId;
}
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
public class SiteRequestSoap implements Serializable {
	public static SiteRequestSoap toSoapModel(SiteRequest model) {
		SiteRequestSoap soapModel = new SiteRequestSoap();

		soapModel.setSiteRequestId(model.getSiteRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setResponse(model.getResponse());
		soapModel.setSiteId(model.getSiteId());
		soapModel.setAdmin(model.getAdmin());

		return soapModel;
	}

	public static SiteRequestSoap[] toSoapModels(SiteRequest[] models) {
		SiteRequestSoap[] soapModels = new SiteRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SiteRequestSoap[][] toSoapModels(SiteRequest[][] models) {
		SiteRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SiteRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SiteRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SiteRequestSoap[] toSoapModels(List<SiteRequest> models) {
		List<SiteRequestSoap> soapModels = new ArrayList<SiteRequestSoap>(models.size());

		for (SiteRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SiteRequestSoap[soapModels.size()]);
	}

	public SiteRequestSoap() {
	}

	public long getPrimaryKey() {
		return _siteRequestId;
	}

	public void setPrimaryKey(long pk) {
		setSiteRequestId(pk);
	}

	public long getSiteRequestId() {
		return _siteRequestId;
	}

	public void setSiteRequestId(long siteRequestId) {
		_siteRequestId = siteRequestId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getResponse() {
		return _response;
	}

	public void setResponse(String response) {
		_response = response;
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	public boolean getAdmin() {
		return _admin;
	}

	public boolean isAdmin() {
		return _admin;
	}

	public void setAdmin(boolean admin) {
		_admin = admin;
	}

	private long _siteRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _status;
	private String _response;
	private long _siteId;
	private boolean _admin;
}
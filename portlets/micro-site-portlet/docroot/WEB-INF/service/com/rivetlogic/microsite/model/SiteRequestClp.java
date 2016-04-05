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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.microsite.service.ClpSerializer;
import com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author steven.barba
 */
public class SiteRequestClp extends BaseModelImpl<SiteRequest>
	implements SiteRequest {
	public SiteRequestClp() {
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
	public long getPrimaryKey() {
		return _siteRequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSiteRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _siteRequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSiteRequestId() {
		return _siteRequestId;
	}

	@Override
	public void setSiteRequestId(long siteRequestId) {
		_siteRequestId = siteRequestId;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteRequestId", long.class);

				method.invoke(_siteRequestRemoteModel, siteRequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_siteRequestRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_siteRequestRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_siteRequestRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_siteRequestRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_siteRequestRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_siteRequestRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_siteRequestRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_siteRequestRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResponse() {
		return _response;
	}

	@Override
	public void setResponse(String response) {
		_response = response;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setResponse", String.class);

				method.invoke(_siteRequestRemoteModel, response);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSiteId() {
		return _siteId;
	}

	@Override
	public void setSiteId(long siteId) {
		_siteId = siteId;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteId", long.class);

				method.invoke(_siteRequestRemoteModel, siteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdmin() {
		return _admin;
	}

	@Override
	public boolean isAdmin() {
		return _admin;
	}

	@Override
	public void setAdmin(boolean admin) {
		_admin = admin;

		if (_siteRequestRemoteModel != null) {
			try {
				Class<?> clazz = _siteRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setAdmin", boolean.class);

				method.invoke(_siteRequestRemoteModel, admin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSiteRequestRemoteModel() {
		return _siteRequestRemoteModel;
	}

	public void setSiteRequestRemoteModel(BaseModel<?> siteRequestRemoteModel) {
		_siteRequestRemoteModel = siteRequestRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _siteRequestRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_siteRequestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SiteRequestLocalServiceUtil.addSiteRequest(this);
		}
		else {
			SiteRequestLocalServiceUtil.updateSiteRequest(this);
		}
	}

	@Override
	public SiteRequest toEscapedModel() {
		return (SiteRequest)ProxyUtil.newProxyInstance(SiteRequest.class.getClassLoader(),
			new Class[] { SiteRequest.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SiteRequestClp clone = new SiteRequestClp();

		clone.setSiteRequestId(getSiteRequestId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());
		clone.setResponse(getResponse());
		clone.setSiteId(getSiteId());
		clone.setAdmin(getAdmin());

		return clone;
	}

	@Override
	public int compareTo(SiteRequest siteRequest) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), siteRequest.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SiteRequestClp)) {
			return false;
		}

		SiteRequestClp siteRequest = (SiteRequestClp)obj;

		long primaryKey = siteRequest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{siteRequestId=");
		sb.append(getSiteRequestId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", response=");
		sb.append(getResponse());
		sb.append(", siteId=");
		sb.append(getSiteId());
		sb.append(", admin=");
		sb.append(getAdmin());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.microsite.model.SiteRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>siteRequestId</column-name><column-value><![CDATA[");
		sb.append(getSiteRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>response</column-name><column-value><![CDATA[");
		sb.append(getResponse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>admin</column-name><column-value><![CDATA[");
		sb.append(getAdmin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _siteRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _status;
	private String _response;
	private long _siteId;
	private boolean _admin;
	private BaseModel<?> _siteRequestRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.microsite.service.ClpSerializer.class;
}
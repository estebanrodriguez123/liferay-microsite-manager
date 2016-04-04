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

package com.rivetlogic.microsite.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.microsite.model.SiteRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SiteRequest in entity cache.
 *
 * @author steven.barba
 * @see SiteRequest
 * @generated
 */
public class SiteRequestCacheModel implements CacheModel<SiteRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{siteRequestId=");
		sb.append(siteRequestId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", response=");
		sb.append(response);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append(", admin=");
		sb.append(admin);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SiteRequest toEntityModel() {
		SiteRequestImpl siteRequestImpl = new SiteRequestImpl();

		siteRequestImpl.setSiteRequestId(siteRequestId);
		siteRequestImpl.setGroupId(groupId);
		siteRequestImpl.setCompanyId(companyId);
		siteRequestImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			siteRequestImpl.setCreateDate(null);
		}
		else {
			siteRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			siteRequestImpl.setModifiedDate(null);
		}
		else {
			siteRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			siteRequestImpl.setName(StringPool.BLANK);
		}
		else {
			siteRequestImpl.setName(name);
		}

		if (description == null) {
			siteRequestImpl.setDescription(StringPool.BLANK);
		}
		else {
			siteRequestImpl.setDescription(description);
		}

		if (status == null) {
			siteRequestImpl.setStatus(StringPool.BLANK);
		}
		else {
			siteRequestImpl.setStatus(status);
		}

		if (response == null) {
			siteRequestImpl.setResponse(StringPool.BLANK);
		}
		else {
			siteRequestImpl.setResponse(response);
		}

		siteRequestImpl.setSiteId(siteId);
		siteRequestImpl.setAdmin(admin);

		siteRequestImpl.resetOriginalValues();

		return siteRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		siteRequestId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		response = objectInput.readUTF();
		siteId = objectInput.readLong();
		admin = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(siteRequestId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (response == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(response);
		}

		objectOutput.writeLong(siteId);
		objectOutput.writeBoolean(admin);
	}

	public long siteRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String status;
	public String response;
	public long siteId;
	public boolean admin;
}
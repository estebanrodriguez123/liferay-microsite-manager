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

import com.rivetlogic.microsite.model.MicroSite;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MicroSite in entity cache.
 *
 * @author steven.barba
 * @see MicroSite
 * @generated
 */
public class MicroSiteCacheModel implements CacheModel<MicroSite>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{microSiteId=");
		sb.append(microSiteId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MicroSite toEntityModel() {
		MicroSiteImpl microSiteImpl = new MicroSiteImpl();

		microSiteImpl.setMicroSiteId(microSiteId);
		microSiteImpl.setCompanyId(companyId);
		microSiteImpl.setUserId(userId);

		if (userName == null) {
			microSiteImpl.setUserName(StringPool.BLANK);
		}
		else {
			microSiteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			microSiteImpl.setCreateDate(null);
		}
		else {
			microSiteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			microSiteImpl.setModifiedDate(null);
		}
		else {
			microSiteImpl.setModifiedDate(new Date(modifiedDate));
		}

		microSiteImpl.setGroupId(groupId);
		microSiteImpl.setSiteId(siteId);

		microSiteImpl.resetOriginalValues();

		return microSiteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		microSiteId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupId = objectInput.readLong();
		siteId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(microSiteId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(siteId);
	}

	public long microSiteId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long groupId;
	public long siteId;
}
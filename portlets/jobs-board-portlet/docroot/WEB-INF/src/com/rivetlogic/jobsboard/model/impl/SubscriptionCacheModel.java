/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.rivetlogic.jobsboard.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.jobsboard.model.Subscription;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subscription in entity cache.
 *
 * @author joseross
 * @see Subscription
 * @generated
 */
public class SubscriptionCacheModel implements CacheModel<Subscription>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{emailAddress=");
		sb.append(emailAddress);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subscription toEntityModel() {
		SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

		if (emailAddress == null) {
			subscriptionImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			subscriptionImpl.setEmailAddress(emailAddress);
		}

		if (fullName == null) {
			subscriptionImpl.setFullName(StringPool.BLANK);
		}
		else {
			subscriptionImpl.setFullName(fullName);
		}

		subscriptionImpl.setGroupId(groupId);
		subscriptionImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			subscriptionImpl.setCreateDate(null);
		}
		else {
			subscriptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subscriptionImpl.setModifiedDate(null);
		}
		else {
			subscriptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		subscriptionImpl.resetOriginalValues();

		return subscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		emailAddress = objectInput.readUTF();
		fullName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String emailAddress;
	public String fullName;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
}
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

import com.rivetlogic.jobsboard.model.Job;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Job in entity cache.
 *
 * @author joseross
 * @see Job
 * @generated
 */
public class JobCacheModel implements CacheModel<Job>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{jobId=");
		sb.append(jobId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", active=");
		sb.append(active);
		sb.append(", category=");
		sb.append(category);
		sb.append(", location=");
		sb.append(location);
		sb.append(", type=");
		sb.append(type);
		sb.append(", description=");
		sb.append(description);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", bookmarks=");
		sb.append(bookmarks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Job toEntityModel() {
		JobImpl jobImpl = new JobImpl();

		jobImpl.setJobId(jobId);
		jobImpl.setGroupId(groupId);
		jobImpl.setCompanyId(companyId);
		jobImpl.setUserId(userId);

		if (userName == null) {
			jobImpl.setUserName(StringPool.BLANK);
		}
		else {
			jobImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			jobImpl.setCreateDate(null);
		}
		else {
			jobImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobImpl.setModifiedDate(null);
		}
		else {
			jobImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			jobImpl.setName(StringPool.BLANK);
		}
		else {
			jobImpl.setName(name);
		}

		jobImpl.setActive(active);
		jobImpl.setCategory(category);
		jobImpl.setLocation(location);
		jobImpl.setType(type);

		if (description == null) {
			jobImpl.setDescription(StringPool.BLANK);
		}
		else {
			jobImpl.setDescription(description);
		}

		jobImpl.setSalary(salary);

		if (bookmarks == null) {
			jobImpl.setBookmarks(StringPool.BLANK);
		}
		else {
			jobImpl.setBookmarks(bookmarks);
		}

		jobImpl.resetOriginalValues();

		return jobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		active = objectInput.readBoolean();
		category = objectInput.readLong();
		location = objectInput.readLong();
		type = objectInput.readLong();
		description = objectInput.readUTF();
		salary = objectInput.readDouble();
		bookmarks = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobId);
		objectOutput.writeLong(groupId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(category);
		objectOutput.writeLong(location);
		objectOutput.writeLong(type);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(salary);

		if (bookmarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookmarks);
		}
	}

	public long jobId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public boolean active;
	public long category;
	public long location;
	public long type;
	public String description;
	public double salary;
	public String bookmarks;
}
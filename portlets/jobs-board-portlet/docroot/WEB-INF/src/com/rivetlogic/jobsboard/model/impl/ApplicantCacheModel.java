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

import com.rivetlogic.jobsboard.model.Applicant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Applicant in entity cache.
 *
 * @author joseross
 * @see Applicant
 * @generated
 */
public class ApplicantCacheModel implements CacheModel<Applicant>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{applicantId=");
		sb.append(applicantId);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", cv=");
		sb.append(cv);
		sb.append(", info=");
		sb.append(info);
		sb.append(", status=");
		sb.append(status);
		sb.append(", notes=");
		sb.append(notes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Applicant toEntityModel() {
		ApplicantImpl applicantImpl = new ApplicantImpl();

		applicantImpl.setApplicantId(applicantId);
		applicantImpl.setJobId(jobId);
		applicantImpl.setGroupId(groupId);
		applicantImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			applicantImpl.setCreateDate(null);
		}
		else {
			applicantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicantImpl.setModifiedDate(null);
		}
		else {
			applicantImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			applicantImpl.setName(StringPool.BLANK);
		}
		else {
			applicantImpl.setName(name);
		}

		if (email == null) {
			applicantImpl.setEmail(StringPool.BLANK);
		}
		else {
			applicantImpl.setEmail(email);
		}

		if (phone == null) {
			applicantImpl.setPhone(StringPool.BLANK);
		}
		else {
			applicantImpl.setPhone(phone);
		}

		applicantImpl.setCv(cv);

		if (info == null) {
			applicantImpl.setInfo(StringPool.BLANK);
		}
		else {
			applicantImpl.setInfo(info);
		}

		if (status == null) {
			applicantImpl.setStatus(StringPool.BLANK);
		}
		else {
			applicantImpl.setStatus(status);
		}

		if (notes == null) {
			applicantImpl.setNotes(StringPool.BLANK);
		}
		else {
			applicantImpl.setNotes(notes);
		}

		applicantImpl.resetOriginalValues();

		return applicantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicantId = objectInput.readLong();
		jobId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		cv = objectInput.readLong();
		info = objectInput.readUTF();
		status = objectInput.readUTF();
		notes = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicantId);
		objectOutput.writeLong(jobId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		objectOutput.writeLong(cv);

		if (info == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(info);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}
	}

	public long applicantId;
	public long jobId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String email;
	public String phone;
	public long cv;
	public String info;
	public String status;
	public String notes;
}
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

package com.rivetlogic.jobsboard.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil;
import com.rivetlogic.jobsboard.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joseross
 */
public class ApplicantClp extends BaseModelImpl<Applicant> implements Applicant {
	public ApplicantClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Applicant.class;
	}

	@Override
	public String getModelClassName() {
		return Applicant.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _applicantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicantId", getApplicantId());
		attributes.put("jobId", getJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("cv", getCv());
		attributes.put("info", getInfo());
		attributes.put("status", getStatus());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicantId = (Long)attributes.get("applicantId");

		if (applicantId != null) {
			setApplicantId(applicantId);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		Long cv = (Long)attributes.get("cv");

		if (cv != null) {
			setCv(cv);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	@Override
	public long getApplicantId() {
		return _applicantId;
	}

	@Override
	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantId", long.class);

				method.invoke(_applicantRemoteModel, applicantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_jobId = jobId;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setJobId", long.class);

				method.invoke(_applicantRemoteModel, jobId);
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

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicantRemoteModel, groupId);
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

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicantRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicantRemoteModel, createDate);
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

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicantRemoteModel, modifiedDate);
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

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_applicantRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_applicantRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_applicantRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCv() {
		return _cv;
	}

	@Override
	public void setCv(long cv) {
		_cv = cv;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCv", long.class);

				method.invoke(_applicantRemoteModel, cv);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfo() {
		return _info;
	}

	@Override
	public void setInfo(String info) {
		_info = info;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setInfo", String.class);

				method.invoke(_applicantRemoteModel, info);
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

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_applicantRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_applicantRemoteModel != null) {
			try {
				Class<?> clazz = _applicantRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_applicantRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getApplicantRemoteModel() {
		return _applicantRemoteModel;
	}

	public void setApplicantRemoteModel(BaseModel<?> applicantRemoteModel) {
		_applicantRemoteModel = applicantRemoteModel;
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

		Class<?> remoteModelClass = _applicantRemoteModel.getClass();

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

		Object returnValue = method.invoke(_applicantRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ApplicantLocalServiceUtil.addApplicant(this);
		}
		else {
			ApplicantLocalServiceUtil.updateApplicant(this);
		}
	}

	@Override
	public Applicant toEscapedModel() {
		return (Applicant)ProxyUtil.newProxyInstance(Applicant.class.getClassLoader(),
			new Class[] { Applicant.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicantClp clone = new ApplicantClp();

		clone.setApplicantId(getApplicantId());
		clone.setJobId(getJobId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setEmail(getEmail());
		clone.setPhone(getPhone());
		clone.setCv(getCv());
		clone.setInfo(getInfo());
		clone.setStatus(getStatus());
		clone.setNotes(getNotes());

		return clone;
	}

	@Override
	public int compareTo(Applicant applicant) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), applicant.getCreateDate());

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

		if (!(obj instanceof ApplicantClp)) {
			return false;
		}

		ApplicantClp applicant = (ApplicantClp)obj;

		long primaryKey = applicant.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{applicantId=");
		sb.append(getApplicantId());
		sb.append(", jobId=");
		sb.append(getJobId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", cv=");
		sb.append(getCv());
		sb.append(", info=");
		sb.append(getInfo());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.jobsboard.model.Applicant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicantId</column-name><column-value><![CDATA[");
		sb.append(getApplicantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
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
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cv</column-name><column-value><![CDATA[");
		sb.append(getCv());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>info</column-name><column-value><![CDATA[");
		sb.append(getInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicantId;
	private long _jobId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _email;
	private String _phone;
	private long _cv;
	private String _info;
	private String _status;
	private String _notes;
	private BaseModel<?> _applicantRemoteModel;
}
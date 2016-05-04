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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Applicant}.
 * </p>
 *
 * @author joseross
 * @see Applicant
 * @generated
 */
public class ApplicantWrapper implements Applicant, ModelWrapper<Applicant> {
	public ApplicantWrapper(Applicant applicant) {
		_applicant = applicant;
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

	/**
	* Returns the primary key of this applicant.
	*
	* @return the primary key of this applicant
	*/
	@Override
	public long getPrimaryKey() {
		return _applicant.getPrimaryKey();
	}

	/**
	* Sets the primary key of this applicant.
	*
	* @param primaryKey the primary key of this applicant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicant.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the applicant ID of this applicant.
	*
	* @return the applicant ID of this applicant
	*/
	@Override
	public long getApplicantId() {
		return _applicant.getApplicantId();
	}

	/**
	* Sets the applicant ID of this applicant.
	*
	* @param applicantId the applicant ID of this applicant
	*/
	@Override
	public void setApplicantId(long applicantId) {
		_applicant.setApplicantId(applicantId);
	}

	/**
	* Returns the job ID of this applicant.
	*
	* @return the job ID of this applicant
	*/
	@Override
	public long getJobId() {
		return _applicant.getJobId();
	}

	/**
	* Sets the job ID of this applicant.
	*
	* @param jobId the job ID of this applicant
	*/
	@Override
	public void setJobId(long jobId) {
		_applicant.setJobId(jobId);
	}

	/**
	* Returns the group ID of this applicant.
	*
	* @return the group ID of this applicant
	*/
	@Override
	public long getGroupId() {
		return _applicant.getGroupId();
	}

	/**
	* Sets the group ID of this applicant.
	*
	* @param groupId the group ID of this applicant
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicant.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this applicant.
	*
	* @return the company ID of this applicant
	*/
	@Override
	public long getCompanyId() {
		return _applicant.getCompanyId();
	}

	/**
	* Sets the company ID of this applicant.
	*
	* @param companyId the company ID of this applicant
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicant.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this applicant.
	*
	* @return the create date of this applicant
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _applicant.getCreateDate();
	}

	/**
	* Sets the create date of this applicant.
	*
	* @param createDate the create date of this applicant
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_applicant.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this applicant.
	*
	* @return the modified date of this applicant
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _applicant.getModifiedDate();
	}

	/**
	* Sets the modified date of this applicant.
	*
	* @param modifiedDate the modified date of this applicant
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_applicant.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this applicant.
	*
	* @return the name of this applicant
	*/
	@Override
	public java.lang.String getName() {
		return _applicant.getName();
	}

	/**
	* Sets the name of this applicant.
	*
	* @param name the name of this applicant
	*/
	@Override
	public void setName(java.lang.String name) {
		_applicant.setName(name);
	}

	/**
	* Returns the email of this applicant.
	*
	* @return the email of this applicant
	*/
	@Override
	public java.lang.String getEmail() {
		return _applicant.getEmail();
	}

	/**
	* Sets the email of this applicant.
	*
	* @param email the email of this applicant
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_applicant.setEmail(email);
	}

	/**
	* Returns the phone of this applicant.
	*
	* @return the phone of this applicant
	*/
	@Override
	public java.lang.String getPhone() {
		return _applicant.getPhone();
	}

	/**
	* Sets the phone of this applicant.
	*
	* @param phone the phone of this applicant
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_applicant.setPhone(phone);
	}

	/**
	* Returns the cv of this applicant.
	*
	* @return the cv of this applicant
	*/
	@Override
	public long getCv() {
		return _applicant.getCv();
	}

	/**
	* Sets the cv of this applicant.
	*
	* @param cv the cv of this applicant
	*/
	@Override
	public void setCv(long cv) {
		_applicant.setCv(cv);
	}

	/**
	* Returns the info of this applicant.
	*
	* @return the info of this applicant
	*/
	@Override
	public java.lang.String getInfo() {
		return _applicant.getInfo();
	}

	/**
	* Sets the info of this applicant.
	*
	* @param info the info of this applicant
	*/
	@Override
	public void setInfo(java.lang.String info) {
		_applicant.setInfo(info);
	}

	/**
	* Returns the status of this applicant.
	*
	* @return the status of this applicant
	*/
	@Override
	public java.lang.String getStatus() {
		return _applicant.getStatus();
	}

	/**
	* Sets the status of this applicant.
	*
	* @param status the status of this applicant
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_applicant.setStatus(status);
	}

	/**
	* Returns the notes of this applicant.
	*
	* @return the notes of this applicant
	*/
	@Override
	public java.lang.String getNotes() {
		return _applicant.getNotes();
	}

	/**
	* Sets the notes of this applicant.
	*
	* @param notes the notes of this applicant
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_applicant.setNotes(notes);
	}

	@Override
	public boolean isNew() {
		return _applicant.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_applicant.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _applicant.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicant.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _applicant.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _applicant.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_applicant.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _applicant.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_applicant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_applicant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_applicant.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicantWrapper((Applicant)_applicant.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.jobsboard.model.Applicant applicant) {
		return _applicant.compareTo(applicant);
	}

	@Override
	public int hashCode() {
		return _applicant.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.jobsboard.model.Applicant> toCacheModel() {
		return _applicant.toCacheModel();
	}

	@Override
	public com.rivetlogic.jobsboard.model.Applicant toEscapedModel() {
		return new ApplicantWrapper(_applicant.toEscapedModel());
	}

	@Override
	public com.rivetlogic.jobsboard.model.Applicant toUnescapedModel() {
		return new ApplicantWrapper(_applicant.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _applicant.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicant.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_applicant.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicantWrapper)) {
			return false;
		}

		ApplicantWrapper applicantWrapper = (ApplicantWrapper)obj;

		if (Validator.equals(_applicant, applicantWrapper._applicant)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Applicant getWrappedApplicant() {
		return _applicant;
	}

	@Override
	public Applicant getWrappedModel() {
		return _applicant;
	}

	@Override
	public void resetOriginalValues() {
		_applicant.resetOriginalValues();
	}

	private Applicant _applicant;
}
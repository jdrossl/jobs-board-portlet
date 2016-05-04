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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author joseross
 * @generated
 */
public class ApplicantSoap implements Serializable {
	public static ApplicantSoap toSoapModel(Applicant model) {
		ApplicantSoap soapModel = new ApplicantSoap();

		soapModel.setApplicantId(model.getApplicantId());
		soapModel.setJobId(model.getJobId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhone(model.getPhone());
		soapModel.setCv(model.getCv());
		soapModel.setInfo(model.getInfo());
		soapModel.setStatus(model.getStatus());
		soapModel.setNotes(model.getNotes());

		return soapModel;
	}

	public static ApplicantSoap[] toSoapModels(Applicant[] models) {
		ApplicantSoap[] soapModels = new ApplicantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicantSoap[][] toSoapModels(Applicant[][] models) {
		ApplicantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicantSoap[] toSoapModels(List<Applicant> models) {
		List<ApplicantSoap> soapModels = new ArrayList<ApplicantSoap>(models.size());

		for (Applicant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicantSoap[soapModels.size()]);
	}

	public ApplicantSoap() {
	}

	public long getPrimaryKey() {
		return _applicantId;
	}

	public void setPrimaryKey(long pk) {
		setApplicantId(pk);
	}

	public long getApplicantId() {
		return _applicantId;
	}

	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
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

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public long getCv() {
		return _cv;
	}

	public void setCv(long cv) {
		_cv = cv;
	}

	public String getInfo() {
		return _info;
	}

	public void setInfo(String info) {
		_info = info;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
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
}
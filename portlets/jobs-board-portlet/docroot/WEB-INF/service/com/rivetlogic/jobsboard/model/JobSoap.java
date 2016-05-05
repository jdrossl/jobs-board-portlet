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
public class JobSoap implements Serializable {
	public static JobSoap toSoapModel(Job model) {
		JobSoap soapModel = new JobSoap();

		soapModel.setJobId(model.getJobId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setActive(model.getActive());
		soapModel.setCategory(model.getCategory());
		soapModel.setLocation(model.getLocation());
		soapModel.setType(model.getType());
		soapModel.setDescription(model.getDescription());
		soapModel.setSalary(model.getSalary());
		soapModel.setBookmarks(model.getBookmarks());

		return soapModel;
	}

	public static JobSoap[] toSoapModels(Job[] models) {
		JobSoap[] soapModels = new JobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobSoap[][] toSoapModels(Job[][] models) {
		JobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobSoap[] toSoapModels(List<Job> models) {
		List<JobSoap> soapModels = new ArrayList<JobSoap>(models.size());

		for (Job model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobSoap[soapModels.size()]);
	}

	public JobSoap() {
	}

	public long getPrimaryKey() {
		return _jobId;
	}

	public void setPrimaryKey(long pk) {
		setJobId(pk);
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getCategory() {
		return _category;
	}

	public void setCategory(long category) {
		_category = category;
	}

	public long getLocation() {
		return _location;
	}

	public void setLocation(long location) {
		_location = location;
	}

	public long getType() {
		return _type;
	}

	public void setType(long type) {
		_type = type;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public double getSalary() {
		return _salary;
	}

	public void setSalary(double salary) {
		_salary = salary;
	}

	public String getBookmarks() {
		return _bookmarks;
	}

	public void setBookmarks(String bookmarks) {
		_bookmarks = bookmarks;
	}

	private long _jobId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private boolean _active;
	private long _category;
	private long _location;
	private long _type;
	private String _description;
	private double _salary;
	private String _bookmarks;
}
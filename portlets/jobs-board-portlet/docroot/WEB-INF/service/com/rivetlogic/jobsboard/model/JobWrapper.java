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
 * This class is a wrapper for {@link Job}.
 * </p>
 *
 * @author joseross
 * @see Job
 * @generated
 */
public class JobWrapper implements Job, ModelWrapper<Job> {
	public JobWrapper(Job job) {
		_job = job;
	}

	@Override
	public Class<?> getModelClass() {
		return Job.class;
	}

	@Override
	public String getModelClassName() {
		return Job.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobId", getJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("active", getActive());
		attributes.put("category", getCategory());
		attributes.put("location", getLocation());
		attributes.put("type", getType());
		attributes.put("description", getDescription());
		attributes.put("salary", getSalary());
		attributes.put("bookmarks", getBookmarks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long category = (Long)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long location = (Long)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Long type = (Long)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double salary = (Double)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		String bookmarks = (String)attributes.get("bookmarks");

		if (bookmarks != null) {
			setBookmarks(bookmarks);
		}
	}

	/**
	* Returns the primary key of this job.
	*
	* @return the primary key of this job
	*/
	@Override
	public long getPrimaryKey() {
		return _job.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job.
	*
	* @param primaryKey the primary key of this job
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_job.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job ID of this job.
	*
	* @return the job ID of this job
	*/
	@Override
	public long getJobId() {
		return _job.getJobId();
	}

	/**
	* Sets the job ID of this job.
	*
	* @param jobId the job ID of this job
	*/
	@Override
	public void setJobId(long jobId) {
		_job.setJobId(jobId);
	}

	/**
	* Returns the group ID of this job.
	*
	* @return the group ID of this job
	*/
	@Override
	public long getGroupId() {
		return _job.getGroupId();
	}

	/**
	* Sets the group ID of this job.
	*
	* @param groupId the group ID of this job
	*/
	@Override
	public void setGroupId(long groupId) {
		_job.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this job.
	*
	* @return the company ID of this job
	*/
	@Override
	public long getCompanyId() {
		return _job.getCompanyId();
	}

	/**
	* Sets the company ID of this job.
	*
	* @param companyId the company ID of this job
	*/
	@Override
	public void setCompanyId(long companyId) {
		_job.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this job.
	*
	* @return the user ID of this job
	*/
	@Override
	public long getUserId() {
		return _job.getUserId();
	}

	/**
	* Sets the user ID of this job.
	*
	* @param userId the user ID of this job
	*/
	@Override
	public void setUserId(long userId) {
		_job.setUserId(userId);
	}

	/**
	* Returns the user uuid of this job.
	*
	* @return the user uuid of this job
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _job.getUserUuid();
	}

	/**
	* Sets the user uuid of this job.
	*
	* @param userUuid the user uuid of this job
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_job.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this job.
	*
	* @return the user name of this job
	*/
	@Override
	public java.lang.String getUserName() {
		return _job.getUserName();
	}

	/**
	* Sets the user name of this job.
	*
	* @param userName the user name of this job
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_job.setUserName(userName);
	}

	/**
	* Returns the create date of this job.
	*
	* @return the create date of this job
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _job.getCreateDate();
	}

	/**
	* Sets the create date of this job.
	*
	* @param createDate the create date of this job
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_job.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this job.
	*
	* @return the modified date of this job
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _job.getModifiedDate();
	}

	/**
	* Sets the modified date of this job.
	*
	* @param modifiedDate the modified date of this job
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_job.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this job.
	*
	* @return the name of this job
	*/
	@Override
	public java.lang.String getName() {
		return _job.getName();
	}

	/**
	* Sets the name of this job.
	*
	* @param name the name of this job
	*/
	@Override
	public void setName(java.lang.String name) {
		_job.setName(name);
	}

	/**
	* Returns the active of this job.
	*
	* @return the active of this job
	*/
	@Override
	public boolean getActive() {
		return _job.getActive();
	}

	/**
	* Returns <code>true</code> if this job is active.
	*
	* @return <code>true</code> if this job is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _job.isActive();
	}

	/**
	* Sets whether this job is active.
	*
	* @param active the active of this job
	*/
	@Override
	public void setActive(boolean active) {
		_job.setActive(active);
	}

	/**
	* Returns the category of this job.
	*
	* @return the category of this job
	*/
	@Override
	public long getCategory() {
		return _job.getCategory();
	}

	/**
	* Sets the category of this job.
	*
	* @param category the category of this job
	*/
	@Override
	public void setCategory(long category) {
		_job.setCategory(category);
	}

	/**
	* Returns the location of this job.
	*
	* @return the location of this job
	*/
	@Override
	public long getLocation() {
		return _job.getLocation();
	}

	/**
	* Sets the location of this job.
	*
	* @param location the location of this job
	*/
	@Override
	public void setLocation(long location) {
		_job.setLocation(location);
	}

	/**
	* Returns the type of this job.
	*
	* @return the type of this job
	*/
	@Override
	public long getType() {
		return _job.getType();
	}

	/**
	* Sets the type of this job.
	*
	* @param type the type of this job
	*/
	@Override
	public void setType(long type) {
		_job.setType(type);
	}

	/**
	* Returns the description of this job.
	*
	* @return the description of this job
	*/
	@Override
	public java.lang.String getDescription() {
		return _job.getDescription();
	}

	/**
	* Sets the description of this job.
	*
	* @param description the description of this job
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_job.setDescription(description);
	}

	/**
	* Returns the salary of this job.
	*
	* @return the salary of this job
	*/
	@Override
	public double getSalary() {
		return _job.getSalary();
	}

	/**
	* Sets the salary of this job.
	*
	* @param salary the salary of this job
	*/
	@Override
	public void setSalary(double salary) {
		_job.setSalary(salary);
	}

	/**
	* Returns the bookmarks of this job.
	*
	* @return the bookmarks of this job
	*/
	@Override
	public java.lang.String getBookmarks() {
		return _job.getBookmarks();
	}

	/**
	* Sets the bookmarks of this job.
	*
	* @param bookmarks the bookmarks of this job
	*/
	@Override
	public void setBookmarks(java.lang.String bookmarks) {
		_job.setBookmarks(bookmarks);
	}

	@Override
	public boolean isNew() {
		return _job.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_job.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _job.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_job.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _job.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _job.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_job.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _job.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_job.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_job.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_job.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobWrapper((Job)_job.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.jobsboard.model.Job job) {
		return _job.compareTo(job);
	}

	@Override
	public int hashCode() {
		return _job.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.jobsboard.model.Job> toCacheModel() {
		return _job.toCacheModel();
	}

	@Override
	public com.rivetlogic.jobsboard.model.Job toEscapedModel() {
		return new JobWrapper(_job.toEscapedModel());
	}

	@Override
	public com.rivetlogic.jobsboard.model.Job toUnescapedModel() {
		return new JobWrapper(_job.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _job.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _job.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_job.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobWrapper)) {
			return false;
		}

		JobWrapper jobWrapper = (JobWrapper)obj;

		if (Validator.equals(_job, jobWrapper._job)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Job getWrappedJob() {
		return _job;
	}

	@Override
	public Job getWrappedModel() {
		return _job;
	}

	@Override
	public void resetOriginalValues() {
		_job.resetOriginalValues();
	}

	private Job _job;
}
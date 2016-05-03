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
 * This class is a wrapper for {@link Subscription}.
 * </p>
 *
 * @author joseross
 * @see Subscription
 * @generated
 */
public class SubscriptionWrapper implements Subscription,
	ModelWrapper<Subscription> {
	public SubscriptionWrapper(Subscription subscription) {
		_subscription = subscription;
	}

	@Override
	public Class<?> getModelClass() {
		return Subscription.class;
	}

	@Override
	public String getModelClassName() {
		return Subscription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emailAddress", getEmailAddress());
		attributes.put("fullName", getFullName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
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
	}

	/**
	* Returns the primary key of this subscription.
	*
	* @return the primary key of this subscription
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _subscription.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subscription.
	*
	* @param primaryKey the primary key of this subscription
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_subscription.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the email address of this subscription.
	*
	* @return the email address of this subscription
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _subscription.getEmailAddress();
	}

	/**
	* Sets the email address of this subscription.
	*
	* @param emailAddress the email address of this subscription
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_subscription.setEmailAddress(emailAddress);
	}

	/**
	* Returns the full name of this subscription.
	*
	* @return the full name of this subscription
	*/
	@Override
	public java.lang.String getFullName() {
		return _subscription.getFullName();
	}

	/**
	* Sets the full name of this subscription.
	*
	* @param fullName the full name of this subscription
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_subscription.setFullName(fullName);
	}

	/**
	* Returns the group ID of this subscription.
	*
	* @return the group ID of this subscription
	*/
	@Override
	public long getGroupId() {
		return _subscription.getGroupId();
	}

	/**
	* Sets the group ID of this subscription.
	*
	* @param groupId the group ID of this subscription
	*/
	@Override
	public void setGroupId(long groupId) {
		_subscription.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this subscription.
	*
	* @return the company ID of this subscription
	*/
	@Override
	public long getCompanyId() {
		return _subscription.getCompanyId();
	}

	/**
	* Sets the company ID of this subscription.
	*
	* @param companyId the company ID of this subscription
	*/
	@Override
	public void setCompanyId(long companyId) {
		_subscription.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this subscription.
	*
	* @return the create date of this subscription
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _subscription.getCreateDate();
	}

	/**
	* Sets the create date of this subscription.
	*
	* @param createDate the create date of this subscription
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_subscription.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this subscription.
	*
	* @return the modified date of this subscription
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _subscription.getModifiedDate();
	}

	/**
	* Sets the modified date of this subscription.
	*
	* @param modifiedDate the modified date of this subscription
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_subscription.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _subscription.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subscription.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subscription.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subscription.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subscription.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subscription.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subscription.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subscription.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subscription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subscription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subscription.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubscriptionWrapper((Subscription)_subscription.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.jobsboard.model.Subscription subscription) {
		return _subscription.compareTo(subscription);
	}

	@Override
	public int hashCode() {
		return _subscription.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.jobsboard.model.Subscription> toCacheModel() {
		return _subscription.toCacheModel();
	}

	@Override
	public com.rivetlogic.jobsboard.model.Subscription toEscapedModel() {
		return new SubscriptionWrapper(_subscription.toEscapedModel());
	}

	@Override
	public com.rivetlogic.jobsboard.model.Subscription toUnescapedModel() {
		return new SubscriptionWrapper(_subscription.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subscription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subscription.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subscription.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriptionWrapper)) {
			return false;
		}

		SubscriptionWrapper subscriptionWrapper = (SubscriptionWrapper)obj;

		if (Validator.equals(_subscription, subscriptionWrapper._subscription)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Subscription getWrappedSubscription() {
		return _subscription;
	}

	@Override
	public Subscription getWrappedModel() {
		return _subscription;
	}

	@Override
	public void resetOriginalValues() {
		_subscription.resetOriginalValues();
	}

	private Subscription _subscription;
}
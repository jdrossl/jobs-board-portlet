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

package com.rivetlogic.jobsboard.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.jobsboard.model.Subscription;

import java.util.List;

/**
 * The persistence utility for the subscription service. This utility wraps {@link SubscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see SubscriptionPersistence
 * @see SubscriptionPersistenceImpl
 * @generated
 */
public class SubscriptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Subscription subscription) {
		getPersistence().clearCache(subscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Subscription update(Subscription subscription)
		throws SystemException {
		return getPersistence().update(subscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Subscription update(Subscription subscription,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(subscription, serviceContext);
	}

	/**
	* Returns all the subscriptions where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Subscription> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the subscriptions where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of subscriptions
	* @param end the upper bound of the range of subscriptions (not inclusive)
	* @return the range of matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Subscription> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the subscriptions where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of subscriptions
	* @param end the upper bound of the range of subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Subscription> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first subscription in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription
	* @throws com.rivetlogic.jobsboard.NoSuchSubscriptionException if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchSubscriptionException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first subscription in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last subscription in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription
	* @throws com.rivetlogic.jobsboard.NoSuchSubscriptionException if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchSubscriptionException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last subscription in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the subscriptions before and after the current subscription in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param emailAddress the primary key of the current subscription
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscription
	* @throws com.rivetlogic.jobsboard.NoSuchSubscriptionException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription[] findByCompanyGroup_PrevAndNext(
		java.lang.String emailAddress, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchSubscriptionException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(emailAddress, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the subscriptions where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of subscriptions where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Caches the subscription in the entity cache if it is enabled.
	*
	* @param subscription the subscription
	*/
	public static void cacheResult(
		com.rivetlogic.jobsboard.model.Subscription subscription) {
		getPersistence().cacheResult(subscription);
	}

	/**
	* Caches the subscriptions in the entity cache if it is enabled.
	*
	* @param subscriptions the subscriptions
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.jobsboard.model.Subscription> subscriptions) {
		getPersistence().cacheResult(subscriptions);
	}

	/**
	* Creates a new subscription with the primary key. Does not add the subscription to the database.
	*
	* @param emailAddress the primary key for the new subscription
	* @return the new subscription
	*/
	public static com.rivetlogic.jobsboard.model.Subscription create(
		java.lang.String emailAddress) {
		return getPersistence().create(emailAddress);
	}

	/**
	* Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emailAddress the primary key of the subscription
	* @return the subscription that was removed
	* @throws com.rivetlogic.jobsboard.NoSuchSubscriptionException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription remove(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchSubscriptionException {
		return getPersistence().remove(emailAddress);
	}

	public static com.rivetlogic.jobsboard.model.Subscription updateImpl(
		com.rivetlogic.jobsboard.model.Subscription subscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subscription);
	}

	/**
	* Returns the subscription with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchSubscriptionException} if it could not be found.
	*
	* @param emailAddress the primary key of the subscription
	* @return the subscription
	* @throws com.rivetlogic.jobsboard.NoSuchSubscriptionException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription findByPrimaryKey(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchSubscriptionException {
		return getPersistence().findByPrimaryKey(emailAddress);
	}

	/**
	* Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param emailAddress the primary key of the subscription
	* @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Subscription fetchByPrimaryKey(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(emailAddress);
	}

	/**
	* Returns all the subscriptions.
	*
	* @return the subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Subscription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscriptions
	* @param end the upper bound of the range of subscriptions (not inclusive)
	* @return the range of subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Subscription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscriptions
	* @param end the upper bound of the range of subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Subscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subscriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subscriptions.
	*
	* @return the number of subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubscriptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubscriptionPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.jobsboard.service.ClpSerializer.getServletContextName(),
					SubscriptionPersistence.class.getName());

			ReferenceRegistry.registerReference(SubscriptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubscriptionPersistence persistence) {
	}

	private static SubscriptionPersistence _persistence;
}
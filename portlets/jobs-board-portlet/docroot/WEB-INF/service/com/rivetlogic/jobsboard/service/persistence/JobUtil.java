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

import com.rivetlogic.jobsboard.model.Job;

import java.util.List;

/**
 * The persistence utility for the job service. This utility wraps {@link JobPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see JobPersistence
 * @see JobPersistenceImpl
 * @generated
 */
public class JobUtil {
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
	public static void clearCache(Job job) {
		getPersistence().clearCache(job);
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
	public static List<Job> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Job> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Job> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Job update(Job job) throws SystemException {
		return getPersistence().update(job);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Job update(Job job, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(job, serviceContext);
	}

	/**
	* Returns all the jobs where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the jobs where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @return the range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the jobs before and after the current job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param jobId the primary key of the current job
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job[] findByCompanyGroup_PrevAndNext(
		long jobId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(jobId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the jobs where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of jobs where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @return the matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, name, active, category,
			location, type, description);
	}

	/**
	* Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @return the range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, name, active, category,
			location, type, description, start, end);
	}

	/**
	* Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, name, active, category,
			location, type, description, start, end, orderByComparator);
	}

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByFilters_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByFilters_First(companyId, groupId, name, active,
			category, location, type, description, orderByComparator);
	}

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByFilters_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFilters_First(companyId, groupId, name, active,
			category, location, type, description, orderByComparator);
	}

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByFilters_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByFilters_Last(companyId, groupId, name, active,
			category, location, type, description, orderByComparator);
	}

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByFilters_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFilters_Last(companyId, groupId, name, active,
			category, location, type, description, orderByComparator);
	}

	/**
	* Returns the jobs before and after the current job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param jobId the primary key of the current job
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job[] findByFilters_PrevAndNext(
		long jobId, long companyId, long groupId, java.lang.String name,
		boolean active, long category, long location, long type,
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByFilters_PrevAndNext(jobId, companyId, groupId, name,
			active, category, location, type, description, orderByComparator);
	}

	/**
	* Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @return the matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, names, actives,
			categories, locations, types, descriptions);
	}

	/**
	* Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @return the range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, names, actives,
			categories, locations, types, descriptions, start, end);
	}

	/**
	* Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, names, actives,
			categories, locations, types, descriptions, start, end,
			orderByComparator);
	}

	/**
	* Removes all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFilters(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByFilters(companyId, groupId, name, active, category,
			location, type, description);
	}

	/**
	* Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @return the number of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFilters(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFilters(companyId, groupId, name, active, category,
			location, type, description);
	}

	/**
	* Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @return the number of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFilters(long companyId, long groupId,
		java.lang.String[] names, boolean[] actives, long[] categories,
		long[] locations, long[] types, java.lang.String[] descriptions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFilters(companyId, groupId, names, actives,
			categories, locations, types, descriptions);
	}

	/**
	* Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @return the matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookmarks(companyId, groupId, name, active, category,
			location, type, description, bookmarks);
	}

	/**
	* Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @return the range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookmarks(companyId, groupId, name, active, category,
			location, type, description, bookmarks, start, end);
	}

	/**
	* Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookmarks(companyId, groupId, name, active, category,
			location, type, description, bookmarks, start, end,
			orderByComparator);
	}

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByBookmarks_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByBookmarks_First(companyId, groupId, name, active,
			category, location, type, description, bookmarks, orderByComparator);
	}

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByBookmarks_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookmarks_First(companyId, groupId, name, active,
			category, location, type, description, bookmarks, orderByComparator);
	}

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByBookmarks_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByBookmarks_Last(companyId, groupId, name, active,
			category, location, type, description, bookmarks, orderByComparator);
	}

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByBookmarks_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBookmarks_Last(companyId, groupId, name, active,
			category, location, type, description, bookmarks, orderByComparator);
	}

	/**
	* Returns the jobs before and after the current job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param jobId the primary key of the current job
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job[] findByBookmarks_PrevAndNext(
		long jobId, long companyId, long groupId, java.lang.String name,
		boolean active, long category, long location, long type,
		java.lang.String description, java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence()
				   .findByBookmarks_PrevAndNext(jobId, companyId, groupId,
			name, active, category, location, type, description, bookmarks,
			orderByComparator);
	}

	/**
	* Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @param bookmarks the bookmarks
	* @return the matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookmarks(companyId, groupId, names, actives,
			categories, locations, types, descriptions, bookmarks);
	}

	/**
	* Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @param bookmarks the bookmarks
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @return the range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, java.lang.String bookmarks, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookmarks(companyId, groupId, names, actives,
			categories, locations, types, descriptions, bookmarks, start, end);
	}

	/**
	* Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @param bookmarks the bookmarks
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, java.lang.String bookmarks, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBookmarks(companyId, groupId, names, actives,
			categories, locations, types, descriptions, bookmarks, start, end,
			orderByComparator);
	}

	/**
	* Removes all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBookmarks(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByBookmarks(companyId, groupId, name, active, category,
			location, type, description, bookmarks);
	}

	/**
	* Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param active the active
	* @param category the category
	* @param location the location
	* @param type the type
	* @param description the description
	* @param bookmarks the bookmarks
	* @return the number of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBookmarks(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBookmarks(companyId, groupId, name, active,
			category, location, type, description, bookmarks);
	}

	/**
	* Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param names the names
	* @param actives the actives
	* @param categories the categories
	* @param locations the locations
	* @param types the types
	* @param descriptions the descriptions
	* @param bookmarks the bookmarks
	* @return the number of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBookmarks(long companyId, long groupId,
		java.lang.String[] names, boolean[] actives, long[] categories,
		long[] locations, long[] types, java.lang.String[] descriptions,
		java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBookmarks(companyId, groupId, names, actives,
			categories, locations, types, descriptions, bookmarks);
	}

	/**
	* Caches the job in the entity cache if it is enabled.
	*
	* @param job the job
	*/
	public static void cacheResult(com.rivetlogic.jobsboard.model.Job job) {
		getPersistence().cacheResult(job);
	}

	/**
	* Caches the jobs in the entity cache if it is enabled.
	*
	* @param jobs the jobs
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.jobsboard.model.Job> jobs) {
		getPersistence().cacheResult(jobs);
	}

	/**
	* Creates a new job with the primary key. Does not add the job to the database.
	*
	* @param jobId the primary key for the new job
	* @return the new job
	*/
	public static com.rivetlogic.jobsboard.model.Job create(long jobId) {
		return getPersistence().create(jobId);
	}

	/**
	* Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job
	* @return the job that was removed
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job remove(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence().remove(jobId);
	}

	public static com.rivetlogic.jobsboard.model.Job updateImpl(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(job);
	}

	/**
	* Returns the job with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchJobException} if it could not be found.
	*
	* @param jobId the primary key of the job
	* @return the job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job findByPrimaryKey(
		long jobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException {
		return getPersistence().findByPrimaryKey(jobId);
	}

	/**
	* Returns the job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobId the primary key of the job
	* @return the job, or <code>null</code> if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job fetchByPrimaryKey(
		long jobId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jobId);
	}

	/**
	* Returns all the jobs.
	*
	* @return the jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @return the range of jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jobs
	* @param end the upper bound of the range of jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of jobs.
	*
	* @return the number of jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JobPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JobPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.jobsboard.service.ClpSerializer.getServletContextName(),
					JobPersistence.class.getName());

			ReferenceRegistry.registerReference(JobUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(JobPersistence persistence) {
	}

	private static JobPersistence _persistence;
}
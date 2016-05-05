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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.jobsboard.model.Job;

/**
 * The persistence interface for the job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see JobPersistenceImpl
 * @see JobUtil
 * @generated
 */
public interface JobPersistence extends BasePersistence<Job> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobUtil} to access the job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the jobs where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

	/**
	* Returns the first job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

	/**
	* Returns the last job in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job, or <code>null</code> if a matching job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job[] findByCompanyGroup_PrevAndNext(
		long jobId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

	/**
	* Removes all the jobs where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jobs where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job findByFilters_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

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
	public com.rivetlogic.jobsboard.model.Job fetchByFilters_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job findByFilters_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

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
	public com.rivetlogic.jobsboard.model.Job fetchByFilters_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job[] findByFilters_PrevAndNext(
		long jobId, long companyId, long groupId, java.lang.String name,
		boolean active, long category, long location, long type,
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByFilters(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByFilters(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByFilters(long companyId, long groupId,
		java.lang.String[] names, boolean[] actives, long[] categories,
		long[] locations, long[] types, java.lang.String[] descriptions)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job findByBookmarks_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

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
	public com.rivetlogic.jobsboard.model.Job fetchByBookmarks_First(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job findByBookmarks_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

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
	public com.rivetlogic.jobsboard.model.Job fetchByBookmarks_Last(
		long companyId, long groupId, java.lang.String name, boolean active,
		long category, long location, long type, java.lang.String description,
		java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.jobsboard.model.Job[] findByBookmarks_PrevAndNext(
		long jobId, long companyId, long groupId, java.lang.String name,
		boolean active, long category, long location, long type,
		java.lang.String description, java.lang.String bookmarks,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, java.lang.String bookmarks, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		java.lang.String[] descriptions, java.lang.String bookmarks, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByBookmarks(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByBookmarks(long companyId, long groupId,
		java.lang.String name, boolean active, long category, long location,
		long type, java.lang.String description, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByBookmarks(long companyId, long groupId,
		java.lang.String[] names, boolean[] actives, long[] categories,
		long[] locations, long[] types, java.lang.String[] descriptions,
		java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the job in the entity cache if it is enabled.
	*
	* @param job the job
	*/
	public void cacheResult(com.rivetlogic.jobsboard.model.Job job);

	/**
	* Caches the jobs in the entity cache if it is enabled.
	*
	* @param jobs the jobs
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.jobsboard.model.Job> jobs);

	/**
	* Creates a new job with the primary key. Does not add the job to the database.
	*
	* @param jobId the primary key for the new job
	* @return the new job
	*/
	public com.rivetlogic.jobsboard.model.Job create(long jobId);

	/**
	* Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job
	* @return the job that was removed
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job remove(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

	public com.rivetlogic.jobsboard.model.Job updateImpl(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchJobException} if it could not be found.
	*
	* @param jobId the primary key of the job
	* @return the job
	* @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job findByPrimaryKey(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchJobException;

	/**
	* Returns the job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobId the primary key of the job
	* @return the job, or <code>null</code> if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job fetchByPrimaryKey(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the jobs.
	*
	* @return the jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jobs.
	*
	* @return the number of jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
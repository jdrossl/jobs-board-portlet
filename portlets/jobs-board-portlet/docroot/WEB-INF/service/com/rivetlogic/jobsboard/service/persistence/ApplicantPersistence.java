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

import com.rivetlogic.jobsboard.model.Applicant;

/**
 * The persistence interface for the applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see ApplicantPersistenceImpl
 * @see ApplicantUtil
 * @generated
 */
public interface ApplicantPersistence extends BasePersistence<Applicant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicantUtil} to access the applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @return the matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByCompanyGroupJob(
		long companyId, long groupId, long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @return the range of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByCompanyGroupJob(
		long companyId, long groupId, long jobId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByCompanyGroupJob(
		long companyId, long groupId, long jobId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant findByCompanyGroupJob_First(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant fetchByCompanyGroupJob_First(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant findByCompanyGroupJob_Last(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant fetchByCompanyGroupJob_Last(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the applicants before and after the current applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param applicantId the primary key of the current applicant
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant[] findByCompanyGroupJob_PrevAndNext(
		long applicantId, long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Removes all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroupJob(long companyId, long groupId, long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @return the number of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroupJob(long companyId, long groupId, long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @return the matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @return the range of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant findByFilters_First(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant fetchByFilters_First(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant findByFilters_Last(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant fetchByFilters_Last(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the applicants before and after the current applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param applicantId the primary key of the current applicant
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant[] findByFilters_PrevAndNext(
		long applicantId, long companyId, long groupId, long jobId,
		java.lang.String name, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param names the names
	* @param status the status
	* @return the matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String[] names,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param names the names
	* @param status the status
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @return the range of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String[] names,
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param names the names
	* @param status the status
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String[] names,
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFilters(long companyId, long groupId, long jobId,
		java.lang.String name, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param name the name
	* @param status the status
	* @return the number of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByFilters(long companyId, long groupId, long jobId,
		java.lang.String name, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @param names the names
	* @param status the status
	* @return the number of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByFilters(long companyId, long groupId, long jobId,
		java.lang.String[] names, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the applicant in the entity cache if it is enabled.
	*
	* @param applicant the applicant
	*/
	public void cacheResult(com.rivetlogic.jobsboard.model.Applicant applicant);

	/**
	* Caches the applicants in the entity cache if it is enabled.
	*
	* @param applicants the applicants
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.jobsboard.model.Applicant> applicants);

	/**
	* Creates a new applicant with the primary key. Does not add the applicant to the database.
	*
	* @param applicantId the primary key for the new applicant
	* @return the new applicant
	*/
	public com.rivetlogic.jobsboard.model.Applicant create(long applicantId);

	/**
	* Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant that was removed
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant remove(long applicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	public com.rivetlogic.jobsboard.model.Applicant updateImpl(
		com.rivetlogic.jobsboard.model.Applicant applicant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the applicant with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchApplicantException} if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant findByPrimaryKey(
		long applicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException;

	/**
	* Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Applicant fetchByPrimaryKey(
		long applicantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the applicants.
	*
	* @return the applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @return the range of applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.jobsboard.model.Applicant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the applicants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of applicants.
	*
	* @return the number of applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
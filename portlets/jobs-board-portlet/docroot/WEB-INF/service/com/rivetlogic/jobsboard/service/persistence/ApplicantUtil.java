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

import com.rivetlogic.jobsboard.model.Applicant;

import java.util.List;

/**
 * The persistence utility for the applicant service. This utility wraps {@link ApplicantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see ApplicantPersistence
 * @see ApplicantPersistenceImpl
 * @generated
 */
public class ApplicantUtil {
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
	public static void clearCache(Applicant applicant) {
		getPersistence().clearCache(applicant);
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
	public static List<Applicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Applicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Applicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Applicant update(Applicant applicant)
		throws SystemException {
		return getPersistence().update(applicant);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Applicant update(Applicant applicant,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(applicant, serviceContext);
	}

	/**
	* Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @return the matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByCompanyGroupJob(
		long companyId, long groupId, long jobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroupJob(companyId, groupId, jobId);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByCompanyGroupJob(
		long companyId, long groupId, long jobId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroupJob(companyId, groupId, jobId, start, end);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByCompanyGroupJob(
		long companyId, long groupId, long jobId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroupJob(companyId, groupId, jobId, start,
			end, orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant findByCompanyGroupJob_First(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence()
				   .findByCompanyGroupJob_First(companyId, groupId, jobId,
			orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant fetchByCompanyGroupJob_First(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroupJob_First(companyId, groupId, jobId,
			orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant findByCompanyGroupJob_Last(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence()
				   .findByCompanyGroupJob_Last(companyId, groupId, jobId,
			orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant fetchByCompanyGroupJob_Last(
		long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroupJob_Last(companyId, groupId, jobId,
			orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant[] findByCompanyGroupJob_PrevAndNext(
		long applicantId, long companyId, long groupId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence()
				   .findByCompanyGroupJob_PrevAndNext(applicantId, companyId,
			groupId, jobId, orderByComparator);
	}

	/**
	* Removes all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroupJob(long companyId, long groupId,
		long jobId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroupJob(companyId, groupId, jobId);
	}

	/**
	* Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param jobId the job ID
	* @return the number of matching applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroupJob(long companyId, long groupId,
		long jobId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroupJob(companyId, groupId, jobId);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, jobId, name, status);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, jobId, name, status,
			start, end);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, jobId, name, status,
			start, end, orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant findByFilters_First(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence()
				   .findByFilters_First(companyId, groupId, jobId, name,
			status, orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant fetchByFilters_First(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFilters_First(companyId, groupId, jobId, name,
			status, orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant findByFilters_Last(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence()
				   .findByFilters_Last(companyId, groupId, jobId, name, status,
			orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant fetchByFilters_Last(
		long companyId, long groupId, long jobId, java.lang.String name,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFilters_Last(companyId, groupId, jobId, name,
			status, orderByComparator);
	}

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
	public static com.rivetlogic.jobsboard.model.Applicant[] findByFilters_PrevAndNext(
		long applicantId, long companyId, long groupId, long jobId,
		java.lang.String name, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence()
				   .findByFilters_PrevAndNext(applicantId, companyId, groupId,
			jobId, name, status, orderByComparator);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String[] names,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, jobId, names, status);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String[] names,
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, jobId, names, status,
			start, end);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findByFilters(
		long companyId, long groupId, long jobId, java.lang.String[] names,
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilters(companyId, groupId, jobId, names, status,
			start, end, orderByComparator);
	}

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
	public static void removeByFilters(long companyId, long groupId,
		long jobId, java.lang.String name, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFilters(companyId, groupId, jobId, name, status);
	}

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
	public static int countByFilters(long companyId, long groupId, long jobId,
		java.lang.String name, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFilters(companyId, groupId, jobId, name, status);
	}

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
	public static int countByFilters(long companyId, long groupId, long jobId,
		java.lang.String[] names, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFilters(companyId, groupId, jobId, names, status);
	}

	/**
	* Caches the applicant in the entity cache if it is enabled.
	*
	* @param applicant the applicant
	*/
	public static void cacheResult(
		com.rivetlogic.jobsboard.model.Applicant applicant) {
		getPersistence().cacheResult(applicant);
	}

	/**
	* Caches the applicants in the entity cache if it is enabled.
	*
	* @param applicants the applicants
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.jobsboard.model.Applicant> applicants) {
		getPersistence().cacheResult(applicants);
	}

	/**
	* Creates a new applicant with the primary key. Does not add the applicant to the database.
	*
	* @param applicantId the primary key for the new applicant
	* @return the new applicant
	*/
	public static com.rivetlogic.jobsboard.model.Applicant create(
		long applicantId) {
		return getPersistence().create(applicantId);
	}

	/**
	* Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant that was removed
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Applicant remove(
		long applicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence().remove(applicantId);
	}

	public static com.rivetlogic.jobsboard.model.Applicant updateImpl(
		com.rivetlogic.jobsboard.model.Applicant applicant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(applicant);
	}

	/**
	* Returns the applicant with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchApplicantException} if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant
	* @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Applicant findByPrimaryKey(
		long applicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.jobsboard.NoSuchApplicantException {
		return getPersistence().findByPrimaryKey(applicantId);
	}

	/**
	* Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Applicant fetchByPrimaryKey(
		long applicantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(applicantId);
	}

	/**
	* Returns all the applicants.
	*
	* @return the applicants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rivetlogic.jobsboard.model.Applicant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the applicants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of applicants.
	*
	* @return the number of applicants
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ApplicantPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplicantPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.jobsboard.service.ClpSerializer.getServletContextName(),
					ApplicantPersistence.class.getName());

			ReferenceRegistry.registerReference(ApplicantUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ApplicantPersistence persistence) {
	}

	private static ApplicantPersistence _persistence;
}
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

package com.rivetlogic.jobsboard.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Job. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author joseross
 * @see JobLocalServiceUtil
 * @see com.rivetlogic.jobsboard.service.base.JobLocalServiceBaseImpl
 * @see com.rivetlogic.jobsboard.service.impl.JobLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface JobLocalService extends BaseLocalService, InvokableLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobLocalServiceUtil} to access the job local service. Add custom service methods to {@link com.rivetlogic.jobsboard.service.impl.JobLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the job to the database. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job addJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new job with the primary key. Does not add the job to the database.
	*
	* @param jobId the primary key for the new job
	* @return the new job
	*/
	public com.rivetlogic.jobsboard.model.Job createJob(long jobId);

	/**
	* Deletes the job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job
	* @return the job that was removed
	* @throws PortalException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job deleteJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the job from the database. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job deleteJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rivetlogic.jobsboard.model.Job fetchJob(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job with the primary key.
	*
	* @param jobId the primary key of the job
	* @return the job
	* @throws PortalException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rivetlogic.jobsboard.model.Job getJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rivetlogic.jobsboard.model.Job> getJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jobs.
	*
	* @return the number of jobs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.jobsboard.model.Job updateJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.rivetlogic.jobsboard.model.Job createJob()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByFilters(long companyId, long groupId,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByBookmarks(long companyId, long groupId,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		java.lang.String bookmarks, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int count(com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, boolean bookmarked)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.rivetlogic.jobsboard.model.Job> find(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, boolean bookmarked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException;
}
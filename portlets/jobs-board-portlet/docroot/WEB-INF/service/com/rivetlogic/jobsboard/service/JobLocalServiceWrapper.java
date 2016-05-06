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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobLocalService}.
 *
 * @author joseross
 * @see JobLocalService
 * @generated
 */
public class JobLocalServiceWrapper implements JobLocalService,
	ServiceWrapper<JobLocalService> {
	public JobLocalServiceWrapper(JobLocalService jobLocalService) {
		_jobLocalService = jobLocalService;
	}

	/**
	* Adds the job to the database. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.jobsboard.model.Job addJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.addJob(job);
	}

	/**
	* Creates a new job with the primary key. Does not add the job to the database.
	*
	* @param jobId the primary key for the new job
	* @return the new job
	*/
	@Override
	public com.rivetlogic.jobsboard.model.Job createJob(long jobId) {
		return _jobLocalService.createJob(jobId);
	}

	/**
	* Deletes the job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job
	* @return the job that was removed
	* @throws PortalException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.jobsboard.model.Job deleteJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.deleteJob(jobId);
	}

	/**
	* Deletes the job from the database. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.jobsboard.model.Job deleteJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.deleteJob(job);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rivetlogic.jobsboard.model.Job fetchJob(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.fetchJob(jobId);
	}

	/**
	* Returns the job with the primary key.
	*
	* @param jobId the primary key of the job
	* @return the job
	* @throws PortalException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.jobsboard.model.Job getJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.getJob(jobId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rivetlogic.jobsboard.model.Job> getJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.getJobs(start, end);
	}

	/**
	* Returns the number of jobs.
	*
	* @return the number of jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.getJobsCount();
	}

	/**
	* Updates the job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.jobsboard.model.Job updateJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.updateJob(job);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jobLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jobLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jobLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rivetlogic.jobsboard.model.Job createJob()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.createJob();
	}

	@Override
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.countByCompanyGroup(companyId, groupId);
	}

	@Override
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.findByCompanyGroup(companyId, groupId);
	}

	@Override
	public int countByFilters(long companyId, long groupId,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.countByFilters(companyId, groupId, keywords,
			status, location, category, type);
	}

	@Override
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.findByFilters(companyId, groupId, keywords,
			status, location, category, type, start, end);
	}

	@Override
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.findByFilters(companyId, groupId, keywords,
			status, location, category, type, start, end, orderBy);
	}

	@Override
	public int countByBookmarks(long companyId, long groupId,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.countByBookmarks(companyId, groupId, keywords,
			status, location, category, type, bookmarks);
	}

	@Override
	public java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		java.lang.String bookmarks, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.findByBookmarks(companyId, groupId, keywords,
			status, location, category, type, bookmarks, start, end, orderBy);
	}

	@Override
	public int count(com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, boolean bookmarked)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.count(themeDisplay, keywords, status, location,
			category, type, bookmarked);
	}

	@Override
	public java.util.List<com.rivetlogic.jobsboard.model.Job> find(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, boolean bookmarked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobLocalService.find(themeDisplay, keywords, status, location,
			category, type, bookmarked, start, end, orderBy);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JobLocalService getWrappedJobLocalService() {
		return _jobLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJobLocalService(JobLocalService jobLocalService) {
		_jobLocalService = jobLocalService;
	}

	@Override
	public JobLocalService getWrappedService() {
		return _jobLocalService;
	}

	@Override
	public void setWrappedService(JobLocalService jobLocalService) {
		_jobLocalService = jobLocalService;
	}

	private JobLocalService _jobLocalService;
}
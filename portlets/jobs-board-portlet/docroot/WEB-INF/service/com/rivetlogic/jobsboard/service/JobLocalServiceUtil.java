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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Job. This utility wraps
 * {@link com.rivetlogic.jobsboard.service.impl.JobLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author joseross
 * @see JobLocalService
 * @see com.rivetlogic.jobsboard.service.base.JobLocalServiceBaseImpl
 * @see com.rivetlogic.jobsboard.service.impl.JobLocalServiceImpl
 * @generated
 */
public class JobLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.jobsboard.service.impl.JobLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the job to the database. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job addJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJob(job);
	}

	/**
	* Creates a new job with the primary key. Does not add the job to the database.
	*
	* @param jobId the primary key for the new job
	* @return the new job
	*/
	public static com.rivetlogic.jobsboard.model.Job createJob(long jobId) {
		return getService().createJob(jobId);
	}

	/**
	* Deletes the job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job
	* @return the job that was removed
	* @throws PortalException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job deleteJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJob(jobId);
	}

	/**
	* Deletes the job from the database. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job deleteJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJob(job);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rivetlogic.jobsboard.model.Job fetchJob(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchJob(jobId);
	}

	/**
	* Returns the job with the primary key.
	*
	* @param jobId the primary key of the job
	* @return the job
	* @throws PortalException if a job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job getJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJob(jobId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rivetlogic.jobsboard.model.Job> getJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobs(start, end);
	}

	/**
	* Returns the number of jobs.
	*
	* @return the number of jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobsCount();
	}

	/**
	* Updates the job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param job the job
	* @return the job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.jobsboard.model.Job updateJob(
		com.rivetlogic.jobsboard.model.Job job)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJob(job);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rivetlogic.jobsboard.model.Job createJob()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createJob();
	}

	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompanyGroup(companyId, groupId);
	}

	public static int countByFilters(long companyId, long groupId,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByFilters(companyId, groupId, keywords, status,
			location, category, type);
	}

	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByFilters(companyId, groupId, keywords, status,
			location, category, type, start, end);
	}

	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByFilters(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByFilters(companyId, groupId, keywords, status,
			location, category, type, start, end, orderBy);
	}

	public static int countByBookmarks(long companyId, long groupId,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, java.lang.String bookmarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByBookmarks(companyId, groupId, keywords, status,
			location, category, type, bookmarks);
	}

	public static java.util.List<com.rivetlogic.jobsboard.model.Job> findByBookmarks(
		long companyId, long groupId, java.lang.String keywords,
		boolean[] status, long[] location, long[] category, long[] type,
		java.lang.String bookmarks, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByBookmarks(companyId, groupId, keywords, status,
			location, category, type, bookmarks, start, end, orderBy);
	}

	public static int count(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, boolean bookmarked)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .count(themeDisplay, keywords, status, location, category,
			type, bookmarked);
	}

	public static java.util.List<com.rivetlogic.jobsboard.model.Job> find(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String keywords, boolean[] status, long[] location,
		long[] category, long[] type, boolean bookmarked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .find(themeDisplay, keywords, status, location, category,
			type, bookmarked, start, end, orderBy);
	}

	public static void clearService() {
		_service = null;
	}

	public static JobLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JobLocalService.class.getName());

			if (invokableLocalService instanceof JobLocalService) {
				_service = (JobLocalService)invokableLocalService;
			}
			else {
				_service = new JobLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(JobLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JobLocalService service) {
	}

	private static JobLocalService _service;
}
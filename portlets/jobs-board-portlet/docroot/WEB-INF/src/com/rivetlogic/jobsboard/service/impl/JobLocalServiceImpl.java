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

package com.rivetlogic.jobsboard.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.service.base.JobLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.jobsboard.service.JobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author joseross
 * @see com.rivetlogic.jobsboard.service.base.JobLocalServiceBaseImpl
 * @see com.rivetlogic.jobsboard.service.JobLocalServiceUtil
 */
public class JobLocalServiceImpl extends JobLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.jobsboard.service.JobLocalServiceUtil} to access the job local service.
	 */
    
    public Job createJob() throws SystemException {
        long jobId = counterLocalService.increment(Job.class.getName());
        return createJob(jobId);
    }
    
    public int countByCompanyGroup(long companyId, long groupId) throws SystemException {
        return jobPersistence.countByCompanyGroup(companyId, groupId);
    }
    
    public List<Job> findByCompanyGroup(long companyId, long groupId) throws SystemException {
        return jobPersistence.findByCompanyGroup(companyId, groupId);
    }
    
}
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
import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.jobsboard.model.Applicant;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.service.base.ApplicantLocalServiceBaseImpl;
import com.rivetlogic.jobsboard.util.FiltersUtil;

import java.util.List;

/**
 * The implementation of the applicant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.jobsboard.service.ApplicantLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author joseross
 * @see com.rivetlogic.jobsboard.service.base.ApplicantLocalServiceBaseImpl
 * @see com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil
 */
public class ApplicantLocalServiceImpl extends ApplicantLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil} to access the applicant local service.
	 */
    
    public Applicant createApplicant() throws SystemException {
        long applicantId = counterLocalService.increment(Applicant.class.getName());
        return super.createApplicant(applicantId);
    }
    
    public int countByCompanyGroupJob(long companyId, long groupId, long jobId) throws SystemException {
        return applicantPersistence.countByCompanyGroupJob(companyId, groupId, jobId);
    }
    
    public List<Applicant> findByCompanyGroupJob(long companyId, long groupId, long jobId) throws SystemException {
        return applicantPersistence.findByCompanyGroupJob(companyId, groupId, jobId);
    }
    
    public int countByFilters(long companyId, long groupId, long jobId, String status, String keywords) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return applicantPersistence.countByFilters(companyId, groupId, jobId, list, status);
    }
    
    public List<Applicant> findByFilters(long companyId, long groupId, long jobId, String status, String keywords, int start, int end) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return applicantPersistence.findByFilters(companyId, groupId, jobId, list, status, start, end);
    }
    
    public void deleteByJob(Job job) throws SystemException {
        List<Applicant> applicants = findByCompanyGroupJob(job.getCompanyId(), job.getGroupId(), job.getJobId());
        for(Applicant applicant : applicants) {
            deleteApplicant(applicant);
        }
    }
    
}
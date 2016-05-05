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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.service.base.JobLocalServiceBaseImpl;
import com.rivetlogic.jobsboard.util.FiltersUtil;

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
    
    public int countByFilters(long companyId, long groupId, String keywords, boolean[] status, long[] location, long[] category, long[] type) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return jobPersistence.countByFilters(companyId, groupId, list, status, category, location, type, list);
    }
    
    public List<Job> findByFilters(long companyId, long groupId, String keywords, boolean[] status, long[] location, long[] category, long[] type, int start, int end) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return jobPersistence.findByFilters(companyId, groupId, new String[]{}, status, category, location, type, list, start, end);
    }
    
    public List<Job> findByFilters(long companyId, long groupId, String keywords, boolean[] status, long[] location, long[] category, long[] type, int start, int end, OrderByComparator orderBy) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return jobPersistence.findByFilters(companyId, groupId, new String[]{}, status, category, location, type, list, start, end, orderBy);
    }
    
    public int countByBookmarks(long companyId, long groupId, String keywords, boolean[] status, long[] location, long[] category, long[] type, String bookmarks) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return jobPersistence.countByBookmarks(companyId, groupId, new String[]{}, status, category, location, type, list, bookmarks);        
    }
    
    public List<Job> findByBookmarks(long companyId, long groupId, String keywords, boolean[] status, long[] location, long[] category, long[] type, String bookmarks, int start, int end, OrderByComparator orderBy) throws SystemException {
        String[] list = FiltersUtil.processKeywords(keywords);
        return jobPersistence.findByBookmarks(companyId, groupId, new String[]{}, status, category, location, type, list, bookmarks, start, end, orderBy);
    }
    
    public int count(ThemeDisplay themeDisplay, String keywords, boolean[] status, long[] location, long[] category, long[] type, boolean bookmarked) throws SystemException {
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        if(bookmarked) {
            long userId = themeDisplay.getUserId();
            String bookmark = StringPool.PERCENT + Long.toString(userId) + StringPool.PERCENT;
            return countByBookmarks(companyId, groupId, keywords, status, location, category, type, bookmark);
        } else {
            return countByFilters(companyId, groupId, keywords, status, location, category, type);
        }
    }
    
    public List<Job> find(ThemeDisplay themeDisplay, String keywords, boolean[] status, long[] location, long[] category, long[] type, boolean bookmarked, int start, int end, OrderByComparator orderBy) throws SystemException {
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        if(bookmarked) {
            long userId = themeDisplay.getUserId();
            String bookmark = StringPool.PERCENT + Long.toString(userId) + StringPool.PERCENT;
            return findByBookmarks(companyId, groupId, keywords, status, location, category, type, bookmark, start, end, orderBy);
        } else {
            return findByFilters(companyId, groupId, keywords, status, location, category, type, start, end, orderBy);
        }
    }
    
}
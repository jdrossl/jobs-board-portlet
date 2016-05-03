package com.rivetlogic.jobsboard.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.service.JobLocalServiceUtil;
import com.rivetlogic.jobsboard.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class JobsBoardPortlet
 */
public class JobsBoardPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(JobsBoardPortlet.class);
    
    public void addJob(ActionRequest req, ActionResponse res) throws IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
        long jobId = ParamUtil.getLong(req, WebKeys.PARAM_JOB_ID, -1);
        Date now = new Date();
        Job job = null;
        try {
            if(jobId == -1) {
                job = JobLocalServiceUtil.createJob();
                job.setCompanyId(themeDisplay.getCompanyId());
                job.setGroupId(themeDisplay.getScopeGroupId());
                job.setCreateDate(now);
            } else {
                job = JobLocalServiceUtil.fetchJob(jobId);
            }
            
            job.setModifiedDate(now);
            
            String name = ParamUtil.getString(req, WebKeys.PARAM_NAME);
            Boolean isActive = ParamUtil.getBoolean(req, WebKeys.PARAM_ACTIVE);
            
            job.setName(name);
            job.setActive(isActive);
            
            JobLocalServiceUtil.updateJob(job);
        } catch (Exception e) {
            LOG.error("Error adding new job:", e);
        }
        sendRedirect(req, res);
    }

}

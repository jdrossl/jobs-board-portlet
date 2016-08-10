package com.rivetlogic.jobsboard.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.jobsboard.model.Applicant;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.model.Subscription;
import com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil;
import com.rivetlogic.jobsboard.service.JobLocalServiceUtil;
import com.rivetlogic.jobsboard.service.SubscriptionLocalServiceUtil;
import com.rivetlogic.jobsboard.util.ApplicantStatus;
import com.rivetlogic.jobsboard.util.FiltersUtil;
import com.rivetlogic.jobsboard.util.PrefsKeys;
import com.rivetlogic.jobsboard.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class JobsBoardPortlet
 */
public class JobsBoardPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(JobsBoardPortlet.class);

    public static final String DEFAULT_FILE_NAME = "CV - ";
    public static final String DEFAULT_FOLDER_NAME = "Jobs Board - CVs";
    public static final String DEFAULT_FOLFER_DESC = "Uploaded Files By Applicants";
    
    public void addSubscription(ActionRequest req, ActionResponse res) throws IOException {
        String name = ParamUtil.getString(req, WebKeys.PARAM_NAME);
        String email = ParamUtil.getString(req, WebKeys.PARAM_EMAIL);
        ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
        Date now = new Date();
        try {
            Subscription subscription = SubscriptionLocalServiceUtil.createSubscription(email);
            subscription.setFullName(name);
            subscription.setCompanyId(themeDisplay.getCompanyId());
            subscription.setGroupId(themeDisplay.getScopeGroupId());
            subscription.setCreateDate(now);
            subscription.setModifiedDate(now);
            SubscriptionLocalServiceUtil.addSubscription(subscription);
        } catch(Exception e) {
            LOG.error("Error registering subscription:", e);
            SessionErrors.add(req, "subscription-error");
            SessionMessages.add(req, PortalUtil.getPortletId(req) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        sendRedirect(req, res);
    }
    
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
                job.setUserId(themeDisplay.getUserId());
                job.setUserName(themeDisplay.getUser().getFullName());
            } else {
                job = JobLocalServiceUtil.fetchJob(jobId);
            }
            
            job.setModifiedDate(now);
            
            String name = ParamUtil.getString(req, WebKeys.PARAM_NAME);
            Boolean isActive = ParamUtil.getBoolean(req, WebKeys.PARAM_ACTIVE);
            String description = ParamUtil.getString(req, WebKeys.PARAM_DESC);
            Double salary = ParamUtil.getDouble(req, WebKeys.PARAM_SALARY);
            
            long categoryId = FiltersUtil.getCategoryId(req, PrefsKeys.CATEGORY_ID);
            long locationId = FiltersUtil.getCategoryId(req, PrefsKeys.LOCATION_ID);
            long typeId = FiltersUtil.getCategoryId(req, PrefsKeys.TYPE_ID);
            
            long type = ParamUtil.getLong(req, WebKeys.PARAM_CATEGORIES + Long.toString(typeId));
            long category = ParamUtil.getLong(req, WebKeys.PARAM_CATEGORIES + Long.toString(categoryId));
            long location = ParamUtil.getLong(req, WebKeys.PARAM_CATEGORIES + Long.toString(locationId));

            job.setName(name);
            job.setActive(isActive);
            job.setDescription(description);
            job.setSalary(salary);
            job.setType(type);
            job.setCategory(category);
            job.setLocation(location);
            
            job.persist();
            if(jobId == -1 && job.isActive()) {
                SubscriptionLocalServiceUtil.notifySubscribers(req, job);
            }
        } catch (Exception e) {
            LOG.error("Error adding new job:", e);
            SessionErrors.add(req, "update-job-error");
            SessionMessages.add(req, PortalUtil.getPortletId(req) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        sendRedirect(req, res);
    }
    
    public void deleteJob(ActionRequest req, ActionResponse res) throws IOException {
        long jobId = ParamUtil.getLong(req, WebKeys.PARAM_JOB_ID);
        try {
            Job job = JobLocalServiceUtil.deleteJob(jobId);
            ApplicantLocalServiceUtil.deleteByJob(job);
        } catch(Exception e) {
            LOG.error("Error deleting job:", e);
            SessionErrors.add(req, "delete-job-error");
            SessionMessages.add(req, PortalUtil.getPortletId(req) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        sendRedirect(req, res);
    }
    
    public void bookmarkJob(ActionRequest req, ActionResponse res) throws IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
        long jobId = ParamUtil.getLong(req, WebKeys.PARAM_JOB_ID);
        String userId = Long.toString(themeDisplay.getUserId());
        try {
            Job job = JobLocalServiceUtil.fetchJob(jobId);
            if(job.getBookmarks().contains(userId)) {
                List<String> list = new ArrayList<String>(); 
                for(String s : job.getBookmarks().split(StringPool.COMMA)) {
                    if(!Validator.equals(s, userId)) {
                        list.add(s);
                    }
                }
                job.setBookmarks(StringUtil.merge(list));
            } else {
                job.setBookmarks(StringUtil.merge(new Object[]{ job.getBookmarks(), userId }));
            }
            job.persist();
        } catch(Exception e) {
            LOG.error("Error bookmarking job:", e);
            SessionErrors.add(req, "bookmark-error");
            SessionMessages.add(req, PortalUtil.getPortletId(req) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        sendRedirect(req, res);
    }

    public void applyToJob(ActionRequest req, ActionResponse res) throws IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
        long jobId = ParamUtil.getLong(req, WebKeys.PARAM_JOB_ID);
        User user = (User) req.getAttribute(WebKeys.USER);
        long userId = user.getUserId();
        UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(req);
        try {
            long cv = storeFile(upload, themeDisplay, jobId, userId);
            
            Applicant applicant = ApplicantLocalServiceUtil.createApplicant();
            
            Date now = new Date();
            
            String name = ParamUtil.getString(upload, WebKeys.PARAM_NAME);
            String email = ParamUtil.getString(upload, WebKeys.PARAM_EMAIL);
            String phone = ParamUtil.getString(upload, WebKeys.PARAM_PHONE);
            String info = ParamUtil.getString(upload, WebKeys.PARAM_INFO);
            
            applicant.setCreateDate(now);
            applicant.setModifiedDate(now);
            applicant.setCompanyId(themeDisplay.getCompanyId());
            applicant.setGroupId(themeDisplay.getScopeGroupId());
            
            applicant.setJobId(jobId);
            applicant.setName(name);
            applicant.setEmail(email);
            applicant.setPhone(phone);
            applicant.setInfo(info);
            applicant.setCv(cv);
            applicant.setStatus(ApplicantStatus.PENDING);
            
            applicant.persist();
            
        } catch(Exception e) {
            LOG.error("Error adding applicant to job:", e);
            SessionErrors.add(req, "apply-error");
            SessionMessages.add(req, PortalUtil.getPortletId(req) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        sendRedirect(req, res);
    }
    
    private long storeFile(UploadPortletRequest upload, ThemeDisplay themeDisplay, long jobId, long userId) throws PortalException, SystemException, FileNotFoundException {
        long groupId = themeDisplay.getScopeGroupId();
        long parent = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
        String applicantName = ParamUtil.getString(upload, WebKeys.PARAM_NAME);
        String fileName = upload.getFileName(WebKeys.PARAM_CV);
        File file = upload.getFile(WebKeys.PARAM_CV);
        String contentType = upload.getContentType(WebKeys.PARAM_CV);
        String name = String.format("%s - %s - %s - %s", 
                DEFAULT_FILE_NAME, jobId, applicantName, fileName);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), upload);
        InputStream is = new FileInputStream(file);
        Folder folder = null;
        try {
            LOG.debug("Looking for CV Uploads forlder");
            folder = DLAppLocalServiceUtil.getFolder(groupId, parent, DEFAULT_FOLDER_NAME);
            LOG.debug("Folder already exists");
        } catch(Exception e) {
            LOG.debug("Folder does not exist");
            folder = DLAppLocalServiceUtil.addFolder(userId, groupId, parent, DEFAULT_FOLDER_NAME, DEFAULT_FOLFER_DESC, serviceContext);
            LOG.debug("Folder created");
        }
        LOG.debug("Adding CV file to folder");
        FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                userId, groupId, folder.getFolderId(), name, contentType, name, StringPool.BLANK, StringPool.BLANK, is, file.length(), serviceContext);
        LOG.debug("File added");
        return fileEntry.getFileEntryId();
    }
    
    public void deleteApplicant(ActionRequest req, ActionResponse res) throws IOException {
        long applicantId = ParamUtil.getLong(req, WebKeys.PARAM_APPLICANT_ID);
        try {
            ApplicantLocalServiceUtil.deleteApplicant(applicantId);
        } catch(Exception e) {
            LOG.error("Error deleting applicant:", e);
        }
        sendRedirect(req, res);
    }
    
    public void updateApplicant(ActionRequest req, ActionResponse res) throws IOException {
        long applicantId = ParamUtil.getLong(req, WebKeys.PARAM_APPLICANT_ID);
        try {
            Applicant applicant = ApplicantLocalServiceUtil.fetchApplicant(applicantId);
            
            String status = ParamUtil.getString(req, WebKeys.PARAM_STATUS);
            String notes = ParamUtil.getString(req, WebKeys.PARAM_NOTES);
            
            applicant.setStatus(status);
            applicant.setNotes(notes);
            applicant.setModifiedDate(new Date());;
            
            applicant.persist();
        } catch(Exception e) {
            LOG.error("Error updating applicant:", e);
            SessionErrors.add(req, "update-applicant-error");
            SessionMessages.add(req, PortalUtil.getPortletId(req) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        sendRedirect(req, res);
    }
    
}
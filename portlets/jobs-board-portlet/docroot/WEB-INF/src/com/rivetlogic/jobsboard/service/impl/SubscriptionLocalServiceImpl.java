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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.model.Subscription;
import com.rivetlogic.jobsboard.service.base.SubscriptionLocalServiceBaseImpl;
import com.rivetlogic.jobsboard.util.MailUtil;

import java.util.List;

import javax.portlet.PortletRequest;

/**
 * The implementation of the subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.jobsboard.service.SubscriptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author joseross
 * @see com.rivetlogic.jobsboard.service.base.SubscriptionLocalServiceBaseImpl
 * @see com.rivetlogic.jobsboard.service.SubscriptionLocalServiceUtil
 */
public class SubscriptionLocalServiceImpl
	extends SubscriptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.jobsboard.service.SubscriptionLocalServiceUtil} to access the subscription local service.
	 */
    
    private static final Log LOG = LogFactoryUtil.getLog(SubscriptionLocalServiceImpl.class);
    
    public void notifySubscribers(PortletRequest req, Job job) {
        LOG.debug("Sending notification to subscribers for " + job.getName());
        try {
            List<Subscription> subscriptions = 
                    subscriptionPersistence.findByCompanyGroup(job.getCompanyId(), job.getGroupId());
            if(!subscriptions.isEmpty()) {
                String message = MailUtil.generateNotification(req, job);
                for(Subscription subscription : subscriptions) {
                    LOG.debug("Sending notification for " + subscription.getEmailAddress());
                    MailUtil.sendNotification(req, subscription, message);
                }
            }
        } catch(Exception e) {
            LOG.error("Error finding subscriptions:", e);
        }
    }
    
}
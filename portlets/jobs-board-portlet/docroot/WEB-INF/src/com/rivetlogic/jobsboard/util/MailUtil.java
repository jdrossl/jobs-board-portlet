package com.rivetlogic.jobsboard.util;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.util.ContentUtil;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.model.Subscription;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


public class MailUtil {

    // TODO: Get from language.properties
    public static final String DEFAULT_SUBJECT = "New Job Posted!";
    // TODO: Get from template file
    public static final String DEFAULT_TEMPLATE = "content/email.vm";
    
    public static void sendNotification(PortletRequest req, Subscription subscription, String body) throws Exception  {
        InternetAddress from = getFromAddress(req);
        InternetAddress to = new InternetAddress(subscription.getEmailAddress());
        MailMessage message = new MailMessage(from, to, getNotificationSubject(req), body, true);
        MailServiceUtil.sendEmail(message);
    }
    
    private static InternetAddress getFromAddress(PortletRequest req) throws AddressException {
        //TODO: Get value from preferences
        return new InternetAddress("jobs@liferay.com");
    }
    
    private static String getNotificationSubject(PortletRequest req) {
        //TODO: Get value from preferences
        return DEFAULT_SUBJECT;
    }
      
    private static String evaluateTemplate(Job job) throws Exception {
        StringWriter writer = new StringWriter();
        String template = ContentUtil.get(DEFAULT_TEMPLATE);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("job", job);
        Velocity.init();
        Velocity.evaluate(new VelocityContext(map), writer, "velocityLogTag", template);
        return writer.toString();
    }
    
    public static String generateNotification(PortletRequest req, Job job) throws Exception {
        //TODO: Get value from preferences
        return evaluateTemplate(job);
    }
    
}

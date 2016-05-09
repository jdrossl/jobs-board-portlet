<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator"%>

<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetVocabulary" %>
<%@ page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil" %>

<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="com.rivetlogic.jobsboard.util.WebKeys" %>
<%@ page import="com.rivetlogic.jobsboard.util.ApplicantStatus" %>
<%@ page import="com.rivetlogic.jobsboard.util.FiltersUtil" %>
<%@ page import="com.rivetlogic.jobsboard.model.Job" %>
<%@ page import="com.rivetlogic.jobsboard.service.JobLocalServiceUtil" %>
<%@ page import="com.rivetlogic.jobsboard.model.Applicant" %>
<%@ page import="com.rivetlogic.jobsboard.model.impl.JobModelImpl"%>
<%@ page import="com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil" %>
<%@page import="com.rivetlogic.jobsboard.util.MailUtil"%>
<%@page import="com.rivetlogic.jobsboard.util.PrefsKeys"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
	String currentURL = PortalUtil.getCurrentURL(request);
	String completeCurrentURL = PortalUtil.getCurrentCompleteURL(request);
	String redirect = ParamUtil.getString(request, "redirect", currentURL);
%>

<aui:script use="jobs-board-portlet">
	var jobs = new A.JobsBoard({
    namespace: '<portlet:namespace />',
    portletResourceUrl: '<portlet:resourceURL />'
  });
</aui:script>

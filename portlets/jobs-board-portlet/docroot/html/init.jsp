<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.rivetlogic.jobsboard.util.WebKeys" %>
<%@ page import="com.rivetlogic.jobsboard.model.Job" %>
<%@ page import="com.rivetlogic.jobsboard.service.JobLocalServiceUtil" %>

<portlet:defineObjects />
<theme:defineObjects />

<%
	String currentURL = PortalUtil.getCurrentURL(request);
	String redirect = ParamUtil.getString(request, "redirect", currentURL);
%>

<aui:script use="jobs-board-portlet">
	var jobs = new A.JobsBoard({
    namespace: '<portlet:namespace />',
    portletResourceUrl: '<portlet:resourceURL />'
  });
</aui:script>

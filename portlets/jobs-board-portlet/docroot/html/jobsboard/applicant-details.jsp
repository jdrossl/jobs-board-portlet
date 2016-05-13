<%@ include file="/html/init.jsp" %>

<%
	long applicantId = ParamUtil.getLong(request, WebKeys.PARAM_APPLICANT_ID);
	Applicant applicant = ApplicantLocalServiceUtil.fetchApplicant(applicantId);
	DLFileEntry file = DLFileEntryServiceUtil.getFileEntry(applicant.getCv());
	String url = themeDisplay.getPortalURL()  + "/c/document_library/get_file";
	url = HttpUtil.addParameter(url, "uuid", file.getUuid());
	url = HttpUtil.addParameter(url, "groupId", themeDisplay.getScopeGroupId());
	pageContext.setAttribute("applicant", applicant);
%>

<aui:model-context model="<%= Applicant.class %>" bean="<%= applicant %>" />

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="applicant-details" />

<liferay-ui:error key="update-applicant-error" message="update-applicant-error"/>

<aui:container>
	<aui:row>
		<aui:col width="100">
			<div class="applicant-details">
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="name" />
					</div> 
					<h2 class="blurb-title">${ applicant.name }</h2>
				</div>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="email-address" /><br/>
					</div>
					<div class="blurb-title">
						<a><strong>${ applicant.email }</strong></a>
					</div>
				</div>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="phone-number" /><br/>
					</div>
					<div class="blurb-title">
						<a><strong>${ applicant.phone }</strong></a>
					</div>
				</div>
				<c:if test="${ not empty applicant.info }">
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="additional-information" />
					</div>
					<div>
						<p>${ applicant.info }.</p>
					</div>
				</div>
				</c:if>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="cv-file" />
					</div>
					<div class="blurb-title">
						<aui:button value="download" href="<%= url %>" />
					</div>
				</div>


				<h3><liferay-ui:message key="hiring-information-process" /></h3>
				<hr/>
				<portlet:actionURL name="updateApplicant" var="updateURL">
					<portlet:param name="applicantId" value="${ applicant.applicantId }"/>
					<portlet:param name="redirect" value="<%= currentURL %>"/>
				</portlet:actionURL>
				<aui:form action="<%= updateURL %>" method="post">
					<aui:select name="status">
						<aui:option label="<%= ApplicantStatus.PENDING %>" value="<%= ApplicantStatus.PENDING %>" />
						<aui:option label="<%= ApplicantStatus.SCHEDULED %>" value="<%= ApplicantStatus.SCHEDULED %>" />
						<aui:option label="<%= ApplicantStatus.ELEGIBLE %>" value="<%= ApplicantStatus.ELEGIBLE %>" />
						<aui:option label="<%= ApplicantStatus.NON_ELEGIBLE %>" value="<%= ApplicantStatus.NON_ELEGIBLE %>" />
						<aui:option label="<%= ApplicantStatus.ON_BOARD %>" value="<%= ApplicantStatus.ON_BOARD %>" />
					</aui:select>
					<liferay-ui:input-editor name="notes" initMethod="initEditor" />
					<aui:button value="save" cssClass="btn-primary save" type="submit"/>
				</aui:form>
			</div>
			
		</aui:col>
	</aui:row>
</aui:container>

<script type="text/javascript">
	function <portlet:namespace />initEditor() { return '<%= UnicodeFormatter.toString(applicant.getNotes()) %>'; }
</script>


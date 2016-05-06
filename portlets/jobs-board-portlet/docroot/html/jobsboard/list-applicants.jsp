<%@ include file="/html/init.jsp" %>

<%
	long jobId = ParamUtil.getLong(request, WebKeys.PARAM_JOB_ID);
	Job job = JobLocalServiceUtil.fetchJob(jobId);
	int totalApplicants = 0;
	
	// ---- FILTERS ----
	String status = ParamUtil.getString(request, WebKeys.PARAM_STATUS);
	String keywords = ParamUtil.getString(request, WebKeys.PARAM_KEYWORDS);
	if(Validator.isNull(status) || Validator.equals(status, StringPool.BLANK)) {
	    status = StringPool.PERCENT;
	}
	if(Validator.isNull(keywords) || Validator.equals(keywords, StringPool.BLANK)) {
	    keywords = StringPool.PERCENT;
	}
	// ---- FILTERS ----
	
	totalApplicants = ApplicantLocalServiceUtil.countByFilters(job.getCompanyId(), job.getGroupId(), jobId, status, keywords);
	SimpleDateFormat format = new SimpleDateFormat("MMMM-d-yyyy, hh:MM a");
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/jobsboard/list-applicants.jsp");
	iteratorURL.setParameter("jobId", Long.toString(jobId));
	iteratorURL.setParameter("redirect", redirect);
%>

<aui:container>
	<aui:row>
		<aui:col>
			<aui:form action="<%= currentURL %>" cssClass="main-filters-form">
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item label="back" iconCssClass="icon-arrow-left" href="<%= redirect %>"/>
					<aui:nav-item label="filters" cssClass="filters" iconCssClass="icon-chevron-down">
						<div class="filters-form popover bottom hidden">
							<div class="arrow"></div>
							<div class="popover-content">
								<aui:fieldset>
									<aui:select name="status" inlineField="true" cssClass="filters-submit">
										<aui:option label="all" value="%" />
										<aui:option label="<%= ApplicantStatus.PENDING %>" value="<%= ApplicantStatus.PENDING %>" />
										<aui:option label="<%= ApplicantStatus.SCHEDULED %>" value="<%= ApplicantStatus.SCHEDULED %>" />
										<aui:option label="<%= ApplicantStatus.ELEGIBLE %>" value="<%= ApplicantStatus.ELEGIBLE %>" />
										<aui:option label="<%= ApplicantStatus.NON_ELEGIBLE %>" value="<%= ApplicantStatus.NON_ELEGIBLE %>" />
										<aui:option label="<%= ApplicantStatus.ON_BOARD %>" value="<%= ApplicantStatus.ON_BOARD %>" />
									</aui:select>
								</aui:fieldset>
							</div>
						</div>
					</aui:nav-item>
					<aui:nav-item>
						<aui:field-wrapper cssClass="nav-keyword-wrapper">
							<aui:input name="keywords" label="" placeholder="keywords" />
						</aui:field-wrapper>
					</aui:nav-item>
					<aui:nav-item label="clear-search" href="<%= iteratorURL.toString() %>" />
				</aui:nav>
			</aui:nav-bar>
			</aui:form>
			
			
			
			<c:if test="<%= totalApplicants > 0 %>">
			<aui:row>
				<aui:col>
					<h2><liferay-ui:message key="x-applicants-for-x" arguments="<%= new Object[]{ totalApplicants, job.getName() } %>" /></h2>
				</aui:col>
			</aui:row>
			</c:if>
			<liferay-ui:search-container iteratorURL="<%= iteratorURL %>" emptyResultsMessage="no-applicants-found">
				<liferay-ui:search-container-results
					results="<%= ApplicantLocalServiceUtil.findByFilters(job.getCompanyId(), job.getGroupId(), jobId, status, keywords, searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%= totalApplicants %>" />
				<liferay-ui:search-container-row className="com.rivetlogic.jobsboard.model.Applicant" modelVar="applicant">
					<portlet:renderURL var="viewURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/applicant-details.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="applicantId" value="${ applicant.applicantId }"/>
					</portlet:renderURL>
					<div class="list-item">
						<div class="applicant-name"><h4><a href="<%= viewURL %>">${ applicant.name }</a></h4></div>
						<span class="applicant-status"><liferay-ui:message key="${ applicant.status }" /></span>
						
						<div class="list-item-actions">
						  <ul>
								<li><span class="applicant-submitted">Submitted: <%= format.format(applicant.getCreateDate()) %></span></li>
								<li class="applicant-delete">
									<portlet:actionURL name="deleteApplicant" var="deleteURL">
										<portlet:param name="applicantId" value="${ applicant.applicantId }"/>
										<portlet:param name="redirect" value="<%= currentURL %>"/>
									</portlet:actionURL>
									<liferay-ui:icon iconCssClass="icon-trash" url="<%= deleteURL %>" />
								</li>
								<li class="applicant-edit">
									<liferay-ui:icon iconCssClass="icon-edit" url="<%= viewURL %>"/>
								</li>
						  </ul>
						</div>
					
					</div>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</aui:col>
	</aui:row>
</aui:container>

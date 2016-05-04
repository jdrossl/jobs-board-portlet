<%@ include file="/html/init.jsp" %>

<%
	long jobId = ParamUtil.getLong(request, WebKeys.PARAM_JOB_ID);
	Job job = JobLocalServiceUtil.fetchJob(jobId);
	int totalApplicants = 0;
	List<Applicant> applicantsList = null;
	try {
	    applicantsList = ApplicantLocalServiceUtil.findByCompanyGroupJob(job.getCompanyId(), job.getGroupId(), jobId);
	    totalApplicants = ApplicantLocalServiceUtil.countByCompanyGroupJob(job.getCompanyId(), job.getGroupId(), jobId);
	} catch(Exception e) {
	    applicantsList = new ArrayList<Applicant>();
	}
	SimpleDateFormat format = new SimpleDateFormat("MMMM-d-yyyy, hh:MM a");
%>

<aui:container>
	<aui:row>
		<aui:col>
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item label="back" iconCssClass="icon-arrow-left" href="<%= redirect %>"/>
					<aui:nav-item label="filters" cssClass="filters" iconCssClass="icon-chevron-down">
						<div class="filters-form popover bottom hidden">
							<div class="arrow"></div>
							<div class="popover-content">
								<aui:form>
									<aui:fieldset>
										<aui:select name="status" inlineField="true">
											<aui:option label="all" value="" />
										</aui:select>
									</aui:fieldset>
								</aui:form>
							</div>
						</div>
					</aui:nav-item>
					<aui:nav-item>
						<aui:field-wrapper cssClass="nav-keyword-wrapper">
							<aui:input name="keywords" label="" placeholder="keywords" />
						</aui:field-wrapper>
					</aui:nav-item>
					<aui:nav-item label="clear-search" />
				</aui:nav>
			</aui:nav-bar>
			
			
			
			<c:if test="<%= !applicantsList.isEmpty() %>">
			<aui:row>
				<aui:col>
					<h2><liferay-ui:message key="x-applicants-for-x" arguments="<%= new Object[]{ totalApplicants, job.getName() } %>" /></h2>
				</aui:col>
			</aui:row>
			</c:if>
			
			<liferay-ui:search-container delta="5" emptyResultsMessage="no-applicants-found">
				<liferay-ui:search-container-results results="<%= applicantsList %>" total="<%= totalApplicants %>" />
				<liferay-ui:search-container-row className="com.rivetlogic.jobsboard.model.Applicant" modelVar="applicant">
					<portlet:renderURL var="viewURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/applicant-details.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="applicantId" value="${ applicant.applicantId }"/>
					</portlet:renderURL>
					<div class="list-item">
						<div class="applicant-name"><h4><a href="<%= viewURL %>">${ applicant.name }</a></h4></div>
						<span class="applicant-status"><liferay-ui:message key="status-${ applicant.status }" /></span>
						
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

<%@ include file="/html/init.jsp" %>

<%
	int totalJobs = 0;
	List<Job> jobsList = null;
	try {
		jobsList = JobLocalServiceUtil.findByCompanyGroup(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		totalJobs = JobLocalServiceUtil.countByCompanyGroup(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	} catch(Exception e) {
	    jobsList = new ArrayList<Job>();
	}
%>

<portlet:renderURL var="addURL">
	<portlet:param name="mvcPath" value="/html/jobsboard/edit-job.jsp"/>
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<aui:container>
	<aui:row>
		<aui:col width="75">
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item cssClass="filters" label="filters" iconCssClass="icon-chevron-down">
						<div class="filters-form popover bottom hidden">
							<div class="arrow"></div>
							<div class="popover-content">
								<aui:form>
									<aui:fieldset>
										<aui:select name="location" inlineField="true">
										</aui:select>
										<aui:select name="category" inlineField="true">
										</aui:select>
										<aui:select name="type" inlineField="true">
										</aui:select>
										<aui:select name="status" inlineField="true">
											<aui:option label="all" value="" />
											<aui:option label="active" value="active" />
											<aui:option label="inactive" value="inactive" />
										</aui:select>
										<aui:input name="only-bookmarked" type="checkbox" />
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
					<aui:nav-item label="add" iconCssClass="icon-plus" href="<%= addURL %>"/>
				</aui:nav>
			</aui:nav-bar>
			
			
			
			<c:if test="<%= !jobsList.isEmpty() %>">
			<aui:row>
				<aui:col width="50">
					<h2><liferay-ui:message key="x-total-jobs" arguments="<%= totalJobs %>" /></h2>
				</aui:col>
				<aui:col width="50">
					<aui:field-wrapper cssClass="sort-by-wrapper pull-right">
						<aui:select name="sort-by" inlineLabel="true">
							<aui:option label="name" value="name" />
						</aui:select>
					</aui:field-wrapper>
				</aui:col>
			</aui:row>
			</c:if>
			
			<liferay-ui:search-container delta="3" emptyResultsMessage="no-jobs-found">
				<liferay-ui:search-container-results results="<%= jobsList %>" total="<%= totalJobs %>" />
				<liferay-ui:search-container-row className="com.rivetlogic.jobsboard.model.Job" modelVar="job">
					<portlet:renderURL var="viewURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/job-details.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:renderURL>
					<portlet:renderURL var="editURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/edit-job.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:renderURL>
					<portlet:renderURL var="applicantsURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/list-applicants.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:renderURL>
					<div class="position-summary">
						<hr/>
						<div class="position-name"><h3><a href="<%= viewURL %>">${ job.name }</a></h3></div>
						<ul class="position-info">
							<li class="position-category">${ job.category }</li>
							<li class="position-location">${ job.location }</li>
							<li class="position-posted">${ job.createDate }</li>
							<li class="position-type">${ job.type }</li>
						</ul>
						
						
						<span class="position-applicants">
							<liferay-ui:icon iconCssClass="icon-user" url="<%= applicantsURL %>" />
						</span>
						<span class="position-bookmark">
							<liferay-ui:icon iconCssClass="icon-bookmark" />
						</span>
						<span class="position-edit">
							<liferay-ui:icon iconCssClass="icon-edit" url="<%= editURL %>" />
						</span>
						<span class="position-delete">
							<liferay-ui:icon iconCssClass="icon-trash" />
						</span>
					</div>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</aui:col>
		<aui:col width="25">
			<div class="well">
				<h4><liferay-ui:message key="subscribe-form-title" /></h4>
				<aui:form>
					<aui:fieldset>
						<aui:field-wrapper cssClass="submit-form-group">
							<aui:input name="name" placeholder="full-name" label="" cssClass="subscribe-form-control"/>
						</aui:field-wrapper>
						<aui:field-wrapper cssClass="submit-form-group">
							<aui:input name="email" placeholder="email-address" label="" cssClass="subscribe-form-control" />
						</aui:field-wrapper>
						<aui:button value="subscribe" cssClass="btn-primary subscribe-form-button" type="submit" />
					</aui:fieldset>
				</aui:form>
			</div>
		</aui:col>
	</aui:row>
</aui:container>

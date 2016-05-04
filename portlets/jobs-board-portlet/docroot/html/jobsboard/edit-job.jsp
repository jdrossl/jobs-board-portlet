<%@ include file="/html/init.jsp" %>

<%
	long jobId = ParamUtil.getLong(request, WebKeys.PARAM_JOB_ID, -1);
	Job job = null;
	String currentCategories = StringPool.BLANK;
	if(jobId != -1) {
	    job = JobLocalServiceUtil.fetchJob(jobId);
	    currentCategories = job.getCategory() + StringPool.COMMA + job.getLocation() + StringPool.COMMA + job.getType();
	}
%>

<aui:model-context model="<%= Job.class %>" bean="<%= job %>" />

<portlet:actionURL name="addJob" var="addURL">
	<c:if test="<%= job != null %>">
	<portlet:param name="jobId" value="<%= Long.toString(job.getJobId()) %>"/>
	</c:if>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="job-details" />

<aui:container>
	<aui:row>
		<aui:col width="100">
			<aui:form cssClass="well" action="<%= addURL %>">
				<aui:fieldset>
					<aui:input name="name" required="true" />
					<aui:field-wrapper>
						<aui:input name="active" label="is-active" />
					</aui:field-wrapper>
					<aui:field-wrapper cssClass="edit-form-categories">
						<liferay-ui:asset-categories-selector hiddenInput="categories" curCategoryIds="<%= currentCategories %>"
							className="<%= Job.class.getName() %>" />
					</aui:field-wrapper>
					<aui:field-wrapper label="description">
						<liferay-ui:input-editor name="description" initMethod="initEditor" />
					</aui:field-wrapper>
					<aui:input name="salary">
						<aui:validator name="number"/>
					</aui:input>
					<aui:button-row>
						<aui:button cssClass="btn-primary" value="submit" type="submit" />
					</aui:button-row>
				</aui:fieldset>
			</aui:form>
		</aui:col>
	</aui:row>
</aui:container>

<script type="text/javascript">
	function <portlet:namespace />initEditor() { return '<%= (job != null)? UnicodeFormatter.toString(job.getDescription()) : StringPool.BLANK %>'; }
</script>

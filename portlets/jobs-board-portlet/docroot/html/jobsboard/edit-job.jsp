<%@ include file="/html/init.jsp" %>

<%
	long jobId = ParamUtil.getLong(request, WebKeys.PARAM_JOB_ID, -1);
	Job job = null;
	if(jobId != -1) {
	    job = JobLocalServiceUtil.fetchJob(jobId);
	}
%>

<c:if test="<%= job != null %>">
	<aui:model-context model="<%= Job.class %>" bean="<%= job %>" />
</c:if>

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
						<aui:input type="checkbox" name="is-active"/>
					</aui:field-wrapper>
					<aui:field-wrapper label="categories" cssClass="edit-form-categories">
						<liferay-ui:asset-categories-selector hiddenInput="categories"  />
					</aui:field-wrapper>
					<aui:field-wrapper>
						<aui:input name="location"/>
					</aui:field-wrapper>
					
					<aui:select name="type" required="true">
						<aui:option label="full-time" value="full-time" />
						<aui:option label="part-time" value="part-time" />
						<aui:option label="contract" value="contract" />
					</aui:select>
					<aui:field-wrapper label="description">
						<liferay-ui:input-editor name="description" initMethod="initEditor" />
					</aui:field-wrapper>
					<aui:input name="salary" type="number" />
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

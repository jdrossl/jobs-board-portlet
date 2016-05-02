<%@ include file="/html/init.jsp" %>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="job-details" />

<aui:container>
	<aui:row>
		<aui:col width="50">
			<aui:form cssClass="well">
				<aui:fieldset>
					<aui:input name="name" />
					<aui:field-wrapper>
						<aui:input type="checkbox" name="is-active"/>
					</aui:field-wrapper>
					<aui:field-wrapper label="categories" cssClass="edit-form-categories">
						<liferay-ui:asset-categories-selector />
					</aui:field-wrapper>
					<aui:field-wrapper>
						<aui:input name="location"/>
					</aui:field-wrapper>
					
					<aui:select name="type">
						<aui:option>Full Time</aui:option>
						<aui:option>Part Time</aui:option>
						<aui:option>Contract</aui:option>
					</aui:select>
					<aui:field-wrapper label="description">
						<liferay-ui:input-editor name="description" initMethod="initEditor" />
					</aui:field-wrapper>
					<aui:input name="salary" type="number" />
					<aui:button-row>
						<aui:button cssClass="btn-primary" value="submit" />
					</aui:button-row>
				</aui:fieldset>
			</aui:form>
		</aui:col>
	</aui:row>
</aui:container>

<script type="text/javascript">
	function <portlet:namespace />initEditor() { return ""; }
</script>
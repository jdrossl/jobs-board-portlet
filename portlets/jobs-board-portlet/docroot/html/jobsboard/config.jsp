<%@ include file="/html/init.jsp" %>

<%
	List<AssetVocabulary> vocabularies =
		AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId(), false);

	pageContext.setAttribute(PrefsKeys.CATEGORY_ID, 
	        GetterUtil.getLong(portletPreferences.getValue(PrefsKeys.CATEGORY_ID, "-1")));
	pageContext.setAttribute(PrefsKeys.LOCATION_ID, 
	        GetterUtil.getLong(portletPreferences.getValue(PrefsKeys.LOCATION_ID, "-1")));
	pageContext.setAttribute(PrefsKeys.TYPE_ID, 
	        GetterUtil.getLong(portletPreferences.getValue(PrefsKeys.TYPE_ID, "-1")));
	pageContext.setAttribute(PrefsKeys.SUBS_EMAIL, 
	        GetterUtil.getString(portletPreferences.getValue(PrefsKeys.SUBS_EMAIL, StringPool.BLANK)));
	
	pageContext.setAttribute(PrefsKeys.SUBS_SUBJECT, MailUtil.getSubject(renderRequest));
	
	String template = MailUtil.getTemplate(renderRequest);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>">
	
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<liferay-ui:tabs names="categories,mail" refresh="false">
		<liferay-ui:section>
			<aui:fieldset>
				<div class="alert alert-info"><liferay-ui:message key="config-help-message"/></div>
				<aui:select name="preferences--categoryId--" label="category-vocabulary" required="true" showEmptyOption="true">
					<c:forEach items="<%= vocabularies %>" var="voc">
						<aui:option label="${ voc.name }" value="${ voc.vocabularyId }" selected="${ voc.vocabularyId == categoryId }" />
					</c:forEach>
				</aui:select>
				<aui:select name="preferences--locationId--" label="location-vocabulary" required="true" showEmptyOption="true">
					<c:forEach items="<%= vocabularies %>" var="voc">
						<aui:option label="${ voc.name }" value="${ voc.vocabularyId }" selected="${ voc.vocabularyId == locationId }" />
					</c:forEach>
				</aui:select>
				<aui:select name="preferences--typeId--" label="type-vocabulary" required="true" showEmptyOption="true">
					<c:forEach items="<%= vocabularies %>" var="voc" >
						<aui:option label="${ voc.name }" value="${ voc.vocabularyId }" selected="${ voc.vocabularyId == typeId }" />
					</c:forEach>
				</aui:select>
			</aui:fieldset>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:fieldset>
				<aui:input name="preferences--email--" label="subscription-email" required="true" value="${ email }">
					<aui:validator name="email"/>
				</aui:input>
				<aui:input name="preferences--subject--" label="subscription-subject" required="true" value="${ subject }" />
				<aui:field-wrapper label="subscription-template">
					<div class="alert alert-info">
						<liferay-ui:message key="template-help-message" />
					</div>
					<liferay-ui:input-editor name="preferences--template--"/>
				</aui:field-wrapper>
			</aui:fieldset>
		</liferay-ui:section>
	</liferay-ui:tabs>
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
	
</aui:form>

<script type="text/javascript">
	function <portlet:namespace />initEditor() { return '<%= UnicodeFormatter.toString(template) %>'; }
</script>
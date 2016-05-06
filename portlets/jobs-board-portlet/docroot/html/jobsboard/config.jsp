<%@page import="com.rivetlogic.jobsboard.util.PrefsKeys"%>
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
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
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
		<aui:button-row>
			<aui:button type="submit"/>
		</aui:button-row>
	</aui:fieldset>
</aui:form>
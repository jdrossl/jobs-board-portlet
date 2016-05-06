<%@ include file="/html/init.jsp" %>

<%
	List<AssetVocabulary> vocabularies =
		AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId(), false);

	pageContext.setAttribute("categoryId", GetterUtil.getLong(portletPreferences.getValue("categoryId", "-1")));
	pageContext.setAttribute("locationId", GetterUtil.getLong(portletPreferences.getValue("locationId", "-1")));
	pageContext.setAttribute("typeId", GetterUtil.getLong(portletPreferences.getValue("typeId", "-1")));
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
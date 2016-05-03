<%@ include file="/html/init.jsp" %>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="applicant-details" />

<aui:container>
	<aui:row>
		<aui:col width="75">
			<liferay-ui:message key="name" />
			<h2>Joe Bloggs</h2>
			<liferay-ui:message key="email-address" /><br/>
			<a>joe.bloggs@liferay.com</a><br/>
			<liferay-ui:message key="phone-number" /><br/>
			<a>8888-8888</a><br/>
			<liferay-ui:message key="additional-information" /><br/>
			<p><strong>Duis gravida enim leo, ac pretium dui porttitor sed. Mauris facilisis aliquet lorem in rhoncus. Nulla nibh nibh, volutpat quis velit id, vulputate efficitur felis. Donec ut mi et odio pharetra dapibus. Ut lacinia sem eget sem laoreet pellentesque.</strong></p>
			<liferay-ui:message key="cv-file" /><br/>
			<aui:button value="download" /><br/>
			<h2><liferay-ui:message key="hiring-information-process" /></h2>
			<hr/>
			<aui:select name="status">
				<aui:option label="status-pending" value="pending" />
			</aui:select>
			<aui:input type="textarea" name="notes"/>
			<aui:button value="save" cssClass="btn-primary"/>
		</aui:col>
	</aui:row>
</aui:container>
<%@ include file="/html/init.jsp" %>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="applicant-details" />

<aui:container>
	<aui:row>
		<aui:col width="100">
			<div class="applicant-details">
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="name" />
					</div> 
					<h2 class="blurb-title">Joe Bloggs</h2>
				</div>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="email-address" /><br/>
					</div>
					<div class="blurb-title">
						<a><strong>joe.bloggs@liferay.com</strong></a>
					</div>
				</div>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="phone-number" /><br/>
					</div>
					<div class="blurb-title">
						<a><strong>8888-8888</strong></a>
					</div>
				</div>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="additional-information" />
					</div>
					<div>
						<p>Duis gravida enim leo, ac pretium dui porttitor sed. Mauris facilisis aliquet lorem in rhoncus. Nulla nibh nibh, volutpat quis velit id, vulputate efficitur felis. Donec ut mi et odio pharetra dapibus. Ut lacinia sem eget sem laoreet pellentesque.</p>
					</div>
				</div>
				<div class="blurb">
					<div class="blurb-sub">
						<liferay-ui:message key="cv-file" />
					</div>
					<div class="blurb-title">
						<aui:button value="download" />
					</div>
				</div>


				<h3><liferay-ui:message key="hiring-information-process" /></h2>
				<hr/>
				<aui:select name="status">
					<aui:option label="status-pending" value="pending" />
				</aui:select>
				<liferay-ui:input-editor name="notes" initMethod="initEditor" />
				<aui:button value="save" cssClass="btn-primary save"/>
			</div>
			
		</aui:col>
	</aui:row>
</aui:container>

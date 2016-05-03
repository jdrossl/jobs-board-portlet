<%@ include file="/html/init.jsp" %>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="job-details" />

<aui:container>
	<aui:row>
		<aui:col width="75">
			<h2>Position Name</h2>
			<div>
				<span><span class="icon icon-calendar"></span>&nbsp; 15-Jun-2016</span>&nbsp;
				<span><span class="icon icon-globe"></span>&nbsp; Costa Rica, San Jose</span>&nbsp;
				<span><span class="icon icon-money"></span>&nbsp; Salary</span>&nbsp;
				<span><span class="icon icon-time"></span>&nbsp; Full Time</span>&nbsp;
			</div>
			<h3>Description</h3>
			<div>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut nulla neque, imperdiet eget orci non, tincidunt ullamcorper risus. Praesent varius tempor mi vitae venenatis. Sed ut ex maximus, lobortis massa ac, dignissim erat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi cursus, turpis in convallis tristique, eros erat dapibus lorem, sit amet vehicula nisl nisl in orci. Mauris at dui lectus. Nunc ut tortor ex. Mauris sagittis lacus non magna auctor, eget posuere risus placerat. Integer rhoncus turpis at leo imperdiet scelerisque.
			</div>
		</aui:col>
		<aui:col width="25">
			<div class="share-box well">
				<h3><liferay-ui:message key="share-title" /></h3>
				<ul>
					<li>
						<span class="share-button">FB</span>
					</li>
					<li>
						<span class="share-button">TW</span>
					</li>
					<li>
						<span class="share-button">IN</span>
					</li>
					<li>
						<span class="share-button">@</span>
					</li>
				</ul>
			</div>
			
			<div class="apply-box well">
				<h3><liferay-ui:message key="apply-title" /></h3>
				<aui:form>
					<aui:fieldset>
						<aui:field-wrapper cssClass="apply-box-group">
							<aui:input name="name" label="" placeholder="full-name"/>
							<aui:input name="email" label="" placeholder="email-address"/>
							<aui:input name="confirm-email" label="" placeholder="confirm-email-address"/>
							<aui:input name="phone" label="" placeholder="phone-number"/>
							<aui:input name="cv" label="" placeholder="cv" type="file"/>
							<aui:input name="info" label="" placeholder="additional-information" type="textarea"/>
							<aui:button value="apply" cssClass="btn-primary apply-form-button" />
						</aui:field-wrapper>
					</aui:fieldset>
				</aui:form>
			</div>
		</aui:col>
	</aui:row>
</aui:container>
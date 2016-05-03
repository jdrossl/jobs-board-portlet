<%@ include file="/html/init.jsp" %>

<%
	long jobId = ParamUtil.getLong(request, WebKeys.PARAM_JOB_ID);
	Job job = JobLocalServiceUtil.fetchJob(jobId);
	pageContext.setAttribute("job", job);
	SimpleDateFormat format = new SimpleDateFormat("d MMMM, yyyy");
%>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="job-details" />

<aui:container>
	<aui:row>
		<aui:col width="75">
			<h2>${ job.name }</h2>
			<div>
				<span><span class="icon icon-calendar"></span>&nbsp; <%= format.format(job.getCreateDate()) %></span>&nbsp;
				<span><span class="icon icon-globe"></span>&nbsp; ${ job.location }</span>&nbsp;
				<c:if test="${ job.salary != 0 }">
				<span><span class="icon icon-money"></span>&nbsp; ${ job.salary }</span>&nbsp;
				</c:if>
				<span><span class="icon icon-time"></span>&nbsp; ${ job.type }</span>&nbsp;
			</div>
			<div>
				${ job.description }
			</div>
		</aui:col>
		<aui:col width="25">
			<div class="share-box well">
				<h3><liferay-ui:message key="share-title" /></h3>
				<ul class="social-buttons ">
					<li>
						<a href="#"><img src='<%= renderRequest.getContextPath() + "/images/facebook.svg" %>' /></a>
					</li>
					<li>
						<a href="#"><img src='<%= renderRequest.getContextPath() + "/images/twitter.svg" %>' /></a>
					</li>
					<li>
						<a href="#"><img src='<%= renderRequest.getContextPath() + "/images/linkedin.svg" %>' /></a>
					</li>
					<li>
						<a href="#"><span class="mail icon-envelope"></span></a>
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

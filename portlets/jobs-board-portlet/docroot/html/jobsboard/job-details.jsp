<%@page import="java.text.NumberFormat"%>
<%@ include file="/html/init.jsp" %>

<%
	long jobId = ParamUtil.getLong(request, WebKeys.PARAM_JOB_ID);
	Job job = JobLocalServiceUtil.fetchJob(jobId);
	pageContext.setAttribute(WebKeys.PARAM_JOB, job);
	SimpleDateFormat format = new SimpleDateFormat("d MMMM, yyyy");
	String category = AssetCategoryLocalServiceUtil.fetchCategory(job.getCategory()).getName();
	String location = AssetCategoryLocalServiceUtil.fetchCategory(job.getLocation()).getName();
	String type = AssetCategoryLocalServiceUtil.fetchCategory(job.getType()).getName();
	String salary = NumberFormat.getCurrencyInstance().format(job.getSalary());
%>

<liferay-ui:header showBackURL="true" backURL="<%= redirect %>"  title="job-details" />

<liferay-ui:error key="apply-error" message="apply-error"/>

<aui:container>
	<aui:row>
		<aui:col width="75">
			<div class="job-details">
				<h2 class="job-details-title">${ job.name }</h2>
				<div class="job-details-meta">
					<span><span class="icon icon-calendar"></span>&nbsp; <%= format.format(job.getCreateDate()) %></span>&nbsp;
					<span><span class="icon icon-globe"></span>&nbsp; <%= location %></span>&nbsp;
					<c:if test="${ job.salary != 0 }">
					<span><span class="icon icon-money"></span>&nbsp; <%= salary %></span>&nbsp;
					</c:if>
					<span><span class="icon icon-time"></span>&nbsp; <%= type %></span>&nbsp;
				</div>
				<div class="job-details-summary">
					${ job.description }
				</div>
			</div>
			
		</aui:col>
		<aui:col width="25">
			<div class="share-box well">
				<h3><liferay-ui:message key="share-title" /></h3>
				<ul class="social-buttons ">
					<li>
						<a href="http://www.facebook.com/sharer.php?u=<%=HttpUtil.encodeURL(completeCurrentURL) %>" target="_blank"><img src='<%= renderRequest.getContextPath() + "/images/facebook.svg" %>' /></a>
					</li>
					<li>
						<a href="https://twitter.com/intent/tweet?url=<%=HttpUtil.encodeURL(completeCurrentURL) %>" target="_blank"><img src='<%= renderRequest.getContextPath() + "/images/twitter.svg" %>' /></a>
					</li>
					<li>
						<a href="http://www.linkedin.com/shareArticle?url=<%=HttpUtil.encodeURL(completeCurrentURL) %>" target="_blank"><img src='<%= renderRequest.getContextPath() + "/images/linkedin.svg" %>' /></a>
					</li>
					<li>
						<a href="mailto:someone@email.com?body=Job url <%=HttpUtil.encodeURL(completeCurrentURL) %>" target="_blank"><span class="mail icon-envelope"></span></a>
					</li>
				</ul>
			</div>
			
			<div class="apply-box well">
				<h3><liferay-ui:message key="apply-title" /></h3>
				<portlet:actionURL name="applyToJob" var="applyURL">
					<portlet:param name="jobId" value="${ job.jobId }"/>
					<portlet:param name="redirect" value="<%= currentURL %>"/>
				</portlet:actionURL>
				<aui:form action="<%= applyURL %>" enctype="multipart/form-data" method="POST">
					<aui:fieldset>
						<aui:field-wrapper cssClass="apply-box-group">
							<aui:input name="name" label="" placeholder="full-name" required="true"/>
							<aui:input name="email" label="" placeholder="email-address" required="true">
								<aui:validator name="email" />
							</aui:input>
							<aui:input name="confirm-email" label="" placeholder="confirm-email-address" required="true">
								<aui:validator name="email" />
								<aui:validator name="equalTo"><portlet:namespace/>email</aui:validator>
							</aui:input>
							<aui:input name="phone" label="" placeholder="phone-number" required="true">
								<aui:validator name="digits" />
							</aui:input>
							<div class="file-field">
								<aui:input name="cv" label="" placeholder="cv" type="file" required="true">
									<aui:validator name="acceptFiles">'doc,docx,pdf'</aui:validator>
								</aui:input>
								<div class="input-append">
								  <input class="span10" id="appendedInputButtons" type="text">
								  <button class="btn" type="button">CV</button>
								</div>
							</div>
							<aui:input name="info" label="" placeholder="additional-information" type="textarea"/>
							<aui:button-row>
								<aui:button value="apply" cssClass="btn-primary apply-form-button" type="submit" />
							</aui:button-row>
						</aui:field-wrapper>
					</aui:fieldset>
				</aui:form>
			</div>
		</aui:col>
	</aui:row>
</aui:container>

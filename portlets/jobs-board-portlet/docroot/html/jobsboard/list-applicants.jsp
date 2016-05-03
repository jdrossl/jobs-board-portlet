<%@ include file="/html/init.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
	List applicantsList = new ArrayList();
	applicantsList.add(1);
	applicantsList.add(1);
	applicantsList.add(1);
	applicantsList.add(1);
	applicantsList.add(1);
%>

<aui:container>
	<aui:row>
		<aui:col>
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item label="back" iconCssClass="icon-arrow-left" href="<%= redirect %>"/>
					<aui:nav-item label="filters" cssClass="filters" iconCssClass="icon-chevron-down">
						<div class="filters-form popover bottom hidden">
							<div class="arrow"></div>
							<div class="popover-content">
								<aui:form>
									<aui:fieldset>
										<aui:select name="status" inlineField="true">
											<aui:option label="all" value="" />
										</aui:select>
									</aui:fieldset>
								</aui:form>
							</div>
						</div>
					</aui:nav-item>
					<aui:nav-item>
						<aui:field-wrapper cssClass="nav-keyword-wrapper">
							<aui:input name="keywords" label="" placeholder="keywords" />
						</aui:field-wrapper>
					</aui:nav-item>
					<aui:nav-item label="clear-search" />
				</aui:nav>
			</aui:nav-bar>
			
			
			
			<c:if test="<%= !applicantsList.isEmpty() %>">
			<aui:row>
				<aui:col>
					<h2><liferay-ui:message key="x-applicants-for-x" arguments="<%= new Object[]{ 5, \"Position Name\" } %>" /></h2>
				</aui:col>
			</aui:row>
			</c:if>
			
			<liferay-ui:search-container delta="3" emptyResultsMessage="no-applicants-found">
				<liferay-ui:search-container-results results="<%= applicantsList %>" total="5" />
				<liferay-ui:search-container-row className="Integer">
					<portlet:renderURL var="viewURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/applicant-details.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="applicantId" value="1"/>
					</portlet:renderURL>
					<div class="list-item">
						<div class="applicant-name"><h4><a href="<%= viewURL %>">Applicant Name</a></h4></div>
						<span class="applicant-status"><liferay-ui:message key="status-on-board" /></span>
						
						<div class="list-item-actions">
						  <ul>
								<li><span class="applicant-submitted">Submitted: Jul-12-2016, 3:30pm</span></li>
								<li class="applicant-delete">
									<liferay-ui:icon iconCssClass="icon-trash" />
								</li>
								<li class="applicant-edit">
									<liferay-ui:icon iconCssClass="icon-edit" />
								</li>
						  </ul>
						</div>
					
					</div>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</aui:col>
	</aui:row>
</aui:container>

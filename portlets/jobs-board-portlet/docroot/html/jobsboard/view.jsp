<%@ include file="/html/init.jsp" %>

<%
	String userId = Long.toString(themeDisplay.getUserId());
	SimpleDateFormat format = new SimpleDateFormat("d MMMM, yyyy");
	
	// -- CATEGORIES --
	List<AssetCategory> categories = FiltersUtil.getCategories(renderRequest, "categoryId");
	List<AssetCategory> locations = FiltersUtil.getCategories(renderRequest, "locationId");
	List<AssetCategory> types = FiltersUtil.getCategories(renderRequest, "typeId");
	// -- CATEGORIES --
	
	// --- FILTERS ---
	String keywords = ParamUtil.getString(renderRequest, "keywords");
	long[] category = FiltersUtil.getFilter(renderRequest, "category", categories);
	long[] location = FiltersUtil.getFilter(renderRequest, "location", locations);
	long[] type = FiltersUtil.getFilter(renderRequest, "type", types);
	boolean[] status = FiltersUtil.getStatus(renderRequest, themeDisplay);
	boolean bookmarked = ParamUtil.getBoolean(request, "only-bookmarked", false);
	// --- FILTERS ---
	
	// --- SORT ---
	String sortBy = ParamUtil.getString(request, "sort-by", "createDate");
	OrderByComparator orderBy = OrderByComparatorFactoryUtil.create(JobModelImpl.TABLE_NAME, sortBy, Validator.equals(sortBy, "name"));
	// --- SORT ---
	
	int totalJobs = JobLocalServiceUtil.count(themeDisplay, keywords, status, location, category, type, bookmarked);
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	
	boolean adminView = FiltersUtil.viewAdmin(themeDisplay);
%>

<portlet:renderURL var="addURL">
	<portlet:param name="mvcPath" value="/html/jobsboard/edit-job.jsp"/>
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<liferay-ui:error key="update-job-error" message="update-job-error"/>
<liferay-ui:error key="bookmark-error" message="bookmark-error"/>
<liferay-ui:error key="subscribe-error" message="subscribe-error"/>

<aui:container>
	<aui:row>
		<aui:col width="75">
			<c:if test="<%= Validator.isNull(categories) || Validator.isNull(locations) || Validator.isNull(types) || categories.isEmpty() || locations.isEmpty() || types.isEmpty() %>">
				<div class="alert alert-danger">
					<liferay-ui:message key="categories-not-configured-alert" />
				</div>
			</c:if>
			<aui:form action="<%= iteratorURL %>" cssClass="main-filters-form">
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item cssClass="filters" label="filters" iconCssClass="icon-chevron-down">
						<div class="filters-form popover bottom hidden">
							<div class="arrow"></div>
							<div class="popover-content">
								<aui:fieldset>
									<div class="row-fluid">
										<div class="span6">
											<aui:select name="location" inlineField="true" cssClass="filters-submit">
												<aui:option label="all" value="all"  />
												<c:forEach items="<%= locations %>" var="location">
													<aui:option label="${ location.name }" value="${ location.categoryId }" />
												</c:forEach>
											</aui:select>
											<aui:select name="type" inlineField="true" cssClass="filters-submit">
												<aui:option label="all" value="all" />
												<c:forEach items="<%= types %>" var="type">
													<aui:option label="${ type.name }" value="${ type.categoryId }" />
												</c:forEach>
											</aui:select>
										</div>
										<div class="span6">
											<aui:select name="category" inlineField="true" cssClass="filters-submit">
												<aui:option label="all" value="all" />
												<c:forEach items="<%= categories %>" var="category">
													<aui:option label="${ category.name }" value="${ category.categoryId }" />
												</c:forEach>
											</aui:select>
											<c:if test="<%= adminView %>">
												<aui:select name="status" inlineField="true" cssClass="filters-submit">
													<aui:option label="all" value="all" />
													<aui:option label="active" value="true" />
													<aui:option label="inactive" value="false" />
												</aui:select>
											</c:if>
										</div>
									</div>
									<c:if test="<%= adminView %>">
										<aui:input name="only-bookmarked" type="checkbox" cssClass="filters-submit"/>
									</c:if>
								</aui:fieldset>
							</div>
						</div>
					</aui:nav-item>
					<aui:nav-item>
						<aui:field-wrapper cssClass="nav-keyword-wrapper">
							<aui:input name="keywords" label="" placeholder="keywords" value="<%= keywords %>" />
						</aui:field-wrapper>
					</aui:nav-item>
					<aui:nav-item label="clear-search" href="<%= iteratorURL.toString() %>" />
					<c:if test="<%= adminView %>">
						<aui:nav-item label="add" iconCssClass="icon-plus" href="<%= addURL %>"/>
					</c:if>
				</aui:nav>
			</aui:nav-bar>
						
			<c:if test="<%= totalJobs > 0 %>">
			<aui:row>
				<aui:col width="50">
					<h2><liferay-ui:message key="x-total-jobs" arguments="<%= totalJobs %>" /></h2>
				</aui:col>
				<aui:col width="50">
					<aui:field-wrapper cssClass="sort-by-wrapper pull-right">
						<aui:select name="sort-by" cssClass="filters-submit" >
							<aui:option label="date" value="createDate" />
							<aui:option label="name" value="name" />
						</aui:select>
					</aui:field-wrapper>
				</aui:col>
			</aui:row>
			</c:if>
			</aui:form>
			
			<liferay-ui:search-container emptyResultsMessage="no-jobs-found">
				<liferay-ui:search-container-results
					results="<%= JobLocalServiceUtil.find(themeDisplay, keywords, status, location, category, type, bookmarked, searchContainer.getStart(), searchContainer.getEnd(), orderBy) %>"
					total="<%= totalJobs %>" />
				<liferay-ui:search-container-row className="com.rivetlogic.jobsboard.model.Job" modelVar="job">
					<%
						String cat = AssetCategoryLocalServiceUtil.fetchCategory(job.getCategory()).getName();
						String loc = AssetCategoryLocalServiceUtil.fetchCategory(job.getLocation()).getName();
						String typ = AssetCategoryLocalServiceUtil.fetchCategory(job.getType()).getName();
					%>
					<portlet:renderURL var="viewURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/job-details.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:renderURL>
					<portlet:renderURL var="editURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/edit-job.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:renderURL>
					<portlet:renderURL var="applicantsURL">
						<portlet:param name="mvcPath" value="/html/jobsboard/list-applicants.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:renderURL>
					<portlet:actionURL name="deleteJob" var="deleteURL">
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:actionURL>
					<portlet:actionURL name="bookmarkJob" var="bookmarkURL">
						<portlet:param name="redirect" value="<%= currentURL %>"/>
						<portlet:param name="jobId" value="${ job.jobId }"/>
					</portlet:actionURL>
					<div class="list-item">
						<div class="position-name"><h3><a href="<%= viewURL %>">${ job.name }</a></h3></div>
						<ul class="position-info">
							<li class="position-category"><%= cat %></li>
							<li class="position-location"><%= loc %></li>
							<li class="position-posted"><%= format.format(job.getCreateDate()) %></li>
							<li class="position-type"><%= typ %></li>
						</ul>
						<c:if test="<%= adminView %>">
						<div class="list-item-actions">
							<ul>
								<li class="position-applicants">
									<liferay-ui:icon iconCssClass="icon-user" url="<%= applicantsURL %>" />
								</li>
								
								<li class="position-bookmark">
									<liferay-ui:icon iconCssClass="<%= (job.getBookmarks().contains(userId))? \"icon-star\":\"icon-star-empty\" %>" url="<%= bookmarkURL %>" />
								</li>
								<li class="position-edit">
									<liferay-ui:icon iconCssClass="icon-edit" url="<%= editURL %>" />
								</li>
								<li class="position-delete">
									<liferay-ui:icon iconCssClass="icon-trash" url="<%= deleteURL %>" />
								</li>
							</ul>
						</div>
						</c:if>
						
					</div>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</aui:col>
		<aui:col width="25">
			<div class="well">
				<h4><liferay-ui:message key="subscribe-form-title" /></h4>
				<portlet:actionURL name="addSubscription" var="subscribeURL">
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:actionURL>
				<aui:form action="<%= subscribeURL %>">
					<aui:fieldset>
						<aui:field-wrapper cssClass="submit-form-group">
							<aui:input name="name" placeholder="full-name" label="" cssClass="subscribe-form-control"/>
						</aui:field-wrapper>
						<aui:field-wrapper cssClass="submit-form-group">
							<aui:input name="email" placeholder="email-address" label="" cssClass="subscribe-form-control" />
						</aui:field-wrapper>
						<aui:button value="subscribe" cssClass="btn-primary subscribe-form-button" type="submit" />
					</aui:fieldset>
				</aui:form>
			</div>
		</aui:col>
	</aui:row>
</aui:container>

create table rivetlogic_jobsboard_Applicant (
	applicantId LONG not null primary key,
	jobId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	cv LONG,
	info VARCHAR(75) null,
	status VARCHAR(75) null,
	notes VARCHAR(75) null
);

create table rivetlogic_jobsboard_Job (
	jobId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	active_ BOOLEAN,
	category LONG,
	location LONG,
	type_ LONG,
	description TEXT null,
	salary DOUBLE,
	bookmarks VARCHAR(75) null
);

create table rivetlogic_jobsboard_Subscription (
	emailAddress VARCHAR(75) not null primary key,
	fullName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);
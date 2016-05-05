create index IX_8D3FFC9C on rivetlogic_jobsboard_Applicant (companyId, groupId, jobId);
create index IX_21741B41 on rivetlogic_jobsboard_Applicant (companyId, groupId, jobId, name, status);

create index IX_8C88047 on rivetlogic_jobsboard_Job (companyId, groupId);
create index IX_7FDED55 on rivetlogic_jobsboard_Job (companyId, groupId, name, active_, category, location, type_, description);
create index IX_D9F8F9F8 on rivetlogic_jobsboard_Job (companyId, groupId, name, active_, category, location, type_, description, bookmarks);

create index IX_BF9D9BE3 on rivetlogic_jobsboard_Subscription (companyId, groupId);
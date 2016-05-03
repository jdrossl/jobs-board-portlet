create index IX_8D3FFC9C on rivetlogic_jobsboard_Applicant (companyId, groupId, jobId);

create index IX_8C88047 on rivetlogic_jobsboard_Job (companyId, groupId);
create index IX_7FDED55 on rivetlogic_jobsboard_Job (companyId, groupId, name, active_, category, location, type_, description);

create index IX_BF9D9BE3 on rivetlogic_jobsboard_Subscription (companyId, groupId);
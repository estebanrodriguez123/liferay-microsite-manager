create table rivetlogic_micro_site_MicroSite (
	microSiteId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupId LONG,
	siteId LONG
);

create table rivetlogic_micro_site_SiteRequest (
	siteRequestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	response VARCHAR(75) null,
	siteId LONG,
	admin BOOLEAN
);
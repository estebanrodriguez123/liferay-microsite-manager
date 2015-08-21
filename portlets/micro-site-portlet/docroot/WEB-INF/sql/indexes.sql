create index IX_79C10C7F on rivetlogic_micro_site_MicroSite (companyId, groupId, userId);
create index IX_E7DD843F on rivetlogic_micro_site_MicroSite (companyId, userId);
create index IX_34A04C7 on rivetlogic_micro_site_MicroSite (groupId);

create index IX_B4C81622 on rivetlogic_micro_site_SiteRequest (companyId, groupId);
create index IX_29262C5C on rivetlogic_micro_site_SiteRequest (companyId, groupId, userId);
alter table role add user_id int;
alter table role add foreign key(user_id) REFERENCES user(id);
alter table role alter column org_id set default 0;
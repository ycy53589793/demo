alter table role add user_id int;
alter table role add foreign key(user_id) REFERENCES user(id);
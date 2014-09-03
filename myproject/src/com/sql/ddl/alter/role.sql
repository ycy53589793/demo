alter table role add user_id int;
alter table role add foreign key(user_id) references user(id);
alter table role drop foreign key role_ibfk_2;
alter table role drop column user_id;
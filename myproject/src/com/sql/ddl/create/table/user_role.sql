create table user_role(
	id int not null auto_increment primary key,
	user_id int COMMENT '用户id',
	role_id int COMMENT '角色id',
	foreign key(user_id) references user(id),
	foreign key(role_id) references role(id)
)
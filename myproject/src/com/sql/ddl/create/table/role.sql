--创建角色表
create table role (
	id int not null auto_increment primary key,
	org_id int COMMENT '公司id',
	--user_id int COMMENT '用户id',
	role_name varchar(255) COMMENT '角色名',
	
	foreign key(org_id) references org(id)
	--foreign key(user_id) references user(id)
);
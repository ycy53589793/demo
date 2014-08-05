--创建用户类型表
create table type (
	id int not null auto_increment primary key,
	type_name varchar(255) COMMENT '类型名'
);
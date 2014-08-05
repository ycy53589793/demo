--创建公司表
create table org (
	id int not null auto_increment primary key,
	org_name varchar(255) COMMENT '公司名'
);
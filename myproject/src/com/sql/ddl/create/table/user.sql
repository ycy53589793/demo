--创建用户表
create table user (
	id int not null auto_increment primary key,
	sex char(1) COMMENT '性别',
	role_id int COMMENT '角色id',
	org_id int COMMENT '公司id',
	enable char(1) COMMENT '是否可用',
	type_id int COMMENT '类型id',
	phone varchar(11) COMMENT '手机号',
	birthday date COMMENT '出生日期',
	professional varchar(255) COMMENT '职业',
	sign varchar(255) COMMENT '签名',
	detail varchar(255) COMMENT '说明',
	interest varchar(255) COMMENT '兴趣爱好',
	school varchar(255) COMMENT '学校',
	credit int COMMENT '信誉等级',
	username varchar(255) COMMENT '用户名',
	password varchar(255) COMMENT '密码',
	
	foreign key(role_id) references role(id),
	foreign key(org_id) references org(id),
	foreign key(type_id) references type(id)
);
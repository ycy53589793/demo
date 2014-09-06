create table car(
	id int not null auto_increment primary key,
	number varchar(20) COMMENT '车牌号',
	color varchar(20) COMMENT '颜色',
	brand varchar(20) COMMENT '品牌',
	type varchar(20) COMMENT '类型',
	user_id int COMMENT '用户id',
	
	foreign key(user_id) references user(id)
)
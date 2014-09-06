create table orders (
	id int not null auto_increment primary key,
	user_phone varchar(20) COMMENT '用户手机号',
	passenger_phone varchar(20) COMMENT '乘客手机号',
	start_place varchar(20) COMMENT '起始地',
	start_place_point varchar(20) COMMENT '起始地经纬度',
	end_place varchar(20) COMMENT '目的地',
	end_place_point varchar(20) COMMENT '目的地经纬度',
	person_number int COMMENT '人数',
	is_whole_car char(1) COMMENT '是否包车',
	expiry_date date COMMENT '订单失效时间',
	have_child char(1) COMMENT '是否带小孩',
	time_expand date COMMENT '订单延长时间',
	status varchar(20) COMMENT '订单状态',
	org_id int COMMENT '公司id',
	is_in_car char(1) COMMENT '是否已经上车',
	is_pre_order char(1) COMMENT '是否预约',
	pre_time date COMMENT '预约时间',
	remark varchar(20) COMMENT '备注',
	task_id int COMMENT '任务id',
	
	foreign key(task_id) references task(id),
	foreign key(org_id) references org(id)
);
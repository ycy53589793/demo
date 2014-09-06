create table task(
	id int not null auto_increment primary key,
	car_id int COMMENT '车辆id',
	status varchar(20) COMMENT '任务状态',
	
	foreign key(car_id) references car(id)
)
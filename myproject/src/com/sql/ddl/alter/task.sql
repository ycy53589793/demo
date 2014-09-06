alter table orders add task_id int;
alter table orders add foreign key(task_id) references task(id);
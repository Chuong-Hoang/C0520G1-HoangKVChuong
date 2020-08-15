create database test;
use test;

create table table_test (
	id int,
    name varchar(50)
);

insert into table_test
values (1, 'Tien');

update table_test
set `name` = 'Chuong'
where id = 1;
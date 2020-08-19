drop database if exists homework4;
create database homework4;
use homework4;

create table student_fees(
	id int not null,
	first_name varchar(20) not null,
	age int not null,
	course varchar(20) not null,
	amount double not null
);

insert into student_fees(id, first_name, age, course, amount) values
	(1, 'Hoang', 21, 'CNTT', 400000),
	(2, 'Viet', 19, 'DTVT', 320000),
	(3, 'Thanh', 18, 'KTDN', 400000),
	(4, 'Nhan', 19, 'CK', 450000),
	(5, 'Huong', 20, 'TCNH', 500000),
	(5, 'Huong', 20, 'TCNH', 200000)
;    

select * from student_fees;

-- display all records having name 'Huong'
select *
from student_fees
where first_name = 'Huong';

-- display total_amount of 'Huong'
select sum(amount) as amount, first_name
from student_fees
where first_name = 'Huong';

-- display all distinct first_name
select distinct first_name, id
from student_fees;
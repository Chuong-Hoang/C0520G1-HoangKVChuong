create database module3;
use module3;
create table c05(
id int,
fullName varchar(255),
address varchar(255)
);

insert into c05(id, fullName, address) values
(1, 'Chuong', 'QT'),
(2, 'Toan', 'DN'),
(3, 'Nhat', 'QT'),
(4, 'Quang', 'DN'),
(5, 'Khanh', 'Vinh');

select * from c05;

update c05 set address = 'NA' where fullName = 'Khanh';
update c05 set address = 'NA' where id = 5;
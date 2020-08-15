use session2;
create table c05(
id int auto_increment primary key,
full_name varchar(30) unique,
address varchar(15) default 'Da Nang',
age int not null);
select * from c05;
alter table c05
add column email varchar(30)
after age;
insert into c05(full_name, age, email) values
('Hoang Kim Van Chuong', 32, 'chuong@hoang'),
('Tran Huu Hien', 28, 'hien@tran'),
('Phan Quoc Khanh', 29, 'khanh@phan');
-- Error Code: 1075. Incorrect table definition; there can be only one auto column and it must be defined as a key

use session2;
create table rolling(
id int auto_increment,
last_name varchar(255) not null,
address varchar(30),
primary key(id, last_name)
);
insert into rolling(id, last_name, address) values
(6, 'Chuong', 'QT'),
(7, 'Chuong', 'DN'),
(8, 'Chuong', 'HN');
select * from rolling;
update rolling set roll_no = 'abc';

alter table rolling
add column roll_no varchar(10)
after id;

alter table rolling drop primary key,
add primary key (id, roll_no);
insert into rolling(id, roll_no, last_name, address) values
(4,'zzz', 'Toan', 'QB'),
(5, 'zzz', 'Toan', 'TK'),
(10, 'zzz', 'Toan', 'HN');
select * from rolling;
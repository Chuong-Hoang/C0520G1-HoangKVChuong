create database practice3;
use practice3;
create table pupil(
id_pupil int auto_increment,
full_name varchar(25),
address varchar(20),
primary key (id_pupil)
);
insert into pupil(full_name, address) values
('Hoang KV Chuong', 'QT'),
('Nguyen Tien Hai','HT'),
('Phan Quoc Khanh','NA'),
('Tu Si Tung','QB'),
('Nguyen Huu Quang','DN'),
('Le Nhat','QT');

create table teacher(
id int auto_increment,
staff varchar(30),
primary key (id),
pupil_id int,
foreign key (pupil_id) references pupil(id_pupil)
);
insert into teacher(staff, pupil_id) values
('teacher A', 1),
('teacher B', 1),
('teacher C', 2);
select * from pupil;
select * from teacher;
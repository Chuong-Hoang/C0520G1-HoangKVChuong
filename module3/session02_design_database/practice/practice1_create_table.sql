use session2;
select * from scrap;
alter table scrap
modify phoneNumber varchar(15);
insert into scrap (full_name, phoneNumber, birthday) values
('Vo Phuc Sinh', '123456789101112', '1985-10-31');
use session2;
alter table scrap
drop column facility;
alter table scrap
rename column phoneNumber to cell_phone;
alter table scrap
rename to student;
select * from student;
alter table student
change column full_name first_name varchar(30);
select * from student;
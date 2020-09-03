drop database if exists `demo`;
create database `demo`;
use `demo`;

create table users(
	id int not null auto_increment,
	name varchar(120) not null,
	email varchar(120) not null,
	country varchar(120),
	primary key (id)
);

insert into users(`name`, email, country) values
	('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values
	('Kante','kante@che.uk','Kenia');
insert into users(`name`, email, country) values
	('James','james@che.uk','England'),
	('Chelsea','chelsea@che.uk','USA'),
	('Kieng','kiengnguyen@che.uk','France')
;

select * from users;

-- 1.Practice 1: Using stored procedure in JDBC
-- create procedure to get user by id
delimiter $$
create procedure get_user_by_id(IN user_id int)
begin
	select users.name, users.email, users.country
    from users
    where users.id = user_id;
end $$
delimiter ;

-- create procedure to insert user
delimiter $$
create procedure insert_user (
	IN user_name varchar(50),
	IN user_email varchar(50),
	IN user_country varchar(50)
)
begin
	insert into users(name, email, country) values
		(user_name, user_email, user_country);
end $$
delimiter ;        

-- 2.Practice 2: Using MySql JDBC Transaction
drop table if exists permission;
create table permission(
	id int auto_increment,
    `name` varchar(50)
);

-- insert into table: permission
insert into permission(name) values('add');
insert into permission(name) values('edit');
insert into permission(name) values('delete');
insert into permission(name) values('view');

drop table if exists user_permission;
create table user_permission(
	permission_id int,
    user_id int
);    

select * from user_permission;

-- Homework1: 1.Create procedure: select all user
delimiter $$
drop procedure if exists select_all_users;
create procedure select_all_users() 
begin
	select id, name, email, country
    from users;
end $$
delimiter ;  

call select_all_users();

-- Homework1: 2.Create procedure: update_set
drop procedure if exists update_user;
delimiter $$
create procedure update_user(	
    IN user_name varchar(50),
	IN user_email varchar(50),
	IN user_country varchar(50),
    IN user_id int
)
begin
	update users set users.name = user_name, users.email = user_email, users.country = user_country  
    where users.id = user_id;
end $$
delimiter ;    

call update_user('Canary', 'hy@gmail.com', 'Vietnam', 1);
select * from users;

-- Homework1: 3.Create procedure delete_user
drop procedure if exists delete_user;
delimiter $$
create procedure delete_user(IN user_id int)
begin
	delete from users where users.id = user_id;
end $$
delimiter ;

call delete_user(1);
select * from users;
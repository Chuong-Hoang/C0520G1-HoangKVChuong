drop database if exists `c05_orm`;
create database `c05_orm`;
use `c05_orm`;

drop table if exists `Customer`;
create table `Customer`(
	id int auto_increment primary key,
	firstName varchar(45),
	lastName varchar(45)
);

select * from customer;




drop table if exists `product`;
create table `product`(
	product_id varchar(45) primary key,	 
	product_name varchar(45),
	product_price varchar(45), 
	product_quantity varchar(45),    
	product_color varchar(45), 
	product_description varchar(45), 
	product_category varchar(45)
);

insert into `product` (
	product_id, 	
	product_name,
	product_price, 
	product_quantity,    
	product_color,     
	product_description, 
	product_category
)  
values
	('1', 'Name 1', '1000', '30', 'black', 'Made in Vietnam', 'Phone'),
	('2', 'Name 2', '1000', '30', 'black', 'Made in Vietnam', 'Phone'),
	('3', 'Name 3', '1000', '30', 'black', 'Made in Vietnam', 'Phone'),
	('4', 'Name 4', '1000', '30', 'black', 'Made in Vietnam', 'Phone'),
	('5', 'Name 5', '1000', '30', 'black', 'Made in Vietnam', 'Phone'),
	('6', 'Name 6', '1000', '30', 'black', 'Made in Vietnam', 'Phone');
  
select * from product;
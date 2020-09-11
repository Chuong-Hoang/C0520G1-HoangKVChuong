drop database if exists `exam`;
create database `exam`;
use `exam`;

drop table if exists `product`;
create table `product`(
	product_id int primary key, 
	product_code varchar(45), 
	product_name varchar(45),
	product_price double, 
	product_quantity int,    
	product_producer varchar(45), 
    
	imported_price double,
    import_province varchar(45),
	import_tax double, 
    
	exported_price double, 
	buying_country varchar(45)
);

insert into `product`
	(product_id, 
	product_code, 
	product_name,
	product_price, 
	product_quantity,    
	product_producer, 
    
    import_province,
	imported_price,
	import_tax)
    values
	(1, 'IP-001', 'Iphone Xs', 12000, 20, 'Apple', 'Quang Tri', 10000, 1000), 
	(2, 'IP-002', 'Iphone Xs', 12000, 20, 'Apple', 'Quang Tri', 10000, 1000), 
	(3, 'IP-003', 'Iphone Xs', 12000, 20, 'Apple', 'Quang Tri', 10000, 1000), 
	(4, 'IP-004', 'Iphone Xs', 12000, 20, 'Apple', 'Quang Tri', 10000, 1000), 
	(5, 'IP-005', 'Iphone Xs', 12000, 20, 'Apple', 'Quang Tri', 10000, 1000); 
    
    insert into `product`
	(product_id, 
	product_code, 
	product_name,
	product_price, 
	product_quantity, 
    product_producer, 
    
	exported_price, 
	buying_country)
    values
	(6, 'IP-006', 'Iphone Xs', 12000, 20, 'Samsung', 15000, 'Russia'), 
	(7, 'IP-007', 'Iphone Xs', 12000, 20,  'Samsung', 15000, 'Russia'), 
	(8, 'IP-008', 'Iphone Xs', 12000, 20,  'Samsung', 15000, 'Russia'), 
	(9, 'IP-009', 'Iphone Xs', 12000, 20,  'Samsung', 15000, 'Russia'), 
	(10, 'IP-010', 'Iphone Xs', 12000, 20, 'Samsung', 15000, 'Russia'); 

select * from `product`;


-- _________________________ CONTACT _________________________________
drop table if exists `contact`;
create table `contact`(
	contact_id varchar(45) primary key,
	contact_name varchar(45),
	contact_phone varchar(45),
	contact_gender varchar(45),
	contact_birthday varchar(45),
	contact_email varchar(45),
	contact_address varchar(45),
	contact_group varchar(45)
);

insert into `contact` values
	('1', 'Chuong Hoang', '123456789', 'male', '1988-04-20', 'chuong@hoang.com.vn', 'Quang Tri', 'Friend'),
	('2', 'Le Toan', '123456789', 'female', '1988-04-20', 'chuong@hoang.com.vn', 'Quang Tri', 'Friend'),
	('3', 'Si Tung', '123456789', 'male', '1988-04-20', 'chuong@hoang.com.vn', 'Quang Tri', 'Company'),
	('4', 'Quang Nguyen', '123456789', 'female', '1988-04-20', 'chuong@hoang.com.vn', 'Quang Tri', 'Family');

select * from `contact`;
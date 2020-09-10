drop database if exists furama;
create database furama;
use furama;

-- _______________________________  CUSTOMER _____________________________________
-- create table 'customer_type'
drop table if exists customer_type;
create table if not exists customer_type(
	customer_type_id int,
    customer_type_name varchar(45) not null unique,
    primary key(customer_type_id)
);

-- insert into customer_type
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Gold'),(3,'Platinum'),(4,'Silver'),(5,'Member');  


-- create table 'customer'
drop table if exists customer;
create table if not exists customer(
	customer_id varchar(45) not null,     
    customer_name varchar(45) not null,
    customer_birthday date not null default '1990-09-22',
    customer_gender varchar(45) not null default 'male',
    customer_id_card varchar(45) not null default '197 182 504',
    customer_phone varchar(45) not null default '084 2345 777',
    customer_email varchar(45) not null default 'customer@gmail.com',
    customer_address varchar(45) not null default 'Da Nang', 
    customer_type_id int,
    primary key(customer_id),
    foreign key(customer_type_id) references customer_type(customer_type_id)
);    

-- insert into customer
INSERT INTO `customer`(customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) VALUES 
	('KH-0001','David Beckham','1987-10-19', 'male','197 182 504','084 2345 777','customer@gmail.com','Da Nang',1),
	('KH-0002','Leonardo Decaprio','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Vinh',2),
	('KH-0003','Jason Statham','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Quang Tri',1),
	('KH-0004','Steven Seagal','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai',3),
	('KH-0005','Jean Claude','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Da Nang',2),
	('KH-0006','Richard Gere','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai',4),
	('KH-0007','Keanu Reaves','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Vinh',5),
	('KH-0008','Jennifer Laurence','1987-10-19','female','197 182 504','084 2345 777','customer@gmail.com','Vinh',1),
	('KH-0009','Juliet Robert','1987-10-19','female','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai',2),
	('KH-0010','Donald Trump','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Vinh',2),
	('KH-0011','Richard Branson','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Quang Tri',3),
	('KH-0012','Will Smith','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Da Nang',4),
	('KH-0013','Tom Cruise','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Hue',5),
	('KH-0014','Sylvester Stallone','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Da Nang',5),
	('KH-0015','James Bond','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Hue',1),
	('KH-0016','Emma Waston','1987-10-19','female','197 182 504','084 2345 777','customer@gmail.com','Hue',1),
	('KH-0017','Owen Wilson','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Da Nang',4),
	('KH-0018','Will Smith','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Da Nang',3),
	('KH-0019','Nicolas Cage','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Vinh',2),
	('KH-0020','Will Smith','1987-10-19','male','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai',2);
-- CUSTOMER end ____________________
select * from customer;

-- ______________________________________ SERVICE _________________________________________
 
-- create table 'rent_type'
drop table if exists rent_type;
create table if not exists rent_type(
	rent_type_id int,
    rent_type_name varchar(45) not null unique,
    rent_type_cost double not null default 1500.00,
    primary key(rent_type_id)
);

-- insert into rent_type
INSERT INTO `rent_type`(rent_type_id, rent_type_name, rent_type_cost) VALUES 
	(1, 'Hourly', 50),
    (2, 'Daily', 250),
    (3, 'Monthly', 1500),
    (4, 'Yearly', 15000);  

-- create table 'service_type'
drop table if exists service_type;
create table if not exists service_type(
	service_type_id int,
    service_type_name varchar(45) not null unique,
    primary key(service_type_id)
);

-- insert into service_type
INSERT INTO `service_type`(service_type_id, service_type_name) VALUES 
	(1,'Villa'),
	(2,'House'),
    (3,'Room');


-- create table 'service'
drop table if exists service;
create table if not exists service(
	service_id varchar(45),
    service_name varchar(45),
    service_area int default 50,
    service_cost double default 1000,
	service_max_people int default '4',
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45), -- vip, business, normal
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    primary key(service_id),
    foreign key(rent_type_id) references rent_type(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);

-- insert into service
INSERT INTO `service`(service_id, service_name, service_area, service_cost, service_max_people,
	rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors) VALUES 
	('DV-0001', 'VL-1', 350.00, 15000, 5, 4, 1, 'Vip', 'Game center', 145.00, 3),
    ('DV-0002', 'VL-2', 350.00, 1500, 5, 3, 1, 'Business', 'Game center', 145.00, 3),
    ('DV-0003', 'VL-3', 350.00, 150, 5, 2, 1, 'Normal', 'Game center', 145.00, 3),
    ('DV-0004', 'VL-4', 350.00, 15000, 5, 4, 1, 'Vip', 'Game center', 145.00, 3),
    ('DV-0005', 'HO-1', 150.00, 15000, 4, 4, 2, 'Business', 'Game center', 0, 2),
    ('DV-0006', 'HO-2', 150.00, 1500, 4, 3, 2, 'Vip', 'Game center', 0, 2),
    ('DV-0007', 'HO-3', 150.00, 150, 4, 2, 2, 'Business', 'Game center', 0, 2),
    ('DV-0008', 'HO-4', 150.00, 1500, 4, 4, 2, 'Normal', 'Game center', 0, 2),
    ('DV-0009', 'RO-1', 50.00, 1250, 3, 3, 3, '-', '-', 0, 0),
    ('DV-0010', 'RO-2', 50.00, 250, 3, 2, 3, '-', '-', 0, 0),
    ('DV-0011', 'RO-3', 50.00, 250, 3, 2, 3, '-', '-', 0, 0),
    ('DV-0012', 'RO-4', 50.00, 25, 3, 1, 3, '-', '-', 0, 0)
;    
-- SERVICE end _________________________
select * from service;


-- ____________________________________ EMPLOYEE ________________________________________
-- create table 'position'
drop table if exists `position`;
create table if not exists `position`(
	position_id int,
    position_name varchar(45) not null unique,
    primary key (position_id)
);

-- insert into position
INSERT INTO `position` VALUES 
	(1,'Director'),
    (2,'Manager'),
    (3,'Supervisor'),
    (4,'Staff'),
    (5,'Receptionist'),    
    (6,'Waiter');


-- create table 'education_degree'
drop table if exists `education_degree`;
create table if not exists `education_degree`(
	education_degree_id int,
    education_degree_name varchar(45) not null unique,
    primary key(education_degree_id)
);

-- insert into `education_degree`
INSERT INTO `education_degree` VALUES 
	(1,'After-university'),
    (2,'University'),
    (3,'College'),
    (4,'Pre-college');
   

-- create table `division`
drop table if exists `division`;
create table if not exists `division`(
	division_id int,
	division_name varchar(45) not null unique,
	primary key(division_id)
); 

-- insert into `division`
 INSERT INTO `division` VALUES 	
    (1,'Management'),
    (2,'Sale-Marketing'),
    (3,'Administration'),
    (4,'Service'); 


-- create table 'Employee'
drop table if exists `employee`;
create table if not exists `employee`(
	employee_id int,
    employee_name varchar(45) not null,
    employee_birthday date,
    employee_id_card varchar(45),
    employee_salary varchar(45),
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    primary key(employee_id),
    foreign key(position_id) references `position`(position_id),
    foreign key(education_degree_id) references `education_degree`(education_degree_id),
    foreign key(division_id) references `division`(division_id)
);	

-- insert into employees
INSERT INTO `employee` VALUES 
	(1,'Chau Kiet Luan','1990-07-25','111 222 333','20000000','0905 555 999','empe@gmail.com','Ha Noi', 1, 1, 3),
    (2,'Ngo Ngan To','1988-03-22','111 333 444','20000000','0905 333 999','emp@gmail.com','Da Nang', 2, 2, 1),
    (3,'Tu Nhuoc Tuyen','1994-09-17','111 222 444','20000000','0905 555 444','empe@gmail.com','Quang Tri', 3, 3, 3),
    (4,'Kim Thanh Vu','1997-11-23','222 333 444','20000000','0905 222 111','emp@gmail.com','Hue', 5, 4, 4),
    (5,'Ly Lien Kiet','1988-12-28','333 111 444','20000000','0905 111 777','emp@gmail.com','Ha Noi', 4, 3, 1),
    (6,'Luu Duc Hoa','1982-10-26','111 444 333','20000000','0905 333 333','emp@gmail.com','Hue', 2, 2, 2),
    (7,'Quach Phu Thanh','1993-07-22','111 222 555','20000000','0905 555 555','emp@gmail.com','Ha Noi', 2, 3, 2),
    (8,'Le Minh','1994-11-25','111 666 444','20000000','0905 888 999','emp@gmail.com','Hue', 3, 3, 2),
    (9,'Truong Hoc Huu','1980-10-19','222 888 444','20000000','0905 222 777','emp@gmail.com','Quang Tri', 3, 2, 2),
    (10,'Nham Dat Hoa','1979-04-16','111 999 444','20000000','0905 234 567','emp@gmail.com','Ha Noi', 4, 1, 4),
    (11,'Hong Kim Bao','1973-07-19','777 333 444','20000000','0905 444 666','emp@gmail.com','Quang Tri', 5, 3, 4),
    (12,'Truong Ve Kien','1992-11-29','111 222 666','20000000','0905 666 222','emp@gmail.com','Da Nang', 6, 4, 4),
    (13,'Ly Gia Han','1985-05-27','111 555 444','20000000','0905 555 888','emp@gmail.com','Da Nang', 2, 2, 1),
    (14,'Co Thien Lac','1990-12-12','111 222 999','20000000','0905 777 999','emp@gmail.com','Ha Noi', 3, 2, 2),
    (15,'Truong Man Ngoc','1978-03-18','777 333 444','20000000','0905 999 999','emp@gmail.com','Da Nang', 3, 3, 2);
-- EMPLOYEE end______________________
select * from employee;



-- ___________________________ CONTRACT ________________________________

-- create table 'attach_service'
drop table if exists `attach_service`;
create table if not exists `attach_service`(
	attach_service_id int,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45),
    primary key(attach_service_id)
); 

-- insert into `attach_service`
INSERT INTO `attach_service` VALUES 
	(1, 'Karaoke', 100, 1, 'available'),
    (2, 'Massage', 120, 1, 'available'),
    (3, 'Food', 50, 1, 'available'),
    (4, 'Drink', 25, 1, 'available'),
    (5, 'Car', 250, 1, 'available');


-- create table `contract`
drop table if exists `contract`;   
create table if not exists `contract`(
	contract_id int,
    contract_start_date date,
    contract_end_date date,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id varchar(45),
    service_id varchar(45),    
    primary key(contract_id),
    foreign key(employee_id) references employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(customer_id) references customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(service_id) references service(service_id) ON DELETE CASCADE ON UPDATE CASCADE
);   

-- insert into `contract`
INSERT INTO `contract` VALUES 
	(1, '2019-08-20', '2020-09-20', 700, 1250, 1, 'KH-0001', 'DV-0011'),
	(2, '2018-08-20', '2020-09-20' , 600, 1200, 2, 'KH-0002', 'DV-0012'),
	(3, '2019-08-20', '2020-09-20', 800, 1650, 3, 'KH-0003', 'DV-0010'),
	(4, '2018-01-20', '2020-09-20', 500, 1300, 4, 'KH-0004', 'DV-0011'),
	(5, '2018-08-20', '2020-09-20', 400, 1450, 5, 'KH-0005', 'DV-0005'),
	(6, '2019-10-20', '2020-09-20', 600, 1650, 6, 'KH-0006', 'DV-0006'),
	(7, '2019-08-20', '2020-09-20', 300, 1600, 7, 'KH-0007', 'DV-0007'),
	(8, '2018-02-20', '2020-09-20', 500, 1100, 8, 'KH-0008', 'DV-0008'),
	(9, '2019-12-20', '2020-09-20', 700, 1200, 9, 'KH-0009', 'DV-0009'),
	(10, '2018-11-20', '2020-09-20', 400, 1350, 10, 'KH-0010', 'DV-0010'),
	(11, '2018-05-20', '2020-09-20', 800, 1150, 1, 'KH-0001', 'DV-0011'),
	(12, '2017-08-20', '2020-09-20', 600, 1650, 2, 'KH-0002', 'DV-0012'),
	(13, '2018-03-20', '2020-09-20', 700, 1500, 3, 'KH-0003', 'DV-0010'),
	(14, '2019-01-20', '2020-09-20', 900, 1350, 4, 'KH-0001', 'DV-0011'),
	(15, '2019-04-20', '2020-09-20', 500, 1400, 5, 'KH-0002', 'DV-0005'),
	(16, '2018-10-20', '2020-09-20', 800, 1200, 6, 'KH-0004', 'DV-0006'),
	(17, '2019-03-20', '2020-09-20', 300, 1700, 7, 'KH-0001', 'DV-0007'),
	(18, '2016-02-20', '2020-09-20', 700, 1350, 8, 'KH-0004', 'DV-0008'),
	(19, '2019-09-20', '2020-09-20', 200, 1500, 9, 'KH-0009', 'DV-0009'),
	(20, '2018-07-20', '2020-09-20', 800, 1500, 10, 'KH-0010', 'DV-0010');
-- CONTRACT end ____________________
select * from `contract`;


-- ______________________________ CONTRACT_DETAIL ______________________________

-- create table `contract_detail`
drop table if exists `contract_detail`;	
create table if not exists `contract_detail`(
	contract_detail_id int,
    contract_id int,
    attach_service_id int,
    quantity int,
    primary key(contract_detail_id),
    foreign key(attach_service_id) references `attach_service`(attach_service_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(contract_id) references `contract`(contract_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- insert into `contract_detail` => time 1.
INSERT INTO `contract_detail` VALUES 
	(1, 5, 1, 1),
    (2, 4, 2, 1),
    (3, 6, 3, 1),
    (4, 3, 4, 1),
    (5, 1, 5, 1),
    (6, 2, 2, 1),
    (7, 8, 2, 1),
    (8, 9, 1, 1),
    (9, 10, 4, 1),
    (10, 11, 5, 1),
    (11, 12, 1, 1),
    (12, 13, 1, 1),
    (13, 14, 2, 1),
    (14, 15, 4, 1),
    (15, 16, 3, 1),
    (16, 17, 5, 1),
    (17, 18, 5, 1),
    (18, 19, 3, 1),
    (19, 20, 3, 1),
    (20, 7, 2, 1);
    
    
-- insert into `contract_detail` => time 2.
INSERT INTO `contract_detail` VALUES 
	(21, 5, 2, 1),
    (22, 4, 3, 1),
    (23, 6, 1, 1),
    (24, 3, 5, 1),
    (25, 1, 3, 1),
    (26, 2, 4, 1),
    (27, 8, 3, 1),
    (28, 9, 5, 1),
    (29, 10, 2, 1),
    (30, 11, 1, 1),
    (31, 12, 5, 1),
    (32, 13, 4, 1),
    (33, 14, 3, 1),
    (34, 15, 5, 1),
    (35, 16, 1, 1),
    (36, 17, 2, 1),
    (37, 18, 3, 1),
    (38, 19, 4, 1),
    (39, 20, 4, 1),
    (40, 7, 5, 1);
    
-- CONTRACT_DETAIL end _________________________
select * from `contract_detail`;

-- +++++++++++++++++++++++++++++++++++++      END ALL     ++++++++++++++++++++++++++++++++++++++++++
-- 2.8.	Tạo màn hình liệt kê danh sách các khách hàng đang sử dụng dịch vụ tại resort 
-- (Dạng bảng, có phân trang, nhảy trang, tìm kiếm, liên kết đến các chức năng xóa và chỉnh sửa thông tin 
-- của Dịch vụ). Nếu hợp đồng có sử dụng dịch vụ đính kèm thì hãy liệt kê các dịch vụ đính kèm đó ra.
-- (sử dụng bảng customer, contract, contract_detail, attach_service).

select customer.customer_id, customer.customer_name, contract.contract_id, contract_detail.contract_detail_id,
	contract.service_id, service.service_name, attach_service.attach_service_id, attach_service.attach_service_name,
    contract.contract_total_money, attach_service.attach_service_cost, contract_detail.quantity
from `customer`
	inner join `contract` on contract.customer_id = customer.customer_id
	left join `service` on contract.service_id = service.service_id
	left join `contract_detail` on contract.contract_id = contract_detail.contract_id
	left join `attach_service` on contract_detail.attach_service_id = attach_service.attach_service_id;   



-- task 3.9
select customer.customer_id, customer.customer_name, contract.contract_id,
	contract.service_id, service.service_name, 
    contract.contract_total_money, sum(attach_service.attach_service_cost * contract_detail.quantity) as `attach_service_total_money`
from `customer`
	inner join `contract` on contract.customer_id = customer.customer_id
	left join `service` on contract.service_id = service.service_id
	left join `contract_detail` on contract.contract_id = contract_detail.contract_id
	left join `attach_service` on contract_detail.attach_service_id = attach_service.attach_service_id
group by customer.customer_id; 

-- contract.contract_total_money
-- attach_service.attach_service_cost
-- contract_detail.quantity








-- _____________________________________________________________________________________________________

-- __________________________________ TASKS OF CASE STUDY (DATABASE) _____________________________
-- 1.Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.
-- ok

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select *
from employees
where employee_name like 'h%' or employee_name like 't%' or employee_name like 'k%'
having length(employee_name) < 16;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from customers
where address in ('Da Nang', 'Quang Tri')
having year(now()) - year(birthday) between 15 and 50;

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo
--      số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select customers.customer_id, customers.customer_name, count(customers.customer_id) as booking_quantity, customer_classes.class_name as customer_type
from customers
	inner join contracts on customers.customer_id = contracts.customer_id
	left join customer_classes on customers.class_id = customer_classes.class_id
where customers.class_id = 25
group by customers.customer_name
order by booking_quantity asc;

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
--      (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
--      cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select customers.customer_id, customer_name, customer_classes.class_name, contracts.contract_id, services.service_name, contracts.contract_date, contracts.finished_date, (contracts.total_amount + (detailed_contracts.quantity *extra_services.price)) as total_bill
from customers
	left join customer_classes on customers.class_id = customer_classes.class_id
	left join contracts on customers.customer_id = contracts.customer_id
	left join services on services.service_id = contracts.service_id
    left join detailed_contracts on contracts.contract_id = detailed_contracts.contract_id
    left join extra_services on detailed_contracts.extra_service_id = extra_services.extra_service_id;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng
--      thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select services.service_id, service_name, area, rent_fee, service_types.service_type_name, contract_date
from services
	left join service_types on services.service_type_id = service_types.service_type_id
    left join contracts on services.service_id = contracts.service_id
where (contract_date not like '2019-01-%') and 
	  (contract_date not like '2019-02-%') and
      (contract_date not like '2019-03-%') or 
      contract_date is null
group by services.service_id;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ
--      đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.

select services.service_id, service_name, area, rent_fee, max_people, service_types.service_type_name, contract_date
from services
	left join service_types on services.service_type_id = service_types.service_type_id
    left join contracts on services.service_id = contracts.service_id
where (contract_date like '2018-%') and contracts.service_id not in (select contracts.service_id
																	from contracts
																	where contract_date like '2019-%');
                                                                    
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- 		Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.

-- // first way
select distinct customer_name
from customers;

-- // second way
select customer_name
from customers
group by customer_name;

-- // third way
select customer_name
from customers
union
select customer_name
from customers;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
--      thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select substr(contract_date, 6, 2) as `month`, count(contracts.customer_id) as customer_quantity, sum(total_amount) as revenue
from contracts
	inner join customers on contracts.customer_id = customers.customer_id
where contracts.contract_date  like '2019-%'
group by substr(contract_date, 6, 2)
order by substr(contract_date, 6, 2);

-- select * from contracts where contracts.contract_date  like '2019-%';

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
--      IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select contracts.contract_id, contract_date, finished_date, prepaid_amount, count(detailed_contracts.quantity) as extra_service_quantity
from contracts
	left join detailed_contracts on contracts.contract_id = detailed_contracts.contract_id
group by contracts.contract_id;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
--      TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select customer_name, customers.address, customer_classes.class_name, contracts.contract_id, detailed_contracts.extra_service_id, extra_service_name, price
from customers
	inner join customer_classes on customers.class_id = customer_classes.class_id
    inner join contracts on customers.customer_id = contracts.customer_id
    inner join detailed_contracts on contracts.contract_id = detailed_contracts.contract_id
    inner join extra_services on detailed_contracts.extra_service_id = extra_services.extra_service_id
where class_name = 'Diamond' and customers.address in ('Quang Ngai', 'Vinh');    

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
--      (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng
--      đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select contracts.contract_id, employees.employee_name, customers.customer_name, services.service_name, count(detailed_contracts.quantity) as extra_service_quantity, prepaid_amount, contract_date
from contracts
	inner join employees on contracts.employee_id = employees.employee_id
    inner join customers on contracts.customer_id = customers.customer_id
    inner join services on contracts.service_id = services.service_id
    inner join detailed_contracts on contracts.contract_id = detailed_contracts.contract_id
group by contracts.contract_id
having year(contract_date) = 2019 and month(contract_date) in (10, 11, 12) and  contracts.contract_id not in (
		select contracts.contract_id
		from contracts
			inner join detailed_contracts on contracts.contract_id = detailed_contracts.contract_id
		where year(contract_date) = 2019 and month(contract_date) in (1,2,3,4,5,6)
);

select * from contracts;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
--      (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create view booking_quantity
as
select extra_service_name, price, sum(quantity) as booked_quantity
from detailed_contracts
	inner join extra_services on detailed_contracts.extra_service_id = extra_services.extra_service_id
group by extra_service_name
order by booked_quantity desc;

select * from booking_quantity
having booked_quantity = max(booked_quantity);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
--      Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select extra_service_name, price, sum(quantity) as booked_quantity
from detailed_contracts
	inner join extra_services on detailed_contracts.extra_service_id = extra_services.extra_service_id
group by extra_service_name
having booked_quantity = 4; -- (4 just for Testing) --> Change number 4 to 1.

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
--      mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select contracts.employee_id, employee_name, phone, address, level_name, division_name, count(contract_id)
from contracts
	inner join employees on contracts.employee_id = employees.employee_id
    inner join levels on employees.level_id = levels.level_id
    inner join divisions on employees.division_id = divisions.division_id
where (contract_date like '2018%') or (contract_date like '2019%')    
group by employees.employee_id
having count(contract_id) <= 3; 

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- has already use 'ON DELETE CASCADE' when creating table
delete from employees
where employee_id not in (
	select employee_id 
    from contracts 
    where year(contract_date) in (2017, 2018, 2019)
);

-- another way of DELETE
SET FOREIGN_KEY_CHECKS = 0;
delete from employees
where employee_id not in (
	select employee_id 
    from contracts 
    where year(contract_date) in (2017, 2018, 2019)
);
SET FOREIGN_KEY_CHECKS = 1;
-- finished --

select * from employees;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
--      chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
update customers
set class_id = 25
where class_id = 15 and customer_id in (
	select customer_id
	from contracts
	where year(contract_date) = 2019
	group by customer_id
	having sum(total_amount) >= 2000 -- => just for testing, change 2000 to 10.000.000 as required.
);

select * from customers;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
delete from customers
where customer_id not in (
		select customer_id
		from contracts
		where year(contract_date) >= 2016
);

select * from customers;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update extra_services
set price = price * 2
where extra_service_id in (
		select extra_service_id
		from detailed_contracts
			left join contracts on detailed_contracts.contract_id = contracts.contract_id
		where year(contract_date) = 2019
		group by extra_service_id
		having sum(quantity) >= 2 -- => Just for testing, change 2 to 10 as required.
);

select * from extra_services;
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
--      thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select  employee_id as id, employee_name as `name`, email, phone, birthday, address
from employees
union
select customer_id as id, customer_name as `name`, email, phone, birthday, address
from customers;

-- __________________________________________________________ THE END _______________________________________________________
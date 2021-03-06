drop database if exists case_study;
create database case_study;
use case_study;

-- --------------------- EMPLOYEES ----------------------------
-- create table 'positions'
drop table if exists positions;
create table if not exists positions(
	position_id int,
    position_name varchar(45) not null unique,
    primary key (position_id)
);

-- insert into positions
INSERT INTO `positions` VALUES (666,'Director'),(555,'Manager'),(111,'Receptionist'),(333,'Staff'),(444,'Supervisor'),(222,'Waiter');


-- create table 'levels'
drop table if exists levels;
create table if not exists levels(
	level_id int,
    level_name varchar(45) not null unique,
    primary key(level_id)
);

-- insert into levels
INSERT INTO `levels` VALUES (44,'After-university'),(22,'College'),(11,'Pre-college'),(33,'University');
   

-- create table 'depts'
drop table if exists divisions;
create table if not exists divisions(
	division_id int,
	division_name varchar(45) not null unique,
	primary key(division_id)
); 

-- insert into divisions
 INSERT INTO `divisions` VALUES (202,'Administration'),(404,'Management'),(101,'Sale-Marketing'),(303,'Service'); 


-- create table 'Employees'
drop table if exists employees;
create table if not exists employees(
	employee_id int,
    employee_name varchar(45) not null,
    position_id int not null,
    level_id int not null,
    division_id int not null,
    birthday date not null default '1988-04-20',
    id_card varchar(45) not null default '111 222 333 444',
    salary varchar(45) not null default '20000000',
    phone varchar(45) not null default '0905 555 999',
    email varchar(45) not null default 'employee@gmail.com',
    address varchar(45) not null default 'Ha Noi',
    primary key(employee_id),
    foreign key(position_id) references positions(position_id),
    foreign key(level_id) references levels(level_id),
    foreign key(division_id) references divisions(division_id)
);	

-- insert into employees
INSERT INTO `employees` VALUES (1,'Chau Kiet Luan',111,11,303,'1990-07-25','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(2,'Ngo Ngan To',222,22,101,'1988-03-22','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(3,'Tu Nhuoc Tuyen',333,33,202,'1994-09-17','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(4,'Kim Thanh Vu',555,44,404,'1997-11-23','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(5,'Ly Lien Kiet',444,33,101,'1988-12-28','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(6,'Luu Duc Hoa',222,22,202,'1982-10-26','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(7,'Quach Phu Thanh',222,33,202,'1993-07-22','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(8,'Le Minh',333,33,202,'1994-11-25','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(9,'Truong Hoc Huu',333,22,202,'1980-10-19','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(10,'Nham Dat Hoa',444,11,404,'1979-04-16','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(11,'Hong Kim Bao',555,33,404,'1973-07-19','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(12,'Truong Ve Kien',666,44,404,'1992-11-29','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(13,'Ly Gia Han',222,22,101,'1985-05-27','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(14,'Co Thien Lac',333,22,202,'1990-12-12','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(15,'Truong Man Ngoc',333,33,202,'1978-03-18','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi');


-- ------------------------ CUSTOMERS -----------------------

-- create table 'customer_classes'
drop table if exists customer_classes;
create table if not exists customer_classes(
	class_id int,
    class_name varchar(45) not null unique,
    primary key(class_id)
);

-- insert into customer_classes
INSERT INTO `customer_classes` VALUES (25,'Diamond'),(35,'Gold'),(55,'Member'),(15,'Platinum'),(45,'Silver');  


-- create table 'customers'
drop table if exists customers;
create table if not exists customers(
	customer_id int,
    class_id int,
    customer_name varchar(45) not null,
    birthday date not null default '1990-09-22',
    id_number varchar(45) not null default '197 182 504',
    phone varchar(45) not null default '084 2345 777',
    email varchar(45) not null default 'customer@gmail.com',
    address varchar(45) not null default 'Da Nang',
    primary key(customer_id),
    foreign key(class_id) references customer_classes(class_id)
);    

-- insert into customers
INSERT INTO `customers` VALUES 
	(1,15,'David Beckham','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),
	(2,25,'Leonardo Decaprio','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),
	(3,15,'John Statham','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Tri'),
	(4,35,'Steven Seagal','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai'),
	(5,25,'Jean Claude','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),
	(6,45,'Richard Gere','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai'),
	(7,55,'Keanu Reaves','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),
	(8,15,'Jennife Laurence','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),
	(9,25,'Juliet Robert','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai'),
	(10,25,'Donald Trump','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),
	(11,35,'Richard Branson','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Tri'),
	(12,45,'Will Smith','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),
	(13,55,'Tom Cruise','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Hue'),
	(14,55,'Sylvester Stallone','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),
	(15,15,'James Bond','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Hue'),
	(16,15,'Emma Waston','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Hue'),
	(17,45,'Owen Wilson','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),
	(18,35,'Will Smith','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),
	(19,25,'Nicolas Cage','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),
	(20,25,'Will Smith','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai');


-- ---------------------- SERVICES ------------------------
 
-- create table 'rent_types'
drop table if exists rent_types;
create table if not exists rent_types(
	rent_type_id int,
    rent_type_name varchar(45) not null unique,
    price int not null default 1500,
    primary key(rent_type_id)
);

-- insert into rent_types
INSERT INTO `rent_types` VALUES (171,'Hourly',1500),(272,'Daily',1500),(373,'Monthly',1500),(474,'Yearly',1500);  


-- create table 'service_types'
drop table if exists service_types;
create table if not exists service_types(
	service_type_id int,
    service_type_name varchar(45) not null unique,
    primary key(service_type_id)
);

-- insert into service_types
INSERT INTO `service_types` VALUES (200,'House'),(300,'Room'),(100,'Villa');


-- create table 'services'
drop table if exists services;
create table if not exists services(
	service_id int,
    service_name varchar(45) not null,
    area int not null default 50,
    story_number int not null default 2,
    max_people varchar(45) not null default '4',
    rent_fee  varchar(45) not null default 10000,
    rent_type_id int,
    service_type_id int,
    service_status varchar(45) not null default 'available',
    primary key(service_id),
    foreign key(rent_type_id) references rent_types(rent_type_id),
    foreign key(service_type_id) references service_types(service_type_id)
);

-- insert into services
INSERT INTO `services` VALUES (1,'King',50,2,'4','10000',272,100,'available'),(2,'Queen',50,2,'4','10000',272,100,'available'),(3,'Prince',50,2,'4','10000',373,100,'available'),(4,'Princess',50,2,'4','10000',474,100,'available'),(5,'Panther',50,2,'4','10000',373,200,'available'),(6,'Lion',50,2,'4','10000',373,200,'available'),(7,'Leopard',50,2,'4','10000',474,200,'available'),(8,'Tiger',50,2,'4','10000',272,200,'available'),(9,'Ant',50,2,'4','10000',171,300,'available'),(10,'Mosquito',50,2,'4','10000',171,300,'available'),(11,'Firefly',50,2,'4','10000',171,300,'available'),(12,'Mantis',50,2,'4','10000',171,300,'available');


-- ---------------------------- CONTRACTS --------------------------------

-- create table 'extra_services'
drop table if exists extra_services;
create table if not exists extra_services(
	extra_service_id int,
    extra_service_name varchar(45) not null unique,
    price int not null default 150,
    unit int not null default 1,
    extra_service_status varchar(45) not null default 'available',
    primary key(extra_service_id)
); 

-- insert into extra_services
INSERT INTO `extra_services` VALUES (1,'Karaoke',150,1,'available'),(2,'Massage',150,1,'available'),(3,'Food',150,1,'available'),(4,'Drink',150,1,'available'),(5,'Car',150,1,'available');


-- create table 'contracts'
drop table if exists contracts;   
create table if not exists contracts(
	contract_id int,
    employee_id int,
    customer_id int,
    service_id int,
    contract_date date not null default '2020-08-20',
    finished_date date not null default '2020-09-20',
    prepaid_amount int not null default 700,
    total_amount int not null default 1500,
    primary key(contract_id),
    foreign key(employee_id) references employees(employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(customer_id) references customers(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(service_id) references services(service_id) ON DELETE CASCADE ON UPDATE CASCADE
);   

-- insert into contracts
INSERT INTO `contracts` VALUES 
	(1,1,1,11,'2019-08-20','2020-09-20',700,1250),
	(2,2,2,12,'2018-08-20','2020-09-20',700,1200),
	(3,3,3,10,'2019-08-20','2020-09-20',700,1650),
	(4,4,4,11,'2018-01-20','2020-09-20',700,1300),
	(5,5,5,5,'2018-08-20','2020-09-20',700,1450),
	(6,6,6,6,'2019-10-20','2020-09-20',700,1650),
	(7,7,7,7,'2019-08-20','2020-09-20',700,1600),
	(8,8,8,8,'2018-02-20','2020-09-20',700,1100),
	(9,9,9,9,'2019-12-20','2020-09-20',700,1200),
	(10,10,10,10,'2018-11-20','2020-09-20',700,1350),
	(11,1,1,11,'2018-05-20','2020-09-20',700,1150),
	(12,2,2,12,'2017-08-20','2020-09-20',700,1650),
	(13,3,3,10,'2018-03-20','2020-09-20',700,1500),
	(14,4,1,11,'2019-01-20','2020-09-20',700,1350),
	(15,5,2,5,'2019-04-20','2020-09-20',700,1400),
	(16,6,4,6,'2018-10-20','2020-09-20',700,1200),
	(17,7,1,7,'2019-03-20','2020-09-20',700,1700),
	(18,8,4,8,'2016-02-20','2020-09-20',700,1350),
	(19,9,9,9,'2019-09-20','2020-09-20',700,1500),
	(20,10,10,10,'2018-07-20','2020-09-20',700,1500);


-- create table 'detailed_contracts'
drop table if exists detailed_contracts;	
create table if not exists detailed_contracts(
	detailed_contract_id int,
    contract_id int,
    extra_service_id int,
    quantity int not null default 1,
    primary key(detailed_contract_id),
    foreign key(extra_service_id) references extra_services(extra_service_id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(contract_id) references contracts(contract_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- insert into detailed_contracts
INSERT INTO `detailed_contracts` VALUES (1,5,1,1),(2,4,2,1),(3,6,3,1),(4,3,4,1),(5,1,5,1),(6,2,2,1),(7,8,2,1),(8,9,1,1),(9,10,4,1),(10,11,5,1),(11,12,1,1),(12,13,1,1),(13,14,2,1),(14,15,4,1),(15,16,3,1),(16,17,5,1),(17,18,5,1),(18,19,3,1),(19,20,3,1),(20,7,2,1);

-- --------------------------------------- TASKS OF CASE STUDY ---------------------------------------
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
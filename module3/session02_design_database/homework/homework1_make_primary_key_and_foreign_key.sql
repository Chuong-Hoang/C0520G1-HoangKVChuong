drop database if exists bank;
create database bank;
use bank;
create table customers(
customer_number int,
full_name varchar(30) not null,
address varchar(50),
email varchar(30),
phone varchar(12),
constraint PK_customer_number primary key (customer_number)
);

drop table if exists accounts;
create table accounts(
account_number int,
account_type varchar(10),
created_date date,
balance int not null,
customer_number int,
constraint PK_account_number primary key (account_number),
constraint FK_customer_number foreign key (customer_number) references customers(customer_number)
);
alter table accounts
modify column account_number varchar(10);

drop table if exists transactions;
create table transactions(
tran_number int,
account_number varchar(10),
tran_date date not null,
amount int not null,
tran_content varchar(50),
constraint PK_tran_number primary key (tran_number),
constraint FK_account_number foreign key (account_number) references accounts(account_number)
);

select * from customers;
insert into customers(customer_number, full_name, address, email, phone) values
(111, 'Chuong Hoang', 'Quang Tri', 'chuong@hoang', '0934432445'),
(222, 'Le Toan', 'Da Nang', 'le@toan.vn', '0349245345'),
(333, 'Quang Nguyen', 'Da Nang', 'quang@nguyen', '23433432532'),
(444, 'Quoc Khanh', 'Vinh', 'quoc@khanh', '0983443959'),
(555, 'Tan Hai', 'Ha Noi', 'tan@hai.com', '08372432354');

select * from accounts;
insert into accounts(account_number, account_type, created_date, balance, customer_number) values
(0081, 'vip', '2011-09-28', 1000, 222),
(0071, 'business', '2010-01-20', 1200, 555),
(0088, 'normal', '2013-03-29', 5500, 333),
(0999, 'vip', '2012-10-31', 1900, 111),
(0777, 'normal', '2020-05-18', 2250, 444);
update accounts set account_number = '0071' where customer_number = 555;
update accounts set account_number = '0777' where customer_number = 444;
update accounts set account_number = '0081' where customer_number = 222;
update accounts set account_number = '0088' where customer_number = 333;
update accounts set account_number = '0999' where customer_number = 111;

select * from transactions;
insert into transactions(tran_number, account_number, tran_date, amount, tran_content) values
(123, '0081', '2020-07-16', 200, 'Payment for goods'),
(234, '0088', '2020-07-16', 550, 'salary'),
(145, '0777', '2020-07-16', 350, 'car rent'),
(149, '0999', '2020-07-16', 1000, 'borrow'),
(562, '0999', '2020-07-16', 880, 'water bill');
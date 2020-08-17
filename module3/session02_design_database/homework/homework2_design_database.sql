drop database if exists homework2;
create database homework2;
use homework2;

-- create table (1): customers
create table customers(
customerNumber int primary key,
customerCompany varchar(50) not null,
customerLastName varchar(20) not null,
customerFirstName varchar(20) not null,
phone varchar(20) not null,
addressLine1 varchar(100) not null,
addressLine2 varchar(100),
city varchar(20) not null,
state varchar(20) not null,
postalCode varchar(20) not null,
country varchar(20) not null,
creditLimit double default 0.0
);

-- create table (2): orders
create table orders(
orderNumber int primary key,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
orderStatus varchar(100) not null,
orderComment varchar(255) default 'N/A', 
quantityOrdered int not null,
priceEach double not null,
customerNumber int,
foreign key(customerNumber) references customers(customerNumber)
);

-- create table (3): payments
create table payments(
customerNumber int,
checkNumber varchar(20) not null,
paymentDate date not null,
amount double not null,
foreign key(customerNumber) references customers(customerNumber)
);

-- create table (5): productlines
create table productlines(
productLine varchar(50) primary key,
textDescription varchar(255) not null,
image varchar(255)
);

-- create table (4): products
create table products(
productCode varchar(20) primary key,
productName varchar(50) not null,
productScale varchar(20) not null,
productVendoer varchar(50) not null,
productDescription varchar(255) not null,
quantityInStock int not null,
buyPrice double not null,
retailPrice double not null,
productLine varchar(50),
foreign key(productLine) references productlines(productLine)
);

-- create table (7): offices
create table offices(
officeCode varchar(20) primary key,
city varchar(20) not null,
phone varchar(20) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) default 'N/A',
state varchar(20) not null,
country varchar(20) not null,
postalCode varchar(20) not null
);

-- create table (6): employees
create table employees(
employeeNumber varchar(20) primary key,
lastName varchar(20) not null,
firstName varchar(20) not null,
email varchar(50) not null,
jobTitle varchar(50) not null,
reportTo varchar(20),
officeCode varchar(20),
foreign key(reportTo) references employees(employeeNumber),
foreign key(officeCode) references offices(officeCode)
);

-- create table (8): orderDetails
create table orderdetails(
productCode varchar(20) not null,
orderNumber int not null,
foreign key(productCode) references products(productCode),
foreign key(orderNumber) references orders(orderNumber)
);



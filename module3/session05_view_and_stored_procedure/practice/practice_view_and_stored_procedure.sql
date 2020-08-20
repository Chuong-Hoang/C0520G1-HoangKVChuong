use classicmodels;
select *
from customers;

-- (1) index in MySQL ------------------------------------------------------------------

select *
from customers
where customerNumber = 175;

explain select *
from customers
where customerNumber = 175;

-- (2) create stored procedure -------------------------------------------------------
delimiter //
create procedure findAllCustomers()
begin
	select *
    from customers;
end //

-- call stored procedure
call findAllCustomers();

-- drop stored procedure and create new procedure
delimiter //
drop procedure if exists `findAllCustomers` //

create procedure findUSACustomers()
begin
	select *
    from customers;
end; //

-- call procedure
call findUSACustomers();

-- drop stored procedure and create new stored procedure
delimiter //
drop procedure if exists `findUSACustomers` //
create procedure findUsaCustomers()
begin
	select *
    from customers
    where country = 'USA';
end; //

-- call procedure
call findUsaCustomers();

-- (3) Parameters in stored procedure ----------------------------------------------------
-- Parameter 'IN' --> default if you do not assign any parameter
delimiter //
create procedure getCustomerById (IN cusNum int)
begin
	select *
    from customers
    where customerNumber = cusNum;
end; //

-- call store procedure
call getCustomerById(175);
call getCustomerById(157);

-- Parameter 'OUT' --> use procedure data for outside action
delimiter //
create procedure getCusCountByCity (IN in_city varchar(50), OUT total int)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end //
delimiter ;

-- call procedure
call getCusCountByCity('Lyon', @total);
select @total;

-- Parameter 'INOUT'
delimiter //
create procedure setCounter(INOUT counter int, in inc int)
begin
	set counter = counter + inc;
end//
delimiter ;

-- call procedure
set @counter = 1;
call setCounter(@counter, 1);
call setCounter(@counter, 1);
call setCounter(@counter, 5);
select @counter;

-- (4) view in MySQL --------------------------------------------------------------
create view customer_view as
select customerNumber, customerName, phone
from customers;

-- select view
select * 
from customer_view;

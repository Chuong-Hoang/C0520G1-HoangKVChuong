SELECT * FROM classicmodels.customers;
select orders.orderNumber, customers.customerName, orders.orderDate
from orders
inner join  customers on orders.customerNumber = customers.customerNumber;

select * from customers;
select * from orders;
select * from payments;
select customers.customerNumber, customers.customerName, orders.shippedDate, payments.paymentDate, payments.amount
from ((customers
inner join orders on customers.customerNumber = orders.customerNumber)
inner join payments on customers.customerNumber = payments.customerNumber);
select sum(amount)
from payments;
select * from products;
select sum(quantityInStock)
from products
where buyPrice between 50 and 60;

select * from products
where quantityInStock between 500 and 1000;
select avg(buyPrice)
from products
where quantityInStock between 500 and 1000;

select max(buyPrice)
from products
where quantityInStock > 100;
select buyPrice, quantityInStock
from products
where quantityInStock > 100;
select sum(quantityInStock) as total
from products
where quantityInStock > 100;
select * from customers where country = 'usa';
select count(country) as totalOfUSA
from customers
where country = "USA";
select count(customers.salesRepEmployeeNumber) as ResultOf1188
from customers
where customers.salesRepEmployeeNumber = 1188;
select * from customers;
select ucase(customers.contactFirstName) as name, ucase(customers.contactLastName) as family_name, city, country
from customers
where city = "NYC";

select *
from customers
where city = "NYC";
use classicmodels;
select * from customers;
select length(customers.city) as lengthOfCity, customers.city, customers.postalCode
from customers;
-- Error Code: 1305. FUNCTION classicmodels.len does not exist --> length() <=> len() in James

select customerName, city, country, now() as perDate
from customers;


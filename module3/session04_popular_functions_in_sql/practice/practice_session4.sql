use classicmodels;
select now() as result;
select format(now(), 'yyy-mm-dd') as `day`;

select count(customerNumber) as quantity, country
from customers
group by country;

select count(customerNumber) as quantityOfUsa
from customers
where country = 'USA';

select count(customerNumber) as quantity, city, country
from customers
group by city
order by country;

select * from payments;

select customerNumber, sum(amount) as amount
from payments
group by customerNumber
order by customerNumber;
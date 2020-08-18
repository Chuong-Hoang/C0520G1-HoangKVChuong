SELECT 
    *
FROM
    classicmodels.customers;
SELECT 
    orders.orderNumber, customers.customerName, orders.orderDate
FROM
    orders
        INNER JOIN
    customers ON orders.customerNumber = customers.customerNumber;

SELECT 
    *
FROM
    customers;
SELECT 
    *
FROM
    orders;
SELECT 
    *
FROM
    payments;
SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.shippedDate,
    payments.paymentDate,
    payments.amount
FROM
    ((customers
    INNER JOIN orders ON customers.customerNumber = orders.customerNumber)
    INNER JOIN payments ON customers.customerNumber = payments.customerNumber);
SELECT 
    SUM(amount)
FROM
    payments;
SELECT 
    *
FROM
    products;
SELECT 
    SUM(quantityInStock)
FROM
    products
WHERE
    buyPrice BETWEEN 50 AND 60;

SELECT 
    *
FROM
    products
WHERE
    quantityInStock BETWEEN 500 AND 1000;
SELECT 
    AVG(buyPrice)
FROM
    products
WHERE
    quantityInStock BETWEEN 500 AND 1000;

SELECT 
    MAX(buyPrice)
FROM
    products
WHERE
    quantityInStock > 100;
SELECT 
    buyPrice, quantityInStock
FROM
    products
WHERE
    quantityInStock > 100;
SELECT 
    SUM(quantityInStock) AS total
FROM
    products
WHERE
    quantityInStock > 100;
SELECT 
    *
FROM
    customers
WHERE
    country = 'usa';
SELECT 
    COUNT(country) AS totalOfUSA
FROM
    customers
WHERE
    country = 'USA';
SELECT 
    COUNT(customers.salesRepEmployeeNumber) AS ResultOf1188
FROM
    customers
WHERE
    customers.salesRepEmployeeNumber = 1188;
SELECT 
    *
FROM
    customers;
SELECT 
    UCASE(customers.contactFirstName) AS name,
    UCASE(customers.contactLastName) AS family_name,
    city,
    country
FROM
    customers
WHERE
    city = 'NYC';

SELECT 
    *
FROM
    customers
WHERE
    city = 'NYC';
use classicmodels;
SELECT 
    *
FROM
    customers;
SELECT 
    LENGTH(customers.city) AS lengthOfCity,
    customers.city,
    customers.postalCode
FROM
    customers;
-- Error Code: 1305. FUNCTION classicmodels.len does not exist --> length() <=> len() in James

SELECT 
    customerName, city, country, NOW() AS perDate
FROM
    customers;

SELECT 
    *
FROM
    products
WHERE
    buyPrice > 60 AND quantityInStock > 100;

SELECT 
    *
FROM
    customers
WHERE
    country = 'usa' AND city = 'nyc';
SELECT 
    *
FROM
    payments
WHERE
    amount > 1000;

-- customerNumber, customerName, phone, paymentDate, amount từ hai bảng customers và payments
SELECT 
    customers.customerNumber,
    customerName,
    phone,
    paymentDate,
    amount
FROM
    customers
        INNER JOIN
    payments ON customers.customerNumber = payments.customerNumber
WHERE
    customers.country = 'uk';

SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
WHERE
    country = 'uk';

SELECT 
    customers.customerNumber,
    customers.customerName,
    country,
    city,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
WHERE
    orders.status = 'on hold';

SELECT 
    customers.customerNumber,
    customers.customerName,
    customers.country,
    orders.orderNumber
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
WHERE
    orderNumber IS NULL;

 -- practice: use group by
SELECT 
    orders.customerNumber, orders.orderDate, orders.status
FROM
    orders
GROUP BY orders.status;
 
SELECT 
    status, COUNT(*) AS 'status_quantity'
FROM
    orders
GROUP BY status
ORDER BY status_quantity;
 -- order by status;
 
SELECT 
    orders.status,
    SUM(orderdetails.quantityOrdered * orderdetails.priceEach) AS total_amount
FROM
    orders
        INNER JOIN
    orderdetails ON orders.orderNumber = orderdetails.orderNumber
GROUP BY status
ORDER BY total_amount;
 
SELECT 
    orderdetails.orderNumber,
    SUM(quantityOrdered * priceEach) AS total_amount,
    customers.customerName
FROM
    (orderdetails
    LEFT JOIN orders ON orderdetails.orderNumber = orders.orderNumber)
        INNER JOIN
    customers ON customers.customerNumber = orders.customerNumber
GROUP BY orderNumber;
 
 select year(orderDate) as year_of_finance from orders;
 -- having ...
select year(orders.orderDate) as year_of_finance, sum(quantityOrdered * priceEach) as total_amount
from orders
	inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year_of_finance
having year_of_finance > 2002;
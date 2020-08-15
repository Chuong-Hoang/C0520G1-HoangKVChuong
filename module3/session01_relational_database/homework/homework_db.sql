use homework_db;
select * from offices;
update offices set territory = 'QT' where officeCode = 1;
update offices set city = 'Hanoi' where officeCode between 2 and 4;
update offices set state = 'N/A' where country = 'usa';
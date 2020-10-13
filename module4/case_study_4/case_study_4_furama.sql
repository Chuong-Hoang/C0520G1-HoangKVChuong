use `case_study_4`;
insert into `customer_type`(customer_type_id, customer_type_name) values
(1, 'Diamond'),
(2, 'Platinium'),
(3, 'Gold'),
(4, 'Silver'),
(5, 'Member');

insert into `service_type`(service_type_id, service_type_name) values
(1, 'Villa'),
(2, 'House'),
(3, 'Room');

insert into `rent_type`(rent_type_id, rent_type_name, rent_type_cost) values
(1, 'Hour', '10'),
(2, 'Day', '240'),
(3, 'Month', '3000'),
(4, 'Year', '36000');

insert into `position` values
(1, 'Receptionist'),
(2, 'Waiter'),
(3, 'Staff'),
(4, 'Supervisor'),
(5, 'Manager'),
(6, 'Director');

insert into `division` values
(1, 'Sale-Marketing'),
(2, 'Administration'),
(3, 'Service'),
(4, 'Management');

insert into `education_degree` values
(1, 'Pre-college'),
(2, 'College'),
(3, 'University'),
(4, 'After-University');
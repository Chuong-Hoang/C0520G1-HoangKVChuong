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

insert into `attach_service`(attach_service_id, attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) values
(1, 'Karaoke', '25', 'hour', 'available'),
(2, 'Massage', '35', 'hour', 'available'),
(3, 'Drink', '5', 'bottle', 'available'),
(4, 'Food', '45', 'meal', 'available'),
(5, 'Car', '50', 'hour', 'available');
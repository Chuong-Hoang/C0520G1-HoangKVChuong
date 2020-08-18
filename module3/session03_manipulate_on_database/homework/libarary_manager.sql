drop database if exists library;
create database library;
use library;

create table book_genres(
	book_genre varchar(50) primary key,
	text_description varchar(255) default 'N/A',
	genre_comment varchar(255) default 'N/A'
);

insert into book_genres(book_genre) values
	('Math'),
	('Literature'),
	('Physics'),
	('Chemistry'),
	('English'),
	('Biology'),
	('Novel'),
	('Technology'),
	('Cuisine'),
	('Travel')
;   
select * from book_genres;

create table books(
	book_id int auto_increment primary key,
	book_title varchar(50) not null,
	publisher varchar(50) not null,
	author varchar(50) not null,
	publishing_year int not null,
	publishing_version int not null,
	price double not null,
    book_genre varchar(50),
    foreign key(book_genre) references book_genres(book_genre),
	image varchar(255) default 'image'
);

insert into books(book_title, publisher, author, publishing_year, publishing_version, price, book_genre) values
	('Math 10', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 15000, 'Math'),
	('Math 11', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 17000, 'Math'),
	('Math 12', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 19000, 'Math'),
	('Physics 10', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 12000, 'Physics'),
	('Physics 11', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 14000, 'Physics'),
	('Physics 12', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 16000, 'Physics'),
	('Chemistry 10', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 18000, 'Chemistry'),
	('Chemistry 11', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 21000, 'Chemistry'),
	('Chemistry 12', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 24000, 'Chemistry'),
	('English 10', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 16500, 'English'),
	('English 11', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 17500, 'English'),
	('English 12', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 18500, 'English'),
	('Literature 10', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 11', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 12', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature')
;

insert into books(book_title, publisher, author, publishing_year, publishing_version, price, book_genre) values
	('Math 10', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 15000, 'Math'),
	('Math 11', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 17000, 'Math'),
	('Math 12', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 19000, 'Math'),
	('Physics 10', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 12000, 'Physics'),
	('Physics 11', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 14000, 'Physics'),
	('Physics 12', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 16000, 'Physics'),
	('Chemistry 10', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 18000, 'Chemistry'),
	('Chemistry 11', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 21000, 'Chemistry'),
	('Chemistry 12', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 24000, 'Chemistry'),
	('English 10', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 16500, 'English'),
	('English 11', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 17500, 'English'),
	('English 12', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 18500, 'English'),
	('Literature 10', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 11', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 12', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
    ('Math 10', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 15000, 'Math'),
	('Math 11', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 17000, 'Math'),
	('Math 12', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 19000, 'Math'),
	('Physics 10', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 12000, 'Physics'),
	('Physics 11', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 14000, 'Physics'),
	('Physics 12', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 16000, 'Physics'),
	('Chemistry 10', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 18000, 'Chemistry'),
	('Chemistry 11', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 21000, 'Chemistry'),
	('Chemistry 12', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 24000, 'Chemistry'),
	('English 10', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 16500, 'English'),
	('English 11', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 17500, 'English'),
	('English 12', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 18500, 'English'),
	('Literature 10', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 11', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 12', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
    ('Math 10', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 15000, 'Math'),
	('Math 11', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 17000, 'Math'),
	('Math 12', 'NXB Giao duc', 'Mr.ABC', 2020, 2, 19000, 'Math'),
	('Physics 10', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 12000, 'Physics'),
	('Physics 11', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 14000, 'Physics'),
	('Physics 12', 'NXB Giao duc', 'Mr.ZZZ', 2010, 2, 16000, 'Physics'),
	('Chemistry 10', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 18000, 'Chemistry'),
	('Chemistry 11', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 21000, 'Chemistry'),
	('Chemistry 12', 'NXB Giao duc', 'Mr.CCC', 2018, 3, 24000, 'Chemistry'),
	('English 10', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 16500, 'English'),
	('English 11', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 17500, 'English'),
	('English 12', 'NXB Giao duc', 'Mr.EEE', 2015, 1, 18500, 'English'),
	('Literature 10', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 11', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature'),
	('Literature 12', 'NXB Giao duc', 'Mr.LLL', 2019, 1, 16500, 'Literature')
;

select * from books;

create table student_cards(
	card_id varchar(20) primary key,
	card_name varchar(50) not null,
	birthday date not null,
	address varchar(255) default 'N/A',
	email varchar(50) default 'abc@xyz.com',
	phone varchar(20) default '090-123-456',
	student_image varchar(255) default 'st_image'
);

insert into student_cards(card_id, card_name, birthday) values
	('S001', 'Hoang Kim Van Chuong', '1988-04-20'),
	('S002', 'Tu Si Tung', '1994-02-02'),
	('S003', 'Tran Huu Hien', '1998-05-10'),
	('S004', 'Le Toan', '1985-10-04'),
	('S005', 'Le Nhat', '1997-11-28'),
	('S006', 'Phan Quoc Khanh', '1993-05-24'),
	('S007', 'Nguyen Tien Hai', '1978-07-30'),
	('S008', 'Tran Thanh Hoang', '1996-06-29'),
	('S009', 'Nguyen Huu Quang', '1994-01-18'),
	('S010', 'Vo Son Tra', '1990-02-24'),
	('S011', 'Nguyen Van Hoat', '1992-03-14')
;
select * from student_cards;

drop table if exists borrowing_bills;
create table borrowing_bills(
	bill_id varchar(20) primary key,
    card_id varchar(20) not null,
    book_id int not null unique,
    borrow_date date not null default '2020-08-16',
    return_date date not null default '2020-09-16',
    return_status varchar(20) not null default 'not yet',
    borrow_comment varchar(255) default 'compensate if late',
    foreign key(book_id) references books(book_id),
    foreign key(card_id) references student_cards(card_id)
);

select * from borrowing_bills;

insert into borrowing_bills(bill_id, card_id, book_id) values
	('BB-001', 'S003', 1),
	('BB-002', 'S003', 2),
	('BB-003', 'S003', 3),
	('BB-004', 'S002', 4),
	('BB-005', 'S002', 5),
	('BB-006', 'S002', 6),
	('BB-007', 'S001', 7),
	('BB-008', 'S001', 8),
	('BB-009', 'S001', 9),
	('BB-010', 'S001', 10),
	('BB-011', 'S007', 11),
	('BB-012', 'S007', 12),
	('BB-013', 'S007', 13),
	('BB-014', 'S007', 14)
;    
select * from borrowing_bills;

-- manipulate database
select student_cards.card_id, student_cards.card_name as student, bill_id, borrowing_bills.book_id, return_status, book_title
from student_cards
	left join borrowing_bills on student_cards.card_id = borrowing_bills.card_id
    left join books on books.book_id = borrowing_bills.book_id;

create table book(
	bnum int auto_increment primary key,
    title varchar(50),
    bookInfo varchar(500),
    author varchar(50),
    publisher varchar(50),
    price int,
    regDate timestamp,
    qty int
);
select * from book;
drop table book;
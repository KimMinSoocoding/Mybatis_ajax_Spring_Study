use sample;

create table board(
	bid int auto_increment primary key,
    btitle varchar(100),
    bname varchar(20),
    bcontent varchar(500),
    bdate timestamp,
    bhit int,
    bgroup int,
    bstep int,
    bindent int
);

drop table board;
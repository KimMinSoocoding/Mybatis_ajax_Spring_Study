create table student(
	sid int auto_increment primary key,
    sName varchar(20) not null,
    sAge int not null,
    sGender varchar(10) not null,
    sEmail varchar(100) not null,
    sMajor varchar(100) not null
);

drop table student;

insert into student(sName, sAge, sGender, sEmail, sMajor) 
values('홍길동', 21, '남', 'hong@naver.com', '컴퓨터공학과');  

select * from student;
-----admin-----
create table flower_admin(
    id varchar2(20) not null,
    password varchar2(20) not null,
    name varchar2(20) not null
);
insert into flower_admin values('flower', '1234', '김민수');
select * from flower_admin;
commit;

-----category-----

create table flower_category(
    cat_num number(5) primary key,
    code varchar2(10) not null,
    cat_name varchar2(20) not null
);

create sequence f_cat_seq;


------Product------

create table flowerproduct(
    pNum number(10) primary key,
    pName varchar2(50) not null,
    pCategory_fk varchar2(30) not null,
    pImage varchar2(50),
    pQty number(5) default 0,
    price number(10) default 0,
    pSpec varchar2(20),
    pContent varchar2(300),
    pPoint number(8) default 0,
    pInputDate date
);

create table flower_shopMember(
    id varchar2(20) not null,
    pw varchar2(20) not null,
    name varchar2(20) not null,
    tel varchar2(20) not null,
    email varchar2(50) not null,
    addr varchar2(100) not null,
    rdate timestamp not null
);
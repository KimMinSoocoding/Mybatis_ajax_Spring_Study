---------- admin ---------
create table tbl_admin(
    id varchar2(20) not null,
    password varchar2(20) not null,
    name varchar2(20) not null,
    email varchar2(30) not null
);

insert into tbl_admin values('test', 'test', '홍길동', 'test@gmail.com');
select * from tbl_admin;
commit;

--------------------------
create table category(
    cat_num number(5) primary key,
    code varchar2(10) not null,
    cat_name varchar2(20) not null
);

create sequence cat_seq;

------------product--------------
create table product(
    pNum number(10) primary key,
    pName VARCHAR2(50) not null,
    pCategory_fk VARCHAR2(30) not null,
    pCompany VARCHAR2(50),
    pImage VARCHAR2(50),
    pQty number(5) default 0,
    price number(10) default 0,
    pSpec VARCHAR2(20),
    pContent VARCHAR2(300),
    pPoint number(8) default 0,
    pInputDate date
);

create SEQUENCE prod_seq
MINVALUE 0
INCREMENT by 1
start with 0
nocache;

/* 
 -- 상품테이블 --
 
    상품번호
    상품명
    상품카테고리 
    상품회사 
    상품이미지 
    상품수량
    상품가격
    상품사양
    상품내용
    포인트
    입고일자 
*/
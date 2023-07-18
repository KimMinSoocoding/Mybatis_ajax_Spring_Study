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

------------- category --------------
create table category(
    cat_num number(5) primary key,
    code varchar2(10) not null,
    cat_name varchar2(20) not null
);

create sequence cat_seq;

/* 상품 테이블
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
-------------- product ---------------
create table product(
    pNum number(10) primary key,
    pName varchar2(50) not null,
    pCategory_fk varchar2(30) not null,
    pCompany varchar2(50),
    pImage varchar2(50),
    pQty number(5) default 0,
    price number(10) default 0,
    pSpec varchar2(20),
    pContent varchar2(300),
    pPoint number(8) default 0,
    pInputDate date
);

create sequence prod_seq
minvalue 0
increment by 1
start with 0
nocache;

------------ shopMember -----------
create table shopMember(
    id varchar2(20) not null,
    pw varchar2(20) not null,
    name varchar2(20) not null,
    tel varchar2(20) not null,
    email varchar2(50) not null,
    addr varchar2(100) not null,
    rdate timestamp not null
);




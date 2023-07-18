-- 아우터 - 코트, 자켓
-- 상의 - 티셔츠, 니트
-- 하의 - 데님팬츠, 스커트
-- 원피스 - 멜빵, 플라워패턴

-----------------------------------------------------------------------
-- 카테고리 테이블 2개(대분류, 소분류)

drop sequence lcateseq ;
drop table lcategory cascade constraints;

create sequence lcateseq
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table lcategory( 
	no number not null primary key,	-- 식별값
	name varchar2(50) not null,     -- 대분류명
	step number not null	 		-- 대분류간 순서조정을 위한 값
);

drop sequence scateseq ;
drop table scategory cascade constraints;

create sequence scateseq
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table scategory( 
	no number not null primary key,	-- 식별값
	name varchar2(50) not null,     -- 소분류명
	step number not null,			-- 소분류간 순서조정을 위한 값
	lcno number				-- 순서조정을 위한 값
);
--아래의 insert 첫줄은 무조건 넣어줘야 함.
insert into lcategory values(-1, '.', 0);
insert into lcategory values(lcateseq.nextval, 'OUTER', 6);
insert into lcategory values(lcateseq.nextval, 'TOP', 3);
insert into lcategory values(lcateseq.nextval, 'DRESS', 5);
insert into lcategory values(lcateseq.nextval, 'BOTTOM', 4);
insert into lcategory values(lcateseq.nextval, 'BEST', 1);
insert into lcategory values(lcateseq.nextval, 'NEW', 2);
insert into lcategory values(lcateseq.nextval, 'BAG', 7);
insert into lcategory values(lcateseq.nextval, 'SHOES', 8);


--아래의 insert 첫줄은 무조건 넣어줘야 함.
insert into scategory values(-1, '.', 1, 0);
commit;
insert into scategory values(scateseq.nextval, '니트', 1, 2);
insert into scategory values(scateseq.nextval, '민소매', 2, 2);
insert into scategory values(scateseq.nextval, '블라우스/셔츠', 3, 2);
insert into scategory values(scateseq.nextval, '데님팬츠', 1, 4);
insert into scategory values(scateseq.nextval, '스커트', 2, 4);
insert into scategory values(scateseq.nextval, '일반팬츠', 3, 4);
insert into scategory values(scateseq.nextval, '니트타입', 1, 3);
insert into scategory values(scateseq.nextval, '플라워패턴', 2, 3);
insert into scategory values(scateseq.nextval, '코트', 1, 1);
insert into scategory values(scateseq.nextval, '자켓', 2, 1);
insert into scategory values(scateseq.nextval, '가디건', 3, 1);


select * from lcategory order by step asc;
select * from scategory order by lcno asc, step asc;

commit;

col lname for a15
col sname for a15
col name for a15

--getAllCategory()
select lcate.no as lno, lcate.name as lname, lcate.step as lstep, scate.no as sno, scate.name as sname, scate.step as sstep
from (select * from lcategory order by step asc) lcate left outer join (select * from scategory order by lcno asc, step asc) scate
on lcate.no = scate.lcno
order by lstep asc, sstep asc;

commit;

select * from lcategory order by step;
select * from scategory order by lcno asc, step asc;
-----------------------------------------------------------------------
-- 상품 테이블

drop sequence prodseq ;
drop table product cascade constraints;

create sequence prodseq
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table product( 
	no number not null primary key,	-- 식별값
	lcno number not null references lcategory(no) on delete cascade,
	scno number references scategory(no) on delete cascade,
	name varchar2(50) not null,
	oriprice number,
	discprice number,
	info varchar2(400),
	mainImgN varchar2(30),
	detailImgN1 varchar2(30),
	detailImgN2 varchar2(30),
	detailImgN3 varchar2(30),
	detailImgN4 varchar2(30)
);

col no for 99
col lcno for 99
col scno for 99
col name for a20
col info for a15
col mainImgN for a15
col detailImgN1 for a15
col detailImgN2 for a15
col detailImgN3 for a15
col detailImgN4 for a15

select * from product;

--getAllProduct()
select pro.NO, pro.LCNAME, scate.name as scname, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4 
from scategory scate inner join (select pro.NO, lcate.NAME as lcname, pro.SCNO, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4
from lcategory lcate inner join product pro
on lcate.no = pro.lcno) pro
on scate.no = pro.scno;

-----------------------------------------------------------------------
-- 사이즈별 재고 테이블

drop sequence stockseq ;
drop table stock;

create sequence stockseq
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table stock( 
	no number not null primary key,	-- 식별값
	pno number references product(no) on delete cascade,
	opname varchar2(20) not null,
	count number
);

commit;

-----------------------------------------------------------------------
-- 장바구니 테이블 생성
drop sequence cartseq ;
drop table cart;

create sequence cartseq   
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table cart(
	no number primary key,
	mno number references product(no) on delete cascade, -- 유저번호
	pno number not null,
	opname varchar2(40),
	qty number not null
);

commit;
------------------------------------------------------------------------
-- 회원 테이블 생성
drop sequence memseq ;
drop table member;

create sequence memseq   
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table member(
	no number primary key,
	id varchar2(40) not null,
	password varchar2(30) not null,
	name varchar2(30) not null,
	rrn1 varchar2(30) not null,
	rrn2 varchar2(30) not null,
	hp1 varchar2(30),
	hp2 varchar2(30),
	hp3 varchar2(30),
	zip varchar2(20),
	addr1 varchar2(50),
	addr2 varchar2(50)
);
insert into member(no, id, password, name, rrn1, rrn2) values(memseq.nextval, 'admin', '1234', '관리자', '123456', '7891011');
insert into member values(memseq.nextval, 'ldgeao99', '1234', '이대곤', '123456', '7891011', '010', '1234', '5678', '08763', '서울 관악구 신림동 465-1', '301호');
commit;
------------------------------------------------------------------------
-- 주문내역 테이블 생성
drop sequence orderseq ;
drop table orderlist;

create sequence orderseq   
increment by 1
start with 1
minvalue 1
maxvalue 10000
nocache;

create table orderlist(
	no number primary key,
	mno number not null,
	pno number,
	opname varchar2(40),
	qty number,
	price number,
	time date,    					-- 결제가 이뤄진 시간
	receiver varchar(40), 	-- 받는 사람
	rv_hp1 varchar2(30),
	rv_hp2 varchar2(30),
	rv_hp3 varchar2(30),
	rv_zip varchar2(20),
	rv_addr1 varchar2(50),
	rv_addr2 varchar2(50),
	memo varchar2(100)
);

commit;
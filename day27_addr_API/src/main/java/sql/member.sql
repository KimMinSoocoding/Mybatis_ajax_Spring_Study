create table member3(
    no int primary key auto_increment,
    id varchar(20) not null,
    pw varchar(20) not null,
    name varchar(20) not null,
    age int not null,
    email varchar(30) not null,
    phone varchar(20) not null,
    zipcode varchar(10),
    road_addr varchar(200),
    jibun_addr varchar(200),
    detail_addr varchar(200),
    unique key(id)
    );
    
    drop table member3;
    
    select * from member3;










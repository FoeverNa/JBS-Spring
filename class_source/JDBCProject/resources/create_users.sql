create table users(
id varchar2(8) primary key,
password varchar2(8) not null,
name varchar2(30) not null,
role varchar2(5) default 'USER')

insert into users(id, password, name, role) values ('admin', 'admin', '������', 'ADMIN');
insert into users(id, password, name ) values ('user', 'user', 'ȸ��1');

select * from users;


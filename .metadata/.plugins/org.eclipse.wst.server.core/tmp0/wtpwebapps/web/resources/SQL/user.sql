select * from users;
create table users (
Sid varchar2(20) primary key, 
Sname varchar2(20), 
Spw varchar2(100), 
Snum varchar2(20), 
Sgrade number(2),
Smajor varchar2(20),
Siscouncil number(2) default 0);
drop table users;
	select Spw from users where Sid='test';
select * from bank;
create table bank(Bid varchar2(30), Bname varchar2(20),Bpw varchar2(100),Brest number(20));
create table Blist(Bid varchar2(30),Bdate date,Brest number(20),Binout number(20),Buser varchar2(20));

create sequence Bseq
start with 1
increment by 1
nocache;--임시메모리 사용 안함@!
drop sequence Bseq;

select Bseq.nextval from dual;

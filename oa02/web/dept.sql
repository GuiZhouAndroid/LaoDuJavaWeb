drop table if exists dept;
create table dept(
	deptno int primary key,
    dname varchar(255),
    loc varchar(255)
);
insert into dept(deptno, dname, loc) values(10, 'XiaoShouBu', 'BEIJING');
insert into dept(deptno, dname, loc) values(20, 'YanFaBu', 'SHANGHAI');
insert into dept(deptno, dname, loc) values(30, 'JiShuBu', 'GUANGZHOU');
insert into dept(deptno, dname, loc) values(40, 'MeiTiBu', 'SHENZHEN');
commit;
select * from dept;
--创建部门表
create table dept
(
 dept_id number(6) primary key,
 dept_name varchar2(50),
 depte_loc varchar2(100)
)
--创建部门表序列
create sequence dept_seq start with 10 increment by 10;

--职务表
create table job
(
 job_id number(6) primary key,
 job_name varchar2(50),
 job_min_sal number(6),
 job_max_sal number(6)
)

--职务序列
create sequence job_seq;

--员工表
create table emp
(
 emp_id number(6) primary key,
 emp_name varchar2(50),
 emp_login_name varchar2(50),
 emp_pwd varchar2(50),
 emp_email varchar2(100),
 emp_phone varchar2(50),
 emp_hiredate date,
 emp_salary number(8,2),
 emp_dept_id number(6) references dept (dept_id) on delete set null,
 emp_job_id number(6) references job (job_id) on delete set null,
 emp_pic clob,
 emp_info varchar2(2000)
);

--员工表序列
create sequence emp_seq;

--图库表
create table pic
(      
       pic_id number(6) primary key,
       pic_name varchar2(100),
       pic_info varchar2(500),
       pic_size number(10),
       pic_author varchar2(50),
       pic_data blob,
       pic_datetime date
)

--图库序列
create sequence pic_seq;
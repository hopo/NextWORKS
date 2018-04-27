4일차
=====

## SELECT를 이용하여 조회
```sql
select a.col, b.col1, b.col2. c.*
	from a, b, c ;
```
* ex) a.col: 테이블a의 칼럼 col


## AS를 이용하여 별칭을 사용한다
```sql
select emp_name as "사원 명칭", salary as 급여
from employees
order by salary ;
```
* select from 프로세서 끝이 난 후 order by가 실행
* 프로세서가 한 번 더 사용 되니 속도가 떨어진다

## DML
### INSERT, UPDATE, DELETE, SELECT

## INSERT (raw단위)

## Example

### 1건의 데이터 입력
```sql
insert into table_name (col1, col2, ...) values (val, val2, ...)
insert into table_name values (val, val2, ...)
```

### 조회된 건수만큼 입력
```sql
insert into table_name (col1, col2, ...) select ...
insert into table_name select ...
```

### CREATE TABLE ex3_1
```sql
create table ex3_1(
    col1 varchar2(10) ,
	col2 number ,
	col3 date
) ;
```

### 데이터 INSERT
```sql
insert into ex3_1 (col1, col2, col3) values ('abc', 1004, sysdate) ;
insert into ex3_1 (col3, col2, col1) values ('abc', 1004, sysdate) ; -- error
insert into ex3_1 (col2) values (365) ;
```

### column 순서, data type을 아는 경우
```sql
insert into ex3_1 values ('hong', 3600, sysdate) ; 
```

### 1.급여가 10000이상인 사원만 조회
```sql
select employee_id, emp_name, salary
from employees
where salary >= 10000 ;
```

## 2.조회된 정보를 INSERT
### TABLE ex3_2
```sql
create table ex3_2 (
	emp_id number,
	emp_name varchar2(100),
	salary number
) ;
```

### INSERT using SELECT FROM
```sql
insert into ex3_2 (emp_id, emp_name, salary)
	select employee_id, emp_name, salary
	 from employees
	 where salary >= 10000 ;
```


## ALTER
### 외래키(FOREIGN KEY) 제약조건(CONSTRAINT) 설정 
* p.65

### using ALTER
```sql
alter table employees
  add constraint fk_dept_emp_department_id
    foreign key (department_id)
      references departments(department_id) ;
```
### exam
* EMPLOYEES table에 job_id column이 있습니다
* JOBS table에 job_id column을 외래키로 설정을 하시오.
* (JOBS를 references하여 JOBS.job_id를 foreign key를 constraint 한다)

```sql
alter table EMPLOYEES
  add constraint fk_job_emp_job_id
	foreign key (job_id)
	  references JOBS(job_id) ;
```


### using UPDATE
```sql
update employees
  set job_id = 'HONG'
    where employee_id = 100
; 
```
* error가 발생한다.
* "parent key not found". 외래키 제약에 의하여

### TABLE ex2_6
```sql
create table ex2_6 (
	age number(3),
	gender varchar2(10),
	point number(5) default 0, -- 세팅을 하면 number(5) 아니면 0
	reg_date date default sysdate,
	-- constraint ck_age check(age between 0 and 100),
	constraint ck_gender check(gender in ('남', '여')),
	constraint ck_age check(age > 0 and age <= 100)
) ;
```

### INSERT test
```sql
insert into ex2_6 (age, gender, point, reg_date) values (27, '남', 30, '1999/04/16') ;
insert into ex2_6 (age, gender, point) values (27, '남', 30) ;
insert into ex2_6 (age, gender) values (25, '여') ;
insert into ex2_6 (age, gender) values (200, '여') ; -- error age colimne
insert into ex2_6 (age, gender) values (45, '남') ;
insert into ex2_6 (age, gender) values (25, '남자') ; -- error gender column
```


### using DROP
```sql
drop table jobs ;
```
* error:unique/primary keys in table referenced by foreign key

### cascade constraints
```sql
drop table jobs cascade constraints ;
```
* 강제 삭제(같은 명령어), p68

### TABLE ex2_10
```sql
create table ex2_10(
	col1 varchar2(10) not null ,
	col2 varchar2(10) null ,
	create_date date default sysdate
) ;
```

### INSERT
```sql
insert into ex2_10 values ('abcdefgh', 'abc', sysdate) ;
```

## using RENAME
```sql
alter table ex2_10 rename column col11 to col99 ;
```
* DBMS 마다 명령어가 조금씩 다르다



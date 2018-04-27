--
-- day-5
--

create table ex2_10 (
	col1 varchar2(10) not null,
	col2 varchar2(10) null,
	create_date date default sysdate
) ;	

insert into ex2_10 values ('abcdegh', 'abc' sysdate) ;

select * from ex2_10 ;

alter table ex2_10 rename column col99 to col11;


-- 일부 사이즈 오류
insert into ex2_10 values ('Hello World', 'malja', sysdate) ;

-- MODIFY
-- col11 varchar사이즈 10 -> 20
alter table ex2_10 modify col11 varchar(20);

-- 테이블에 데이터가 없다면 다른 타입으로 변경 가능 (LOB타입으로는 안됨)
-- 사이즈가 줄일 경우 기존 데이터 크기보다는 커야 한다.
alter table ex2_10 modify col11 varchar(8);
alter table ex2_10 modify col11 varchar(20);

alter table ex2_10 add col3 number(5) not null; -- 데이터가 존재해서 NN 오류
alter table ex2_10 add col3 number(5) default 0 not null; -- 기본값 설정으로 해결


alter table ex2_10 drop column col3 ;

alter table ex2_10 add constraint pk_ex2_10 primary key (col11) ;

alter table ex2_10 drop constraint pk_ex2_10 ;

-- sqlDev Connections 파트에서 테이블 생성 하면 코드를 치지 않고 만들 수 있다.
select * from ex2_11;


-- 테이블 복사
create table ex2_emp as
select * from employees ;

select * from ex2_emp ;


-- EXAM
-- 사원테이블에서 급여가 10000 이상인 사원을 조회해서 ex2_emp2 테이블생성
-- 사번, 사원명, 급여 
create table ex2_emp2 (emp_id, emp_name, salary) -- 컬러명을 지정 할 수 있음
as
select employee_id, emp_name, salary
	from employees 
	where salary >= 10000
;

select * from ex2_emp2 ;
-- drop table ex2_emp2;


-- EXAM
-- 사원테이블과 동일한 구조를 갖는 ex2_emp3 테이블 생성
-- 단 구조만 복제함 
create table ex2_emp3 as
select * from employees
	where 1 = 0 -- where 뒤에 false 조건이 들어가도록
;
-- 실행 결과 (NN 조건도 복사) (그러나 key 제약 조건은 복사 안됨)

select * from ex2_emp3 ;

commit ;
rollback ;

-- UPDATE 
-- ex2_emp.salary에서 17000인 data의 emp_name을 'Hong'으로 salary를 10000으로 UPDATE
update ex2_emp2
	set emp_name = 'Hong' ,
		salary = 10000
where salary = 17000
;

update ex2_emp2
	set salary = 3000
where emp_name = 'Hong' 
;

-- 급여(salary)가 NULL인 사원의 급여를 3000으로 변경
update ex2_emp2
	set salary = 3000
where salary is null 	-- '= null' 이 아닌 'is null'로 사용해야한다
;	

commit ;
rollback;

delete from ex2_emp2
where salary = 10500;

delete from ex2_emp2
where salary < 10500;

select * from ex2_emp2 ;

update ex2_emp2
	set emp_name = 'Nolja'
where salary = 10000;

update ex2_emp2
	set emp_name = 'Haja'
where salary = 10000;

delete ex2_emp2 where emp_id = 204 ;

select * from ex2_emp2 ;

truncate table ex2_emp2; -- 복구는 되지 않는다. 빠르긴 하다.


insert into ex2_emp2
select employee_id, emp_name, salary
	from employees 
	where salary >= 10000
;
select * from ex2_emp2 ;

-- ROWNUM, ROWID (p110)
select rownum, rowid, emp_id, emp_name from ex2_emp2;


select rownum, rowid, emp_id, emp_name
from ex2_emp2
where rownum = 1 ; -- first row

select rownum, rowid, emp_id, emp_name
from ex2_emp2
where rownum < 5 ; -- 상위 4개만 조회

select rownum, rowid, emp_id, emp_name
from ex2_emp2
where rownum > 1 ; -- rownum 1 이 1보다 큰 가? => false

select emp_id, emp_name, salary, salary/12 as sa12
	from ex2_emp2;

-- p112
select emp_id || '-' || emp_name as emp_Id_Name, salary, salary/12 as sa12
	from ex2_emp2;

commit;

--
-- day-5 end line --
--


--
-- day-8 --
--



create table ex3_3 (
	emp_id number primary key,
	emp_name varchar2(60),
	bonus number default 0
);

insert into ex3_3 values(1, 'malja', 1000);
insert into ex3_3 values(2, 'sunja', 2000);

-- 화면에서 2, 'nolja', 3000 이라는 값이 넘어 왔어요
-- 1. 조회
select * from ex3_3 where emp_id = 2;

-- 2.1 결과가 있으면
	update ex3_3 set emp_name = 'nolja', bonus = 3000 where emp_id = 2
-- 2.2 결과가 없으면
	insert into ex3_3 values(2, 'nolja', 3000);

select 2 id, 'nolja' name , 3000 bonus from dual;


-- MERGE
-- p101

merge into ex3_3 a
	using (select 2 id, 'nolja' name, 3000 bonus from dual) b
	on (a.emp_id = b.id)
when matched then
	update set emp_name = b.name, bonus = b.bonus
when not matched then
	insert values (b.id, b.name, b.bonus);

select * from ex3_3;


-- 사원(employees) Table에서 부서코드가 80이고 급여(salary)가 8000이상인 부서의 사번(emp_id), 사원명(emp_name)
-- 조회해서 ex3_3 Table에 입력
insert into ex3_3 (emp_id, emp_name)
select employee_id, emp_name
from employees
where department_id = 80
and salary >= 8000 ;


-- 사원(employees) Table에서 관리자사번(manager_id) 148인 정보를 입력
-- ex3_3에 이미 존재하는 경우, 보너스 = 급여 * 커미션을 곱한 값으로
--				존재하지X 경우, 보너스 = 3000

-- 
select employee_id, emp_name, salary, commission_pct
from employees
where manager_id = 148 ;

-- lookup
select * from ex3_3;

-- merge query
merge into ex3_3 a
	using (select employee_id, emp_name, salary, commission_pct
            from employees
            where manager_id = 148) b
        on (b.employee_id = a.emp_id)
when matched then
	update set bonus = b.salary * b.commission_pct
when not matched then
	insert (emp_id, emp_name, bonus) values (b.employee_id, b.emp_name, 3000)
;


-- [4장 함수] p126


-- 숫자 함수 (ABS, CEIL, FLOOR)

select abs(10), abs(-12.45) from dual;
select abs(10), abs(-12.45) from employees;

select ceil(10.000001), ceil(10.9) from dual;
select ceil(-10.000001), ceil(-10.9) from dual;

select floor(10.000001), floor(10.9) from dual;

select round(145.154), round(145.154, 1), round(145.154, 2), round(145.154, -1) from dual;

select trunc(145.154), trunc(145.154, 1), trunc(145.154, 2), trunc(145.154, -1) from dual;

-- 사원(employees) Table에서, 사번(employee_id), 사원명(emp_name), 급여(salary),
-- 급여/12(as 월급여), 급여/12(as 월급여2) 소숫점 2번째까지 반올림(round()) 표현
select employee_id, emp_name, salary/12 as 월급여, round(salary/12, 2) as 월급여2
from employees;

-- 사번, 사원명 월급여
-- 단 월급여가 200에서 300
select employee_id, emp_name, round(salary/12) as 월급여
from employees
where round(salary/12) between 200 and 300
;

--
select employee_id, emp_name, round(salary/12) as 월급여
from employees
where round(salary/12) between 200 and 300
;

-- POWER SQRT MOD REMAINDER
select power(3, 2), power(3, 3) from dual;
select sqrt(2),  sqrt(9) from dual;
select mod(19, 4), remainder(19, 4) from dual;

commit;


-- INITCAP LOWER UPPER
-- p130
select emp_name, initcap(emp_name), lower(emp_name), upper(emp_name)
from employees
where rownum < 10
;

select * from ex3_3 where emp_name = lower('MalJA') ;

-- CONCAT SUBSTR
select concat('abc', 'def'), 'abc' || 'def' from dual;

select 'abcdefg', substr('abcdefg', 3) , substr('abcdefg', 3, 2) from dual;

select 'abcdefg', substr('abcdefg', -3) , substr('abcdefg', -3, 2) from dual;


-- 사원명에 'll'이 있는 사원조회 using LIKE
select emp_name, salary
from employees
--where emp_name like '%ll%'
where emp_name like '%' || 'll' || '%'
;

-- 사원명의 3번째에서 2글자 'll'인 사원조회 using substr
select emp_name, salary
from employees
where substr(emp_name, 3, 2) = 'll'
;


-- TRIM
-- 1.좌우의 공백을 제거 하는 풩션
select ltrim('    abcd    ') as c1, 
        rtrim('    abcd    ') as c2,
        trim('    abcd    ') as c3
from dual
;

-- 2.'-'으로 세팅
select ltrim('----ab-cd----', '-') as c1, 
        rtrim('----ab-cd----', '-') as c2,
        trim('-' from '----ab-cd----') as c3
from dual
;

commit;

--
-- day-08 end line --
--


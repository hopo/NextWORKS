--
-- Week02 , day-6
--


-- 같지 않다라는 표현 <>, !=. ^=
select * from ex3_2
where salary != 17000
--where salary <> 17000
--where salary ^= 17000
;


-- 표현식(Expression) p113
-- case (if 문 형식)
SELECT employee_id, salary,
    CASE WHEN salary <= 5000 THEN 'C'
         WHEN salary > 5000 AND salary <= 15000 THEN 'B'
         ELSE 'A'
    END AS salary_grade
FROM EMPLOYEES
;

-- case (swtich 문 형식)
-- case 비교대상(col) when '비교값' then 값
SELECT employee_id, salary, department_id,
    CASE department_id WHEN 50 THEN '배송부'
                       WHEN 10 THEN '총무기획부'
                       WHEN 20 THEN '마케팅'
                       ELSE '기타부서'
    END AS dept_name
FROM employees
;


-- 오라클 함수 중 decode(표현식, 비교1, 값1, 비교2, 값2, ... , 기본값) as값
SELECT employee_id, salary, department_id,
    decode(department_id, 50, '배송부', 10, '총무기획부', 20, '마케팅', '기타부서') dept_name
FROM employees
;


-- 비교조건식 p114
-- ANY, SOME
SELECT employee_id, salary, department_id
FROM employees
WHERE salary = ANY(2000, 3000, 4000) -- salary = (2000 or 3000 or 4000)
;

-- ALL
SELECT employee_id, salary, department_id
FROM employees
WHERE salary = ALL(2000, 3000, 4000) -- salary = (2000 and 3000 and 4000)
;

SELECT employee_id, salary, department_id
FROM employees
WHERE salary >= ANY(2000, 3000, 4000) -- salary 2000 이상
;

SELECT employee_id, salary, department_id
FROM employees
WHERE salary >= ALL(2000, 3000, 4000) -- salary 4000 이상
;


-- 논리 조건식 p116
select employee_id, salary
from employees
where not(salary >= 2500)
;


-- SEQUENCE
-- p83

-- 시퀀스 생성
create sequence seq_ex
increment by 5  -- 5씩 증가하여라
start with 10
maxvalue 100
cycle   -- maxvalue에 도달하면 다시 start로
;

-- DUAL (sysnonym)
select * from dual; -- sys 소의의 테이블, 전역적으로 사용가능하게 한 시노님(별칭)

select seq_ex.nextval from dual;
select seq_ex.currval from dual;


-- using seq_ex.NEXTVALUE
create table ex2_6b
(
    col1 number ,
    col2 varchar2(30)
);

insert into ex2_6b (col1, col2) values (1, 'Malja');
insert into ex2_6b (col1, col2) values (2, 'Soonja');

insert into ex2_6b (col1, col2) values (seq_ex.nextval, 'Nolja');
insert into ex2_6b (col1, col2) values (seq_ex.nextval, 'Haja');

select * from ex2_6b;


-- EXAM
-- 1000 부터 시작하는 시퀀스 객체를 생성해라 seq_ex2
-- 조건 1 증가 최대값 9999
create sequence seq_ex2
start with 1000
maxvalue 9999
--minvalue 1
--cycle
;


select seq_ex2.nextval from dual;
select seq_ex2.currval from dual;

commit;


-- 우선수위는 NOT, AND, OR 순 입니다.

-- 업무가 'IT_PROG' 또는 'AD_PRES' 인 사원을 조회
select EMPLOYEE_ID, EMP_NAME, SALARY, JOB_ID
from employees
--where job_id = any('IT_PROG', 'AD_PRES')
where job_id = 'IT_PROG' or job_id = 'AD_PRES'
;


-- 업무가 'IT_PROG' 또는 'AD_PRES' 이고, 급여가 5000 이하인 사원을 조회
select EMPLOYEE_ID, EMP_NAME, SALARY, JOB_ID
from employees
where (job_id = 'IT_PROG'
		or job_id = 'AD_PRES')
		and salary <= 5000
;


-- EXAM
-- 급여가 6000이상 이고 7000 이하
select EMPLOYEE_ID, EMP_NAME, SALARY, JOB_ID
from employees
where salary >= 6000 and salary <= 7000
;

-- using between A and B (and 조건을 변환), (주로 사용은 숫자 또는 날짜)
select EMPLOYEE_ID, EMP_NAME, SALARY, JOB_ID
from employees
where salary between 6000 and 7000
;

-- EXAM
--  업무가 'MK_REP' 또는 'IT_PROG' 또는 'AD_PRES' 인 사원을 조회
select EMPLOYEE_ID, EMP_NAME, SALARY, JOB_ID
from employees
where job_id = 'IT_PROG'
	OR job_id = 'AD_PRES'
	OR job_id = 'MK_REP'
;

-- using IN (or 조건을 변환)
select EMPLOYEE_ID, EMP_NAME, SALARY, JOB_ID
from employees
where job_id in ('MK_REP', 'IT_PROG', 'AD_PRES')
;


--
-- day-6 end line --
--

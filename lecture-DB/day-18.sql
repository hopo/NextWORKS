--
-- day-18 --
-- 

-- 집계함수(Aggregate Function), Sub Query
-- UPDATE SET, MERGE INTO
-- Data Dictionary
-- - - -


-- ### exA)
-- 상위부서가 기획부(90)인 사원들의 부서별, 평균급여를 구하라
-- (60, 70, 100, 110)
select department_id, round(avg(salary), 2)
from employees 
where department_id in (60, 70, 100, 110)
group by department_id ;

-- ### exA2)
select department_id, round(avg(salary), 2)
from employees 
where department_id in (select department_id from departments where parent_id = 90)
group by department_id ;


-- ### exB)
-- 상위부서가 기획부(90)인 사원들의  급여를 해당 부서의 평균급여를 구하라

update employees a
set salary = (
    select sal
    from (
        select department_id, avg(salary) as sal
        from employees 
        where department_id in (select department_id from departments where parent_id = 90)
        group by department_id
    ) b
    where a.department_id = b.department_id
)
where department_id in (select department_id from departments where parent_id = 90);
-- inline-view : from 절의 안 쿼리


-- ### exB2)
update employees a
set salary = b.sal
from (
    select department_id, avg(salary) as sal
    from employees 
    where department_id in (select department_id from departments where parent_id = 90)
    group by department_id
) b
where a.department_id = b.department_id ;
-- 오라클은 update 구문에 from 절을 사용 안함
-- MERGE를 사용 해야 함..


-- ## exB3) MERGE
merge into employees a
using (
    select department_id, avg(salary) as sal
    from employees 
    where department_id in (select department_id from departments where parent_id = 90)
    group by department_id
) b
on (a.department_id = b.department_id)
when matched then update set a.salary = b.sal ;



-- EXAM)

-- exA)
-- 사원정보를 조회해 주세요
-- 사번, 사원명, 급여, 부서코드별 해당 부서의 평균 급여
-- 해당 부서의 평균 급여: select 절의 서브쿼리로
select a.employee_id, a.emp_name, a.salary, a.department_id,
    (select round(avg(salary), 2) from employees where department_id = a.department_id) as dep_avg
from employees a ;

-- exA2)
select distinct  a.department_id,
    (select round(avg(salary), 2) from employees where department_id = a.department_id) as dep_avg
from employees a ;

-- exB)
-- 부서별 최고급여, 최저급여, 평균급여를 조회하라
select department_id, max(salary), min(salary), round(avg(salary), 2)
from employees
group by department_id ;


-- exC)
-- 사번, 사원명, 급여, 부서코드
-- 해당 부서의 평균 급여, 최대급여, 최저급여
select a.employee_id, a.emp_name, a.salary, a.department_id,
    b.max_sal, b.min_sal, b.avg_sal
from employees a,
    (select department_id, max(salary) max_sal, min(salary) min_sal, round(avg(salary), 2) avg_sal
    from employees
    group by department_id) b
where a.department_id = b.department_id ;



-- - - -
-- ## DATA DICTIONARY
-- pdf236
-- 탐색
-- 01
select *
from dictionary
where table_name like 'USER%' ;

-- 02
select * from all_tables ;

-- 03
select * from user_tables ;

-- 04
select * from tabs ;

-- 05
select * from user_tab_cols ;


-- exA)
-- user_tab_cols 에서 사원정보(employees) 테이블을 검색
-- 컬럼명, 데이터타입, 길이, nullable, 컬럼순서를 조회
select column_name, data_type, data_length, column_id, nullable
from user_tab_cols
where table_name = 'EMPLOYEES';


-- 탐색
select * from user_views ;
select * from user_constraints ;
select * from user_tab_cols ;
select * from user_col_comments ;

-- exB)
-- user_tab_cols, user_col_comments 를 활용해서
-- 사원테이블(employees)의 컬럼명, 타입, 널허용여부, 컬럼순서, 코멘트(comments)를 조회
select a.column_name, a.data_type, a.nullable, a.column_id,
    b.comments
from user_tab_cols a, user_col_comments b
where a.column_name = b.column_name
    and a.table_name = 'EMPLOYEES' 
    and b.table_name = 'EMPLOYEES' ;

-- exB2)
select a.column_name, a.data_type, a.nullable,  a.column_id,
    b.comments
from user_tab_cols a, user_col_comments b
where a.table_name = 'EMPLOYEES'
    and a.column_name = b.column_name
    and a.table_name = b.table_name ; 
    






COMMIT ;

--
-- day-18 end line -
--

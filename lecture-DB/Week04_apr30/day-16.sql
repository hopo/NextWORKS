--
-- day-16 --
-- ======

-- Semi Join, Anti Join, Self Join, OUTER JOIN(외부)
-- - - -


-- ## foreign key 추가
-- job_history 테이블에 관계키가 현재 존재하지 않습니다
alter table job_history
add constraint fk_jobs_job_history_job_id
    foreign key (job_id)
    references jobs(job_id) ;
    
alter table job_history
add constraint fk_dept_job_history_dept_id
    foreign key (department_id)
    references departments(department_id) ;
    
-- - - -


-- ## 세미조인
-- p177
-- 서브 커뤼를 이요해서 서브쿼리에 존재한은 데이터만 추출하는 조인

-- EXAM
-- 부서정보를 조회해 주세요
-- 단, 급여가 3000이상인 사원의 부서만 ....

-- ### exA)
select a.department_id, a.department_name
from departments a, employees b
where a.department_id = b.department_id
and b.salary >= 3000 ;
-- 82건
    
-- ### exA2) using EXIST
select a.department_id, a.department_name
from departments a
where exists(
    select 1
    from employees b
    where a.department_id = b.department_id
    and b.salary >= 3000
) ;
-- 11건


-- ### exB) using IN
select a.department_id, a.department_name
from departments a
where a.department_id in (10, 20, 50, 70) ;

-- ### exB2)
select department_id
from employees
where salary >= 3000 ;

-- ### exB3)
select a.department_id, a.department_name
from departments a
where a.department_id in (
    select department_id
    from employees
    where salary >= 3000
) ;


-- ## 안티 조인 & 쎌프 조인

-- ### exA) 사원id 198과 동일한 부서에 근무하는 사원은?
select a.emp_name, a.salary, b.department_id, b.emp_name, b.salary
from employees a, employees b
where a.employee_id = 198
and a.department_id = b.department_id ;


-- ### exB)
-- 사원 중에 Adam Fripp (employee_id = 121)이 있는데 그 사원보다 급여가 많은 사원를 조회
-- 사번, 사원명, 급여
select a.employee_id, a.emp_name, a.salary,
    b.employee_id, b.emp_name, b.salary
from employees a, employees b
where a.employee_id = 121
and a.salary < b.salary ;


-- ## 외부조인
-- p181

-- ### exA)
select a.department_id, a.department_name, b.employee_id, b.job_id, b.department_id
from departments a, job_history b
where a.department_id = b.department_id
order by 1 ;


-- ### exA2)
select a.department_id, a.department_name, b.employee_id, b.job_id, b.department_id
from departments a, job_history b
where a.department_id = b.department_id(+)
order by 1 ;
-- WHERE clause 데이터가 부족한 쪽 테이블에 (+)기호

-- * 외부조인 DBMS 마다 조금씩 사용법이 다릅니다.
-- * 외부조인은 ANSI를 사용하도록.
-- 오라클 : where a.col1 = b.col2(+)
-- sql server : where a.col1 += b.col2 ;


-- ### exA3) ANSI: OUTER JOIN
select a.department_id, a.department_name,
    b.employee_id, b.job_id, b.department_id
from departments a left outer join job_history b 
    on (a.department_id = b.department_id)
order by 1 ;
-- 모두 조회 하고 싶은 방향 left, right or full
-- 'outer' 는 옵션


-- ### exB) 테이블 3개 이상 경우
select a.department_id, a.department_name,
    b.employee_id, b.job_id, b.department_id,
    c.job_id
from departments a, job_history b, jobs c
where a.department_id = b.department_id(+)
and c.job_id = b.job_id(+)
order by 1 ;
-- 동시에 a 테이블, c 테이블 나올 수 없다


-- EXAM)
-- 사번, 사원명 부서명을 조회
-- 단, 모든 사원이 나와야 합니다

-- exA)
select a.employee_id, a.emp_name, b.department_name, c.job_title
from employees a, departments b, jobs c
where a.department_id = b.department_id
and a.job_id = c.job_id
order by 1 ;

-- exB) 외부 조인 : in oracle
select a.employee_id, a.emp_name, b.department_name, c.job_title
from employees a, departments b, jobs c
where a.department_id = b.department_id(+)
and a.job_id = c.job_id(+)
order by 1 ;

-- exB2) ANSI : OUTER JOIN
select a.employee_id, a.emp_name, b.department_name, c.job_title
from employees a
    left outer join departments b on (a.department_id = b.department_id)
    left outer join jobs c on (a.job_id = c.job_id)
order by 1 ;


-- exC) 
select a.employee_id, a.emp_name, b.department_name, c.job_title
from employees a, departments b, jobs c
where a.department_id = b.department_id(+)
and a.job_id = c.job_id(+)
and b.department_id in (10, 20, 30)
order by 1 ;
-- 외부조인을 하면 대상 테이블이 다 나오지만, 조건은 조건입니다.


-- ## FULL OUTER JOIN
-- 예제를 위한 table hong_a hong_b
create table hong_a (emp_id number) ;
create table hong_b (emp_id number) ;
insert into hong_a values(10);
insert into hong_a values(20);
insert into hong_a values(40);
insert into hong_b values(10);
insert into hong_b values(20);
insert into hong_b values(30);

-- ### inner, left, right, full
select a.emp_id, b.emp_id
from hong_a a inner join hong_b b on (a.emp_id = b.emp_id) ;

select a.emp_id, b.emp_id
from hong_a a left join hong_b b on (a.emp_id = b.emp_id) ;

select a.emp_id, b.emp_id
from hong_a a right join hong_b b on (a.emp_id = b.emp_id) ;

select a.emp_id, b.emp_id
from hong_a a full join hong_b b on (a.emp_id = b.emp_id) ;



COMMIT ;

--
-- day-16 end line --
--

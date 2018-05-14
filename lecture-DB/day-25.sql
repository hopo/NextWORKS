-- DAY-25 
-- ======

-- ### 기타함수: FIRST, LAST
-- * 기간별, 지역별, 대출잔액을 기반으로 해서 대출 최대 지역, 최소 지역
with t1 as (
            select period, region, sum(loan_jan_amt) jan_amt
            from kor_loan_status
            group by period, region
            )
select period, max(jan_amt), sum(jan_amt),
    max(region) keep(dense_rank first order by jan_amt) 최소지역,
    min(region) keep(dense_rank last order by jan_amt) 최대지역
from t1 
group by period ;
-- * max(), min()의 의미보다 dense_rank의 뒤 first, last의 의미가 더욱 중요

-- ### EXAM)
-- ### exA)
-- * 부서별 부서 id, 최대 급여, 총 급여를 조회,
-- * 추가적으로 최대급여 사원아이디 사원명
-- * 그룹내에서 임의컬름을 기준으로 정렬된 정보 중 처음/마지막 정보를 조회
select department_id, max(salary), sum(salary),
    max(department_id) keep(dense_rank last order by salary) 사원아이디,
    max(emp_name) keep(dense_rank last order by salary) 사원명
from employees
group by department_id;
-- * keep(): `salary`를 내림차순으로 oreder by 한 dense_rank의 last


-- ### RATIO_TO_REPORT()
select employee_id, emp_name, salary, department_id,
    ratio_to_report(salary) over() r1,
    round(ratio_to_report(salary) over(partition by department_id) * 100, 2) r2
from employees
where department_id in (30, 60);


-- ### 다중 테이블 INSERT
-- * p247

-- ### exA)
-- * employees Table에서 부서가 30인 사원을 ex7_3, ex7_4 테이블에 insert 하라
-- 예제를 위한 테이블 생성
create table ex7_3 (
    emp_id number,
    emp_name varchar2(100)
);

create table ex7_4 (
    emp_id number,
    emp_name varchar2(100)
);

-- INSERT
insert all
    into ex7_3 values(employee_id, emp_name)
    into ex7_4 values(employee_id, emp_name)
select employee_id, emp_name
from employees
where department_id = 30 ;

-- 확인
select * from ex7_3;
select * from ex7_4;



-- ### exB)
-- * 30부서는 ex7_3, 90번 부서는 ex7_4
-- * WHEN clause 를 이용하여 multi-raw insert

-- 이번 예제를 위해 truncate
truncate table ex7_3 ;
truncate table ex7_4 ;

-- insert
insert all
    when department_id = 30 then
        into ex7_3 values(employee_id, emp_name)
    when department_id = 90 then
        into ex7_4 values(employee_id, emp_name)
select employee_id, emp_name, department_id
from employees ;

-- 확인
select * from ex7_3;
select * from ex7_4;
    

-- ### exC)
-- * 30 부서가 사원을 대상으로 사번이 116 보다 작으면 ex7_3
-- * 끕여가 5000 보다 작으면 ex7_4

-- 이번 예제를 위해 truncate
truncate table ex7_3 ;
truncate table ex7_4 ;

-- INSERT FIRST
insert first
    when employee_id < 116 then
        into ex7_3 values(employee_id, emp_name)
    when salary < 5000 then
        into ex7_4 values(employee_id, emp_name)
select employee_id, emp_name, department_id, salary
from employees
where department_id = 30;

-- 확인
select * from ex7_3;
select * from ex7_4;
-- * all: 조건에 만족하면 모두 insert된다
-- * first: 첫번째 조건에 만족하는 곳에만 insert 된다

-- ### exA)
-- * p246. 대출상태 Table에서 월별 매출잔액이 최소인 지역과, 최대인 지역을 조회
with t1 as (
    select period, region, sum(loan_jan_amt) jan_amt
    from kor_loan_status
    group by period, region
)
select a.period, 
    min(a.region) keep(dense_rank first order by jan_amt) mn_reg,
    min(jan_amt) mn_amt,
    max(a.region) keep(dense_rank last order by jan_amt) mx_reg,
    max(jan_amt) mn_amt
from t1 a
group by a.period ;

-- ### exB)
-- * p245. WITH를 사용한 샘플코드를 실행

-- ### Self-Check
-- * p256
-- ### 문제2)
-- * 퇴사일자는 입사일 기준으로 다음사람의 입사일자로 설정해 주어라
select employee_id, emp_name, hire_date,
    lead(hire_date) over(order by hire_date) as rt_date
from employees
where job_id = 'SH_CLERK'
order by hire_date ;

-- ### 문제5)
-- * 지역별, 대출종류별, 총 대출잔액과 지역별 파티션을 만들어
-- * 대출 종류별 대출 잔액
with t1 as (
    select region, gubun,
        sum(case period when '201111' then loan_jan_amt else 0 end) as s1,
        sum(case period when '201112' then loan_jan_amt else 0 end) as s2,
        sum(case period when '201210' then loan_jan_amt else 0 end) as s3,
        sum(case period when '201211' then loan_jan_amt else 0 end) as s4,
        sum(case period when '201212' then loan_jan_amt else 0 end) as s5,
        sum(case period when '201310' then loan_jan_amt else 0 end) as s6,
        sum(case period when '201311' then loan_jan_amt else 0 end) as s7
    from kor_loan_status
    group by region, gubun
)
select region, gubun,
    s1 || '( ' || round(ratio_to_report(s1) over (partition by region) *100) || '% )' as d1,
    s2 || '( ' || round(ratio_to_report(s2) over (partition by region) *100) || '% )' as d2,
    s3 || '( ' || round(ratio_to_report(s3) over (partition by region) *100) || '% )' as d3,
    s4 || '( ' || round(ratio_to_report(s4) over (partition by region) *100) || '% )' as d4,
    s5 || '( ' || round(ratio_to_report(s5) over (partition by region) *100) || '% )' as d5,
    s6 || '( ' || round(ratio_to_report(s6) over (partition by region) *100) || '% )' as d6,
    s7 || '( ' || round(ratio_to_report(s7) over (partition by region) *100) || '% )' as d7
from t1;



-- - - -
-- DAY-25 end line --
commit ;


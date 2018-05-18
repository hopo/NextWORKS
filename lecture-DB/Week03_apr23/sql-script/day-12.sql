--
-- day-12 --
-- ======


-- ## 집계함수(계속)

-- 사원에서 최고급여(MAX salary), 최소급여(MIN salary), 가장 최근 입사일을 구하세요
SELECT MAX(salary), MIN(salary), MAX(hire_date)
FROM employees ;

-- SUM salary
SELECT MAX(salary), MIN(salary), SUM(salary)
FROM employees ;


-- ## GROUP BY clause and HAVING clause
-- p156


-- 부서별(department_id) 최고급여, 최소급여, 총급여를 구하세요
SELECT department_id, MAX(salary), MIN(salary), SUM(salary)
FROM employees
GROUP BY department_id
ORDER BY department_id ;
-- SELECT clause에서 표기를 위해서는 department_id를 같이 조회한다


-- 부셔별 사원수, 총급여 평균급여를 조회해 주세요
SELECT department_id,
    COUNT(*), -- count(1), -- count(employee_id), SUM(1),
    SUM(salary),
    ROUND(AVG(salary), 2)
FROM employees
GROUP BY department_id
ORDER BY department_id ;


-- COUNT() SUM()의 parameter에 따라서의 값
SELECT department_id,
    COUNT(employee_id), -- PK일 경우
    COUNT(1),
    SUM(1),
    SUM(0),
    SUM(salary)
FROM employees
GROUP BY department_id
ORDER BY department_id ;


-- Table kor_loan_status
-- 2013년 지역별, 총 대출잔액을 조회
SELECT region, period, SUM(loan_jan_amt)
FROM kor_loan_status
WHERE period LIKE '2013%'
GROUP BY region, period
ORDER BY region, period ;
-- GROUP 별로 집계할 때 표기를 위해 SELECT 에 column name을 쓴다


-- 2013년 대출상태 별, 총 대출잔액, 평균 대출잔액을 조회해 주세요
SELECT gubun, SUM(loan_jan_amt), AVG(loan_jan_amt)
FROM kor_loan_status
WHERE period LIKE '2013%'
GROUP BY gubun
ORDER BY gubun ;


-- ## 집계함수의 위치!
-- WHERE AND 위치
SELECT region, period, SUM(loan_jan_amt)
FROM kor_loan_status
WHERE period like '2013%'
    AND SUM(loan_jan_amt) > 100000 -- Error
GROUP BY region, period
ORDER BY region, period ;
-- Error : "GROUP function is not allowed here"

-- using HAVING clause
-- GROUP BY 다음
SELECT region, period, SUM(loan_jan_amt)
FROM kor_loan_status
WHERE period like '2013%'
GROUP BY region, period
    having SUM(loan_jan_amt) > 100000
ORDER BY region, period ;


-- 부서별로 총급여, 사원수를 조회하세요
-- 단, 건수가 3건이상인고 평균급여가 5000이상이어야 한다
SELECT department_id, SUM(salary), COUNT(*)
FROM employees
GROUP BY department_id
    HAVING COUNT(*) > 3
        AND AVG(salary) > 5000
ORDER BY department_id ;


-- EXAM
-- 1)
-- 사원테이블에서 입사년도별 사원수, 최고급여, 최저급여 평균급여를 조회해 주세요
-- 입사일(hire_date)
select to_char(hire_date, 'YYYY'),
    count(*),
    max(salary),
    min(salary),
    round(avg(salary), 2)
from employees
group by to_char(hire_date, 'YYYY')
order by 1 ; -- to_char(hire_date, 'YYYY') ;
-- ORDER BY 1 : select clause에서 첫번째


-- 2)
-- 사원테이블에서 부서별, 입사 월별, 사원수 조회해 주세요
select department_id,
    to_char(hire_date, 'MM'),
    count(*)
from employees
group by department_id, to_char(hire_date, 'MM')
order by 1, 2 ;


-- 3)
-- 사원테이블에서 입사년, 월별, 사원수를 조회해 주세요
-- 단, 월을 행단위로 출려기 아닌 열에 표현하도록

-- using DECODE()
select department_id,
    sum(decode(to_char(hire_date, 'MM'), '01', 1, 0)) as jan,
    sum(decode(to_char(hire_date, 'MM'), '02', 1, 0)) as feb,
    sum(decode(to_char(hire_date, 'MM'), '03', 1, 0)) as mar,
    sum(decode(to_char(hire_date, 'MM'), '04', 1, 0)) as apr,
    sum(decode(to_char(hire_date, 'MM'), '05', 1, 0)) as may,
    sum(decode(to_char(hire_date, 'MM'), '06', 1, 0)) as jun,
    sum(decode(to_char(hire_date, 'MM'), '07', 1, 0)) as jul,
    sum(decode(to_char(hire_date, 'MM'), '08', 1, 0)) as aug,
    sum(decode(to_char(hire_date, 'MM'), '09', 1, 0)) as sep,
    sum(decode(to_char(hire_date, 'MM'), '10', 1, 0)) as oct,
    sum(decode(to_char(hire_date, 'MM'), '11', 1, 0)) as nov,
    sum(decode(to_char(hire_date, 'MM'), '12', 1, 0)) as dec,
    count(*)
from employees
group by department_id
order by 1 ;

-- using CASE
select department_id,
    sum(case to_char(hire_date, 'MM') when '01' then 1 else 0 end) as jan,
    sum(case to_char(hire_date, 'MM') when '02' then 1 else 0 end) as feb,
    sum(case to_char(hire_date, 'MM') when '03' then 1 else 0 end) as mar,
    sum(case to_char(hire_date, 'MM') when '04' then 1 else 0 end) as apr,
    sum(case to_char(hire_date, 'MM') when '05' then 1 else 0 end) as may,
    sum(case to_char(hire_date, 'MM') when '06' then 1 else 0 end) as jun,
    sum(case to_char(hire_date, 'MM') when '07' then 1 else 0 end) as jul,
    sum(case to_char(hire_date, 'MM') when '08' then 1 else 0 end) as aug,
    sum(case to_char(hire_date, 'MM') when '09' then 1 else 0 end) as sep,
    sum(case to_char(hire_date, 'MM') when '10' then 1 else 0 end) as oct,
    sum(case to_char(hire_date, 'MM') when '11' then 1 else 0 end) as nov,
    sum(case to_char(hire_date, 'MM') when '12' then 1 else 0 end) as dec,
    count(*) as total
from employees
group by department_id
order by 1 ;

-- for test query
select department_id,
    case to_char(hire_date, 'MM') when '01' then 1 else 0 end
from employees
where department_id = 50 ;



-- ## 집합연산자
-- p163
-- UNION, UNION ALL, INTERSECT, MINUS

-- (A)사원테이블에서 job_id = 'IT_PROG'
select employee_id, emp_name, salary
from employees
where job_id = 'IT_PROG' ; --5rows

-- (B)salary가 6000 이상
select employee_id, emp_name, salary
from employees
where salary >= 9000 ; -- 27rows

-- A union B
select employee_id, emp_name, salary from employees where job_id = 'IT_PROG' --5rows
union
select employee_id, emp_name, salary from employees where salary >= 9000 ; -- 27rows
-- (5 + 27) - 1(;중복) = 36rows
-- 정렬도 한다

-- A union all B
select employee_id, emp_name, salary from employees where job_id = 'IT_PROG' --5rows
union all
select employee_id, emp_name, salary from employees where salary >= 9000 ; -- 27rows
-- 때려 붙이기만 한다

-- A intersect B
select employee_id, emp_name, salary from employees where job_id = 'IT_PROG' --5rows
intersect
select employee_id, emp_name, salary from employees where salary >= 9000 ; -- 27rows

-- A minus B
select employee_id, emp_name, salary from employees where job_id = 'IT_PROG' --5rows
minus
select employee_id, emp_name, salary from employees where salary >= 9000 ; -- 27rows

-- B minus A
select employee_id, emp_name, salary from employees where salary >= 9000 -- 27rows
minus
select employee_id, emp_name, salary from employees where job_id = 'IT_PROG' ; --5rows 


-- ### 예제
select employee_id, emp_name as EMPLOYEE_FULL_NAME, salary from employees where job_id = 'IT_PROG'
union all
select employee_id, emp_name, null from employees where salary >= 9000
order by 3 desc ;
-- coulumn 수를 맞춘다 (using null)
-- order by의 위치는 마지막
    

COMMIT;

--
-- day-12 end line --
--

-- DAY-22
-- ======

-- ## WITH clause
-- * 226
-- * 개선된 sub query, query를 변수화 하는 형태

-- ### EXAM)
-- ### exA)
-- * 연도별, 최종월 기준 가장 대출이 많은 도시와 잔액을 조회

-- 1) 연도별 최종월을 조회
SELECT substr(
    period, 1, 4
), MAX(period)
FROM kor_loan_status a
GROUP BY substr(
    period, 1, 4
);

-- 2) 기간별, 지역별 매출액
SELECT period, region, SUM(loan_jan_amt) jan_amt
FROM kor_loan_status
GROUP BY period, region;

-- 3) 1, 2 를 이용하여 최종월 기준 잔액 조회, 그 중에서 최고잔액
SELECT b.period, MAX(jan_amt)
FROM (
    SELECT substr(
        period, 1, 4
    ) yr, MAX(period) max_period
    FROM kor_loan_status
    GROUP BY substr(
        period, 1, 4
    )
) a, (
    SELECT period, region, SUM(loan_jan_amt) jan_amt
    FROM kor_loan_status
    GROUP BY period, region
) b
WHERE a.max_period = b.period
GROUP BY b.period;

-- 4) 2, 3의 결과에서 조건에 맞는 정보 추출
SELECT a.period, a.region, a.jan_amt
FROM (
    SELECT period, region, SUM(loan_jan_amt) jan_amt
    FROM kor_loan_status
    GROUP BY period, region
) a, (
    SELECT b.period, MAX(jan_amt) max_amt
    FROM (
        SELECT substr(
            period, 1, 4
        ) yr, MAX(period) max_period
        FROM kor_loan_status
        GROUP BY substr(
            period, 1, 4
        )
    ) a, (
        SELECT period, region, SUM(loan_jan_amt) jan_amt
        FROM kor_loan_status
        GROUP BY period, region
    ) b
    WHERE a.max_period = b.period
    GROUP BY b.period
) b
WHERE a.period = b.period
      AND a.jan_amt = b.max_amt;
   
   
--
-- * 위 쿼리를 WITH clause로
WITH t1 AS (
    SELECT period, region, SUM(loan_jan_amt) jan_amt
    FROM kor_loan_status
    GROUP BY period, region
), t2 AS (
    SELECT t1.period, MAX(jan_amt) max_amt
    FROM (
        SELECT substr(
            period, 1, 4
        ) yr, MAX(period) max_period
        FROM kor_loan_status
        GROUP BY substr(
            period, 1, 4
        )
    ) a, t1
    WHERE a.max_period = t1.period
    GROUP BY t1.period
) SELECT t1.*
  FROM t1, t2
  WHERE t1.period = t2.period
        AND t1.jan_amt = t2.max_amt;
        
        
-- ### EXAM)
-- ### exA)
-- * 사번, 사원명, 급여, 부서, 해당부서의 최고급여, 평균급여
-- 탐색
SELECT employee_id, emp_name, salary, department_id
FROM employees;

-- exA)
SELECT a.employee_id, a.emp_name, a.salary, a.department_id, (
    SELECT MAX(salary)
    FROM employees
    WHERE department_id = a.department_id
) max_sal, (
    SELECT AVG(salary)
    FROM employees
    WHERE department_id = a.department_id
) avg_sal
FROM employees a;
-- exB)
SELECT a.employee_id, a.emp_name, a.salary, a.department_id, b.max_sal, b.avg_sal, (
    SELECT MAX(salary)
    FROM employees
) all_max_sal
FROM employees a, (
    SELECT department_id, MAX(salary) max_sal, AVG(salary) avg_sal
    FROM employees
    GROUP BY department_id
) b
WHERE a.department_id = b.department_id;

-- exC) WITH clause
WITH t1 AS (
    SELECT department_id, MAX(salary) max_sal, AVG(salary) avg_sal
    FROM employees
    GROUP BY department_id
), t2 AS (
    SELECT MAX(t1.max_sal) all_max_sal
    FROM t1
) SELECT a.employee_id, a.emp_name, a.salary, a.department_id, t1.max_sal, t1.avg_sal, t2.all_max_sal
  FROM employees a, t1, t2
  WHERE t1.department_id = a.department_id;
  
  
-- ## recursive subquery
-- * p229
-- exA)
WITH recur (
    department_id, parent_id, department_name, lvl
) AS (
    SELECT department_id, parent_id, department_name, 1 lvl
    FROM departments
    WHERE parent_id IS NULL -- start with에 해당
    UNION ALL
    SELECT a.department_id, a.parent_id, a.department_name, b.lvl + 1 lvl
    FROM departments a, recur b
    WHERE a.parent_id = b.department_id -- connect by prior department_id = parent_id
) SELECT department_id, lpad(
    ' ', (lvl - 1) * 3
) || department_name, lvl
  FROM recur;

-- ### using DEPTH FIRST BY
-- * p230
-- * sql-server에서
WITH recur (
    department_id, parent_id, department_name, lvl
) AS (
    SELECT department_id, parent_id, department_name, 1 lvl
    FROM departments
    WHERE parent_id IS NULL -- start with에 해당
    UNION ALL
    SELECT a.department_id, a.parent_id, a.department_name, b.lvl + 1 lvl
    FROM departments a, recur b
    WHERE a.parent_id = b.department_id -- connect by prior department_id = parent_id
)
    SEARCH DEPTH FIRST BY department_id SET order_seq -- by column은 정렬의 역할
SELECT department_id, lpad(
    ' ', (lvl - 1) * 3
) || department_name, lvl
FROM recur;

--
-- ## 분석함수(Analytic function)와 window 함수
-- * p231
-- * OVER가 들어가면 분석함수라고 생각하라(표준)

-- OVER()를 이용하여 집계함수(Aggregate function) 조회
-- * 사번, 사원명, 급여, 부서 조회, 최소급여, 최고급여, 총급여, 평균, 건수
-- exA)
SELECT employee_id, emp_name, salary, department_id,
    MIN(salary) OVER(), MAX(salary) OVER(), SUM(salary) OVER(),
    AVG(salary) OVER(), COUNT(salary) OVER()
FROM employees;

-- exB) OVER()에 parameter로 (PARTITION BY ~)
SELECT employee_id, emp_name, salary, department_id,
    SUM(salary) OVER() AS tot_sal,
    SUM(salary) OVER(PARTITION BY department_id) AS dep_tot_sal,
    MAX(salary) OVER()
FROM employees;

--
-- - - -
-- DAY-22 end line
COMMIT;
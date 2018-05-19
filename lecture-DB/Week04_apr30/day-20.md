DAY-20
======
- - -

...ing
- - -

### 복잡한 쿼리?
1. 최종적으로 조회되는 결과 항목을 정의한다
2. 필요한 테이블과 컬럼을 파악하나
3. 작은 단위로 분할해서 쿼리를 작성한다
4. 분할한 단위의 쿼리를 하나로 합쳐 최종 결과를 산출한다
5. 결과를 검증한다.

-- ### exA)
-- * 2000년도 이탈리아 평균매출액보다 큰 월평균매출액을 조회

-- #### 필요한 컬럼을 탐색
SELECT *
  FROM sales; -- cust_id, sales_month, amount_sold
SELECT *
  FROM customers; -- cust_id, country_id
SELECT *
  FROM countries; -- country_id, country_name

-- #### JOIN
-- * 월평균 매출액
SELECT round(AVG(a.amount_sold), 2) AS month_avg
  FROM sales a,
       customers b,
       countries c
 WHERE a.cust_id = b.cust_id
   AND b.country_id = c.country_id
   AND c.country_name = 'Italy'
   AND a.sales_month LIKE '2000%'
 GROUP BY a.sales_month;

-- * 연평균 매출액
SELECT round(AVG(a.amount_sold), 2) AS year_avg
  FROM sales a,
       customers b,
       countries c
 WHERE a.cust_id = b.cust_id
   AND b.country_id = c.country_id
   AND c.country_name = 'Italy'
   AND a.sales_month LIKE '2000%';

-- * 위 두 쿼리들을 인라인view로 사용
-- * month_avg(view) a, year_avg(view) b
SELECT a.month_avg,
       b.year_avg
  FROM (
    SELECT round(AVG(a.amount_sold), 2) AS month_avg
      FROM sales a,
           customers b,
           countries c
     WHERE a.cust_id = b.cust_id
       AND b.country_id = c.country_id
       AND c.country_name = 'Italy'
       AND a.sales_month LIKE '2000%'
     GROUP BY a.sales_month
) a,
       (
    SELECT round(AVG(a.amount_sold), 2) AS year_avg
      FROM sales a,
           customers b,
           countries c
     WHERE a.cust_id = b.cust_id
       AND b.country_id = c.country_id
       AND c.country_name = 'Italy'
       AND a.sales_month LIKE '2000%'
) b
 WHERE a.month_avg > b.year_avg;

-- search
SELECT *
  FROM countries;
SELECT *
  FROM sales;
SELECT *
  FROM customers;
SELECT *
  FROM employees;

-- ### EXAM)
-- ### exA)
-- * 2001년 국가별(country_id, country_name), 총매출액(sum(amount_sold)), 평균매출액(avg(amount_sold))
-- *출력예) Spain, 2342343, 106
SELECT c.country_id,
       c.country_name,
       round(SUM(a.amount_sold), 2) total_sold,
       round(AVG(a.amount_sold), 2) avg_sold
  FROM sales a,
       customers b,
       countries c
 WHERE a.cust_id = b.cust_id
   AND b.country_id = c.country_id
   AND a.sales_month LIKE '2001%'
 GROUP BY c.country_id,
          c.country_name;

-- ### exB)
-- * 2001년 사원별(employee_id, emp_name), 급여(salary), 부서(department_id),
-- * 총매출액(sum(amount_sold)), 평균매출액(avg(amount_sold))
-- Eleni Zlotkey, 2443736, 130
SELECT b.employee_id,
       b.emp_name,
       b.salary,
       b.department_id,
       round(SUM(a.amount_sold), 2) total_sold,
       round(AVG(a.amount_sold), 2) avg_sold
  FROM sales a,
       employees b
 WHERE a.employee_id = b.employee_id
   AND a.sales_month LIKE '2001%'
 GROUP BY b.employee_id,
          b.emp_name,
          b.salary,
          b.department_id;
    
    

-- - - -
-- ## [7장 고급쿼리 다루기]
-- *p208

-- ## 계층형 쿼리 Hierarchical Query
-- ### exA)
-- level 1 (root)
SELECT 1 AS levels,
       department_id,
       department_name
  FROM departments
 WHERE parent_id IS NULL
UNION
-- level 2
SELECT 2 AS levels,
       t2.department_id,
       t2.department_name
  FROM departments t1,
       departments t2 -- self-join: departments and departments
 WHERE t1.parent_id IS NULL
   AND t1.department_id = t2.parent_id;
    
-- ### exA2)
-- * START WITH 를 이용하여
SELECT level,
       department_name,
       department_id,
       parent_id
  FROM departments START WITH
    parent_id IS NULL -- Start node (root)
CONNECT BY
    PRIOR department_id = parent_id; -- 앞선 데이터(department_id)와 같은 것
    
-- ### exA3)
-- * START WITH 를 이용하여 (department_id <- parent_id)
SELECT level,
       lpad(' ', (level - 1) * 2)
       || department_name,
       department_id,
       parent_id
  FROM departments START WITH
    parent_id IS NULL -- Start node (root)
CONNECT BY
    PRIOR department_id = parent_id; -- 앞선 데이터(department_id)와 같은 것
    
    
-- ### EXAM)
-- ### exA)
-- 사원들의 계층구조(employee_id <- manager_id)를 만들어 주세요
SELECT employee_id,
       lpad('|', (level - 1) * 2)
       || emp_name,
       salary,
       manager_id,
       department_id
  FROM employees START WITH
    manager_id IS NULL
CONNECT BY
    PRIOR employee_id = manager_id;

-- ### exA2)
SELECT a.employee_id,
       lpad('|', (level - 1) * 2)
       || a.emp_name,
       a.salary,
       a.manager_id,
       a.department_id,
       b.department_name
  FROM employees a,
       departments b
 WHERE a.department_id = b.department_id START WITH
    a.manager_id IS NULL
CONNECT BY
    PRIOR a.employee_id = a.manager_id;

-- ### 계층 쿼리에서 정렬
-- * p215
-- ### exA)
-- * 계층형 구조에서는 굳이 ORDER BY 할 필요가 없다 (전체의 정렬이 된다)
SELECT level,
       lpad(' ', (level - 1) * 2)
       || department_name,
       department_id,
       parent_id
  FROM departments START WITH
    parent_id IS NULL -- Start node (root)
CONNECT BY
    PRIOR department_id = parent_id
 ORDER BY department_name;

-- ### exA2)
-- * 꼭 필요시, ORDER SIBLINGS BY. 
SELECT level,
       lpad(' ', (level - 1) * 2)
       || department_name,
       department_id,
       parent_id
  FROM departments START WITH
    parent_id IS NULL -- Start node (root)
CONNECT BY
    PRIOR department_id = parent_id
 ORDER SIBLINGS BY department_name;
 
-- ### exA3)
-- CONNECT_BY_ROOT를 이용하여 root 조회
SELECT level,
       lpad(' ', (level - 1) * 2)
       || department_name,
       department_id,
       parent_id,
       CONNECT_BY_ROOT department_name
  FROM departments START WITH
    parent_id IS NULL -- Start node (root)
CONNECT BY
    PRIOR department_id = parent_id
 ORDER SIBLINGS BY department_name;


- - -
-- DAY-20 end lilne --



-- 제출 과제 2 --
-- sql --

-- [1]
CREATE TABLESPACE ts_study datafile '/u01/app/oracle/oradata/XE/ts_study.dbf'
size 100M autoextend ON next 5M;


-- [2]
CREATE USER java2 IDENTIFIED BY oracle
DEFAULT tablespace TS_STUDY
TEMPORARY tablespace TEMP;


-- [3]
GRANT CONNECT, RESOURCE TO java2;


-- [4]
create table ex_emp (
    emp_id NUMBER(6) NOT NULL,
    emp_name VARCHAR2(30) NOT NULL,
    dept_id NUMBER(6),
    salary NUMBER(8, 2) DEFAULT 0,
    reg_date DATE DEFAULT SYSDATE,
    CONSTRAINT pk_emp_id PRIMARY KEY(EMP_ID)
);


-- [5]
ALTER TABLE ex_emp MODIFY emp_name VARCHAR(80);


-- [6]
CREATE SEQUENCE seq_code
START WITH 1000
MAXVALUE 9999
CYCLE;


-- [7]
INSERT INTO ex_emp (emp_id, emp_name, dept_id, reg_date)
VALUES (1, '홍길동', 30, sysdate);


-- [8]
INSERT INTO ex_emp (emp_id, emp_name, dept_id, salary)
SELECT employee_id, emp_name, department_id, salary
FROM employees
WHERE department_id in (30, 80) ;


-- [9]
DELETE from ex_emp where emp_name LIKE 'A%';


-- [10]
SELECT employee_id, emp_name, department_id, salary
FROM employees
WHERE department_id = 100
AND salary between 7000 and 10000
ORDER BY salary DESC;


-- [11]
SELECT employee_id, emp_name, salary
FROM employees
WHERE salary = 2600
OR salary = 3000
OR salary = 5000;


-- [12]
SELECT to_char(hire_date,'YYYY') hire_year,
	   count(1) emp_cnt,
       max(salary) max_sal,
       round(avg(salary)) avg_sal
FROM employees
GROUP BY to_char(hire_date, 'YYYY')
HAVING count(1) <= 10;


-- [13]
SELECT a.employee_id, a.emp_name, a.department_id, a.salary, b.department_name
FROM employees a, departments b
WHERE a.department_id = b.department_id;


-- [14]
SELECT a.employee_id, a.emp_name, a.department_id, a.salary, b.department_name
FROM employees a INNER JOIN departments b ON a.department_id = b.department_id;


-- 제출 과제 2  end line --


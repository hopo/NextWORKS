
-- [1]
CREATE tablespace study datafile '/u01/app/oracle/oradata/XE/ts_study.dbf'
size 100M autoextend next 5M;


-- [2]
CREATE USER java2 IDENTIFIED BY oracle
DEFAULT tablespace TS_STUDY
TEMP tablespace TEMP;


-- [3]
GRANT CONNECT, RESOURCE TO java2;


-- [4]
create table ex_emp (
    emp_id NUMBER(6) NOT NULL,
    emp_name VARCHAR2(30) NOT NULL,
    dept_id NUMBER(6),
    salary NUMBER(8, 2) DEFAULT 0,
    reg_date DATE DEFAUTL SYSDATE,
    CONSTRAINT pk_emp_id PRIMARY KEY(EMP_ID)
);

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
select employee_id, employee_name, department_id, salary
from employees
where department_id in (30, 80) ;


-- [9]
delete from ex_emp where emp_name LIKE 'A%';


-- [10]
select employee_id, emp_name, department_id, salary
from employees
where department_id = 100
and salary >= 7000
and salary <= 10000
order by salary desc;


-- [11]
select employee_id, emp_name, salary
from employees
where salary = 2600
or salary = 3000
or salary = 5000;


-- [12]
select to_char(hire_date, 'YYYY') hire_year,
	   count(1) emp_cnt, max(salary) max_sal, round(avg(salary), 2) avg_sal
from employees
group by to_char(hire_date, 'YYYY')
where rownum >=10;


-- [13]
select a.employee_id, a.emp_name, a.department_id, a.salary, b.department_name
from employees a, departments b
where a.department_id = b.department_id;

-- [14]
select a.employee_id, a.emp_name, a.department_id, a.salary, b.department_name
from employees a inner join departments b on a.department_id = b.department_id;








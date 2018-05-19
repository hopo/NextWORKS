DAY-15
======
- - -

* EQUI-JOIN, ANSI INNER JOIN
- - -

### EQUI-JOIN, ANSI INNER JOIN
* p184

### exA)
```sql
select employee_id, emp_name, salary, department_id
from employees ;
```

### exB)
* exA에 EQUI-JOIN (모든 DBMS 사용 가능)
```sql
select a.employee_id, a.emp_name, a.salary, a.department_id,
    b.department_name
from employees a, departments b
where a.department_id = b.department_id
and a.salary >= 9000 ;
```

### exB2)
* ANSI INNER JOIN (사용빈도수는 EQUI-JOIN이 더 많음)
```sql
select a.employee_id, a.emp_name, a.salary, a.department_id,
    b.department_name
from employees a inner join departments b
on a.department_id = b.department_id
where a.department_id = b.department_id
and a.salary >= 9000 ;
```
* 조인 조건이 WHERE clause가 아닌 FROM clause에 들어간다


### EXAM
### exA)
* 입사월이 7월인 사원을 조회해 주세요
* 사번, 사원명, 급여, 입사일, 업무코드, 업무명
```sql
-- EQUI-JOIN
select A.employee_id, A.emp_name, A.salary, A.hire_date, A.job_id, B.job_title
from employees A, jobs B 
where A.job_id = B.job_id
and to_char(A.hire_date, 'MM') = '07';

-- ANSI INNER JOIN
select A.employee_id, A.emp_name, A.salary, A. hire_date, A.job_id, B.job_title
from employees A inner join jobs B
on A.job_id = B.job_id
where to_char(A.hire_date, 'MM') = '07';
```

### exB)
* 급여가 9000이상인 사원을 조회
* 사번, 사원명, 급여, 부서명, 업무명

```sql
-- EQUI-JOIN
select A.employee_id, A.emp_name, A.salary,
    B.department_id, B.department_name,
    C.job_title
from employees A, departments B, jobs C
where A.department_id = B.department_id
and A.job_id = C.job_id
and A.salary >= 9000 ;
    
-- ANSI INNER JOIN
select A.employee_id, A.emp_name, A.salary,
    B.department_id, B.department_name,
    C.job_title
from employees A
inner join departments B on A.department_id = B.department_id
inner join jobs C on A.job_id = C.job_id
where A.salary >= 9000 ;
```


### exC)
* 이력 테이블에서
* 사번, 시작일, 종료일, 업무명, 부서명

```sql
-- EQUI-JOIN
select A.employee_id, A.start_date, A.end_date, A.job_id,
    B.job_id,
    C.department_name
from job_history A, jobs B, departments C
where A.job_id = B.job_id
and A.department_id = C.department_id ;

-- ANSI INNER JOIN
select A.employee_id, A.start_date, A.end_date,
    B.job_id,
    C.department_name
from job_history A
inner join jobs B on A.job_id = B.job_id
inner join departments C on A.department_id = C.department_id ;
```



- - - 
-- day-15 end line --


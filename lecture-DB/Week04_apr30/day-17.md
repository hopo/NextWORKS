DAY-17
======
- - -

* EXIST, IN
* (Correlated | Un-Correlated) Subquery
- - -


## Subquery
* p191

* 연관 서브쿼리 (메인쿼리의 정보를 사용하는 경우)
* 비연관 서브쿼리 (메인쿼리의 정보를 사용하지 않는 경우)

### exA)
```sql
select employee_id, emp_name, salary, job_id,
    (select job_title from jobs b where b.job_id = a.job_id)
from employees a
where salary > 10000 ;

-- cf)
-- select job_title from jobs where job_id = 'MK_MAN' ;
```

### exA2)
* exA 를 equi-join으로
```sql
select a.employee_id, a.emp_name, a.salary, a.job_id, b.job_title
from employees a, jobs b
where a.job_id = b.job_id
and salary > 10000 ;
```

### exB)
* 급여가 10000 이상인 사원정보를
* 사번, 사원명, 급여, 부서코드 ,부서명 으로 조회해라

* sub-query
```sql
select employee_id, emp_name, department_id,
    (select department_name from departments b where b.department_id = a.department_id)
from employees a
where salary >= 10000 ;
```


### exB2)
* equi-join
```sql
select a.employee_id, a.emp_name, a.department_id,
    b.department_name
from employees a, departments b
where b.department_id = a.department_id
    and salary >= 10000 ;
```
* select 절의 sub-query, 그 결과가 꼭 한개가 나옵니다. (열1, 행1)
* alias를 꼭 정의

### exC)
* 사번, 사원명, 급여, 업무명, 업무의 최소급여, 업무의 최대급여
```sql
select employee_id, emp_name, salary, job_id,
    (select job_title from jobs b where b.job_id = a.job_id) job_title,
    (select min_salary from jobs b where b.job_id = a.job_id) min_salary,
    (select max_salary from jobs b where b.job_id = a.job_id) max_salary
from employees a where salary >= 10000 ;
```

### exD)
```sql
select a.employee_id, a.emp_name, a.salary, a.job_id,
    b.job_title
from employees a, jobs b
where a.job_id = b.job_id
and salary > 10000 ;
```

### exE)
* select절 서브쿼리로 이용하여
```sql
select avg(salary) from employees ; -- 6461.83

select a.employee_id, a.emp_name, a.salary
from employees a
where a.salary > (select avg(salary) from employees) ;
```

### EXAM
### exA)
* 최고급여를 받는 사원은 누구?
```sql
select a.employee_id, a.emp_name, a.salary
from employees a
where a.salary = (select max(salary) from employees) ;
```


###  IN과 sub-query
### exB)
* 급여를 10000 이상 받는 사원들의 부서정보 쿼리를
```sql
select distinct department_id
from employees
where salary > 10000 ;

-- IN
select * from departments
where department_id
in (select distinct department_id from employees where salary > 10000) ;
```
    
    
### exC)
```sql
select employee_id, emp_name, job_id, department_id
from employees
where (employee_id, department_id)
in (select employee_id, department_id from job_history) ;
```
* 동시 만족

### exC2)
* exC와 비교 (-> 비슷한 면은 있지만 의미는 다름)
```sql
select employee_id, emp_name, job_id, department_id
from employees
where employee_id in (select employee_id from job_history)
and department_id in (select department_id from job_history) ;
```
* A 만족 그리고 B 만족


### exD)
* 사원을 조회. 사번, 사원명, 급여, 업무명, 부서명을 equi-join
```sql
select a.employee_id, a.emp_name, a.salary,
    b.job_title,
    c.department_name
from employees a, jobs b, departments c
where a.job_id = b.job_id
and a.department_id = c.department_id ;
```

### exD2)
* exD를 서브쿼리로
```sql
select a.employee_id, a.emp_name, a.salary,
    (select job_title from jobs b where a.job_id = b.job_id) as job_tit,
    (select department_name from departments c where a.department_id = c.department_id) as dpt_name
from employees a
where a.department_id is not null ;
```


## (Correlated | Un-Correlated) Subquery
* p194

### exE)
* using EXIST (연관쿼리)
* 업무 이력테이블에서 사용되는 부서정보를 조회
```sql
select * from departments a
where exists ( select * from job_history b where a.department_id = b.department_id ) ;
```
* EXISTS 는 NN이면 true 반환.
* 하나의 행이 걸리면 (내부의 다음 레코드들, 하위결과들을) 검색 필요가 없다.
* 다른 연산자를 사용하나느 것 보다 빠르게 동작한다

### exE2)
* IN을 사용하여
```sql
select * from departments a
where department_id in ( select department_id from job_history b ) ;
```


- - -
-- DAY-17 end line --
    

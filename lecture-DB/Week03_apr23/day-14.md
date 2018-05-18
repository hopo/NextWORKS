DAY-14
======
- - -

* ROLLUP()
* CUBE()
* GROUPING()
* GROUPING_ID()
* GROUPING SETS()
* EQUI-JOIN
- - -


## ROLLUP(expr1, expr2, ...)
* p158
* 소계 출력
* GROUP BY 뒤

### exA)
* 부서 별, 총 급여 사원수를 조회해 주세요
```sql
select department_id, sum(salary), count(*)
from employees
group by department_id 
order by 1 ;
```

### exA2)
* 부서 별, 총 급여 사원수를 조회해 주세요 and 소계(ROLLUP())
```sql
select department_id, sum(salary), count(*)
from employees
group by rollup(department_id)
order by 1 ;

### exA3)
* ROLLUP()을 사용하지 않고 동일한 조회
```sql
select department_id, sum(salary), count(*)
from employees
group by department_id
union
select null, sum(salary), count(*)
from employees ;
```

### exB)
* 부서 별, 업무 별, 총 급여 사원수를 조회해 주세요
```sql
select department_id, job_id, sum(salary), count(*)
from employees
group by department_id, job_id
order by 1 ;
```

### exB2)
* 부서 별, 업무 별, 총 급여 사원수를 조회해 주세요 and 각 업무별 소계 부서별 소계
```sql
select department_id, job_id, sum(salary), count(*)
from employees
group by rollup(department_id, job_id)
order by 1 ;
```

### exB3)
* ROOLUP()을 사용하지 않고
```sql
select department_id, job_id, sum(salary), count(*)
from employees
group by department_id, job_id
union
select department_id, null, sum(salary), count(*)
from employees
group by department_id
union 
select null, null, sum(salary), count(*)
from employees 
order by 1 ;
```

### exB4)
* 부분 소계
* 부서 별, 총 급여 원수를 조회해 주세요  and 업무별로만 소계
```sql
select department_id, job_id, sum(salary), count(*)
from employees
group by department_id, rollup(job_id)
order by 1 ;
```

* 부서 별, 총 급여 원수를 조회해 주세요  and 부서별로만 소계
```sql
select department_id, job_id, sum(salary), count(*)
from employees
group by rollup(department_id), job_id
order by 2 ;
```


## CUBE(expr1, expr2, ...)
* p161

### exA)
```sql
select department_id, job_id, sum(salary), count(*)
from employees
group by cube(department_id, job_id) ;
```
 
 
## GROUPING(exp)
* ROLLUP()의 확인을 위한 함수
### exA)
```sql
select department_id, job_id,
    sum(salary),
    count(*),
    grouping(department_id) dept_g,
    grouping(job_id) job_g
from employees
group by rollup(department_id, job_id) ;
```
*grouping(exp) : 해당 exp로 그루핑 된 경우면 1


## GROUPING_ID(exp1,exp2)
### exA)
```sql
select department_id, job_id,
    sum(salary),
    count(*),
    grouping(department_id) dept_g,
    grouping(job_id) job_g,
    grouping_id(department_id, job_id) g_id
from employees
group by rollup(department_id, job_id) ;
```
* 각 exp이 그루핑 된경우 1을 반환 -> 결과 값이 (00 | 01 | 10 | 11)의 decimal


### exB)
* decode()와 함께 사용하는 예
```sql
select department_id,
    decode(grouping_id(job_id), 1, '소계', job_id) as modi_job_id,
    sum(salary),
    count(*)
from employees
group by rollup(department_id, job_id) ;
```

## GROUPING SETS(expr1, expr2, expr3)
* p171

### exA)
```sql
select department_id,
    job_id,
    sum(salary),
    count(*)
from employees
group by grouping sets(department_id, job_id) ;
```
* union all 개념이 섞여 있다.

### exB)
```sql
select period, gubun, region, sum(loan_jan_amt) as tot_amt
from kor_loan_status
where period like '2013%'
    and region in ('서울', '경기')
group by grouping sets(period, (gubun, region)) ;
```

### EXAM
### exA)
```sql
-- A. 사원테이블에서 입사월별 사원수를 조회하는 쿼리
select to_char(hire_date, 'MM'),
    sum(1)
from employees
group by to_char(hire_date, 'MM') 
order by 1;


-- B. 대출테이블에서 지역별, 월별 대출 종액을 조회해 주세여
select region,
    sum(case period when '201111' then loan_jan_amt else 0 end) as "201111",
    sum(case period when '201112' then loan_jan_amt else 0 end) as "201112",
    sum(case period when '201210' then loan_jan_amt else 0 end) as "201210",
    sum(case period when '201211' then loan_jan_amt else 0 end) as "201211",
    sum(case period when '201212' then loan_jan_amt else 0 end) as "201212",
    sum(case period when '201310' then loan_jan_amt else 0 end) as "201310",
    sum(case period when '201311' then loan_jan_amt else 0 end) as "201311",
    sum(loan_jan_amt)
from kor_loan_status
group by region ;
```



## 6장. 조인과 서브 쿼리

### EQUI-JOIN
### exA)
```sql
select a.emp_name, a.salary, b.department_name
from employees a, departments b
where a.department_id = b.department_id ;
```

### exB)
* 급여가 9000 이상인 사원을 조회
* 사번(employee_id), 사원명(emp_name), 급여(salary), 부서코드(department_id), 부서명(department_name)
```sql
select a.employee_id,
    a.emp_name,
    a.salary,
    b.department_id,
    b.department_name
from employees a, departments b 
where a.department_id = b.department_id 
    and a.salary >= 9000
order by 4;
```


- - -
-- DAY-14 end line --

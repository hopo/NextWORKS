DAY-11
======
- - -

* REPLACE(), LPAD()
* DECODE(), TRUNC()
* Aggregate function(집계함수)
* COUNT(), MAX(), MIN(), SUM(), AVG()
* ALL and DISTINCT
* VARIANCE(), STDDEV()
- - -


## EXAM
* p150

### exA)
* 사원(employees)테이블에 전화번호(phone_number)에서
* 처음 3자리 숫자 대신 '(02)'를 붙여서 조회해 주세요.
```sql
select phone_number, replace(phone_number, substr(phone_number, 1, 4), '(02)' )
from employees ;
```

### exA2)
```sql
select phone_number, lpad(substr(phone_number, 5, 12), 12, '(02)')
from employees ;
```

### exA3)
```sql
select phone_number, '(02)' || substr(phone_number, 5)
from employees ;
```


### exB)
* 근속년수가 10년이상인 사원을, 근속년수 순서(내림차순) 조회
* 사번(employee_id), 사원명(emp_name), 입사일자(hire_date), 근속년수(today-hiredate)
```sql
select employee_id, emp_name, hire_date, trunc( (sysdate - hire_date) / 365 ) as 근속년수
from employees
where trunc( (sysdate - hire_date) / 365 ) >= 10
order by hire_date desc ;
```

### exB2)
```sql
select employee_id, emp_name, hire_date, trunc( months_between(sysdate, hire_date) / 12 ) as 근속년수
from employees
where trunc( months_between(sysdate, hire_date) / 12 ) >= 10
order by hire_date desc ;
```

### exB3)
```sql
select employee_id, emp_name, hire_date,
    trunc(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') as year1,
	trunc((sysdate - hire_date) / 365.25 ) as year2,
	trunc( months_between(sysdate, hire_date) / 12 ) as year3
from employees
where trunc( months_between(sysdate, hire_date) / 12 ) >= 10
order by year3 desc ;
```

### exC)
* **고객(customers)테이블에서 고객의 출생년도(cust_year_of_birth)
* 현재일자 기준으로 30대, 40대, 50대, 그리고 나머지는 기타로 조회
* 고객명, 출생년도, 연령대
* decode() 활용 - OracleDB
```sql
select cust_name, cust_year_of_birth,
    decode( trunc((to_number(to_char(sysdate, 'yyyy')) - cust_year_of_birth) / 10),
            3, '30대',  4, '40대',  5, '50대', '기타'
    )
from customers ;
```

### exC2)
```sql
select cust_name, cust_year_of_birth,
	trunc( (to_char(sysdate, 'yyyy') - cust_year_of_birth) / 10 ) as ref,
    decode(trunc( (to_char(sysdate, 'yyyy') - cust_year_of_birth) / 10 ),
            3, '30대', 4, '40대', 5, '50대', '기타'
        ) as ages
from customers ;
```

### exC3)
```sql
select cust_name, cust_year_of_birth, to_char(sysdate, 'yyyy') - cust_year_of_birth,
	case when to_char(sysdate, 'yyyy') - cust_year_of_birth between 50 and 59 then '50s'
		when to_char(sysdate, 'yyyy') - cust_year_of_birth between 40 and 49 then '40s'
		when to_char(sysdate, 'yyyy') - cust_year_of_birth between 30 and 39 then '30s'
		else 'ETC'
	end as ages
from customers ;
```

### exC4)
```sql
select cust_name,
    cust_year_of_birth,
	to_char(sysdate, 'yyyy') - cust_year_of_birth,
	case trunc( (to_char(sysdate, 'yyyy') - cust_year_of_birth) / 10 )
		when 5 then '50s'
		when 4 then '40s'
		when 3 then '30s'
		else 'ETC'
	end as ages
from customers ;
```


## Aggregate function(집계함수)
* p152
* 대표적 5개 집계함수
* 건수(count), 최대(max), 최소(min), 합(sum), 평균(avg)

### COUNT(), MAX(), MIN()
```sql
select count(*) from employees ;
select max(salary) from employess ;
select count(*), max(salary), min(salary) from employees ;
```

### ALL and DISTINCT
```sql
select count(*), count(all manager_id), count(distinct manager_id) from employees ;
```
* * : NULL 포함 모두
* ALL : NULL을 제외한 모두
* DISTINCT : 중복된 값은 제거

```sql
select count(*), count(manager_id), count(distinct manager_id) from employees ;
```
* SELECT 절에서의 DISTINCT와 마찬가지로 중복된 값을 제거하기 위해 내부 작업을 합니다
* 굳이 DISTINCT를 사용할 필요가 없으면 사용하지 마세요! (속도 저하)

```sql
select distinct manager_id, salary from employees ;
```
* SELECT 절의 DISTINCT는 모든 행이 동일한 경우 제거


### EXAM
### exA)
* 사원테이블에서 부서(department_id)가 50, 60, 70, 80 인 곳의
* 사원수, 최고급여, 최저급여를 조회해 주세요.

```sql
select count(*) as 사원수, max(salary) as 최고급여, min(salary) as 최저급여
from employees
where department_id = 50
	or department_id = 60
	or department_id = 70
	or department_id = 80 ;
```

### exA2)
```sql
select count(*), max(salary), min(salary)
from employees
where department_id in (50, 60, 70, 80) ;
```

### SUM(), AVG()
```sql
select sum(salary), sum(distinct salary),
    round(avg(salary), 2), round(avg(distinct salary), 2)
from employees ;
```

### VARIANCE(), STDDEV()
* p155
* 분산(分散, variance), 표준편차(標準 偏差, standard deviation)

```sql
select avg(salary), variance(salary), stddev(salary)
from employees ;
```


- - -
-- DAY-11 end line --


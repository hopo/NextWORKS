DAY-07
======
- - -
...ing
- - -


### exA)
* 부서코드(department_id) 가 10 또는 20 또는 50을 조회해 주세여
* 사번(employee_id), 사원명(emp_name), 급여(salary), 부서코드(department_id)
```sql	
select employee_id, emp_name, salary, department_id
from employees
where department_id = 10 or department_id = 20 or department_id = 50 ;
--where department_id = any(10, 20, 50) ;
```
 
## EXIST
* p118
```sql
select employee_id, emp_name, salary, department_id
from employees 
where exists (select * from dual where 1 = 1); 
```

```sql
select department_id, department_name
from departments a
where exists (
				select b.emp_name, b.salary, b.department_id
				from employees b
				where a.department_id = b.department_id
				and b.salary > 3000
			) ;
```

## LIKE
* p119
### exA)
```sql
select department_id, department_name
from departments
where department_name like '%팀' -- 끝이 '팀' ;
```

### exB)
```sql
select department_id, department_name
from departments
where department_name like '%무%' -- 까운뗴 '무' ;
```

### exC)
```sql
select department_id, department_name
from departments
where department_name like '__부' -- **'부' ;
```

### esacpae(\) 활성화
```sql
insert into ex3_2 values (300, '우피 10%', 1000);
insert into ex3_2 values (300, '우피 15%', 1000);
insert into ex3_2 values (300, '우피 20%', 1000);
insert into ex3_2 values (300, '광피 10', 1000);

select * from ex3_2 where emp_name like '%10\%%' escape '\' ;
```


### exA)
* p122
* create table as select 로 테이블 작성 (ex3_6)
* 사원테이블(employees)에서 관리자사번(employee_id)이 124번이고 급여(salary)가 2000에서 3000사이
* 조회할 컬럼 사번(employee_id), 사원명(emp_name), 급여(salary)가 관리자사번

```sql
create table ex3_6 (emp_id, emp_name, salary)
as
select employee_id, emp_name, salary 	
	from employees
	where employee_id = 124
		and salary between 2000 and 3000 ;
```

### exB) 커미션퍼센트가 없는 사원을 조회(null)
```sql
select * from employees
where commission_pct is null;
```

### exC) 논리 연산자 로 변셩
```sql
select employee_id, salary
from employees
where salary between 2000 and 2500
order by employee_id ;
```

```sql
select employee_id, salary
from employees
where salary >= 2000 and salary <= 2500
order by employee_id ;
```


## LIKE
* INDEX p75
* 고객명이 'Ann'으로 시작하는 고객을 조회
* LIKE 'A%': 인덱스 사용
* LIKE '%A' - 인덱스 미사용(사용할 수도 있음)
* LIKE '%A%': 인데스 미사용
```sql
select *
from customers
-- where cust_name = 'Ann%	-- sytax error
--where cust_name like 'Ann%'	-- explain plan(f10) for check
--where cust_name like 'Ber%'
where cust_name like '%Baley' ;
```
* => INDEX를 타면 cost가 줄어든다.

```sql
create index ix_customers_cust_name
on customers(cust_name) ;
```
* WHERE(A,B)에서, 자주 사용하는 컬럼은 앞에 둔다


- - - 
-- DAY-07 end line -



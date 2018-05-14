DAY-10
======
- - -

* ADD_MONTH(), MONTH_BETWEEN(), ROUND()
* NEXT_DAY()
* TO_CHAR(), TO_NUMBER()
* NVL(), NVL2()
* COALESCE()
* LNNVL()
* NULLIF()
* GREATEST(), LEAST()
* DECODE()
* ASCII()
- - -


## SYSDATE
* p138

### exA) sysdate 연산
```sql
select sysdate, sysdate + 1, sysdate + (6 / 24) from dual;

select sysdate - to_date('1993/11/1') from dual;
```

### ADD_MONTH(), MONTH_BETWEEN(), ROUND()

```sql
-- ADD_MONTHS()
select add_months(sysdate, 12) from dual ;

-- MONTH_BETWEEN()
select months_between(sysdate, '2015/10/15') from dual ;

-- LAST_DAY()
select last_day(sysdate) from dual;

-- ROUND()
select round(sysdate, 'month') , -- 달 반올림
		trunc(sysdate, 'mm')
from dual ;

select round(to_date('2018/09/23'), 'year') ,
        round(sysdate, 'dd') ,
		trunc(sysdate, 'yy')
from dual ;
```

### NEXT_DAY()
```sql
select next_day(sysdate, '월') from dual ;
select next_day(sysdate, '월요일') from dual ;
-- select next_day(sysdate, 'Monday') from dual ;
```


### EXAM
### exA)
* 사원이 근무한 일수, 월수를 조회해 주세요
```sql
select emp_name, hire_date,
		trunc(sysdate-hire_date) as 근무_일,
		trunc(months_between(sysdate, hire_date)) as 근무_월
from employees ;
```


## 변환함수
* p140

### TO_CHAR()
### exA)
```sql
-- 날짜
select to_char(sysdate, 'YYYY.MM.DD HH24:MI:SS') from dual ;
select to_char(sysdate, 'AD CC WW IW W Q') from dual ;

-- 숫자
select to_char(120452700, '999,999,999.00') from dual ; -- 포맷을 넉넉하게, 0은 값이 없으면 표기X
select to_char(2017, 'RN') from dual ;
select to_char(-24, 'S99') from dual ;
select to_char(-24, '99PR') from dual ;
select to_char(12, 'L99.00') from dual ;
```

### exB)
```sql
-- 입사월을 조회
select emp_name, hire_date, to_char(hire_date, 'mm')
from employees ;

-- 입사월이 3월인 사원의 이름, 월급여, 입사일
select emp_name, salary, hire_date
from employees
where to_char(hire_date, 'mm') = '03' ; -- CHAR 입니다

--  format 활용
select emp_name, round(salary/12, 2), to_char(salary/ 12 , 'L99,999.0')
from employees ;
```

### TO_NUMBER()
### exA) 
```sql
-- 예시
select to_number('123000') from dual ;
select to_number('123,000', '999,999') from dual ;
select to_number('<23,000>', '999,999PR') from dual ;

-- 기본설정에 따라 에러가 날 수가 있으니 포매터를 적어준다
select to_date('2018-12-25') from dual ;

select to_date('2018-12-25 15:30') from dual ;
select to_date('2018-12-25 15:30', 'YYYY-MM-DD HH24:MI') from dual ;

select to_date('2018-12-25 15:30:09') from dual ;
select to_date('2018-12-25 15:30:09', 'YYYY-MM-DD HH24:MI:SS') from dual ;
```


### NULL 함수
* p143

### NVL(), NVL2()
```sql
-- 탐색
select emp_name, manager_id
from employees ;

-- NVL(p1, p2)
-- p1이 NULL 이면 p2
select employee_id, emp_name, manager_id, nvl(manager_id, 999) -- NULL이면 999
from employees ;

-- NVL2(p1, p2, p3)
-- (p1 != NULL) p2, 그렇지 않으면 p3
select employee_id, emp_name, manager_id, nvl2(manager_id, 'YES', 'NO')
from mployees ;
```

### exA)
* 연말에 보너스 지급 (보너스 = 급여 + (급여 * 커미션비율))
* commission_pct가 NULL 이면 salary
```sql
select employee_id, emp_name, salary, commission_pct ,
	salary + salary * commission_pct as bonus1 ,
	nvl2(commission_pct, salary + salary * commission_pct, salary) as bonus2 ,
	nvl(salary + salary * commission_pct, salary) as bonus3 , -- NULL 연산은 NULL
	salary + salary * nvl(commission_pct, 0) as bonus4 ,
	salary + coalesce(salary * commission_pct, 0) as bonus5
from employees ;
```


### COALESCE(p1, p2, p3, ...)
```sql
-- parameter 순서 중 NULL이 아닌 값으로
select coalesce(null, 100, 200) from dual ;
```
### LNNVL()
```sql
select employee_id, emp_name, salary, commission_pct
from employees
-- where nvl(commission_pct, 0) < 0.2 ;
where lnnvl(commission_pct >= 0.2) ; -- 부정을 뜻하는 함수
```

### NULLIF(p1, p2)
```sql
-- (p1 = p2)이면 NULL 그렇지 않으면 p1
select nullif(100, 100), nullif(200, 100) from dual ;

-- 예시
select employee_id ,
		to_char(start_date, 'yyyy') as st_year ,
		to_char(end_date, 'yyyy') as ed_year ,
		nullif(to_char(end_date, 'yyyy'), to_char(start_date, 'yyyy')) as ed2_year
from job_history ;
```


### 기타 함수
* p147

### GRATEST(p1, p2, p3, ...)

```sql
select greatest('홍', '강감찬') from dual ;
```

### LEAST(p1, p2, p3, ...)
```sql
select least(1000, 999) from dual ;
```

### exA)
* 연말, 모든 직원 100% 보너스
* 만약 3000보단 작은 직원은 3000 지급
```sql
select employee_id, emp_name, salary, greatest(salary, 3000) as bonus
from employees ;
```


### DECODE(expr, search1, result1, search2, result2, ..., default)
```sql
select prod_id, channel_id, decode(channel_id, 3, 'Direct', 9, 'Direct', 5, '간접', '기타등등')
from sales
where rownum <= 10 ;
```

### ASCII()
```sql
select ascii(' '), ascii('0'), ascii('A'), ascii('a') from dual ;
```


- - -
-- DAY-10 end line --


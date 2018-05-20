DAY-28
======
- - -

* 사용자 정의 함수
* CREATE OR REPLACE
* PROCEDURE
- - -

## 사용자 정의 함수
* p285

### exA)
* sub-query 이용
```sql
select employee_id, emp_name, department_id,
       ( select b.department_name
    	 from departments b
    	 where b.department_id = a.department_id
       ) as dep_name
from employees a;
```

### exB)
```sql
-- 부서 번호를 리턴하는 function 정의
create or replace
function fn_dept_name(p_dept_id number) return varchar2
is
    r_dept_name varchar2(100) ;
begin
    select department_name into r_dept_name
    from departments
    where department_id = p_dept_id;
    return r_dept_name;
end ;
/

-- function call 확인
select fn_dept_name(10) from dual;

-- function을 이용한 쿼리
select employee_id, emp_name, department_id,
       fn_dept_name(department_id)
from employees a;
```

### EXAM
### exA)
* 사원을 조회, 해당 사원이 어떤 년도의 매출액을 조회
```sql
-- 탐색
select employee_id, emp_name, department_idf from employees ;

-- id157, yr1998 - query)
select sum(amount_sold)
from sales
where employee_id=157
and sales_month like '1998'||'%';

-- id157, yr1998 - query2)
select sum(amount_sold)
from sales
where employee_id = 157
and to_char(sales_date, 'YYYY') = '1998' ;

-- function 정의
create or replace 
function fn_emp_amount(
        p_emp_id employees.employee_id%type,
        p_year number := to_number(to_char(sysdate, 'YYYY')) -- ':= default'
    )
    return number
is
    r_amount number(10,2);
begin
    select nvl(sum(amount_sold), 0) into r_amount
    from sales
    where employee_id=p_emp_id    
    and to_char(sales_date, 'yyyy') = p_year || '';    
    return r_amount;
end ;
/

-- function 확인
select fn_emp_amount(157, 1998) as id157_yr98,
       fn_emp_amount(157, 1999) id157_yr99,
       fn_emp_amount(157) is157_now
from dual;
```

### exB)
* exA의fn_emp_amount()를 이용하여, 80번 부서의 사원들을 조회, 1998, 1999, 올해 매출액
```sql
select employee_id, emp_name, department_id,
       fn_emp_amount(employee_id, 1998) yr_1998,
       fn_emp_amount(employee_id, 1999) yr_1999,
       fn_emp_amount(employee_id) yr_now
from employees
where department_id=80;
```

### exC)
* *parameter a ~ b 사이 수의 합
```sql
-- fucntion 정의
create or replace
function fn_sum(p_a number, p_b number) return number
is
    r_sum number := 0;
    vn_a number := p_a;
    vn_b number := p_b;
    vn_x number := 0;
begin
    if vn_a > vn_b then
        vn_a := p_b;
        vn_b := p_a;
    end if;
    for vn_x in vn_a..vn_b loop
        r_sum := r_sum + vn_x;
    end loop;
    return r_sum;
end ;
/

-- 확인
select fn_sum(1, 10), fn_sum(10, 5) from dual;
```

### exC2)
```sql
create or replace
function fn_sum(p_a number, p_b number) return number
is
    r_sum number := 0;
    vn_a number := p_a;
    vn_b number := p_b;
    tmp number := 0;
    
begin
    if p_a > p_b then
        vn_a := p_b;
        vn_b := p_a;
    end if;
    select sum(level) into r_sum from dual connect by level <= vn_b;
    if vn_a != 1 then
        select sum(level) into tmp from dual connect by level < vn_a;
    end if;
    return r_sum - tmp ;
end ;
/

-- 확인
select fn_sum(1,10), fn_sum(10, 5) from dual;
```


## PROCEDURE
* p289

### exA)
```sql
create or replace
procedure proc_new_job(
            p_job_id jobs.job_id%type,
            p_job_title jobs.job_title%type,
            p_min_sal jobs.min_salary%type,
            p_max_sal jobs.max_salary%type
        )
is
begin
    insert into jobs (job_id,job_title, min_salary, max_salary)
    values (p_job_id, p_job_title, p_min_sal, p_max_sal) ;
    
    commit ;
end;
/

-- procedure 실행
exec proc_new_job('SM_2001', 'Sample 2001', 2000, 6000);

-- table 확인
select*from jobs where job_id='SM_2001';
```



- - -
-- DAY-28 end line --


DAY-09
=======
- - -

* LPAD(), RPAD()
* REPLACE()
* TRANSLATE()
* INSTR(), SUBSTR()
* VIEW
* CREATE OR REPLACE ~
- - -


### LPAD(), RPAD()
* p133
```sql
select emp_name, salary, lpad(salary, 4, '*'), rpad(salary, 10, '-') from employees;
```

### REPLACE()
```sql
select replace('나는 너를 모르는데 너는 나를 알겠는가?', '나', '너') from dual;

select emp_name, replace(emp_name, 'a', 'ee'), salary from employees;
```

### exA) 
```sql
select emp_name, replace(emp_name, 'abcde', '12345'), salary from employees;
```

### TRANSLATE()
* 보안상 위험 하여 잘 사용하지는 않음
```sql
create table ex4_1 (
    emp_name varchar(100),
    salary number
);

insert into ex4_1 select translate(emp_name, 'aeiou', '12345'), salary from employees ;

select translate(emp_name, '12345', 'aeiou'), salary from ex4_1 ;
```

### INSTR()
* p137
```sql
select instr('나는 너를 모르는데 너는 나를 알겠는가?', '나') as c1,
		instr('나는 너를 모르는데 너는 나를 알겠는가?', '나', 3) as c2,
		instr('나는 너를 모르는데 너는 나를 알겠는가?', '나', 1, 2) as c3, -- 1시작 2번째
		instr('나는 너를 모르는데 너는 나를 알겠는가?', '길동') as c4
from dual ;
```

### SUBSTR()
* 'David Lee' 에서 성과 이름을 나누기
```sql
select substr('David Lee', 1, 5) as 이름,
		substr('David Lee', 7) as 성
from dual ;
```

### EXAM)
### exA)
* 사원(employee) Table에서 사원이름의 성, 이름, 급여(salary)를 조회해 주세요.
```sql
-- 탐색
select emp_name, instr(emp_name, ' ') from employees;

select substr(emp_name, 1, instr(emp_name, ' ') - 1) as 이름,
		substr(emp_name, instr(emp_name, ' ') + 1) as 성,
		salary
from employees;
```

### exB)
* Table employee에서, salary가 2000 ~ 3000 이고
* 사원의 employee_id, emp_name, salary, department_id
```sql
select employee_id, emp_name, salary, department_id
from employees
where salary between 2000 and 3000
		and department_id = 50 ;
```

## VIEW
* p73

* 자주 사용되고 복잡한 쿼리를 dbms에 쿼리들을 객체화 시켜 관리한다.
* 웹서버와 dbms간의 전송량을 줄인다.

### exA)
```sql
create or replace view v_emp
as
select employee_id, emp_name, salary, department_id
from employees
where salary between 2000 and 3000
and department_id = 50 ;
```

### exB)
* VIEW update is possible.
```sql
update v_emp
set emp_name = 'malja'
where employee_id = 198;
```

### ExC)
```sql
create or replace
view v_emp (emp_id, emp_name, salary, dept_id)
as
select employee_id, emp_name, salary, department_id
from employees
where salary between 2000 and 3000
and department_id = 50
with check option ; -- 뷰에 보일 때만
```

### exD)
```sql
select * from v_emp ;

update v_emp
set emp_name = 'sunja'
where emp_id = 199 ;

update v_emp
set salary = 4555
where emp_id = 126 ; -- view 영역의 밖이다.

select * from employees;
```

* ?
```sql
select sysdate, systimestamp from dual;
```

- - - 
-- DAY-09 end line --


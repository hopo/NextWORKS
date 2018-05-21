DAY-30
======
- - -

* EXCEPTION
* PRAGMA EXCEPTION_INT
* TRANSACTION
* CURSOR statement
- - -

## EXCEPTION
* p306
```sql
declare
    vi_num number := 0;
begin
    vi_num := 10 / 0;
    dbms_output.put_line('vi = ' || vi_num);
exception
    when others then
        dbms_output.put_line('this is EXCEPTION line.');
        dbms_output.put_line('SQLCODE = ' || sqlcode);
        dbms_output.put_line('SQLERRM = ' || sqlerrm);
        dbms_output.put_line('SQLERRM(code) = ' || sqlerrm(sqlcode));
        dbms_output.put_line('UTIL = ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE );
end;
/
```

### EXAM
### exA)
* 부서번호를 입력 받아서 부서명을 출력하고
* 해당 부서를 삭제하는 익명블럭 생성
```sql
declare
    v_dept_id number := 180;
    v_dept_name varchar2(100);
    exp_reference EXCEPTION;
    PRAGMA EXCEPTION_INIT(exp_reference, -2292); -- 사용자 정의 exception
begin
    select department_name into v_dept_name from departments where department_id = v_dept_id;
    
    dbms_output.put_line('v_dept_name = ' || v_dept_name);
    delete from departments where department_id = v_dept_id;
    
    dbms_output.put_line( v_dept_name || ' is DELETED.');
    
    -- commit;
exception
    when no_date_found then
        dbms_output.put_line(v_dept_id || 'execpetion: NO DATA FOUND');
    when others then
        dbms_output.put_line('this is EXCEPTION line.');
        dbms_output.put_line('SQLCODE = ' || sqlcode);
        dbms_output.put_line('SQLERRM = ' || sqlerrm);
        
        -- rollback;
end;
/
```


## TRANSACTION
* p328



## CURSOR statement
* p342, (pdf)p278

### EXAM
### exA)
* 30번 부서를 조회하는 커서를 생성하고, 사번, 사원명 급여
* WHILE statement
```sql
declare
    v_emp_id number;
    v_emp_name varchar2(100);
    v_sal number;
    cursor emp_cur is
        select employee_id, emp_name, salary
        from employees
        where department_id = 30;
begin
    open emp_cur; -- 커서를 연다
    fetch emp_cur into v_emp_id, v_emp_name, v_sal;
    while emp_cur%found loop
          dbms_output.put_line(v_emp_id || ', ' || v_emp_name || ', ' || v_sal);
          fetch emp_cur into v_emp_id, v_emp_name, v_sal;
    end loop;
    close emp_cur; -- 커서를 닫는다
end;
/
```
* for 문을 돌면서 각각의 레코드를 작업하는 모습

### exA2)
* FOR statement
```sql
declare
    cursor emp_cur is
        select employee_id, emp_name, salary
        from employees
        where department_id = 30;
begin
    for emp_rec in emp_cur loop
          dbms_output.put_line(
                emp_cur%rowcount || ' = '
                || emp_rec.employee_id || ', '
                || emp_rec.emp_name || ', '
                || emp_rec.salary
          );
    end loop;
end;
/
```

### exB)
* 30번 부서의 급여가 10000이상이면 A, 5000이상이면 B로 출력
* 임의 테이블에 사번, 사원명 급여, 등급을 입력
```sql
declare
    cursor emp_cur is
        select employee_id, emp_name, salary
        from employees
        where department_id = 30;
begin
    for emp_rec in emp_cur loop
        case
            when emp_rec.salary > 10000 then
                dbms_output.put_line(emp_rec.emp_name || ': ' || emp_rec.salary || ', A');
            when emp_rec.salary > 5000 then
                dbms_output.put_line(emp_rec.emp_name || ': ' || emp_rec.salary || ', B');
            else
                dbms_output.put_line(emp_rec.emp_name || ': ' || emp_rec.salary || ', C');
        end case;
    end loop;
end;
/
```

### exB2)
```sql
declare
    cursor emp_cur is
        select employee_id, emp_name, salary
        from employees
        where department_id = 30;
begin
    for emp_rec in emp_cur loop
        dbms_output.put(emp_rec.emp_name || ': ' || emp_rec.salary);
        case
            when emp_rec.salary > 10000 then
                dbms_output.put_line(', A');
            when emp_rec.salary > 5000 then
                dbms_output.put_line(', B');
            else
                dbms_output.put_line(', C');
        end case;
    end loop;
end;
/
```


- - -
-- DAY-30 end line --



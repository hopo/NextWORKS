DAY-26
======
- - -

* DECALRE, BEGIN, END
- - -

## PL/SQL
* p260, (pdf)p254

### variable declare and print
```sql
DECLARE
    v_i NUMBER(9,2) := 0;
    v_name VARCHAR2(20);
    c_pi CONSTANT NUMBER(8,6) := 3.141592;
    v_flag BOOLEAN NOT NULL := true;
    v_date VARCHAR2(10) := TO_CHAR(SYSDATE, 'YYYY-MM-DD');
BEGIN
    v_name := '홍길동';
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.PUT_LINE( 'v_i : ' || v_i );
    DBMS_OUTPUT.PUT_LINE( 'v_name : ' || v_name);
    DBMS_OUTPUT.PUT_LINE( 'c_pi : ' || c_pi );
    DBMS_OUTPUT.PUT_LINE( 'v_date : ' || v_date);
END;
/
```

-- ### IF statement
DECLARE
    v_num NUMBER := 77;
BEGIN
    DBMS_OUTPUT.ENABLE;
    IF v_num > 90 THEN
        DBMS_OUTPUT.PUT_LINE('수');
    ELSIF v_num > 80 THEN
        DBMS_OUTPUT.PUT_LINE('우');
    ELSIF v_num > 70 THEN
        DBMS_OUTPUT.PUT_LINE('미');
    ELSE
        DBMS_OUTPUT.PUT_LINE('분발합시다.');
    END IF;
END;
/


-- ### EXAM)
-- ### exA)
-- * 사원의 평균급여를 변수에 담아 출력하는 익명블럭을 생성하라
declare
    v_avg number;
begin
    select avg(salary) into v_avg from employees;
    dbms_output.put_line('v_avg = ' || v_avg);
end;
/

-- ### exB)
-- * 100 사원의 이름, 급여를 변수에 담아 출력하는 익명블럭을 생성하라
declare
    v_name employees.emp_name%type;
    v_sal employees.salary%type;
begin
    select emp_name, salary into v_name, v_sal from employees where employee_id = 100;
    dbms_output.put_line('v_name = ' || v_name);
    dbms_output.put_line('v_sal = ' || v_sal);
end;
/

-- ### self-check. p272
-- ### 문제3)
declare
    v_name employees.emp_name%type;
    v_sal employees.salary%type;
begin
    select emp_name, salary into v_name, v_sal from employees where employee_id = 100;
    
    insert into ex7_3 values(v_sal, v_name);
    
    dbms_output.put_line('v_name = ' || v_name);
    dbms_output.put_line('v_sal = ' || v_sal);
end;
/

-- 인서트한 것을 조회
select * from ex7_3;

-- ### CASE state
-- ### exA)
DECLARE
    v_num NUMBER := 77;
BEGIN
    v_num := TRUNC(v_num / 10 );
    CASE v_num
        WHEN 10 THEN DBMS_OUTPUT.PUT_LINE('수');
        WHEN 9 THEN DBMS_OUTPUT.PUT_LINE('수');
        WHEN 8 THEN DBMS_OUTPUT.PUT_LINE('우');
        WHEN 7 THEN DBMS_OUTPUT.PUT_LINE('미');
        ELSE DBMS_OUTPUT.PUT_LINE('분발합시다.');
    END CASE;
END;
/

-- ### exB)
-- * 121번 사원의 salary를 조회 하여
-- * 10000 초과면 관리자, 10000~5000 일반관리자, 그 밖엔 사원을 출력
declare
    v_sal employees.salary%type;
begin
    select salary into v_sal from employees where employee_id = 121;
    case
        when v_sal > 10000 then dbms_output.put_line('관리자');
        when v_sal > 5000 then dbms_output.put_line('일반관리자');
        else dbms_output.put_line('사원');
    end case;
end;
/

-- ### WHILE state
-- ### exA)
DECLARE
    v_sum NUMBER := 0;
    v_var NUMBER := 1;
BEGIN
    WHILE v_var <= 10 LOOP
        v_sum := v_sum + v_var;
        v_var := v_var + 1;
        dbms_output.put_line(v_var || ', ' || v_sum);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1 부터 10 까지의 합 = ' || v_sum);
END;
/




-- - - -
-- DAY-26 end line --
COMMIT;

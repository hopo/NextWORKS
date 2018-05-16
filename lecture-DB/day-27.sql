-- DAY-27
-- ======

-- ## PL/SQL
-- ### WHILE statement
-- * (pdf)p257
-- ### exA) 별 출력1
DECLARE
    v_id NUMBER := 1;
    BEGIN
        WHILE v_id < 20 LOOP
            DBMS_OUTPUT.PUT_LINE( RPAD( '*', v_id, '*' ));
            v_id := v_id + 2;
    END LOOP;
END;
/

-- ### exB) 별 출력2
DECLARE
    v_id NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    WHILE v_id < 10 LOOP
        DBMS_OUTPUT.PUT_LINE(RPAD(' ', 10-v_id) || RPAD( '*', (v_id*2)+1, '*' ));
        v_id := v_id + 1;
    END LOOP;
END;
/

-- ### exB2) 별 출력2-2
DECLARE
    v_id NUMBER := 1;
    v_s number := 10;
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    WHILE v_id < 20 LOOP
        DBMS_OUTPUT.PUT_LINE(LPAD(' ', v_s) || RPAD( '*', v_id, '*' ));
        v_id := v_id + 2;
        v_s := v_s -1;
    END LOOP;
END;
/

-- ### exC) 3단
declare
    v_dan number;
    v_i number;
begin
    v_dan := 3;
    v_i := 1;
    while v_i < 10 loop
        dbms_output.put_line(v_dan ||' x '  || v_i || ' = ' || v_dan*v_i);
        v_i := v_i+1;
    end loop;
end;
/

-- ### exD) 구구단
DECLARE
    v_dan NUMBER := 2;
    v_i NUMBER := 1;
BEGIN
    WHILE v_dan < 10 LOOP
        WHILE v_i < 10 LOOP
            DBMS_OUTPUT.PUT_LINE( v_dan || ' * ' || v_i || ' = ' || (v_dan * v_i) );
            v_i := v_i + 1;
        END LOOP;
        v_i := 2;
        v_dan := v_dan + 1;
    END LOOP;
END;
/

-- ### GOTO
-- ### exA)
DECLARE
    v_sum INT := 0;
    v_var INT := 1;
BEGIN
    <<mylabel>>
    v_sum := v_sum + v_var;
    v_var := v_var + 1;
    IF v_var <= 10 THEN
        GOTO mylabel;
    END IF;
    DBMS_OUTPUT.PUT_LINE(v_sum);
    DBMS_OUTPUT.PUT_LINE(v_var);
END;
/

-- ### LOOP statement
-- ### exA)
DECLARE
    v_sum NUMBER := 0;
    v_var NUMBER := 1;
BEGIN
    LOOP
        v_sum := v_sum + v_var;
        v_var := v_var + 1;
        IF v_var > 10 THEN
            EXIT;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('LOOP: 1 부터 10 까지의 합 = ' || v_sum);
END;
/

-- ### EXIT
-- ### exA)
DECLARE
    v_sum NUMBER := 0;
    v_var NUMBER := 1;
BEGIN
    LOOP
        v_sum := v_sum + v_var;
        v_var := v_var + 1;
        EXIT WHEN v_var > 10 ;  
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('EXIT: 1 부터 10 까지의 합 = ' || v_sum);
END;
/

-- ### FOR statement
-- ### exA)
BEGIN
    FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE( 'i = ' || i );
    END LOOP;
END;
/

-- ### exB) 구구단
BEGIN
    FOR v_dan IN 2..9 LOOP
        FOR v_i IN 1..9  LOOP
            DBMS_OUTPUT.PUT_LINE(v_dan || ' x ' || v_i || ' = ' || v_dan * v_i );
        END LOOP;
    END LOOP;
END;
/


-- - - -
-- DAY-27 end line --
commit ;
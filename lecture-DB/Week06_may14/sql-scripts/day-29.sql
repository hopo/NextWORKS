-- DAY-29
-- ======

-- ### exA)
create or replace
procedure proc_new_job(
            p_job_id jobs.job_id%type,
            p_job_title jobs.job_title%type,
            p_min_sal jobs.min_salary%type := 1000,
            p_max_sal jobs.max_salary%type default 5000
        )
is
    v_cnt number;
begin
    -- 해당 업무코드 존재 확인
    select count(1) into v_cnt from jobs where job_id = p_job_id;
    
    -- v_cnt가 0과 같다면
    if v_cnt = 0 then
        insert into jobs (job_id, job_title, min_salary, max_salary)
        values (p_job_id, p_job_title, p_min_sal, p_max_sal) ;
    -- 그렇지 않다면
    else
        update jobs
        set job_title = p_job_title,
            min_salary = p_min_sal,
            max_salary = p_max_sal,
            update_date = sysdate
        where job_id = p_job_id ;
    end if;
    
    commit ;
end;
/

-- 확인
exec proc_new_job('SM_2001', 'Sample Job 2001', 2000, 6000);
exec proc_new_job('SM_2002', 'Sample Job 2002', 2000);
exec proc_new_job(p_job_title => '업무상세명', p_job_id => 'SM_2003', p_max_sal => 9990);

select*from jobs where job_id like 'SM_%';


-- ### OUT, IN OUT 매개변수
-- ### exA)
create or replace
procedure proc_out_test (p_var1 in varchar2, p_var2 out varchar2, p_var3 in out varchar2) 
is
begin
    dbms_output.put_line('p_var1 = ' || p_var1);
    dbms_output.put_line('p_var2 = ' || p_var2);
    dbms_output.put_line('p_var3 = ' || p_var3);
    
    -- out 변수에 값 할당
    p_var2 := 'HONG_KIL';
    p_var3 := 'KANG_KAM';
end;
/

-- pl/sql 안 procedure
declare
    v_var1 varchar2(20) := 'A';
    v_var2 varchar2(20) := 'B';
    v_var3 varchar2(20) := 'C';
begin
    proc_out_test( v_var1, v_var2, v_var3 );
    
    dbms_output.put_line('v_var1 = ' || v_var1);
    dbms_output.put_line('v_var2 = ' || v_var2);
    dbms_output.put_line('v_var3 = ' || v_var3);
    
end;
/

-- user_source 데이터 보기
select*from user_source;

-- 'proc_new_job'만 보기
select*from user_source
where name='PROC_NEW_JOB'
order by line;


-- ### EXAM
-- ### exA)
-- * proc_new_job의 내용을 merge를 이용해서 proc_new_job2 생성
create or replace
procedure proc_new_job2(
            p_job_id jobs.job_id%type,
            p_job_title jobs.job_title%type,
            p_min_sal jobs.min_salary%type := 1000,
            p_max_sal jobs.max_salary%type default 5000
        )
is
begin
    merge into jobs a
    using (select p_job_id j_id, p_job_title j_t, p_min_sal j_min, p_max_sal j_max from dual) b
    on (a.job_id = b.j_id)
    when matched then
        update set
            job_title = j_t,
            min_salary = j_min,
            max_salary = j_max
    when not matched then
        insert (job_id, job_title, min_salary, max_salary)
        values (j_id, j_t, j_min, j_max);
        
    commit ;
end;
/

-- 확인
exec proc_new_job2('SM_2010', 'Sample 2010', 1000, 7700);
select*from jobs where job_id like 'SM_%';


--
-- ### exB)
-- * p304
-- ch09_dept Table Create
create table ch09_dept (dept_id, dept_name, parent_id)
as
select department_id, department_name, parent_id
from departments;

-- 확인
select*from ch09_dept;

-- dept_manager_proc
-- 1. 플래그가 'upsert'이면 insert/update 실행(merge 하란 말) 'delete'이면 삭제
-- 삭제시 해당 사원이 있으면 삭제 하지 않는다
create or replace
procedure dept_manager_proc(
            p_dept_id number,
            p_dept_name Ch09_Dept.Dept_Name%type,
            p_parent_id Ch09_Dept.Parent_Id%type,
            p_flag varchar2
        )
is
    v_cnt number := 0;
begin
    case upper(p_flag)
        when 'UPSERT' then
            merge into ch09_dept a using(select p_dept_id dept_id from dual) b
            on (a.dept_id =b.dept_id)
            when matched then
                update set
                    dept_name = p_dept_name,
                    parent_id = p_parent_id
            when not matched then
                insert
                values (p_dept_id, p_dept_name, p_parent_id) ;
        when 'DELETE' then
            select count(1) into v_cnt
            from employees
            where department_id=p_dept_id;
            if v_cnt > 0 then
                dbms_output.put_line(p_dept_id || '는 사용중입니다.');
                return;
            else
                delete from ch09_dept where dept_id = p_dept_id;
            end if;
    end case;
    
    commit;
end;
/

-- 확인
exec DEPT_MANAGER_PROC(30, '출석부', 10, 'upsert');
exec DEPT_MANAGER_PROC(30, '출석부', 10, 'delete');
select*from ch09_dept;


-- - - -
-- DAY-29 --
commit ;

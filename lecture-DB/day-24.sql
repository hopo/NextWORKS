-- DAY-24
-- ======

-- ## 페이징
-- ### exA)
select b.*
from (
    select rownum as rn, employee_id, emp_name, salary, hire_date
    from employees
) b
where b.rn between 21 and 30 ;
-- * employees 테이블에 rownum을 붙이고 그 뷰를 이용하여 필요한 넘버만 페이지로 표시

--### exB)
-- * desc 한 뷰를 페이징 하기
select bb.*
from (
        select rownum as rn, aa.*
        from (
            select employee_id, emp_name, salary, hire_date
            from employees
            order by hire_date desc
        ) aa
) bb
where rn between 21 and 30 ;


--### exC)
-- * salary 3000 이상이라는 조건을 넣을 때
select bb.*
from (
        select rownum as rn, aa.*
        from (
            select employee_id, emp_name, salary, hire_date
            from employees
            where salary >= 3000
            order by hire_date desc
        ) aa
) bb
where rn between 1 and 20 ;

-- ### exD)
-- * rownum 20이하 레코드 까지 끝단을 설정 -> 속도를 개선한다
select bb.*
from (
        select rownum as rn, aa.*
        from (
            select employee_id, emp_name, salary, hire_date
            from employees
            where salary >= 3000
            order by hire_date desc
        ) aa
        where rownum <= 20
) bb
where rn between 11 and 20 ;

-- ### EXAM
-- ### exA)
-- * 입사일 내림차순
select rownum rn, a.*
from (
    select employee_id, emp_name, salary, hire_date
    from employees
    order by hire_date desc
) a ;

-- ### exB)
-- * 위 쿼리를 Analytic function ROW_NUMBER()을 사용해서 행 번호를 붙여라
select row_number() over(order by hire_date desc) rn, employee_id, emp_name, salary, hire_date
from employees ;
-- * rownum 부분과 order by 부분을 동시에 해결하는 효과

-- ### exC)
-- * exB를 이용하여 페이징
select * 
from (
    select row_number() over(order by hire_date desc) rn, employee_id, emp_name, salary, hire_date
    from employees
    where salary >= 3000
) a
where rn between 11 and 20;

-- ### exD)
-- * exB 뷰에 total count를 표시 하라
select row_number() over(order by hire_date desc) rn, employee_id, emp_name, salary, hire_date,
    count(1) over() tot_cnt
from employees ;
-- * total count는 페이지 갯수를 결정할 때 필요

/*
-- in MySQL
select * from
order by COL1 desc limit 999991, 10; -- (시작점, 길이)
*/


-- ## Window functions
-- ### FIRST_VALUE(), LAST_VALUE()
-- * 주어진 그룹 상에서 first_value() 가장 첫번째 값을, last_value()가장 마지막 값을
-- ### exA)
select employee_id, emp_name, salary, hire_date, department_id,
    first_value(emp_name) over() f1,
    first_value(emp_name) over(partition by department_id) f2
from employees ;

-- ### exB) first_value()
select employee_id, emp_name, salary, hire_date, department_id,
   first_value(emp_name) over(partition by department_id order by salary) f2,
   first_value(emp_name) over(
                            partition by department_id order by salary
                            rows between current row and unbounded following -- 참고 WINDOW clause (in day-23)
                         ) f3
from employees
where department_id in (30, 60);

--### exC) last_value()
select employee_id, emp_name, salary, hire_date, department_id,
   last_value(emp_name) over(partition by department_id order by salary) f2,
   last_value(emp_name) over(
                            partition by department_id order by salary
                            rows between current row and unbounded following
                        ) f3
from employees
where department_id in (30, 60);

-- ### exC2) last_value()
-- * f3 f4 비교
select employee_id, emp_name, salary, hire_date, department_id,
   last_value(emp_name) over(partition by department_id order by salary) f2,
   last_value(emp_name) over(partition by department_id order by salary
                            rows between current row and unbounded following) f3,
   last_value(emp_name) over(partition by department_id order by salary
                            rows between unbounded preceding and unbounded following) f4
from employees
where department_id in (30, 60);

-- ### NTH_VALUE()
-- ### exA)
select employee_id, emp_name, salary, hire_date, department_id,
   nth_value(emp_name,2) over(partition by department_id order by salary) f2,
   nth_value(emp_name,2) over(partition by department_id order by salary
                            rows between current row and unbounded following) f3
from employees
where department_id in (30, 60);

-- ### 기타함수
-- ### exA) WIDTH_BUCKET ; NTILE()와 비슷
select employee_id, emp_name, salary, hire_date, department_id,
    width_bucket(salary, 3000, 10000, 5) w1 -- 3000~10000, 5분할
from employees
where department_id in (30, 60);

/*
!!! 팀과제
ERD 과련 프로그램 사용법 설명
exERD 프러그인을 이클립스에 설치후 시연 -- 2~3개 테이블
샘플스키마를 예상하여 제출
*/
 
    


-- - - -
-- DAY-24 end line --
commit;

--
-- day-07 --
--


-- 부서코드(department_id) 가 10 또는 20 또는 50을 조회해 주세여
-- 사번, 사원명, 급여, 부서코드

select employee_id, emp_name, salary, department_id
from employees
where department_id = 10 or department_id = 20 or department_id = 50
--where department_id = any(10, 20, 50)
;
 
-- EXIST, 존재하니?
-- p118
select employee_id, emp_name, salary, department_id
from employees
where exists (select * from dual where 1 = 1);
;

select * from dual where 1 = 1;



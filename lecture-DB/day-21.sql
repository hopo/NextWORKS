-- DAY-21
-- ======
-- - - -
-- - - -

-- ## BOM - 계층형 함수
-- ### exA)
-- * DAY-20 복습
SELECT department_id,
       level,
       lpad(' ', (level - 1) * 3)
       || department_name,
       parent_id,
       CONNECT_BY_ROOT department_name AS root_name -- 루트노드의 정보
  FROM departments START WITH
    parent_id IS NULL -- 시작노드
CONNECT BY
    PRIOR department_id = parent_id -- 부모, 자식 노드 간의 관계
 ORDER SIBLINGS BY department_name;
-- * PRIOR: prior의 위치에 따라서 Top-Bottom 또는 Bottom-Top의 구조
 
-- ### exA2)
-- * root 포인트를 설정
SELECT department_id,
       level,
       lpad(' ', (level - 1) * 3)
       || department_name,
       parent_id,
       CONNECT_BY_ROOT department_name AS root_name
  FROM departments START WITH
    department_id IN (
        30,
        90
    )
CONNECT BY
    PRIOR department_id = parent_id
 ORDER SIBLINGS BY department_name;
 

-- #### 계층형 쿼리를 사용하는 예
-- * 자재비용 산출, 계층형게시판, 메뉴구조
-- ### exA)
-- * memu.sql에서 만든 테이블을 계층형으로 조회

-- search
SELECT *
  FROM menus;

-- root 시작
SELECT mnu_id,
       level,
       lpad(' ', (level - 1) * 3)
       || mnu_name,
       mnu_link,
       CONNECT_BY_ROOT mnu_id AS root_id
  FROM menus START WITH
    mnu_parent IS NULL
CONNECT BY
    PRIOR mnu_id = mnu_parent;

-- ## 계층형쿼리 심화
-- ### exA)
-- * CONNECT_BY_ISLEAF isleaf, -- 최하위 노드 여부
-- * SYS_CONNECT_BY_PATH(column, '|') path -- 시작부터 자신까지 구분자 '|'를 넣어 보기
SELECT department_id,
       level,
       lpad(' ', (level - 1) * 3)
       || department_name AS dep_name,
       parent_id,
       CONNECT_BY_ROOT department_name AS root_name,
       sys_connect_by_path(department_name, '|') path,
       CONNECT_BY_ISLEAF isleaf
  FROM departments START WITH
    parent_id IS NULL -- 시작노드
CONNECT BY
    PRIOR department_id = parent_id
 ORDER SIBLINGS BY department_name;
 
-- ### CONNECT BY 루프 오류
-- * p218
-- * 계층형 쿼리는 루프 알고리즘이다. 조건을 잘못 설정해 주면 무한 루프에 빠진다
--      + >> SQL 오류 : ORA-01436: CONNECT BY loop in user data
-- * 발생 (예상)시, CONNECT_BY_ISCYCLE과 NOCYCLE를 이용하여 문제 해결

-- ## 계층형 쿼리 응용
-- * p220
-- ### exA)
CREATE TABLE ex7_1
    AS
        SELECT ROWNUM rn,
               '2014'
               || lpad(ceil(ROWNUM / 1000), 2, '0') month,
               round(dbms_random.value(100, 10000) ) amt
          FROM dual
CONNECT
BY
    level <= 12000;
-- create table 결과 보기
SELECT *
  FROM ex7_1;
    
-- ## EXAM)
-- ### exA)
-- * 월별계산을 하다보니 빠진 달이 있는 어떤 해가 있다
-- * 이를 개선하고자 열 두달이 존재하는 인라인 뷰가 필요하다
-- * 1부터 12까지 존재하는 뷰를 만들어라
SELECT ROWNUM rn,
       level lv
  FROM dual CONNECT BY
    level <= 12;

-- ## LISTAGG(expr, delimiter) WITHIN GROUP (ORDER BY ~)
-- * raw를 column으로 변환
-- ### exA)
-- * 사원테이블에서 부서별, 사원수, 최대급여 평균급여를 조회
SELECT department_id,
       COUNT(1),
       MAX(salary),
       round(AVG(salary), 2) AS avg,
       LISTAGG(employee_id, ',') WITHIN  GROUP(
     ORDER BY emp_name
) e_names
  FROM employees
 GROUP BY department_id
 ORDER BY 1;

-- ## EXAM)
-- ### exA)
-- * 사원테이블에서 60번 부서의 입사월별 사원수, 최대급여, 평균급여를 조회
-- * 단, 모든 월이 나와야 합니다. (hire_date)
-- ing
SELECT ROWNUM rn
  FROM dual CONNECT BY
    level <= 12;
SELECT TO_CHAR(hire_date, 'MM'),
       emp_name
  FROM employees
 WHERE department_id = 60;
 
--
SELECT ROWNUM rn
  FROM dual CONNECT BY
    level <= 12;
    
--
SELECT TO_CHAR(hire_date, 'MM'),
       COUNT(1),
       MAX(salary),
       AVG(salary)
  FROM employees
 WHERE department_id = 60
 GROUP BY hire_date;

--
-- - - -
-- DAY-21 end line --
COMMIT;
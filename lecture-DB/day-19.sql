--
-- DAY-19 --
-- ======
-- - - -

-- * Binds
-- * View Snippets
-- - - -

-- ### departments TABLE info
SELECT
    *
FROM
    user_tab_cols
WHERE
    table_name = 'DEPARTMENTS';

-- Meta-Table을 이용해서 java에서 사용할 VO를 생성
-- 컬럼이름을 그대로 사용 또는 CamelCase
/*
!! in java
private int department_id ;
private String department_name = "";
!! convert
NUMBER -> int, VARCHAR2, CHAR -> String, DATE, TIMESTAMP _> String, java.util.Date
; 날짜는 String이 무난한 편
*/

-- exA) using case

SELECT
    column_name,
    data_type,
    CASE data_type
            WHEN 'NUMBER'   THEN 'int'
            ELSE 'String'
        END
    AS vo_data_type
FROM
    user_tab_cols
WHERE
    table_name = 'DEPARTMENTS';
    
-- exA2) using decode()

SELECT
    column_name,
    data_type,
    DECODE(data_type,'NUMBER','int','String') AS vo_data_type
FROM
    user_tab_cols
WHERE
    table_name = 'DEPARTMENTS';

-- exA3) using decode()

SELECT
    'private '
    || DECODE(data_type,'NUMBER','int ','String ')
    || lower(column_name)
    || DECODE(data_type,'NUMBER','','= ""')
    || ';'
FROM
    user_tab_cols
WHERE
    table_name = 'DEPARTMENTS';
    
-- exC)
-- 함수를 이용하여 원하는 문자열 만ㅁ들기
-- initcap(), replace()

SELECT
    substr(lower(column_name),1,1)
    || substr(replace(initcap(column_name),'_',''),2)
FROM
    user_tab_cols
WHERE
    table_name = 'DEPARTMENTS';
    

-- exD) Binds!!   

SELECT
    'private '
    || DECODE(data_type,'NUMBER','int ','String ')
    || lower(column_name)
    || DECODE(data_type,'NUMBER','','= ""')
    || ';'
FROM
    user_tab_cols
WHERE
    table_name = upper(:tb_name); -- Binds, Run시 입력 값을 받는다
    
    
-- ## SQL Developer Snippets 이용하기
-- * 메뉴 View-Snippets
-- * 쿼리들을 저장 해둬서 사용할 수 있다

COMMIT;
--
-- DAY-19 end line --
--
-- =====================================
-- 0815
-- =====================================

-- 
USE pc33_db;

-- 
SELECT * FROM pc33_db.tab_customer;
-- 
SELECT min(cust_id) FROM pc33_db.tab_customer;

-- LIMIT in mysql
SELECT cust_id, cust_name, cust_postal_code
FROM pc33_db.tab_customer
ORDER BY 1
LIMIT 100, 200;

-- rownum ex1
SELECT @RNUM := @RNUM + 1 AS ROWNUM
FROM ( SELECT @RNUM := 0 ) R;

-- rownum ex2
SELECT
	@RNUM := @RNUM + 1 AS ROWNUM, tc.*
FROM (
    SELECT *
    FROM tab_customer
    ORDER BY 1
) tc, (
	SELECT @RNUM := 0
) R

-- rownum ex2
SELECT
	@RNUM := @RNUM + 1 AS ROWNUM, tc.*
FROM (
    SELECT *
    FROM tab_customer
    ORDER BY 1
) tc, (
	SELECT @RNUM := 0
) R

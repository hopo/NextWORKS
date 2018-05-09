
-- # WITH clause practice
-- # in DAY-22


-- ### EXAM)
-- ### exA)
-- * 연도별, 최종월 기준 가장 대출이 많은 도시와 잔액을 조회

-- 1) 연도별 최종월을 조회
SELECT substr(period, 1, 4), MAX(period)
FROM kor_loan_status
GROUP BY substr(period, 1, 4);

-- 2) 기간별, 지역별 매출액
SELECT period, region, SUM(loan_jan_amt) jan_amt
FROM kor_loan_status
GROUP BY period, region;

-- 3) 1, 2 를 이용하여 최종월 기준 잔액 조회, 그 중에서 최고잔액
SELECT b.period, MAX(jan_amt)
FROM (
    SELECT substr(period, 1, 4) year, MAX(period) max_period
    FROM kor_loan_status
    GROUP BY substr(period, 1, 4)
) a, (
    SELECT period, region, SUM(loan_jan_amt) jan_amt
    FROM kor_loan_status
    GROUP BY period, region
) b
WHERE a.max_period = b.period
GROUP BY b.period;

-- 4) 2, 3의 결과에서 조건에 맞는 정보 추출
SELECT a.*
FROM (
    SELECT period, region, SUM(loan_jan_amt) jan_amt
    FROM kor_loan_status
    GROUP BY period, region
) a, (
    SELECT b.period,
           MAX(jan_amt) max_amt
    FROM (
        SELECT substr(period, 1, 4) year, MAX(period) max_period
        FROM kor_loan_status
        GROUP BY substr(period, 1, 4)
    ) a, (
        SELECT period, region, SUM(loan_jan_amt) jan_amt
        FROM kor_loan_status
        GROUP BY period, region
    ) b
    WHERE a.max_period = b.period
    GROUP BY b.period
) b
WHERE a.period = b.period
      AND a.jan_amt = b.max_amt;

--
-- # *** WITH

WITH t1 AS(
    SELECT period, region, SUM(loan_jan_amt) jan_amt
    FROM kor_loan_status
    GROUP BY period, region
),
t2 AS (
    SELECT t1.period, MAX(jan_amt) max_amt
    FROM (
        SELECT substr(period, 1, 4) year, MAX(period) max_period
        FROM kor_loan_status
        GROUP BY substr(period, 1, 4)
    ) a, t1
    WHERE a.max_period = t1.period
    GROUP BY t1.period
)
SELECT t1.*
FROM t1, t2
WHERE t1.period = t2.period
      AND t1.jan_amt = t2.max_amt;


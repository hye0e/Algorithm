-- 1. 2022년 8월부터 10월까지 대여 기록 조회 및 총 대여 횟수가 5회 이상인 자동차 필터링
WITH MonthlyRentalCounts AS (
    SELECT 
        CAR_ID,
        MONTH(START_DATE) AS MONTH,
        COUNT(*) AS TOTAL_RENTALS
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY 
        CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m')
),
CarRentalCounts AS (
    SELECT 
        CAR_ID,
        SUM(TOTAL_RENTALS) AS TOTAL_RENTAL_COUNT
    FROM 
        MonthlyRentalCounts
    GROUP BY 
        CAR_ID
    HAVING 
        SUM(TOTAL_RENTALS) >= 5
)

-- 2. 월별 자동차 ID별 대여 횟수 집계 및 정렬
SELECT 
    m.MONTH,
    m.CAR_ID,
    m.TOTAL_RENTALS AS RECORDS
FROM 
    MonthlyRentalCounts m
JOIN 
    CarRentalCounts c ON m.CAR_ID = c.CAR_ID
ORDER BY 
    m.MONTH ASC,
    m.CAR_ID DESC;

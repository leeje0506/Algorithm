SELECT
    FP.PRODUCT_ID,
    FP.PRODUCT_NAME,
    SUM(FO.AMOUNT * FP.PRICE) AS TOTAL_SALES
FROM
    FOOD_PRODUCT FP
JOIN
    FOOD_ORDER FO ON FP.PRODUCT_ID = FO.PRODUCT_ID
WHERE
    FO.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY
    FP.PRODUCT_ID,
    FP.PRODUCT_NAME
ORDER BY
    TOTAL_SALES DESC,
    FP.PRODUCT_ID ASC;

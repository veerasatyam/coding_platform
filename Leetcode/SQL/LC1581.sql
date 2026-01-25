# Write your MySQL query statement below
SELECT T1.customer_id,COUNT(*) AS count_no_trans
FROM Visits AS T1 LEFT JOIN Transactions
AS T2 ON T1.visit_id = T2.visit_id WHERE T2.visit_id IS NULL 
GROUP BY T1.customer_id;
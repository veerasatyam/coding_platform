# Write your MySQL query statement below
SELECT T2.product_name ,T1.year,T1.price FROM Sales AS T1 LEFT JOIN Product AS T2
ON T1.product_id=T2.product_id;
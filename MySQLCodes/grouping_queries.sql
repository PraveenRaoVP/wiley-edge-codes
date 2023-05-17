--group by works with aggregate functions
SELECT status FROM orders GROUP BY status;
--just returns distinct values
SELECT DISTINCT status from orders;

SELECT status, COUNT(*) FROM orders GROUP BY status;

-- get the total amount of all the order by status, join order table with orderdetails table

SELECT status, SUM(quantityOrdered*priceEach) AS Amount FROM orders INNER JOIN orderDetails
    USING (`orderNumber`)
    GROUP BY orderNumber; 
    
-- get the total amount of all the order by each year, join order table with orderdetails table
SELECT YEAR(orderDate), SUM(quantityOrdered*priceEach) AS Amount FROM orders INNER JOIN orderDetails
    USING (`orderNumber`)
    WHERE status="Shipped"
    GROUP BY YEAR(orderDate); 

--GROUP BY WITH HAVING CLAUSE
-- select the total sales of the years after 2004
SELECT YEAR(orderDate) AS year, SUM(quantityOrdered*priceEach) AS Amount FROM orders INNER JOIN orderDetails
    WHERE status="Shipped" GROUP BY year HAVING year > 2003;

--number of orders per YEAR
SELECT YEAR(orderDate) AS year, COUNT(*) AS NoOfOrders FROM orders GROUP BY year;
--number of orders per year by status desc
SELECT YEAR(orderDate) AS year, status, COUNT(*) AS NoOfOrders FROM orders  GROUP BY status, year;
--status count
SELECT status, COUNT(*) AS StatusCount from orders GROUP BY status;

SELECT orderNumber, SUM(quantityOrdered) AS ItemsCount, SUM(priceEach*quantityOrdered) AS Total FROM orderDetails
    GROUP BY `orderNumber`;

SELECT orderNumber, SUM(quantityOrdered) AS ItemsCount, SUM(priceEach*quantityOrdered) AS Total FROM orderDetails
    GROUP BY `orderNumber`
    HAVING total> 1000 AND ItemsCount > 600;

SELECT a.orderNumber, status, SUM(priceEach*quantityOrdered) AS total from orderDetails a INNER JOIN orders b 
ON a.`orderNumber` = b.orderNumber 
GROUP BY orderNumber, status 
HAVING status="Shipped" AND total > 1500;

--ROLLUP
CREATE TABLE sales
    SELECT productLine, YEAR(orderDate) AS orderYear, SUM(quantityOrdered*priceEach) AS total
    FROM orderDetails 
    INNER JOIN orders USING (orderNumber)
    INNER JOIN products USING (productCode)
    GROUP BY productLine, orderYear; 

SELECT
    productLine, SUM(total) AS totalOrderValue
FROM sales
GROUP BY productLine;

--create an empty GROUP 
SELECT SUM(total) AS totalOrderValue FROM sales;

--two or more GROUPS into one query (eg grand total).
SELECT productLine, SUM(total) AS totalOrderValue
FROM sales
GROUP BY `productLine`
UNION ALL
SELECT NULL, SUM(total) totalOrderValue 
FROM sales;

--ROLLUP
SELECT
    productLine, SUM(total) AS totalOrderValue
FROM sales
GROUP BY productLine WITH ROLLUP;

SELECT 
    orderYear,
    productLine,
    SUM(total) AS totalOrderValue
    FROM sales
    GROUP BY orderYear, `productLine`
    WITH ROLLUP;

--orderYear > productLine
-- to check whether null in the result set represent subtotal or grand totals, we use GROUPING() FUNCTION
-- return 1 when null occurs in super AGGREGATE ROW

SELECT
    IF(GROUPING(orderYear),'All Years', orderYear) orderYear,
    IF(GROUPING(productLine),"All Product Line", `productLine`) productLine,
    SUM(total) totalOrderValue
FROM sales
GROUP BY `orderYear`,`productLine` WITH ROLLUP;


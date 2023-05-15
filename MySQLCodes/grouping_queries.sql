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
SELECT lastName, firstName FROM employees
WHERE `officeCode` IN (
    SELECT officeCode FROM offices WHERE country="USA"
);

SELECT 
    customerNumber, checkNumber, amount
    FROM payments
    WHERE amount=(SELECT MAX(amount) FROM payments);
SELECT 
    customerNumber, checkNumber, amount
    FROM payments
    WHERE amount > (SELECT AVG(amount) FROM payments);

--customers with no orders
SELECT 
    customerName
    FROM customers WHERE 
    `customerNumber` NOT IN 
    (SELECT DISTINCT customerNumber FROM orders);

SELECT
    MAX(items), AVG(items), MIN(items)
    FROM(
        SELECT orderNumber, COUNT(orderNumber) AS items FROM orderDetails GROUP BY orderNumber
    ) AS lineItems;


-- corelated QUERY
SELECT
    productName, buyPrice
    FROM products p1 
    WHERE `buyPrice` > (
        SELECT AVG(buyPrice) FROM products WHERE `productLine`=p1.`productLine`
    );

--EXISTS QUERY
SELECT 
    orderNumber, SUM(quantityOrdered*priceEach) from orderDetails INNER JOIN orders 
    USING (orderNumber) 
    GROUP BY `orderNumber`
    HAVING SUM(`priceEach`*`quantityOrdered`) > 60000;

SELECT customerNumber, customerName from customers WHERE EXISTS (SELECT 
    orderNumber, SUM(quantityOrdered*priceEach) from orderDetails INNER JOIN orders 
    USING (orderNumber) 
    GROUP BY `orderNumber`
    HAVING SUM(`priceEach`*`quantityOrdered`) > 60000);

-- get top 5 products by sales revenue in 2003 from orders and orderDetails table
SELECT
    productCode, SUM(quantityOrdered*priceEach) sales 
    FROM orderDetails INNER JOIN orders USING(`orderNumber`)
    WHERE YEAR(`shippedDate`)=2003
    GROUP BY `productCode`
    ORDER BY sales DESC
    LIMIT 5;

-- Use the result of the query as a derived table and join it with products table
SELECT productName, sales 
    FROM (
        SELECT productCode, ROUND(SUM(quantityOrdered*priceEach)) AS sales 
    FROM orderDetails INNER JOIN orders USING(`orderNumber`)
    WHERE YEAR(`shippedDate`)=2003
    GROUP BY `productCode`
    ORDER BY sales DESC
    LIMIT 5
    ) top5ProductOf2003 INNER JOIN products USING (`productCode`);

SELECT
    customerNumber,
    ROUND(SUM(quantityOrdered*priceEach)) AS sales ,
    (CASE 
        WHEN SUM(quantityOrdered*priceEach)<10000 THEN "Silver"
        WHEN SUM(quantityOrdered*priceEach) BETWEEN 10000 AND 100000 THEN "Gold" 
        WHEN SUM(`quantityOrdered`*`priceEach`) > 100000 THEN "Platinum"
    END) AS membership FROM orderDetails INNER JOIN orders USING(`orderNumber`) WHERE YEAR(`shippedDate`)=2003
    GROUP BY `customerNumber`;

SELECT 
    membership,
    COUNT(cg.membership) as groupCount 
    FROM (
        SELECT
    customerNumber,
    ROUND(SUM(quantityOrdered*priceEach)) AS sales ,
    (CASE 
        WHEN SUM(quantityOrdered*priceEach)<10000 THEN "Silver"
        WHEN SUM(quantityOrdered*priceEach) BETWEEN 10000 AND 100000 THEN "Gold" 
        WHEN SUM(`quantityOrdered`*`priceEach`) > 100000 THEN "Platinum"
    END) AS membership FROM orderDetails INNER JOIN orders USING(`orderNumber`) WHERE YEAR(`shippedDate`)=2003
    GROUP BY `customerNumber`
    ) cg GROUP BY cg.membership;

--Customers who have atleast one order using EXISTS
SELECT customerNumber FROM customers WHERE EXISTS(SELECT 1 from orders WHERE orders.`customerNumber`=customers.`customerNumber`);

--customers with no orders
SELECT customerNumber FROM customers WHERE NOT EXISTS(SELECT 1 from orders WHERE orders.`customerNumber`=customers.`customerNumber`);


SELECT 
    employeeNumber, firstName, lastName, extension
    FROM employees
    WHERE EXISTS(
        SELECT NULL FROM offices WHERE city="San Francisco" AND offices.`officeCode`=employees.`officeCode`
    ) ;

UPDATE employees SET extension=CONCAT(extension,'1')
WHERE EXISTS(
        SELECT 1 FROM offices WHERE city="San Francisco" AND offices.`officeCode`=employees.`officeCode`
    );


CREATE TABLE customer_archive LIKE customers;
INSERT INTO customer_archive (SELECT * FROM customers WHERE NOT EXISTS (
    SELECT 1 FROM orders WHERE orders.`customerNumber` = customers.`customerNumber`
)) ;

SELECT * FROM customer_archive;

--mysql delete exists
DELETE FROM customers WHERE EXISTS (
    SELECT 1 from customer_archive a
    WHERE a.customerNumber = customers.`customerNumber`
);

-- IN vs EXISTS
SELECT customerNumber, customerName
FROM customers WHERE customerNumber IN ( SELECT customerNumber from orders);

SELECT customerNumber, customerName
FROM customers WHERE EXISTS (SELECT 1 FROM orders WHERE orders.`customerNumber` = customers.`customerNumber`);

EXPLAIN SELECT
    customerName, customerNumber
    FROM customers 
    WHERE EXISTS(SELECT 1 FROM orders WHERE orders.`customerNumber` = customers.`customerNumber`);


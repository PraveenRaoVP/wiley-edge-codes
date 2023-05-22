SET AUTOCOMMIT = OFF;
use empdb;
show tables;
COMMIT;
SELECT * FROM cars;
DELETE FROM cars;
SELECT * FROM cars;
INSERT INTO cars VALUES(1,2009,'dawd','wdaw');
COMMIT;
ROLLBACK;
INSERT INTO cars VALUES(2,2010,'daddwd','waswdwdaw');


------------------------------------
 -- 1. start a new transaction
use wileyclassic;
START TRANSACTION;

-- 2. Get the latest order number
SELECT 
    @orderNumber:=MAX(orderNUmber)+1
FROM
    orders;

-- 3. insert a new order for customer 145
INSERT INTO orders(orderNumber,
                   orderDate,
                   requiredDate,
                   shippedDate,
                   status,
                   customerNumber)
VALUES(@orderNumber,
       '2005-05-31',
       '2005-06-10',
       '2005-06-11',
       'In Process',
        145);
        
-- 4. Insert order line items
INSERT INTO orderdetails(orderNumber,
                         productCode,
                         quantityOrdered,
                         priceEach,
                         orderLineNumber)
VALUES(@orderNumber,'S18_1749', 30, '136', 1),
      (@orderNumber,'S18_2248', 50, '55.09', 2); 
      
-- 5. commit changes    
COMMIT;



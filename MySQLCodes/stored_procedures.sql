DELIMITER $$ 
CREATE PROCEDURE GetProducts() BEGIN 
SELECT * FROM products; 
END $$ DELIMITER;
CALL GetProducts();
--  DELIMITER $$
--  CREATE PROCEDURE GetCustomerDetails()
--     BEGIN
--         SELECT customerName,
--             city,
--             state,
--             postalCode,
--             country
--             FROM customers ORDER BY `customerName`;
--     END $$ DELIMITER;

-- CALL GetCustomerDetails();

-- SELECT * FROM customers;
DELIMITER $$ USE wileyclassic $$ CREATE PROCEDURE GetAllCustomers() BEGIN SELECT * from customers; END $$ DELIMITER;

SHOW PROCEDURE status;

DELIMITER $$ CREATE PROCEDURE GetOfficeByCountry(IN customerName VARCHAR(255)) BEGIN SELECT * FROM offices WHERE country=customerName; END $$ DELIMITER;
CALL GetOfficeByCountry("USA");

DELIMITER $$ CREATE PROCEDURE GetNumberOfOrders(IN orderStatus VARCHAR(25), OUT total INT) BEGIN SELECT COUNT(orderNumber) INTO total FROM orders WHERE status=orderStatus; END $$ DELIMITER;

CALL GetNumberOfOrders("Shipped", @total);
SELECT @total AS total_in_process; 


DELIMITER $$ CREATE PROCEDURE SetCounter(IN counter INT, IN inc INT) BEGIN SET counter = counter+inc; END $$ DELIMITER;
SET @counter = 1;
CALL SetCounter(@counter,1);
SELECT @counter;
CALL SetCounter(@counter,5);



DELIMITER $$ CREATE PROCEDURE GetTotalOrders() BEGIN DECLARE totalOrder INT DEFAULT 0; SELECT COUNT(*) INTO totalORder FROM orders; SELECT totalORder; END $$ DELIMITER;

CALL `GetTotalOrders`();

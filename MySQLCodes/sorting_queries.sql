-- sort data by last NAME
SELECT contactLastName, contactFirstName from customers ORDER BY `contactLastName`;
SELECT contactLastName, contactFirstName from customers ORDER BY `contactLastName` DESC, `contactFirstName` ASC;

-- orderline items from orderDetails table to calculate subtotal and sort subtotal
SELECT orderNumber, orderLineNumber, quantityOrdered*priceEach AS subtotal FROM orderDetails ORDER BY subtotal DESC LIMIT 10;

SELECT orderNumber, status from orders ORDER BY FIELD(status,"In Process","On Hold", "Cancelled", "Resolved","Disputed","Shipped");

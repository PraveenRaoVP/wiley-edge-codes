WITH customers_in_usa AS (
    SELECT customerName, state from customers WHERE country="USA"
) SELECT customerName FROM customers_in_usa WHERE state="CA";
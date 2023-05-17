-- Active: 1684126024255@@127.0.0.1@3306@empdb
CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);

-- insert some rows into the tables members and committees
INSERT INTO members(name)
VALUES('Venkat'),('Jahnavi'),('Rishav'),('Sachin'),('Anjali');

INSERT INTO committees(name)
VALUES('Venkat'),('Rishav'),('Anjali'),('Steve');

-- Verify the data
SELECT * FROM members;
SELECT * FROM committees;

-- MySQL INNER JOIN clause
-- The following shows the basic syntax of the inner join clause that joins two tables table_1 and table_2:
SELECT column_list
FROM table_1
INNER JOIN table_2 ON join_condition;

-- Inner join clause to find members who are also the committee members:
SELECT 
    m.member_id, 
    m.name AS member, 
    c.committee_id, 
    c.name AS committee
FROM
    members m
INNER JOIN committees c ON c.name = m.name;

-- MySQL LEFT JOIN clause

SELECT column_list 
FROM table_1 
LEFT JOIN table_2 ON join_condition;


-- left join clause to join the members with the committees table:
SELECT 
    m.member_id, 
    m.name AS member, 
    c.committee_id, 
    c.name AS committee
FROM
    members m
LEFT JOIN committees c USING(name);


-- MySQL RIGHT JOIN clause

SELECT column_list 
FROM table_1 
RIGHT JOIN table_2 ON join_condition;

SELECT column_list 
FROM table_1 
RIGHT JOIN table_2 USING (column_name);

-- To find rows in the right table that does not have corresponding rows in the left table, you also use a WHERE clause with the IS NULL operator:
SELECT column_list 
FROM table_1 
RIGHT JOIN table_2 USING (column_name)
WHERE column_table_1 IS NULL;

-- use the right join to join the members and committees tables:
SELECT 
    m.member_id, 
    m.name AS member, 
    c.committee_id, 
    c.name AS committee
FROM
    members m
RIGHT JOIN committees c on c.name = m.name;



-- MySQL CROSS JOIN clause

SELECT select_list
FROM table_1
CROSS JOIN table_2;


-- use the cross join clause to join the members with the committees tables:

SELECT 
    m.member_id, 
    m.name AS member, 
    c.committee_id, 
    c.name AS committee
FROM
    members m
CROSS JOIN committees c;

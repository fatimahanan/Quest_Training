use hotelreservationsystem;

CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    phone_number VARCHAR(11) NOT NULL,
    address VARCHAR(20) NOT NULL
);

CREATE TABLE Rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_type ENUM('single', 'double', 'suite') NOT NULL,
    price_per_night INT NOT NULL,
    status ENUM('available', 'occupied', 'under maintenance') NOT NULL,
    floor_number INT NOT NULL
);

CREATE TABLE Reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    room_id INT,
    reservation_date DATE NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    status ENUM('confirmed', 'cancelled', 'completed') NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

CREATE TABLE Payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    reservation_id INT,
    payment_date DATE NOT NULL,
    amount_paid INT NOT NULL,
    payment_method ENUM('credit card', 'cash') NOT NULL,
    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id)
);

CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    role ENUM('receptionist','manager','house keeper','security','shuttle driver','valet') NOT NULL,
    hire_date DATE NOT NULL
);

CREATE TABLE Room_Assignments (
    assignment_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT,
    room_id INT,
    assignment_date DATE NOT NULL,
    task_description TEXT,
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

 -- 3NF Normalizatiom
ALTER TABLE Customers DROP COLUMN address;

CREATE TABLE Customer_Addresses (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    city VARCHAR(50) NOT NULL,
    postal_code INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

SELECT * FROM CUSTOMERS;
SELECT * FROM Customer_Addresses;
SELECT * FROM Rooms;
SELECT * FROM Reservations;
SELECT * FROM Staff;
SELECT * FROM Payments;

INSERT INTO Customers (first_name, last_name, email, phone_number) VALUES
('Harry', 'Steve', 'harry@gmail.com', '8234567890'),
('John', 'Austin', 'john@hotmai.com', '7745678901'),
('Benita', 'Paul', 'benita@gmail.com', '81456789012'),
('Cheryl', 'David', 'cheryl@gmail.com', '7567890123'),
('Nuha', 'Althaf', 'nuha@hotmail.com', '9678901234');

INSERT INTO Customer_Addresses (customer_id, city, postal_code) VALUES
(1, 'Delhi', '622701'),
(2, 'Chennai', '629902'),
(3, 'Bangalore', '627303'),
(4, 'Chennai', '692704'),
(5, 'Kochi', '670028');

INSERT INTO Rooms (room_type, price_per_night, status, floor_number) VALUES
('single', 4000, 'available', 1),
('double', 6000, 'occupied', 2),
('suite', 12000, 'under maintenance', 3),
('single', 5000, 'available', 2),
('suite', 10000, 'available', 1);

INSERT INTO Reservations (customer_id, room_id, reservation_date, check_in_date, check_out_date, status) VALUES
(1, 1, '2024-11-01', '2024-11-05', '2024-11-10', 'confirmed'),
(2, 2, '2024-11-02', '2024-11-08', '2024-11-12', 'confirmed'),
(3, 3, '2024-11-03', '2024-11-06', '2024-11-09', 'confirmed'),
(4, 1, '2024-11-06', '2024-11-10', '2024-11-15', 'cancelled'),  
(5, 3, '2024-11-07', '2024-11-08', '2024-11-09', 'completed');

INSERT INTO Staff (first_name, last_name, role, hire_date) VALUES
('Alice', 'Green', 'receptionist', '2023-05-01'),
('Bobby', 'Ray', 'manager', '2022-03-15'),
('Jenna', 'Taylor', 'house keeper', '2024-02-20'),
('Diana', 'Swift', 'security', '2023-11-10'),
('Eva', 'Johnson', 'valet', '2022-04-01');

INSERT INTO Payments (reservation_id, payment_date, amount_paid, payment_method) VALUES
(15, '2024-11-02', 40000, 'credit card'),  
(16, '2024-11-03', 12000, 'cash'),        
(17, '2024-11-04', 36000, 'credit card'),  
(18, '2024-11-07', 40000, 'cash'),         
(19, '2024-11-08', 12000, 'credit card');  

INSERT INTO Room_Assignments (staff_id, room_id, assignment_date, task_description) VALUES
(13, 1, '2024-11-06', 'Clean and prepare room for new guest'), -- Housekeeper Jenna for Room 1
(13, 2, '2024-11-08', 'Clean and maintain room'),              -- Housekeeper Jenna for Room 2
(14, 3, '2024-11-07', 'Security check for room 3'),            -- Security Diana for Room 3
(15, 4, '2024-11-09', 'Assist with parking and check-in'),     -- Valet Eva for Room 4
(12, 5, '2024-11-10', 'Manager overseeing guest check-in');    -- Manager Bobby for Room 5

-- Retrieve all information about rooms available on a specific floor.
SELECT 
    ro.room_id, 
    ro.room_type, 
    ro.price_per_night, 
    ro.status AS room_status, 
    ro.floor_number,
    r.reservation_id,
    r.customer_id, 
    r.reservation_date, 
    r.check_in_date, 
    r.check_out_date, 
    r.status AS reservation_status
FROM Rooms ro LEFT JOIN Reservations r  -- left join includes rooms without reservations too
ON ro.room_id = r.room_id
WHERE 
    ro.floor_number = 1 
    AND ro.status = 'available';
 
 
 -- List all reservations with customer details (first name, last name, email) sorted by check-in date (earliest first). 
SELECT 
    r.reservation_id, 
    r.room_id, 
    r.reservation_date, 
    r.check_in_date, 
    r.check_out_date, 
    r.status AS reservation_status,
    c.first_name, 
    c.last_name, 
    c.email
FROM 
    Reservations r JOIN Customers c
ON r.customer_id = c.customer_id
ORDER BY r.check_in_date ASC;

-- Find all customers who have reserved rooms for more than 5 nights. Use DATEDIFF function to calculate the number of nights.
SELECT 
    c.customer_id, 
    c.first_name, 
    c.last_name, 
    c.email, 
    r.reservation_id, 
    r.check_in_date, 
    r.check_out_date, 
    DATEDIFF(r.check_out_date, r.check_in_date) AS nights_reserved
FROM Reservations r JOIN Customers c 
ON r.customer_id = c.customer_id
WHERE DATEDIFF(r.check_out_date, r.check_in_date)>3;

-- Get the total amount paid for each reservation. Use SUM() to aggregate the payment amounts and group by reservation.
SELECT 
    r.reservation_id, 
    SUM(p.amount_paid) AS total_amount_paid
FROM Reservations r JOIN Payments p 
ON r.reservation_id = p.reservation_id
GROUP BY r.reservation_id;

-- Find the average room price for each room type. Use GROUP BY with AVG().
SELECT 
    room_type, 
    AVG(price_per_night) AS average_room_price
FROM Rooms
GROUP BY room_type;

-- Display the total revenue generated from all reservations in the last month. Use SUM() and WHERE with date filters.
SELECT 
    SUM(p.amount_paid) AS total_revenue_last_month
FROM Payments p JOIN Reservations r 
ON p.reservation_id = r.reservation_id
WHERE 
    r.reservation_date >= DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH) AND r.reservation_date < CURRENT_DATE;  -- DATE_SUB(to subtarct 1 month interval from current date)
  
-- Retrieve the most recent reservation for each customer. Use JOIN, GROUP BY, and ORDER BY to get the latest reservation per customer.
SELECT 
	c.customer_id,
    c.first_name, 
    c.last_name, 
    c.email,
    c.phone_number,
    r.reservation_id,
    r.room_id,
    MAX(r.reservation_date) AS last_reservation_date,
    r.check_in_date,
    r.check_out_date,
    r.status AS reservation_status
FROM Reservations r JOIN Customers c
ON r.customer_id = c.customer_id
GROUP BY c.customer_id;

-- Room Availability Check: Create a query that checks which rooms are available for a given date range (i.e., not reserved for those dates). Use NOT EXISTS or LEFT JOIN to find rooms with no overlapping reservations.
SELECT 
    r.room_id, 
    r.room_type, 
    r.price_per_night, 
    r.status AS room_status,
    r.floor_number
FROM Rooms r LEFT JOIN Reservations res 
ON 
	r.room_id = res.room_id
	AND res.check_in_date >= '2024-01-20' 
    AND res.check_out_date <= '2024-02-15'
WHERE 
    r.status = 'available' 
    AND res.reservation_id IS NULL;  










SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;














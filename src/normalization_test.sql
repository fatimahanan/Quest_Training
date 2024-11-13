create database normalization_test;
use normalization_test;

-- Convert the following table into 1NF: Table Orders with Columns: `OrderID`, `CustomerName`, `ProductNames` (where `ProductNames` might contain multiple product names separated by commas).
create table Orders (
	order_id int primary key auto_increment,
    customer_name varchar(25),
    product_names varchar(100)
    );


insert into Orders (customer_name, product_names) VALUES
('Jerry Thomas', 'Milk, Sugar'),
('Allen Smith', 'Jam, Bread'),
('Zac Efron', 'Butter, Bread'),
('Sarah Williams', 'Milk, Water'),
('Ray Smith', 'Jam, Milk, Butter');

select * from Orders;

-- converting to 1NF
create table Orders_1NF (
	order_id int primary key auto_increment,
    customer_name varchar(25),
    product_names varchar(100)
    );
    
insert into Orders_1NF (customer_name, product_names) VALUES
('Jerry Thomas', 'Milk'),
('Jerry Thomas', 'Sugar'),
('Allen Smith', 'Jam'),
('Allen Smith', 'Bread'),
('Zac Efron', 'Butter'),
('Zac Efron', 'Bread'),
('Sarah Williams', 'Milk'),
('Sarah Williams', 'Water'),
('Ray Smith', 'Jam'),
('Ray Smith', 'Milk'),
('Ray Smith', 'Butter');

-- 2NF
CREATE TABLE Student_Courses (
    StudentID INT,
    StudentName VARCHAR(100),
    CourseID INT,
    CourseName VARCHAR(100),
    InstructorID INT,
    InstructorName VARCHAR(100),
    PRIMARY KEY (StudentID, CourseID)
);
INSERT INTO Student_Courses (StudentID, StudentName, CourseID, CourseName, InstructorID, InstructorName) 
VALUES (1, 'Alice', 101, 'Math', 201, 'Dr. Smith');
INSERT INTO Student_Courses (StudentID, StudentName, CourseID, CourseName, InstructorID, InstructorName) 
VALUES (1, 'Alice', 102, 'Physics', 202, 'Dr. Johnson');
INSERT INTO Student_Courses (StudentID, StudentName, CourseID, CourseName, InstructorID, InstructorName) 
VALUES (2, 'Bob', 101, 'Math', 201, 'Dr. Smith');
INSERT INTO Student_Courses (StudentID, StudentName, CourseID, CourseName, InstructorID, InstructorName) 
VALUES (2, 'Bob', 103, 'Chemistry', 203, 'Dr. Lee');
INSERT INTO Student_Courses (StudentID, StudentName, CourseID, CourseName, InstructorID, InstructorName) 
VALUES (3, 'Carol', 104, 'Biology', 204, 'Dr. Taylor');
    
-- converting 2NF
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100)
);

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(100),
    InstructorID INT
);

CREATE TABLE Instructor (
	Instructor_ID INT,
    Instructor_Name VARCHAR(100)
    );

CREATE TABLE Student_Course (   -- association
    StudentID INT,
    CourseID INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

INSERT INTO Students (StudentID, StudentName) 
VALUES 
    (1, 'Alice'),
    (2, 'Bob'),
    (3, 'Carol');

INSERT INTO Courses (CourseID, CourseName, InstructorID) 
VALUES 
    (101, 'Math', 201),
    (102, 'Physics', 202),
    (103, 'Chemistry', 203),
    (104, 'Biology', 204);
    
INSERT INTO Instructor (InstructorID, InstructorName) 
VALUES 
	(201, 'Dr. Smith'),
	(202, 'Dr. Johnson'),
	(203, 'Dr. Lee'),
	(204, 'Dr. Taylor');
    
INSERT INTO Student_Course (StudentID, CourseID) 
VALUES 
    (1, 101),
    (1, 102),
    (2, 101),
    (2, 103),
    (3, 104);
    
select * from student_courses;
select * from students;
select * from courses;
select * from instructors;
select * from student_course;

-- 3NF
CREATE TABLE Sales (
    SalesID INT PRIMARY KEY,
    ProductID INT,
    ProductName VARCHAR(100),
    CategoryID INT,
    CategoryName VARCHAR(100),
    SaleDate DATE
);

INSERT INTO Sales (SalesID, ProductID, ProductName, CategoryID, CategoryName, SaleDate) VALUES 
(1, 1001, 'Laptop', 200, 'Electronics', '2024-01-10'),
(2, 1002, 'Phone', 200, 'Electronics', '2024-01-11'),
(3, 1003, 'Chair', 201, 'Furniture', '2024-01-12'),
(4, 1004, 'Desk', 201, 'Furniture', '2024-01-13'),
(5, 1005, 'Tablet', 200, 'Electronics', '2024-01-14');

-- converting to 3nf
CREATE TABLE Category(
    CategoryID INT PRIMARY KEY,
    CategoryName VARCHAR(100)
);

CREATE TABLE Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    CategoryID INT,
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

CREATE TABLE Sales_3NF (
    SalesID INT PRIMARY KEY,
    ProductID INT,
    SaleDate DATE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

INSERT INTO Category (CategoryID, CategoryName) VALUES 
(200, 'Electronics'),
(201, 'Furniture');

INSERT INTO Product (ProductID, ProductName, CategoryID) VALUES 
(1001, 'Laptop', 200),
(1002, 'Phone', 200),
(1003, 'Chair', 201),
(1004, 'Desk', 201),
(1005, 'Tablet', 200);

INSERT INTO Sales_3NF (SalesID, ProductID, SaleDate) VALUES 
(1, 1001, '2024-01-10'),
(2, 1002, '2024-01-11'),
(3, 1003, '2024-01-12'),
(4, 1004, '2024-01-13'),
(5, 1005, '2024-01-14');

select * from Sales;
select * from Category;
select * from Product;
select * from Sales_3NF;

-- BONUS
-- Write an SQL statement to create a table in 1NF with the following information: Columns: BookID, Title, Authors (where each book can have multiple authors).
CREATE TABLE BookAuthors (
    BookID INT,
    Title VARCHAR(255),
    Author VARCHAR(100),
    PRIMARY KEY (BookID, Author)
);
INSERT INTO BookAuthors (BookID, Title, Author) VALUES 
(1, 'Ikigai', 'Hector Garcia'),
(1, 'Ikigai', 'Francesc Miralles'),
(2, 'The Talisman', 'Peter Straub'),
(2, 'The Talisman', 'Stephen King'),
(3, 'Harry Potter', 'J K Rowling');

select * from BookAuthors;

-- bonus 2 
CREATE TABLE Suppliers_B2 (
    SupplierID INT PRIMARY KEY,
    SupplierName VARCHAR(100)
);

CREATE TABLE Products_B2 (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    SupplierID INT,
    FOREIGN KEY (SupplierID) REFERENCES Suppliers_B2(SupplierID)
);

CREATE TABLE Orders_B2 (
    OrderID INT PRIMARY KEY,
    ProductID INT,
    FOREIGN KEY (ProductID) REFERENCES Products_B2(ProductID)
);

INSERT INTO Suppliers_B2 (SupplierID, SupplierName) VALUES 
(1, 'Gadegon'),
(2, 'ControlQore'),
(3, 'Star Link');

INSERT INTO Products_B2 (ProductID, ProductName, SupplierID) VALUES 
(101, 'Laptop', 1),
(102, 'Smartphone', 2),
(103, 'Printer', 3),
(104, 'Tablet', 1);

INSERT INTO Orders_B2 (OrderID, ProductID) VALUES 
(1, 101),
(2, 102),
(3, 103),
(4, 104);

select * from Orders_B2;
select * from Suppliers_B2;
select * from Products_B2;








use library_management;

CREATE TABLE Authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL
);
CREATE TABLE Books (
	book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author_id INT,
    publication_year YEAR,
    price DECIMAL(10, 2),
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);
CREATE TABLE Borrowers (
    borrower_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    dob DATE NOT NULL
);
CREATE TABLE Loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    borrower_id INT,
    book_id INT,
    loan_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (borrower_id) REFERENCES Borrowers(borrower_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

INSERT INTO Authors (first_name,last_name) 
VALUES ("John","Green"),
	   ("Roald","Dahl"),
	   ("Paulo","Coelho"),
       ("Khaled","Hosseini"),
       ("Enid","Blyton");

INSERT INTO Books (title, author_id, publication_year, price) 
VALUES ("The Fault in Our Stars", 1, 2012, 700),
       ("The Kite Runner", 4, 2003, 900),
       ("Matilda", 2, 2017, 600),
       ("Turtles All the Way Down", 1, 1998, 899),
       ("The AlChemist",3, 1998, 1200);
       
INSERT INTO Borrowers (first_name, last_name, email, dob) 
VALUES ('Fatima', 'Hanan', 'alice@yahoo.com', '2001-01-15'),
       ('Bob', 'Harris', 'bob@gmail.com', '2013-07-22'),
       ('Charlie', 'Thomas', 'charlie@gmail.com', '2003-09-03'),
       ('Shreya','Pramod', 'shreya@gmail.com', '2002-10-18'),
       ('Abel', 'Shone', 'abel@hotmail.com', '2003-02-25');

INSERT INTO Loans (borrower_id, book_id, loan_date, return_date) 
VALUES (1, 1, '2024-02-01', '2024-10-15'),
	   (2, 2, '2023-10-05', '2024-11-19'),
	   (3, 3, '2023-09-10', '2024-10-24'),
       (1, 2, '2024-10-12', '2024-11-26'),
       (2, 1, '2024-08-15', '2024-10-29');
       
-- Select all columns from the Books table.
select * from Books;

-- Select the title, price, and publication_year of books where price > 20.
select title, price, publication_year from Books where price>20;	

-- Select the first_name, last_name, and email of borrowers who have borrowed books after '2024-01-01'.
SELECT DISTINCT first_name, last_name, email
	FROM Borrowers JOIN Loans 
    ON Borrowers.borrower_id=Loans.borrower_id
    WHERE Loans.loan_date>'2024-01-01';

-- Update the price of the book with title = 'The Fault in Our Stars' to 800
UPDATE Books SET price=800 WHERE title='Fault in Our Stars';

-- Delete the book from the Books table where title = 'The Kite Runner'
DELETE FROM Loans WHERE book_id = (SELECT book_id FROM Books WHERE title = 'The Kite Runner');
DELETE FROM Books WHERE title='The Kite Runner';

-- Alter the Books table to add a new column genre of type VARCHAR(50).
ALTER TABLE Books 
ADD COLUMN genre VARCHAR(50);

-- Use the COUNT function to find the total number of borrowers.
SELECT COUNT(borrower_id) AS total_no_of_borrowers FROM Borrowers;

-- Use the SUM function to find the total price of all books in the library.
SELECT SUM(price) AS total_price FROM Books;

-- Use the AVG function to calculate the average price of books.
SELECT AVG(price) AS average_price FROM Books;

-- Write a subquery to find all books that have been borrowed by any borrower who is over 12 years old.
SELECT DISTINCT b.title FROM Books b
WHERE b.book_id IN (
    SELECT l.book_id
    FROM Loans l JOIN Borrowers br 
    ON l.borrower_id = br.borrower_id
    WHERE DATEDIFF(CURDATE(), br.dob) / 365 > 12
);



select * from books;
select * from borrowers;
select * from loans;
select * from authors;

SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;
    

    

       

    




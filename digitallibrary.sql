CREATE DATABASE DigitalLibrary;
GO

USE DigitalLibrary;
GO

CREATE TABLE BOOK(
	BookID INT PRIMARY KEY,
	Title NVARCHAR(200) NOT NULL,
	Author NVARCHAR(100) NOT NULL,
	Publisher NVARCHAR(100),
	PublishYear INT,
	Quantity INT NOT NULL
);

INSERT INTO BOOK
	(BookID, Title, Author, Publisher, PublishYear, Quantity)
VALUES
    (101, N'Java Programming', N'James Gosling', N'Pearson', 2024, 10),
    (102, N'Clean Code', N'Robert C. Martin', N'Prentice Hall', 2008, 5),
    (103, N'Database Systems', N'Elmasri', N'Pearson', 2022, 8);


SELECT * FROM BOOK;
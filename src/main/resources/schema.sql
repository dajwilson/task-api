Create Table Tasks (
    Id int NOT NULL AUTO_INCREMENT,
    Name varchar(255) NOT NULL,
    Priority int NOT NULL,
    Inprogress boolean NOT NULL,
    Incomplete boolean NOT NULL
);
CREATE DATABASE IF NOT EXISTS recruitmentdb;
USE recruitmentdb;

CREATE TABLE IF NOT EXISTS storeuser (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL, -- Name can be duplicated
    email VARCHAR(50) NOT NULL UNIQUE, -- Unique identifier
    jobTitle VARCHAR(50) NOT NULL,
    score INT NOT NULL
);
SELECT * FROM storeuser;

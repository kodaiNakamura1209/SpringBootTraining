DROP TABLE IF EXISTS USER_INFO;

CREATE TABLE USER_INFO (
    USER_ID VARCHAR(8) NOT NULL PRIMARY KEY,
    USER_PASSWORD VARCHAR(8) NOT NULL,
    USER_NAME VARCHAR(255) NOT NULL
);
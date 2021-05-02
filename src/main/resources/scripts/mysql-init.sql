DROP DATABASE IF EXISTS recommendationservice;
DROP USER IF EXISTS `recommendation_service`@`%`;
CREATE DATABASE IF NOT EXISTS recommendationservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `recommendation_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `recommendationservice`.* TO `recommendation_service`@`%`;
FLUSH PRIVILEGES;


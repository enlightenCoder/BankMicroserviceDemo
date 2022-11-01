DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

CREATE TABLE `customer` (
    `customer_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `mobile_number` varchar(20) NOT NULL,
    `created_dt` date DEFAULT NULL
);

CREATE TABLE `accounts` (
    `customer_id` int not null,
    `account_number` int AUTO_INCREMENT PRIMARY KEY,
    `account_type` varchar(200) NOT NULL,
    `branch_address` varchar(200) NOT NULL,
    `created_dt` date DEFAULT NULL
);

INSERT INTO `customer` (`customer_id`,`name`,`email`,`mobile_number`,`created_dt`)
 VALUES (1,'Christopher','cami@gmail.com','59028679', CURDATE());

INSERT INTO `accounts` (`customer_id`,`account_number`,`account_type`,`branch_address`,`created_dt`)
 VALUES (1, 86576453, 'Savings','123 Main street, New York', CURDATE());
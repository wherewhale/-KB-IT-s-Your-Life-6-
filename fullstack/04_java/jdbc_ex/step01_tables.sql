CREATE TABLE customer (
  id VARCHAR(10) PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE sushi_log (
   id INT AUTO_INCREMENT PRIMARY KEY,
   customer_id VARCHAR(10),
   plate_color VARCHAR(10),
   eaten_at DATETIME DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (customer_id) REFERENCES customer(id)
);


SELECT * FROM customer;
SELECT * FROM sushi_log;
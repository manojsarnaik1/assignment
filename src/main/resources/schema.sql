DROP TABLE IF EXISTS TBL_EMPLOYEES;
 
CREATE TABLE tb_user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  status VARCHAR(250) DEFAULT NULL
);
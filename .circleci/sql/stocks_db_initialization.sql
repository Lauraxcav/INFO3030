
/* delete tables if they exist already - ensuring a clean db*/
DROP TABLE IF EXISTS stocks.person_symbol CASCADE;
DROP TABLE IF EXISTS stocks.person CASCADE;



/** creates a table to store a list of people */
CREATE TABLE stocks.person
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);

/** A list of people and their symbols */
CREATE TABLE stocks.person_symbol
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  symbol VARCHAR(10) NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID)
);

/** now add some sample data */

/** wow, amazing, it's all the same people who also happen to have hobbies */
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Drew', 'Hope', '1999/10/10');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lang', 'Heckman', '1959/11/11');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lucy', 'Jones', '2010/1/1');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Stew', 'Hammer', '1990/3/28');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Dan', 'Lane', '1986/4/18');

INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (1,1,'APPL');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (2,1,'DIS');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (3,1,'AMZN');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (4,2,'APPL');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (5,2,'GOOG');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (6,3,'AMZN');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (7,3,'APPL');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (8,4,'DIS');
INSERT INTO stocks.person_symbol (ID, person_id, symbol) VALUES (9,5,'GOOG');



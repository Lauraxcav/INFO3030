
/* delete tables if they exist already - ensuring a clean db*/
DROP TABLE IF EXISTS activities.person_hobby CASCADE;
DROP TABLE IF EXISTS activities.hobbies CASCADE;
DROP TABLE IF EXISTS activities.person CASCADE;


/* creates a table to store a list of hobbies and their recommended ages */
CREATE TABLE activities.hobbies
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  description VARCHAR(2056) NOT NULL,
  minimum_age INT NOT NULL
);

/** creates a table to store a list of people */
CREATE TABLE activities.person
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);

/** A list of people and their hobbies */
CREATE TABLE activities.person_hobby
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  hobbie_id INT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID),
  FOREIGN KEY (hobbie_id) REFERENCES hobbies (ID)
);

/** now add some sample data */

INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('board games', 'assorted board games like monopoly', 8);
INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('chess', 'ancient strategy game', 5);
INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('go', 'ancient strategy game', 5);
INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('archery', 'shot arrows with a bow', 12);
INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('alpine skiing', 'recreation of sliding down snow-covered hills on skis with fixed-heel bindings', 2);
INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('snow shoeing', 'traverse snow wearing large funny shoes', 6);
INSERT INTO activities.hobbies (name,description,minimum_age) VALUES ('stamp collecting', 'collect rare and unusual postage stamps', 6);

INSERT INTO activities.person (first_name,last_name,birth_date) VALUES ('Drew', 'Hope', '1999/10/10');
INSERT INTO activities.person (first_name,last_name,birth_date) VALUES ('Lang', 'Heckman', '1959/11/11');
INSERT INTO activities.person (first_name,last_name,birth_date) VALUES ('Lucy', 'Jones', '2010/1/1');
INSERT INTO activities.person (first_name,last_name,birth_date) VALUES ('Stew', 'Hammer', '1990/3/28');
INSERT INTO activities.person (first_name,last_name,birth_date) VALUES ('Dan', 'Lane', '1986/4/18');

INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (1, 1, 2);
INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (2, 1, 1);
INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (3, 2, 1);
INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (4, 3, 1);
INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (5, 3, 3);
INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (6, 3, 4);
INSERT INTO activities.person_hobby (ID, person_id, hobbie_id) VALUES (7, 4, 7);


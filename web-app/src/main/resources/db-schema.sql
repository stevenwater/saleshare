create schema saleshare;
DROP TABLE IF EXISTS saleshare.demo;
CREATE TABLE saleshare.demo
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	descs VARCHAR(255),
	code INTEGER,
	PRIMARY KEY (id),
	UNIQUE UQ_demo_id(id)
) ;



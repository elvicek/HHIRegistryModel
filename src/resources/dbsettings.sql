INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (1,1,'MR');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (2,1,'MRs');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (3,1,'MISS');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (4,1,'MS');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (5,1,'REV');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (6,1,'DR');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (7,1,'PROF');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (8,2,'M');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (9,2,'F');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (10,3,'ADMINISTRATOR');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (11,3,'RECEPTIONIST');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (12,3,'ENGINEER');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (13,3,'DIRECTOR');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (14,4,'FULL QUATERLY SURVEY');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (15,4,'FULL ADHOC SURVEY');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (16,4,'INVESTIGATIVE SURVEY');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (17,5,'NEW');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (18,5,'IN PROGRESS');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (19,5,'COMPLETE');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (20,5,'REJECTED');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (21,6,'SQUARE METERS');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (22,6,'CUBIC METERS');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (23,6,'METER/SEC');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (24,6,'Pa');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (25,7,'AREA');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (26,7,'VOLUME');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (27,7,'VELOCITY');
INSERT INTO dbsettings (ID,TYPE,DESCRIPTION) VALUES (28,7,'PRESSURE');
-- Add Admin User Address
INSERT INTO ADDRESS(address_id,addressline1,addressline2,created_by,created_date) values(1,'internal','internal','installer',CURRENT_TIMESTAMP);
-- Add Admin Person
INSERT INTO PERSON(person_id,address_id,email,created_by,created_date) values(1,1,'admin@aes.co.zw','installer',CURRENT_TIMESTAMP);
-- Add Admin User
INSERT INTO user (username, password, person_id,created_by, created_date) VALUES ('admin', 'aesworld',1,'installer',CURRENT_TIMESTAMP);
-- Add roles
INSERT INTO role (role_name, role_description, created_by, created_date) VALUES ('admin','This is the administrator of the application with full privilleges','installer',CURRENT_TIMESTAMP);
INSERT INTO role (role_name, role_description, created_by, created_date) VALUES ('secretary','This is the secretary or officer role','installer',CURRENT_TIMESTAMP);
INSERT INTO role (role_name, role_description, created_by, created_date) VALUES ('engineer','This is the ventilation engineer role','installer',CURRENT_TIMESTAMP);
-- Add user role
INSERT INTO user_role (username, role_name) VALUES ('admin', 'admin');

USE mysql;
CREATE USER 'realm_access'@'localhost' IDENTIFIED BY 'realmpass';
GRANT SELECT ON aes.* TO realm_access@localhost;

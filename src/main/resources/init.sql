INSERT INTO User (id, email, password, worktype) VALUES (1, 'mari@test.com', '123ABc', 'STUDENT');
INSERT INTO User (id, email, password, worktype) VALUES (2, 'ole@test.com', 'abC123', 'TEACHER');
INSERT INTO User (id, email, password, worktype) VALUES (3, 'kari@test.com', '1234Abc', 'STUDENT');
INSERT INTO User (id, email, password, worktype) VALUES (4, 'knut@test.com', 'abC123', 'TEACHER');
INSERT INTO User (id, email, password, worktype) VALUES (5, 'geir@test.com', '1234Abc', 'STUDENT');

INSERT INTO LOCATION (id, building, room) VALUES (1, 'Galleriet', '81');
INSERT INTO LOCATION (id, building, room) VALUES (2, 'Galleriet', '82');
INSERT INTO LOCATION (id, building, room) VALUES (3, 'Vulkan', '104');
INSERT INTO LOCATION (id, building, room) VALUES (4, 'Vulkan', '105');

INSERT INTO SUBJECT (id, name, FK_LOCATION) VALUES (1, 'PG5100', 1);
INSERT INTO SUBJECT (id, name, FK_LOCATION) VALUES (2, 'PG6100', 2);
INSERT INTO SUBJECT (id, name, FK_LOCATION) VALUES (3, 'PA1010', 3);
INSERT INTO SUBJECT (id, name, FK_LOCATION) VALUES (4, 'PA3030', 4);
INSERT INTO SUBJECT (id, name, FK_LOCATION) VALUES (5, 'PA9090', 4);


INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (1,1);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (2,1);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (3,3);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (4,3);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (5,4);

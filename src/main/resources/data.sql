INSERT INTO USERS(username, password) VALUES('Usuario 1', '$2a$10$v.S5YecGG.KlKinME04lc.tFlzqOdlJGa/ikGvsMvGkpnyppVd/oq');
INSERT INTO USERS(username, password) VALUES('Usuario 2', '$2a$10$pvThGc1cWsTmrVRVpkPrZunCGTMg.NW7PdRKKwXAco/oqiyvgYu5W');

INSERT INTO ROLES(name) VALUES('ADMIN');
INSERT INTO ROLES(name) VALUES('USER');

INSERT INTO USERS_ROLES(user_id, role_id) VALUES(1, 1);
INSERT INTO USERS_ROLES(user_id, role_id) VALUES(2, 2);

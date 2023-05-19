insert into squad (name)
values ('squad1'),
       ('squad2'),
       ('squad7');

insert into mg_users (username, password, active)
values ('user1', '123', TRUE),
       ('user2', '123', TRUE),
       ('user3', '123', TRUE),
       ('user4', '123', TRUE),
       ('user5', '123', TRUE),
       ('user6', '123', TRUE);

insert into squad_user (email, first_name, last_name, patronymic, squad_role, squad_id, security_id)
values ('test_email1@email.com', 'firstname1', 'last_name1', 'patronymic1', 'CANDIDATE', 1, 1),
       ('test_email2@email.com', 'firstname2', 'last_name2', 'patronymic2', 'CANDIDATE', 1, 2),
       ('test_email3@email.com', 'firstname3', 'last_name3', 'patronymic3', 'CANDIDATE', 2, 3),
       ('test_email4@email.com', 'firstname4', 'last_name4', 'patronymic4', 'CANDIDATE', 2, 4),
       ('test_email5@email.com', 'firstname5', 'last_name5', 'patronymic5', 'CANDIDATE', 3, 5),
       ('test_email6@email.com', 'firstname6', 'last_name6', 'patronymic6', 'CANDIDATE', 3, 6);

insert into role (name)
values ('BASIC_STATE'),
       ('ADMINISTRATION_STATE');


INSERT INTO user_to_role (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 2),
       (6, 2);

insert into hard_work (title, description, date, coefficient)
values ('HardWork1', 'make something 1', '2022-09-19', 1),
       ('HardWork2', 'make something 2', '2022-10-22', 1),
       ('HardWork3', 'make something 3', '2022-10-19', 2),
       ('HardWork4', 'make something 4', '2022-11-22', 2),
       ('HardWork5', 'make something 5', '2022-07-22', 1),
       ('HardWork6', 'make something 6', '2022-05-12', 1);

insert into social_work (title, description, date, coefficient)
values ('SocialWork1', 'make something 1', '2022-08-19', 1),
       ('SocialWork2', 'make something 2', '2022-09-22', 1),
       ('SocialWork3', 'make something 3', '2022-09-19', 1),
       ('SocialWork4', 'make something 4', '2022-10-22', 1),
       ('SocialWork5', 'make something 5', '2022-06-22', 1),
       ('SocialWork6', 'make something 6', '2022-03-12', 1);

INSERT INTO user_to_hard_work (work_id, user_id, time_work)
VALUES (1, 1, '01:00'),
       (2, 1, '01:35'),
       (2, 2, '00:03'),
       (3, 3, '00:45'),
       (3, 4, '07:30'),
       (4, 4, '00:27'),
       (6, 5, '17:01'),
       (5, 6, '00:30');

INSERT INTO user_to_social_work (work_id, user_id, time_work)
VALUES (1, 1, '07:00'),
       (2, 1, '00:38'),
       (2, 2, '03:27'),
       (3, 3, '00:23'),
       (3, 4, '04:18'),
       (4, 4, '00:28'),
       (6, 5, '06:07'),
       (5, 6, '01:48');

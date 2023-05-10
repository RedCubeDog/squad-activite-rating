insert into squad (id, name)
values (1, 'squad1'),
       (2, 'squad2'),
       (3, 'squad3');

insert into app_user (id, email, first_name, last_name, login, patronymic, squad_role, state, squad_id)
values (1, 'test_email1@email.com', 'firstname1', 'last_name1', 'login1', 'patronymic1', 'CANDIDATE', 'BASIC_STATE', 1),
       (2, 'test_email2@email.com', 'firstname2', 'last_name2', 'login2', 'patronymic2', 'CANDIDATE', 'BASIC_STATE', 1),
       (3, 'test_email3@email.com', 'firstname3', 'last_name3', 'login3', 'patronymic3', 'CANDIDATE', 'BASIC_STATE', 2),
       (4, 'test_email4@email.com', 'firstname4', 'last_name4', 'login4', 'patronymic4', 'CANDIDATE', 'BASIC_STATE', 2),
       (5, 'test_email5@email.com', 'firstname5', 'last_name5', 'login5', 'patronymic5', 'CANDIDATE', 'BASIC_STATE', 3),
       (6, 'test_email6@email.com', 'firstname6', 'last_name6', 'login6', 'patronymic6', 'CANDIDATE', 'BASIC_STATE', 3);

insert into hard_work (id, title, description, date, coefficient)
values (1, 'HardWork1', 'make something 1', '2022-09-19', 1),
       (2, 'HardWork2', 'make something 2', '2022-10-22', 1),
       (3, 'HardWork3', 'make something 3', '2022-10-19', 2),
       (4, 'HardWork4', 'make something 4', '2022-11-22', 2),
       (5, 'HardWork5', 'make something 5', '2022-07-22', 1),
       (6, 'HardWork6', 'make something 6', '2022-05-12', 1);

insert into social_work (id, title, description, date, coefficient)
values (1, 'SocialWork1', 'make something 1', '2022-08-19', 1),
       (2, 'SocialWork2', 'make something 2', '2022-09-22', 1),
       (3, 'SocialWork3', 'make something 3', '2022-09-19', 1),
       (4, 'SocialWork4', 'make something 4', '2022-10-22', 1),
       (5, 'SocialWork5', 'make something 5', '2022-06-22', 1),
       (6, 'SocialWork6', 'make something 6', '2022-03-12', 1);

INSERT INTO user_to_hard_work (id, work_id, user_id, time_work)
VALUES (1, 1, 1, '01:00'),
       (2, 2, 1, '01:35'),
       (3, 2, 2, '00:03'),
       (4, 3, 3, '00:45'),
       (5, 3, 4, '07:30'),
       (6, 4, 4, '00:27'),
       (7, 6, 5, '17:01'),
       (8, 5, 6, '00:30');

INSERT INTO user_to_social_work (id, work_id, user_id, time_work)
VALUES (1, 1, 1, '07:00'),
       (2, 2, 1, '00:38'),
       (3, 2, 2, '03:27'),
       (4, 3, 3, '00:23'),
       (5, 3, 4, '04:18'),
       (6, 4, 4, '00:28'),
       (7, 6, 5, '06:07'),
       (8, 5, 6, '01:48');

INSERT INTO mg_users
VALUES (1, true, '', '', 123, user);

INSERT INTO user_role (user_id, roles)
VALUES (1, 'USER');

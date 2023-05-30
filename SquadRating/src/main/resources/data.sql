insert into squad (name)
values ('squad1'),
       ('squad2'),
       ('squad7'),
       ('default_squad');

insert into security_user (username, password, active)
values ('user', '123', true),
       ('admin', '123', true),
       ('userAndAdmin', '123', true),
       ('test', 'test', true),
       ('user2', '123', true),
       ('user3', '123', true);

insert into user_role
values (1, 'BASIC_STATE'),
       (2, 'ADMINISTRATION_STATE'),
       (3, 'BASIC_STATE'),
       (3, 'ADMINISTRATION_STATE'),
       (4, 'BASIC_STATE'),
       (4, 'ADMINISTRATION_STATE'),
       (5, 'BASIC_STATE'),
       (6, 'BASIC_STATE');

insert into squad_user (email, first_name, last_name, patronymic, squad_role, squad_id, security_id)
values ('user@email.com', 'User', 'Userovich', 'patr1', 'CANDIDATE', 1, 1),
       ('admin@email.com', 'Admin', 'Adminovich', 'patr2', 'CANDIDATE', 1, 2),
       ('userAndAdmin@email.com', 'UserAndAdmin', 'Usedmin', 'patr3', 'CANDIDATE', 2, 3),
       ('test_email4@email.com', 'User1', 'Userovich1', 'patronymic1', 'CANDIDATE', 2, 4),
       ('test_email5@email.com', 'User2', 'Userovich2', 'patronymic2', 'CANDIDATE', 2, 5),
       ('test_email6@email.com', 'User3', 'Userovich3', 'patronymic3', 'CANDIDATE', 3, 6);

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

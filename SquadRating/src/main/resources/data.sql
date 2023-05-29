insert into squad (name)
values ('squad1');

insert into app_user (email, first_name, last_name, login, patronymic, squad_role, state, squad_id)
values ('test_email1@email.com', 'firstname1', 'last_name1', 'login1', 'patronymic1', 'CANDIDATE', 'BASIC_STATE', 1),
       ('test_email2@email.com', 'firstname2', 'last_name2', 'login2', 'patronymic2', 'CANDIDATE', 'BASIC_STATE', 1),
       ('test_email3@email.com', 'firstname3', 'last_name3', 'login3', 'patronymic3', 'CANDIDATE', 'BASIC_STATE', 1),
       ('test_email4@email.com', 'firstname4', 'last_name4', 'login4', 'patronymic4', 'CANDIDATE', 'BASIC_STATE', 1);

insert into hard_work (title, description, date, coefficient)
values ('HardWork1', 'make something 1', '2022-09-19', 1),
       ('HardWork2', 'make something 1', '2022-10-22', 1),
       ('HardWork2', 'make something 2', '2022-10-19', 1),
       ('HardWork3', 'make something 2', '2022-11-22', 1);

insert into social_work (title, description, date, coefficient)
values ('SocialWork1', 'make something 4', '2022-10-23', 1),
       ('SocialWork2', 'make something 5', '2022-12-22', 1),
       ('SocialWork2', 'make something 6', '2022-10-24', 1),
       ('SocialWork3', 'make something 6', '2022-11-11', 1);

insert into user_to_hard_work (work_Id, user_Id)
values (1, 1),
       (1, 2),
       (2, 1),
       (3, 3),
       (4, 2),
       (4, 4);

insert into user_to_social_work (work_Id, user_Id)
values (1, 1),
       (2, 1),
       (2, 2),
       (3, 2),
       (4, 3),
       (4, 3);

insert into mg_users(active, first_name, last_name, password, username)
values (true, 'Тест', 'имя', 'test', 'test');
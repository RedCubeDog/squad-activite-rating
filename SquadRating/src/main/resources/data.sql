insert into squad (id, name)
values (1, 'squad1');

insert into app_user (id, email, first_name, last_name, login, patronymic, squad_role, state, squad_id)
values (1, 'test_email1@email.com', 'firstname1', 'last_name1', 'login1', 'patronymic1', 'CANDIDATE', 'BASIC_STATE', 1),
       (2, 'test_email2@email.com', 'firstname2', 'last_name2', 'login2', 'patronymic2', 'CANDIDATE', 'BASIC_STATE', 1),
       (3, 'test_email3@email.com', 'firstname3', 'last_name3', 'login3', 'patronymic3', 'CANDIDATE', 'BASIC_STATE', 1),
       (4, 'test_email4@email.com', 'firstname4', 'last_name4', 'login4', 'patronymic4', 'CANDIDATE', 'BASIC_STATE', 1);

insert into hard_work (id, title, description, date, coefficient)
values (1, 'HardWork1', 'make something 1', '2022-09-19', 1),
       (2, 'HardWork2', 'make something 1', '2022-10-22', 1),
       (3, 'HardWork2', 'make something 2', '2022-10-19', 1),
       (4, 'HardWork3', 'make something 2', '2022-11-22', 1);

insert into social_work (id, title, description, date, coefficient)
values (1, 'SocialWork1', 'make something 4', '2022-10-23', 1),
       (2, 'SocialWork2', 'make something 5', '2022-12-22', 1),
       (3, 'SocialWork2', 'make something 6', '2022-10-24', 1),
       (4, 'SocialWork3', 'make something 6', '2022-11-11', 1);

insert into user_to_hard_work (id, work_Id, user_Id)
values (1, 1, 1),
       (2, 1, 2),
       (3, 2, 1),
       (4, 3, 3),
       (5, 4, 2),
       (6, 4, 4);

insert into user_to_social_work (id, work_Id, user_Id)
values (1, 1, 1),
       (2, 2, 1),
       (3, 2, 2),
       (4, 3, 2),
       (5, 4, 3),
       (6, 4, 3);

insert into mg_users(id, active, first_name, last_name, password, username)
values (1, true, 'Тест', 'имя', 'test', 'test');
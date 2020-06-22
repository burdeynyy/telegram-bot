DROP TABLE IF EXISTS client;

CREATE SEQUENCE client_seq
    START WITH 10
    INCREMENT BY 50
    MINVALUE 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE client
(
    id            BIGINT default client_seq.nextval PRIMARY KEY,
    name          varchar(200) not null,
    telegram_user bigint       not null
);


DROP TABLE IF EXISTS message;

CREATE SEQUENCE message_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE message
(
    id            BIGINT             default message_seq.nextval PRIMARY KEY,
    content       text      not null,
    chat          bigint    not null,
    in_reply_to   bigint,
    client        bigint    not null,
    is_bot_answer boolean   not null,
    creation_date timestamp not null default now(),
    FOREIGN KEY (client) REFERENCES client (id) ON DELETE CASCADE ON UPDATE NO ACTION

);

insert into client(id, name, telegram_user) values (1, 'Test client 1 ', 99999);
insert into client(id, name, telegram_user) values (2, 'Test client 2 ', 88888);
insert into client(id, name, telegram_user) values (3, 'Test client 3 w/o messages ', 77777);
insert into client(id, name, telegram_user) values (4, 'Test client 4 w/o messages ', 666666);
insert into client(id, name, telegram_user) values (5, 'Test client 5 w/o messages ', 55555);
insert into client(id, name, telegram_user) values (6, 'Test client 6 w/o messages with very long name ', 444444);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '1This is fake message. You cannot send or receive messages from test clients.', 666, null, 1, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '2This is fake answer message. You cannot send or receive messages from test clients.', 666, null, 1, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '3This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '4This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '5This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '6This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '7This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '8This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '9This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '10This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '11This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '12This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '13This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '14This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '15This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '16This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '17This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '18This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '19This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '20This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '21This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '22This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '23This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '24This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '25This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '26This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '27This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '28This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '29This is fake message. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '30This is fake ANSWER message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '31This is fake MESSAGE. You cannot send or receive messages from test clients.', 777, null, 2, false, default);

insert into message(id, content, chat, in_reply_to, client, is_bot_answer, creation_date)
values (default, '32This is fake answer message. You cannot send or receive messages from test clients.', 777, null, 2, true, default);

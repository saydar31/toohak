create sequence quiz_seq;
create table quiz(
    id bigint default next value for quiz_seq primary key,
    name varchar(255) not null,
    description text,
    created timestamp not null default now()
);

create sequence question_seq;
create table question(
    id bigint default next value for question_seq primary key,
    text text not null,
    image varchar(255),
    with_prize bool,
    quiz_id bigint not null references quiz,
    order_number integer not null,
    seconds_to_think integer not null
);

create sequence answer_seq;
create table answer(
    id bigint default next value for answer_seq primary key,
    text text,
    correct boolean,
    question_id bigint not null references question
);

create sequence game_seq;
create table game(
    id bigint default next value for game_seq primary key,
    quiz_id bigint not null references quiz,
    started timestamp not null default now(),
    finished timestamp,
    join_code integer not null
);

create sequence game_question_seq cycle;
create table game_question(
    id bigint default next value for game_question_seq primary key,
    game_id bigint not null references game,
    question_id bigint not null references question,
    started timestamp not null default now()
);

create table player(
    id uuid default random_uuid() primary key,
    name varchar(255) not null,
    game_id bigint not null references game,
    score double not null default 0.0
);
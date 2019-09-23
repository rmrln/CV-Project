create table users
(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    picture TEXT not null,
    cv_title TEXT not null,
    first_name TEXT not null,
    last_name TEXT not null,
    age int null,
    phone_number int null,
    address TEXT not null,
    linkedin TEXT not null,
    mail TEXT not null,
    presentation TEXT not null,
    skill TEXT not null,
    hobby TEXT not null,
    language TEXT not null
);

create table formations
(
    id bigint auto_increment,
    PRIMARY KEY (id),
    formation_title TEXT not null,
    formation_description TEXT not null,
    formation_date int null,
    user_id bigint,
    CONSTRAINT FK_Formation FOREIGN KEY (user_id) REFERENCES users(id)
);

create table experiences
(
    id bigint auto_increment,
    PRIMARY KEY (id),
    experience_title TEXT not null,
    experience_description TEXT not null,
    experience_position TEXT not null,
    experience_date int null,
    user_id bigint,
    CONSTRAINT FK_Experience FOREIGN KEY (user_id) REFERENCES users(id)
);


create table users
(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    cv_tittle TEXT not null,
    first_name TEXT not null,
    last_name TEXT not null,
    age int null,
    linkedin TEXT not null,
    mail TEXT not null,
    presentation TEXT not null,
    skill TEXT not null,
    language TEXT not null
);

create table formations
(
    FormationID bigint auto_increment,
    PRIMARY KEY (FormationID),
    formation_tittle TEXT not null,
    formation_description TEXT not null,
    formation_name TEXT not null,
    formation_date int null,
    id bigint,
    CONSTRAINT FK_Formation FOREIGN KEY (id) REFERENCES users(id)
);

create table experiences
(
    ExperienceID bigint auto_increment,
    PRIMARY KEY (ExperienceID),
    experience_tittle TEXT not null,
    experience_description TEXT not null,
    experience_position TEXT not null,
    experience_name TEXT not null,
    experience_date int null,
    id bigint,
    CONSTRAINT FK_Experience FOREIGN KEY (id) REFERENCES users(id)
);


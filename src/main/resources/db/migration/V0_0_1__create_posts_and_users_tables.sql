create table if not exists users
(
    id                binary(16) primary key,
    username          varchar(32)  not null unique,
    password          varchar(256) not null,
    registration_date timestamp
);

create table if not exists users_roles
(
    id      int primary key auto_increment,
    user_id binary(16)  not null,
    role    varchar(32) not null,
    foreign key (user_id) references users (id) on delete cascade on update cascade
);

create table if not exists posts
(
    id            binary(16) primary key,
    title         varchar(128)  not null,
    content       varchar(2000) not null,
    author_id     binary(16)    not null,
    creation_date timestamp,
    foreign key (author_id) references users (id) on delete cascade on update cascade
);
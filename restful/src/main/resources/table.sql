    create table article (
       id bigint generated by default as identity,
        content varchar(255),
        title varchar(255),
        primary key (id)
    )
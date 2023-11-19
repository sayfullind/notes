create table if not exists notes
(
    id bigserial primary key ,
    title varchar(80) not null ,
    content varchar not null
);

insert into notes (title, content)
values ('Hello!', 'You can create your first note!');

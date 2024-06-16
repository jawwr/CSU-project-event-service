create sequence if not exists event_seq start 1;
create table if not exists events
(
    id          numeric primary key default nextval('event_seq'::regclass),
    title       varchar   not null,
    text        text      not null,
    city_code   varchar   not null,
    date_start  date      not null,
    date_end    date      not null,
    date_create timestamp not null,
    date_modify timestamp not null
);

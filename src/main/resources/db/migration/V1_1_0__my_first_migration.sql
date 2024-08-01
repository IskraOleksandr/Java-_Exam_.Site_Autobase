CREATE TABLE IF NOT EXISTS public.app_user
(
    user_id  serial not null constraint app_user_pkey primary key,
    user_name varchar(30),
    encryted_password varchar(128),
    enabled boolean
    )
    TABLESPACE pg_default;

create table if not exists public.cargo(
                                           id serial primary key,
                                           name varchar(30),
    leveldriverexpirience integer
    )
    TABLESPACE pg_default;

create table if not exists public.destination(
                                                 id serial primary key,
                                                 name varchar(30),
    summa double precision
    )
    TABLESPACE pg_default;

create table if not exists public.driver(
                                            id serial primary key,
                                            full_name varchar(30),
    expirience integer,
    age integer,
    available boolean
    )
    TABLESPACE pg_default;

create table if not exists public.orders(
                                            id serial primary key,
                                            weight integer,
                                            cargoid integer,
                                            destinationid integer,
                                            status varchar(30),
    foreign key (cargoid) references Cargo (id) on delete cascade,
    foreign key (destinationid) references Destination (id) on delete cascade
    )
    TABLESPACE pg_default;

create table if not exists public.truck(
                                           id serial primary key,
                                           maxweight integer,
                                           available boolean,
                                           repairability boolean,
                                           name varchar(30)
    )
    TABLESPACE pg_default;


create table if not exists public.truck_driver(
                                                  id serial primary key,
                                                  truckid integer,
                                                  driverid integer,
                                                  foreign key (truckid) references truck (id) on delete cascade,
    foreign key (driverid) references driver (id) on delete cascade
    )
    TABLESPACE pg_default;

create table if not exists public.truck_repair(
                                                  id serial primary key,
                                                  day integer,
                                                  truckid integer,
                                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                  foreign key (truckid) references truck (id) on delete cascade
    )
    TABLESPACE pg_default;

create table if not exists public.route(
                                           id serial primary key,
                                           date integer,
                                           orderid integer,
                                           truck_driverid integer,
                                           foreign key (orderid) references Orders (id) on delete cascade,
    foreign key (truck_driverid) references truck_driver (id) on delete cascade
    )
    TABLESPACE pg_default;

create table if not exists public.oder_route(
                                                id serial not null primary key,
                                                orderid integer,
                                                routeid integer,
                                                foreign key (orderid) references Orders (id) on delete cascade,
    foreign key (routeid) references Route (id) on delete cascade
    )
    TABLESPACE pg_default;

create table if not exists public.role(
                                          role_id serial primary key,
                                          role_name varchar(30)
    )
    TABLESPACE pg_default;

create table if not exists public.salary(
                                            id serial primary key,
                                            summa double precision,
                                            driverid integer,
                                            routeid integer,
                                            foreign key (driverid) references driver (id) on delete cascade,
    foreign key (routeid) references Route (id) on delete cascade
    )
    TABLESPACE pg_default;

create table if not exists public.user_role(
                                               id serial primary key,
                                               app_user_user_id integer,
                                               role_role_id integer,
                                               foreign key (app_user_user_id) references app_user (user_id) on delete cascade,
    foreign key (role_role_id) references Role (role_id) on delete cascade
    )
    TABLESPACE pg_default;


insert into app_user (user_id, user_name, encryted_password, enabled)
values (1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true),
       (2, 'director', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true),
       (3, 'driver', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true),
       (4, 'anonim', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true);


insert into  role (role_id, role_name)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_DIRECTOR'),
       (3, 'ROLE_DRIVER'),
       (4, 'ROLE_DEFAULT');

insert into  user_role (id, app_user_user_id, role_role_id)
values (1,1,1),
       (2,2,2),
       (3,3,3),
       (4,4,4);
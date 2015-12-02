# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tool (
  id                        bigserial not null,
  title                     varchar(255),
  price                     varchar(255),
  description               varchar(255),
  owner                     varchar(255),
  constraint pk_tool primary key (id))
;

create table users (
  id                        bigserial not null,
  name                      varchar(255),
  username                  varchar(255),
  password_hash             varchar(255),
  email                     varchar(255),
  phone                     varchar(255),
  constraint uq_users_username unique (username),
  constraint pk_users primary key (id))
;




# --- !Downs

drop table if exists tool cascade;

drop table if exists users cascade;


# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tool (
  id                        bigint not null,
  title                     varchar(255),
  price                     varchar(255),
  description               varchar(255),
  owner                     varchar(255),
  constraint pk_tool primary key (id))
;

create table user (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  phone                     varchar(255),
  constraint pk_user primary key (id))
;

create sequence tool_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tool;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tool_seq;

drop sequence if exists user_seq;


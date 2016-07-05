drop table user;
drop table role;
drop table resource;
drop table user_role;
drop table role_resource;
# user,role,resource,user_role,role_resource
create table user(
	user_id int auto_increment primary key,
    user_name varchar(20),
    user_password varchar(50),
    locked int
)engine = innodb default charset = utf8;
create table role(
	role_id int auto_increment primary key,
    role_name varchar(10),
    available int
)engine = innodb default charset=utf8;

create table resource(
	resource_id int auto_increment primary key,
    resource_type int,
    resource_name varchar(10),
    url  varchar(30) ,
    parent int ,
    permission varchar(30)
) engine = innodb default charset = utf8;

create table user_role(
 user_id int,
 role_id int,
 primary key(user_id,role_id)
)engine=innodb default charset =utf8;

create table role_resource(
 role_id int ,
 resource_id int,
 primary key(role_id,resource_id)
)engine=innodb default charset =utf8;

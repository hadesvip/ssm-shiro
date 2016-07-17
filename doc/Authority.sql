DROP TABLE user;
DROP TABLE role;
DROP TABLE resource;
DROP TABLE user_role;
DROP TABLE role_resource;
# user,role,resource,user_role,role_resource
CREATE TABLE user (
  user_id       INT AUTO_INCREMENT PRIMARY KEY,
  user_name     VARCHAR(20),
  user_password VARCHAR(50),
  locked        INT,
  UNIQUE user_name_uq(user_name)
)ENGINE = innodb DEFAULT CHARSET = utf8;

CREATE TABLE role (
  role_id   INT AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(10),
  available INT,
  UNIQUE role_name_uq (role_name)
)ENGINE = innodb DEFAULT CHARSET = utf8;

CREATE TABLE resource (
  resource_id   INT AUTO_INCREMENT PRIMARY KEY,
  resource_type INT,
  resource_name VARCHAR(10),
  url           VARCHAR(30),
  parent        INT,
  permission    VARCHAR(30),
  UNIQUE resource_name_uq(resource_name)
)ENGINE = innodb DEFAULT CHARSET = utf8;

CREATE TABLE user_role (
  user_id INT,
  role_id INT,
  PRIMARY KEY (user_id, role_id)
)ENGINE = innodb DEFAULT CHARSET = utf8;

CREATE TABLE role_resource (
  role_id     INT,
  resource_id INT,
  PRIMARY KEY (role_id, resource_id)
)ENGINE = innodb DEFAULT CHARSET = utf8;

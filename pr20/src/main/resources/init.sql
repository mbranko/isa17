DROP TABLE IF EXISTS admins;

CREATE TABLE admins (
  admin_id   INTEGER      NOT NULL  AUTO_INCREMENT,
  username   VARCHAR(50)  NOT NULL,
  pasword    VARCHAR(50)  NOT NULL,
  PRIMARY KEY(admin_id)
);
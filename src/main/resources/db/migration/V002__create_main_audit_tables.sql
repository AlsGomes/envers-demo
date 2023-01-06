CREATE TABLE revinfo (
  rev int NOT NULL AUTO_INCREMENT,
  revtstmp bigint DEFAULT NULL,
  PRIMARY KEY (rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE clients_audit (
  id bigint NOT NULL,
  rev int NOT NULL,
  revtype tinyint DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (rev,id),
  CONSTRAINT FK_REVINFO FOREIGN KEY (rev) REFERENCES revinfo (rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
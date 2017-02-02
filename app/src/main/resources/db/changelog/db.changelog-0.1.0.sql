--liquibase formatted sql

--changeset dgutierrez:1
CREATE TABLE aws_credentials (
  alias VARCHAR(200) NOT NULL UNIQUE,
  access_key VARCHAR(200) NOT NULL,
  secret_key VARCHAR(200) NOT NULL,
  PRIMARY KEY (alias)
);

CREATE TABLE projects (
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(200) NOT NULL,
  keyset_alias VARCHAR (200) NOT NULL,
  ami_retention_non_promoted INT NOT NULL,
  ami_retention_promoted INT NOT NULL,
  project_region VARCHAR (200) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY fk_creds(keyset_alias) REFERENCES aws_credentials(alias)
);

CREATE TABLE users (
  username VARCHAR(200) NOT NULL UNIQUE,
  password_hash VARCHAR(200) NOT NULL,
  email VARCHAR(200),
  is_super_user TINYINT NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE project_users (
  project_id INT NOT NULL,
  username VARCHAR(128) NOT NULL,
  PRIMARY KEY (project_id, username),
  FOREIGN KEY fk_projects(project_id) REFERENCES projects(id),
  FOREIGN KEY fk_users(username) REFERENCES users(username)
);

CREATE TABLE build_jobs (
  id INT AUTO_INCREMENT NOT NULL,
  project_id INT NOT NULL,
  job_name VARCHAR(200) NOT NULL,
  job_description VARCHAR(500),
  base_os VARCHAR(200) NOT NULL,
  auto_build TINYINT NOT NULL,
  last_built_base_ami_id VARCHAR(100) NOT NULL,
  last_build_date DATETIME,
  auto_deploy TINYINT NOT NULL,
  keep_util_manual_delete TINYINT NOT NULL,
  build_script TEXT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY fk_projects(project_id) REFERENCES projects(id)
);

CREATE TABLE amis (
  id INT AUTO_INCREMENT NOT NULL,
  baked_ami_id VARCHAR(100),
  base_ami_id VARCHAR(100) NOT NULL,
  ami_status VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE builds (
  id INT AUTO_INCREMENT NOT NULL,
  project_id INT NOT NULL,
  job_id INT NOT NULL,
  build_date DATETIME NOT NULL,
  build_status VARCHAR(120) NOT NULL,
  build_type VARCHAR(120) NOT NULL,
  promoted TINYINT NOT NULL,
  ami_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY fk_projects(project_id) REFERENCES projects(id),
  FOREIGN KEY fk_jobs(job_id) REFERENCES build_jobs(id),
  FOREIGN KEY fk_ami(ami_id) REFERENCES amis(id)
);

ALTER TABLE amis
ADD COLUMN build_id INT NOT NULL,
ADD FOREIGN KEY fk_builds(build_id) REFERENCES builds(id);

CREATE TABLE environments (
  id INT AUTO_INCREMENT NOT NULL,
  project_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  build_id INT,
  auto_deploy TINYINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY fk_projects(project_id) REFERENCES projects(id),
  FOREIGN KEY fk_builds(build_id) REFERENCES builds(id)
);

---rollback DROP TABLE projects,projects_users,users,aws_credentials,build_jobs,builds,amis,environments;
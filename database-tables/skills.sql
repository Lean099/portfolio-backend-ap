CREATE TABLE railway.skills (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	skill_name varchar(100) NULL,
	percentage INT NULL,
	CONSTRAINT skills_PK PRIMARY KEY (id),
	CONSTRAINT skills_FK FOREIGN KEY (id_user) REFERENCES railway.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
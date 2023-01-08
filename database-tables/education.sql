CREATE TABLE railway.education (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	institution varchar(100) NULL,
	`degree` varchar(100) NULL,
	enddate DATE NULL,
	CONSTRAINT education_PK PRIMARY KEY (id),
	CONSTRAINT education_FK FOREIGN KEY (id_user) REFERENCES railway.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
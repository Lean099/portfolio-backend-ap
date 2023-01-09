CREATE TABLE railway.`work` (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	company varchar(100) NULL,
	job varchar(255) NULL,
	startdate DATE NULL,
	enddate DATE NULL,
	id_picture CHAR(36) NOT NULL,
	CONSTRAINT work_PK PRIMARY KEY (id),
	CONSTRAINT work_FK FOREIGN KEY (id_user) REFERENCES railway.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
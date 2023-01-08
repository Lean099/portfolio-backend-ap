CREATE TABLE railway.location (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	country varchar(50) NULL,
	city varchar(50) NULL,
	location varchar(50) NULL,
	CONSTRAINT location_PK PRIMARY KEY (id),
	CONSTRAINT location_FK FOREIGN KEY (id_user) REFERENCES railway.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
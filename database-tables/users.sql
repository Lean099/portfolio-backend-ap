CREATE TABLE railway.users (
	id CHAR(36) NOT NULL,
	firstname varchar(100) NULL,
	lastname varchar(100) NULL,
	email varchar(100) NOT NULL,
	password CHAR(60) NOT NULL,
	about TEXT NULL,
	dob DATE NULL,
	city varchar(50) NULL,
	picture varchar(255) NULL,
	CONSTRAINT users_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

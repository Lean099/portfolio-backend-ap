CREATE TABLE public.province (
	id CHAR(36) NOT NULL,
	name varchar(100) NULL,
	CONSTRAINT province_PK PRIMARY KEY (id),
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
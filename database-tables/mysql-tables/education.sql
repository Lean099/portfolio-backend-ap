CREATE TABLE public.education (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	institution varchar(100) NULL,
	`degree` varchar(100) NULL,
	enddate DATE NULL,
	id_picture CHAR(36) NULL,
	CONSTRAINT education_PK PRIMARY KEY (id),
	CONSTRAINT education_picture_FK FOREIGN KEY (id_picture) REFERENCES public.pictures(id),
	CONSTRAINT education_user_FK FOREIGN KEY (id_user) REFERENCES public.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
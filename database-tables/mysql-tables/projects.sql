CREATE TABLE public.projects (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	name varchar(100) NULL,
	description TEXT NULL,
	enddate DATE NULL,
	link_github varchar(500) NULL,
	link_project varchar(500) NULL,
	CONSTRAINT projects_PK PRIMARY KEY (id),
	CONSTRAINT projects_user_FK FOREIGN KEY (id_user) REFERENCES public.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
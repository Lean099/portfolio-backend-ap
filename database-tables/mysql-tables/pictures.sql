CREATE TABLE public.pictures (
	id CHAR(36) NOT NULL,
	id_user CHAR(36) NOT NULL,
	id_entity CHAR(36) NULL,
	public_id varchar(255) NOT NULL,
	filename varchar(255) NULL,
	url varchar(500) NOT NULL,
	CONSTRAINT pictures_PK PRIMARY KEY (id),
	CONSTRAINT pictures_user_FK FOREIGN KEY (id_user) REFERENCES public.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
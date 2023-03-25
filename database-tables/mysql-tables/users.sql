CREATE TABLE public.users (
	id CHAR(36) NOT NULL,
	firstname varchar(100) NULL,
	lastname varchar(100) NULL,
	email varchar(100) NOT NULL,
	password varchar(255) NOT NULL,
	about TEXT NULL,
	dob DATE NULL,
	address CHAR(36) NULL,
	id_profile_picture CHAR(36) NOT NULL,
	id_banner_picture CHAR(36) NOT NULL,
	CONSTRAINT users_PK PRIMARY KEY (id),
	CONSTRAINT users_address_FK FOREIGN KEY (address) REFERENCES public.address(id),
	CONSTRAINT users_profile_FK FOREIGN KEY (id_profile_picture) REFERENCES public.pictures(id),
	CONSTRAINT users_banner_FK FOREIGN KEY (id_banner_picture) REFERENCES public.pictures(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

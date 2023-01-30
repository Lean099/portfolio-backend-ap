CREATE TABLE public.education (
	id char(36) NOT NULL,
	id_user char(36) NOT NULL,
	institution varchar(100) NULL,
	"degree" varchar(100) NULL,
	enddate date NULL,
	id_picture char(36) NULL,
	CONSTRAINT education_pk PRIMARY KEY (id),
	CONSTRAINT education_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
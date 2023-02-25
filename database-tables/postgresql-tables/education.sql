CREATE TABLE public.education (
	id bpchar(36) NOT NULL,
	id_user bpchar(36) NOT NULL,
	institution varchar(100) NULL,
	"degree" varchar(100) NULL,
	enddate date NULL,
	id_picture bpchar(36) NULL,
	CONSTRAINT education_pk PRIMARY KEY (id),
	CONSTRAINT education_picture_fk FOREIGN KEY (id_picture) REFERENCES public.pictures(id),
	CONSTRAINT education_user_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
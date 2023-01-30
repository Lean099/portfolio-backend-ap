CREATE TABLE public."location" (
	id char(36) NOT NULL,
	id_user char(36) NOT NULL,
	country varchar(50) NULL,
	city varchar(50) NULL,
	"location" varchar(50) NULL,
	CONSTRAINT location_pk PRIMARY KEY (id),
	CONSTRAINT location_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
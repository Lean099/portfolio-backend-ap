CREATE TABLE public.city (
	id bpchar(36) NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT city_pk PRIMARY KEY (id)
);
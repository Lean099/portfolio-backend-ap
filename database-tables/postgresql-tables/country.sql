CREATE TABLE public.country (
	id bpchar(36) NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT country_pk PRIMARY KEY (id)
);
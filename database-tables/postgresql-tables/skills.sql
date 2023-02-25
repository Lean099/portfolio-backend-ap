CREATE TABLE public.skills (
	id bpchar(36) NOT NULL,
	id_user bpchar(36) NOT NULL,
	skill_name varchar(100) NULL,
	percentage int4 NULL,
	CONSTRAINT skills_pk PRIMARY KEY (id),
	CONSTRAINT skills_user_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
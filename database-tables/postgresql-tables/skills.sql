CREATE TABLE public.skills (
	id char(36) NOT NULL,
	id_user char(36) NOT NULL,
	skill_name varchar(100) NULL,
	percentage int NULL,
	CONSTRAINT skills_pk PRIMARY KEY (id),
	CONSTRAINT skills_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
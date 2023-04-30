CREATE TABLE public.projects (
	id bpchar(36) NOT NULL,
	id_user bpchar(36) NOT NULL,
	"name" varchar(100) NULL,
	description text NULL,
	enddate date NULL,
	link_github varchar(500) NULL,
	link_project varchar(500) NULL,
	CONSTRAINT projects_pk PRIMARY KEY (id),
	CONSTRAINT projects_user_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
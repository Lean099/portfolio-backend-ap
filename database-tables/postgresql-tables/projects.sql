CREATE TABLE public.projects (
	id char(36) NOT NULL,
	id_user char(36) NOT NULL,
	"name" varchar(100) NULL,
	description text NULL,
	link_github varchar(500) NULL,
	link_project varchar(500) NULL,
	CONSTRAINT projects_pk PRIMARY KEY (id),
	CONSTRAINT projects_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);
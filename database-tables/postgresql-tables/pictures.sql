CREATE TABLE public.pictures (
	id char(36) NOT NULL,
	id_user char(36) NOT NULL,
	id_entity char(36) NULL,
	public_id varchar(255) NOT NULL,
	filename varchar(255) NULL,
	url varchar(500) NOT NULL,
	CONSTRAINT pictures_pk PRIMARY KEY (id),
	CONSTRAINT pictures_user_fk FOREIGN KEY (id_user) REFERENCES public.users(id),
	CONSTRAINT pictures_work_fk FOREIGN KEY (id_entity) REFERENCES public."work"(id),
	CONSTRAINT pictures_education_fk FOREIGN KEY (id_entity) REFERENCES public.education(id)
);